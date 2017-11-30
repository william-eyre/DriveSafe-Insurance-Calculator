package exceptions;

public class InvalidYearsNoClaims extends Throwable {

    public double yearsNoClaims;

    public InvalidYearsNoClaims(double yearsNoClaims) {
        this.yearsNoClaims = yearsNoClaims;
    }
}
