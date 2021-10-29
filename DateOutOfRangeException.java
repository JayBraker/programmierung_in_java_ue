package uebung1;

public class DateOutOfRangeException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 3008917761744123474L;

    public DateOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
