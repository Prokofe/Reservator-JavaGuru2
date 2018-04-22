package lv.javaguru.java2.domain;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "tables")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int personCount;

    public Table() {
    }

    public Table(int id, int personCount) {
        this.id = id;
        this.personCount = personCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (id != table.id) return false;
        return personCount == table.personCount;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + personCount;
        return result;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", personCount=" + personCount +
                '}';
    }
}
