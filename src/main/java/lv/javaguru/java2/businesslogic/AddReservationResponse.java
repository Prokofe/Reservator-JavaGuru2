package lv.javaguru.java2.businesslogic;

public class AddReservationResponse {

    private boolean success;
    private Error error;

    public AddReservationResponse(boolean success, Error error) {
        this.success = success;
        this.error = error;
    }


    public boolean isSuccess() {
        return true;
    }
}
