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
        person = new PersonModel("Tony Stark", "05/03/1996", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  510.00, 0);
    }

    @Test
    public void test_22To24() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Black Widow", "09/11/1994", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  390.00, 0);
    }

    @Test
    public void test_25To35() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Thor", "25/12/1987", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  360.00, 0);
    }

    @Test
    public void test_36To55() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Star Lord", "17/02/1977", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  330.00, 0);
    }

    @Test
    public void test_56To70() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Nick Fury", "06/01/1957", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  360.00, 0);
    }

    @Test
    public void test_71To100() throws Exception, InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
        person = new PersonModel("Quicksilver", "15/06/1918", 5, "Comprehensive");
        composite.calculate(person, total);

        Assert.assertEquals(person.getQuote(),  510.00, 0);
    }



}