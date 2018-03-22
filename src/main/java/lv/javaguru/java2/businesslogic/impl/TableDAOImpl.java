package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.database.TableDAO;
import lv.javaguru.java2.domain.Table;

import java.util.HashSet;
import java.util.Set;

public class TableDAOImpl implements TableDAO {

    @Override
    public Set<Table> findAll() {
        return new HashSet<>();
    }

    @Override
    public Table save(Table table) {
        return null;
    }
}
