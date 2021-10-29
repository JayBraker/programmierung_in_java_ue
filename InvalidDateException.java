package uebung1;

public class InvalidDateException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 4163865420561046042L;

    public InvalidDateException (String message) {
        super(message);
    }
}
