package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;
import org.junit.Assert;
import org.junit.Test;

public class DriversAgeIncreaseTest {

    private double total = 300;
    private PersonModel person;

    private CalculationsInterface composite = new CompositeCalculation(
            new DriversAgeIncrease());

    @Test
    public void test_17To21() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 21, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  510.00, 0);
    }

    @Test
    public void test_22To24() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 23, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  390.00, 0);
    }

    @Test
    public void test_25To35() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 30, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  360.00, 0);
    }

    @Test
    public void test_36To55() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 40, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  330.00, 0);
    }

    @Test
    public void test_56To70() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 60, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  360.00, 0);
    }

    @Test
    public void test_71To100() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Tony Stark", 99, 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  510.00, 0);
    }



}