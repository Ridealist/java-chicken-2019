package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Integer> getTableNumbers() {
        return tables.stream()
                .map(Table::getNumber)
                .collect(Collectors.toList());
    }

    public static Table findMenuByNumber(int number) {
        return tables.stream()
                .filter(menu -> menu.getNumber() == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않은 테이블입니다."));
    }
}
