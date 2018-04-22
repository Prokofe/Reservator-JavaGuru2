package lv.javaguru.java2.domain;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int customerId;
    private int tableId;
    private LocalDateTime reservationTime;

    public Reservation(int id, int customerId, int tableId, LocalDateTime reservationTime) {
        this.id = id;
        this.customerId = customerId;
        this.tableId = tableId;
        this.reservationTime = reservationTime;
    }

    public Reservation() {
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

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (customerId != that.customerId) return false;
        if (tableId != that.tableId) return false;
        return reservationTime != null ? reservationTime.equals(that.reservationTime) : that.reservationTime == null;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + tableId;
        result = 31 * result + (reservationTime != null ? reservationTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", tableId=" + tableId +
                ", reservationTime=" + reservationTime +
                '}';
    }
}
