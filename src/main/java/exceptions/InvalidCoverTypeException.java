package exceptions;

public class InvalidCoverTypeException extends Throwable {

    public String coverType;

    public InvalidCoverTypeException(String coverType) {
        this.coverType = coverType;
    }
}
