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
        person = new PersonModel("Dick Grayson", "05/03/1996", 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 571.20, 0);
    }

    @Test
    public void calculationsTest_22To24AgeRange() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Wally West", "04/09/1994", 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 436.80, 0);
    }
    @Test
    public void calculationsTest_25To35AgeRange() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Zatana", "04/04/1987", 3, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  403.20, 0);
    }

    @Test
    public void thirdPartyTest() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bruce Wayne", "05/03/1996", 3, "Third Party");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  367.20, 0);
    }

    @Test
    public void thirdPartyAndFireTest() throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Hal Jordon", "05/03/1996", 3, "Third Party & Fire");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  448.80, 0);
    }



}
