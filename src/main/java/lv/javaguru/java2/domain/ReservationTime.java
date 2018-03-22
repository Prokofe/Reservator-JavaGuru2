package lv.javaguru.java2.domain;

import java.time.LocalDateTime;

public class ReservationTime {

    private int id;
    private int tableId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ReservationTime(int id, int tableId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.tableId = tableId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ReservationTime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationTime that = (ReservationTime) o;

        if (tableId != that.tableId) return false;
        if (!startTime.equals(that.startTime)) return false;
        return endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        int result = tableId;
        result = 31 * result + startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ReservationTime{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
