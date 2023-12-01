package bilov.di;

public class CircularException extends RuntimeException {
    public CircularException(String s) {
    super(s);
    }
}
