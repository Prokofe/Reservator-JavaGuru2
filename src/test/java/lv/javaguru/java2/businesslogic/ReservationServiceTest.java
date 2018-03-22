package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.dto.ReservationRequestDTO;
import lv.javaguru.java2.businesslogic.dto.ReservationResponseDTO;
import lv.javaguru.java2.businesslogic.impl.ReservationServiceImpl;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.ReservationDAO;
import lv.javaguru.java2.database.TableDAO;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.domain.ReservationTime;
import lv.javaguru.java2.domain.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservationServiceTest {

    private ReservationService service;
    private CustomerDAO customerDAO = mock(CustomerDAO.class);
    private TableDAO tableDAO = mock(TableDAO.class);
    private ReservationDAO reservationDAO = mock(ReservationDAO.class);

    @Before
    public void setUp() throws Exception {
        service = new ReservationServiceImpl(customerDAO, tableDAO, reservationDAO);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void makeReservationWhenFreeTablesArePresent() {
        when(customerDAO.findByPhoneNumber(any())).thenReturn(new Customer(1, "123", "testName", Customer.Status.REGULAR));
        when(customerDAO.save(any())).thenReturn(new Customer(1, "123", "testName", Customer.Status.REGULAR));

        Set<Table> tables = new HashSet<>();
        //preparing table with id 1
        Table table = new Table(1, 5, true, new HashSet<>());
        LocalDateTime reservedTime = LocalDateTime.of(2018, 3, 6, 13, 00);
        LocalDateTime reservedTime2 = LocalDateTime.of(2018, 3, 6, 8, 00);
        ReservationTime reservationTime = new ReservationTime(1, 1, reservedTime, reservedTime.plusHours(3));
        ReservationTime reservationTime2 = new ReservationTime(1, 1, reservedTime2, reservedTime2.plusHours(3));
        table.getReservationTimes().add(reservationTime);
        table.getReservationTimes().add(reservationTime2);

        //preparing table with id 2
        Table table2 = new Table(2, 4, true, new HashSet<>());
        LocalDateTime reservedTime22 = LocalDateTime.of(2018, 3, 6, 10, 00);
        LocalDateTime reservedTime23 = LocalDateTime.of(2018, 3, 6, 16, 00);
        ReservationTime reservationTime22 = new ReservationTime(1, 1, reservedTime22, reservedTime22.plusHours(3));
        ReservationTime reservationTime23 = new ReservationTime(1, 1, reservedTime23, reservedTime23.plusHours(3));
        table2.getReservationTimes().add(reservationTime22);
        table2.getReservationTimes().add(reservationTime23);

        tables.add(table);
        tables.add(table2);

        when(tableDAO.findAll()).thenReturn(tables);

        LocalDateTime reservTime = LocalDateTime.of(2018, 3, 6, 16, 01);
        ReservationRequestDTO reservationRequestDTO = new ReservationRequestDTO("123", "name", reservTime, 4);

        when(tableDAO.save(any())).thenReturn(table);

        ReservationResponseDTO responseDTO = service.makeReservation(reservationRequestDTO);

        assertTrue("There must no errors", responseDTO.getErrors().isEmpty());
        assertEquals("Table Id is not match", 1, responseDTO.getTableId());
        assertEquals("Reservation time is nom match", reservTime, responseDTO.getReservationTime());

    }

}