package exceptions;

public class InvalidAgeException extends Throwable {

    public int age;

    public InvalidAgeException(int age) {
        this.age = age;
    }
}
