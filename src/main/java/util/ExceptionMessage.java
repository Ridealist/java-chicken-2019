package util;

public enum ExceptionMessage {

    NO_MAIN_OPTION("해당 메인 옵션이 존재하지 않습니다."),
    NO_SUCH_TABLE("해당하는 테이블이 존재하지 않습니다."),

    NO_SUCH_MENU("해당 메뉴가 존재하지 않습니다."),

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),

    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),

    INVALID_RANGE("동일한 메뉴를 100개 이상 구매할 수 없습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}