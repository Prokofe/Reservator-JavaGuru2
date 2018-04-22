package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.dto.ReservationRequestDTO;
import lv.javaguru.java2.businesslogic.dto.ReservationResponseDTO;

public interface ReservationService {

    ReservationResponseDTO makeReservation(ReservationRequestDTO reservationRequestDTO);


}
