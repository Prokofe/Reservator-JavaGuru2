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
import lv.javaguru.java2.domain.ReservationTime;
import lv.javaguru.java2.domain.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReservationServiceImpl implements ReservationService {

    private CustomerDAO customerDAO;
    private TableDAO tableDAO;
    private ReservationDAO reservationDAO;

    public ReservationServiceImpl(CustomerDAO customerDAO, TableDAO tableDAO, ReservationDAO reservationDAO) {
        this.customerDAO = customerDAO;
        this.tableDAO = tableDAO;
        this.reservationDAO = reservationDAO;
    }

    @Override
    public ReservationResponseDTO makeReservation(ReservationRequestDTO reservationRequestDTO) {

        ReservationResponseDTO responseDTO = new ReservationResponseDTO(new ArrayList<>(), 0, null);

        String phoneNumber = reservationRequestDTO.getPhoneNumber();
        Customer customer = customerDAO.findByPhoneNumber(phoneNumber);
        if (customer != null && customer.getStatus().equals(Customer.Status.BANNED)) {
            Error error = new Error("customer", "banned customer");
            responseDTO.getErrors().add(error);
            return responseDTO;
        }

        LocalDateTime reservationTime = reservationRequestDTO.getDateTime();
        int personCount = reservationRequestDTO.getPersonCount();
        Set<Table> freeTables = findFreeTables(reservationTime, personCount);
        if (freeTables.isEmpty()) {
            Error error = new Error("table", "no free tables");
            responseDTO.getErrors().add(error);
            return responseDTO;
        }
        Table table = new Table();
        for (Table freeTable : freeTables) {
            table = freeTable; //TODO return table with optimal person count
        }
//        Table table = freeTables.stream().findAny().orElse(null);
        if (customer == null) {
            customer = new Customer(
                    0,
                    reservationRequestDTO.getPhoneNumber(),
                    reservationRequestDTO.getName(),
                    Customer.Status.REGULAR);
        }
        Customer storedCustomer = customerDAO.save(customer);
        table.getReservationTimes().add(new ReservationTime(0, table.getId(), reservationTime, reservationTime.plusHours(3L)));
        Table storedTable = tableDAO.save(table);
        Reservation reservation = new Reservation(0, storedCustomer.getId(), storedTable.getId(), reservationTime);
        Reservation storedReservation = reservationDAO.save(reservation);
        responseDTO.setReservationTime(reservationTime);
        responseDTO.setTableId(table.getId());
        return responseDTO;
    }

    private Set<Table> findFreeTables(LocalDateTime reservationTime, int personCount) {

        Set<Table> tables = tableDAO.findAll();
        Set<Table> freeTables = filterFreeTablesByPersonCount(tables, personCount);
        freeTables = filterFreeTablesByAvailability(freeTables);
        freeTables = filterFreeTablesByReservationTime(freeTables, reservationTime);
        return freeTables;
    }

    private Set<Table> filterFreeTablesByReservationTime(Set<Table> tables, LocalDateTime reservationTime) {

        Set<Table> freeTables = new HashSet<>();
        for (Table table : tables) {
            if (hasFreeTime(table.getReservationTimes(), reservationTime)) {
                freeTables.add(table);
            }
        }
        return freeTables;
    }

    private boolean hasFreeTime(Set<ReservationTime> reservationTimes, LocalDateTime reservationTime) {

        for (ReservationTime time : reservationTimes) {
            if (reservationTime.isBefore(time.getEndTime()) && reservationTime.isAfter(time.getStartTime())) {
                return false;
            }
        }
        return true;
    }

    private Set<Table> filterFreeTablesByAvailability(Set<Table> tables) {

        Set<Table> freeTables = new HashSet<>();
        for (Table table : tables) {
            if (table.isAvalaible()) {
                freeTables.add(table);
            }
        }
        return freeTables;
    }

    private Set<Table> filterFreeTablesByPersonCount(Set<Table> tables, int personCount) {

        Set<Table> freeTables = new HashSet<>();
        for (Table table : tables) {
            if (personCount <= table.getPersonCount()) {
                freeTables.add(table);
            }
        }
        return freeTables;
    }


}

