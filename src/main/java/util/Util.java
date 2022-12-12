package util;

public class Util {
    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    private enum Regex {
        SPACE(" "), NO_SPACE("");

        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    private Util() {
    }
}
