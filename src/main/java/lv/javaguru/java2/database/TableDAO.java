package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Table;

import java.util.Set;

public interface TableDAO {

    Set<Table> findAll();

    Table save(Table table);
}
