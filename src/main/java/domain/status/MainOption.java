package domain.status;

public enum MainOption {

    INITIALIZE_APPLICATION,
    ORDER_REGISTRATION,
    PAYMENT,
    APPLICATION_EXIT;

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }

}