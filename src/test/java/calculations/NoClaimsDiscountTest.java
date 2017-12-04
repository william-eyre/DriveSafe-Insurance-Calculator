package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;
import org.junit.Assert;
import org.junit.Test;

public class NoClaimsDiscountTest {

    private double total = 300;
    private PersonModel person;

    private CalculationsInterface composite = new CompositeCalculation(
            new NoClaimsDiscount());
    @Test
    public void test_5yearsNoClaims() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bruce Banner", "24/01/1987", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  195.00, 0);

    }

    @Test
    public void test_11yearsNoClaims() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bruce Banner", "30/09/1992", 11, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  120.00, 0);

    }

    @Test
    public void test_1yearsNoClaims() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bruce Banner", "10/08/1995", 1, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  285.00, 0);

    }

}