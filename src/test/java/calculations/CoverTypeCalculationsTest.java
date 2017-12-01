package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;
import org.junit.Assert;
import org.junit.Test;

public class CoverTypeCalculationsTest  {

    private double total = 300;
    private PersonModel person;

    private CalculationsInterface composite = new CompositeCalculation(
            new CoverTypeCalculations());

    @Test
    public void comprehensiveTest() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Dr Doom", 30, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 420, 0);
    }

    @Test
    public void thirdPartyAndFireTest() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Solomon Grundy", 30, 5, "Third Party & Fire");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 330, 0);
    }

    @Test
    public void calculate() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Bizaro", 30, 5, "Third Party");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(), 270, 0);
    }

}
