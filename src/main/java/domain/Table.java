package domain;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSame(String number){
        return String.valueOf(this.number).equals(number);
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
