package lv.javaguru.java2.domain;

import java.util.Set;

public class Table {

    private int id;
    private int personCount;
    private boolean avalaible;
    private Set<ReservationTime> reservationTimes;

    public Table(int id, int personCount, boolean avalaible, Set<ReservationTime> reservationTimes) {
        this.id = id;
        this.personCount = personCount;
        this.avalaible = avalaible;
        this.reservationTimes = reservationTimes;
    }


    public Table() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public boolean isAvalaible() {
        return avalaible;
    }

    public void setAvalaible(boolean avalaible) {
        this.avalaible = avalaible;
    }

    public Set<ReservationTime> getReservationTimes() {
        return reservationTimes;
    }

    public void setReservationTimes(Set<ReservationTime> reservationTimes) {
        this.reservationTimes = reservationTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (personCount != table.personCount) return false;
        if (avalaible != table.avalaible) return false;
        return reservationTimes.equals(table.reservationTimes);
    }

    @Override
    public int hashCode() {
        int result = personCount;
        result = 31 * result + (avalaible ? 1 : 0);
        result = 31 * result + reservationTimes.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", personCount=" + personCount +
                ", avalaible=" + avalaible +
                ", reservationTimes=" + reservationTimes +
                '}';
    }
}
