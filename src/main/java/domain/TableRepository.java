package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.ExceptionMessage;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table from(String number) {
        return tables.stream()
                .filter(table -> table.isSame(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_TABLE.getMessage()));
    }
}
