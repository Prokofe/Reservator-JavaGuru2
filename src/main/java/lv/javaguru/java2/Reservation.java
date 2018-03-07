package lv.javaguru.java2;

public class Reservation {

    private String dateTime;
    private String name;
    private String phoneNumber;
    private String personCount;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (!dateTime.equals(that.dateTime)) return false;
        if (!name.equals(that.name)) return false;
        if (!phoneNumber.equals(that.phoneNumber)) return false;
        return personCount.equals(that.personCount);
    }

    @Override
    public int hashCode() {
        int result = dateTime.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + personCount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "dateTime='" + dateTime + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personCount='" + personCount + '\'' +
                '}';
    }
}
