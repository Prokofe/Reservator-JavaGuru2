package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.impl.ReservationServiceImpl;
import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.database.ReservationDAO;
import lv.javaguru.java2.database.TableDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

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
//        when(customerDAO.findByPhoneNumber(any())).thenReturn(new Customer(1, "123", "testName", Customer.Status.REGULAR));
//        when(customerDAO.save(any())).thenReturn(new Customer(1, "123", "testName", Customer.Status.REGULAR));
//
//        Set<Table> tables = new HashSet<>();
//        //preparing table with id 1
//        Table table = new Table(1, 5, new HashSet<>());
//        LocalDateTime reservedTime = LocalDateTime.of(2018, 3, 6, 13, 00);
//        LocalDateTime reservedTime2 = LocalDateTime.of(2018, 3, 6, 8, 00);
//        Reservation reservation1 = new Reservation(1, 1, 1, reservedTime, reservedTime.plusHours(3));
//        Reservation reservation2 = new Reservation(2, 1, 1, reservedTime2, reservedTime2.plusHours(3));
//        table.getReservations().add(reservation1);
//        table.getReservations().add(reservation2);
//
//        //preparing table with id 2
//        Table table2 = new Table(2, 4, new HashSet<>());
//        LocalDateTime reservedTime22 = LocalDateTime.of(2018, 3, 6, 10, 00);
//        LocalDateTime reservedTime23 = LocalDateTime.of(2018, 3, 6, 16, 00);
//        Reservation reservation3 = new Reservation(3, 1, 2, reservedTime22, reservedTime22.plusHours(3));
//        Reservation reservation4 = new Reservation(4, 1, 2, reservedTime23, reservedTime23.plusHours(3));
//        table2.getReservations().add(reservation3);
//        table2.getReservations().add(reservation4);
//
//        tables.add(table);
//        tables.add(table2);
//
//        when(tableDAO.findAll()).thenReturn(tables);
//
//        LocalDateTime reservTime = LocalDateTime.of(2018, 3, 6, 16, 01);
//        ReservationRequestDTO reservationRequestDTO = new ReservationRequestDTO("123", "name", reservTime, 4);
//
//        when(tableDAO.save(any())).thenReturn(table);
//        when(reservationDAO.save(any())).thenReturn(reservation1);
//
//        ReservationResponseDTO responseDTO = service.makeReservation(reservationRequestDTO);
//
//        assertTrue("There must no errors", responseDTO.getErrors().isEmpty());
//        assertEquals("Table Id is not match", 1, responseDTO.getTableId());
//        assertEquals("Reservation time is nom match", reservTime, responseDTO.getReservationTime());

    }

}