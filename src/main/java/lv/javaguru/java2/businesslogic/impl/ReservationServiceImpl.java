package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.Error;
import lv.javaguru.java2.businesslogic.ReservationService;
import lv.javaguru.java2.businesslogic.dto.ReservationRequestDTO;
import lv.javaguru.java2.businesslogic.dto.ReservationResponseDTO;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.ReservationDAO;
import lv.javaguru.java2.database.TableDAO;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.Reservation;
import lv.javaguru.java2.domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReservationServiceImpl implements ReservationService {

    private CustomerDAO customerDAO;
    private TableDAO tableDAO;
    private ReservationDAO reservationDAO;

    @Autowired
    public ReservationServiceImpl(CustomerDAO customerDAO, TableDAO tableDAO, ReservationDAO reservationDAO) {
        this.customerDAO = customerDAO;
        this.tableDAO = tableDAO;
        this.reservationDAO = reservationDAO;
    }

    @Override
    public ReservationResponseDTO makeReservation(ReservationRequestDTO reservationRequestDTO) {

        ReservationResponseDTO responseDTO = new ReservationResponseDTO(new ArrayList<>(), 0, 0, null);

        Table table = findFreeTable(reservationRequestDTO.getPersonCount(), reservationRequestDTO.getStartTime());
        if (table == null) {
            responseDTO.getErrors().add(new Error("", "There is no free tables are found"));
            return responseDTO;
        }

        Customer customer = findCustomer(reservationRequestDTO.getPhoneNumber());
        if (customer == null) {
            customer = createCustomer(reservationRequestDTO.getPhoneNumber(), reservationRequestDTO.getName());
        }

        LocalDateTime endTime = reservationRequestDTO.getEndTime() == null ?
                reservationRequestDTO.getStartTime().plusHours(2L).plusMinutes(55L) :
                reservationRequestDTO.getEndTime();

        Reservation reservation = buildReservation(
                customer.getId(),
                table.getId(),
                reservationRequestDTO.getStartTime(),
                endTime);

        Reservation storedReservation = reservationDAO.save(reservation);
        if (storedReservation == null) {
            responseDTO.getErrors().add(new Error("", "Reservation can't be created"));
            return responseDTO;
        }

        return responseDTO;
    }

    private Customer createCustomer(String phoneNumber, String name) {
        return customerDAO.save(new Customer(0, phoneNumber, name, Customer.Status.REGULAR));
    }

    private Customer findCustomer(String phoneNumber) {
        return customerDAO.findByPhoneNumber(phoneNumber);
    }

    private Table findFreeTable(int personCount, LocalDateTime startTime) {
        Set<Reservation> reservations = reservationDAO.findByDate(startTime);
        Set<Table> tables = tableDAO.findAll();
        if (reservations.isEmpty()) {
            return tables.stream().findFirst().orElse(null);
        }
        Set<Reservation> filteredReservations = filterReservationsByTime(reservations, startTime);
        List<Table> freeTables = new LinkedList<>();
        for (Reservation filteredReservation : filteredReservations) {
            for (Table table : tables) {
                if (filteredReservation.getTableId() != table.getId()) {
                    freeTables.add(table);
                }
            }
        }
        if (freeTables.isEmpty()) {
            return null;
        }

        for (Table freeTable : freeTables) {
            if (freeTable.getPersonCount() >= personCount) {
                return freeTable;
            }
        }
        return null;
    }

    private Set<Reservation> filterReservationsByTime(Set<Reservation> reservations, LocalDateTime startTime) {
        Set<Reservation> filteredReservation = new HashSet<>();
        for (Reservation reservation : reservations) {
            if (startTime.isBefore(reservation.getEndTime()) && startTime.isAfter(reservation.getStartTime())) {
                filteredReservation.add(reservation);
            }
        }
        return filteredReservation;
    }

    private Reservation buildReservation(int customerId, int tableId, LocalDateTime startTime, LocalDateTime endTime) {
        return new Reservation(0, customerId, tableId, startTime, endTime);
    }

}

