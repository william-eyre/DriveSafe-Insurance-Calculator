package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;
import org.junit.Assert;
import org.junit.Test;

public class FullCalculationsTest {

    private double total = 300;
    private PersonModel person;

    private CalculationsInterface composite = new CompositeCalculation(
            new CoverTypeCalculations(),
            new DriversAgeIncrease(),
            new NoClaimsDiscount());

    @Test
    public void calculationsTest_17To21AgeRange() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Dick Grayson", 21, 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 571.20, 0);
    }

    @Test
    public void calculationsTest_22To24AgeRange() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Wally West", 23, 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 436.80, 0);
    }
    @Test
    public void calculationsTest_25To35AgeRange() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Zatana", 30, 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  403.20, 0);
    }

    @Test
    public void thirdPartyTest() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bruce Wayne", 21, 3, "Third Party");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  367.20, 0);
    }

    @Test
    public void thirdPartyAndFireTest() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Hal Jordon", 21, 3, "Third Party & Fire");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  448.80, 0);
    }



}
