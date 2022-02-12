package utils;

public class TestUtils {
    public static long getMobileNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
}
