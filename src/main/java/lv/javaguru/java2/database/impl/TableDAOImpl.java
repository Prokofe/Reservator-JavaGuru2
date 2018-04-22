package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.TableDAO;
import lv.javaguru.java2.domain.Table;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TableDAOImpl extends ORMRepository
        implements TableDAO {

    @Override
    public Set<Table> findAll() {
        List<Table> tables = session().createCriteria(Table.class).list();
        return new HashSet<>(tables);
    }

    @Override
    public Table save(Table table) {
        session().save(table);
        return (Table) session().get(Table.class, table.getId());
    }
}
