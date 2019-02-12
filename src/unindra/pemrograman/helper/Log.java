package unindra.pemrograman.helper;

public class Log {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\033[1;91m";
    public static final String ANSI_GREEN = "\033[1;92m";
    public static final String ANSI_YELLOW = "\033[1;93m";
    public static final String ANSI_BLUE = "\033[1;94m";
    public static final String ANSI_PURPLE = "\033[1;95m";
    public static final String ANSI_CYAN = "\033[0;32m";
    public static final String ANSI_WHITE = "\033[1;97m";

    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    //info
    public static void i(String message) {
        System.out.println(PURPLE + message + ANSI_RESET);
    }

    //error
    public static void e(String message) {
        System.out.println(RED + message + ANSI_RESET);
    }

    //debug
    public static void d(String message) {
        System.out.println(BLUE + message + ANSI_RESET);
    }

    //warning
    public static void w(String message) {
        System.out.println(YELLOW + message + ANSI_RESET);
    }

    //dosen
    public static void dosen(String message) {
        System.out.println(CYAN + message + ANSI_RESET);
    }

}
