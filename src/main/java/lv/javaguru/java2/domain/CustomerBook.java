package lv.javaguru.java2.domain;

import java.time.LocalDateTime;

public class CustomerBook {

    private int id;
    private int customerId;
    private boolean checkedIn;
    private LocalDateTime reservationDate;

    public CustomerBook(int id, int customerId, boolean checkedIn, LocalDateTime reservationDate) {
        this.id = id;
        this.customerId = customerId;
        this.checkedIn = checkedIn;
        this.reservationDate = reservationDate;
    }

    public CustomerBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerBook that = (CustomerBook) o;

        if (customerId != that.customerId) return false;
        if (checkedIn != that.checkedIn) return false;
        return reservationDate.equals(that.reservationDate);
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (checkedIn ? 1 : 0);
        result = 31 * result + reservationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CustomerBook{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", checkedIn=" + checkedIn +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
