package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;

public class CompositeCalculation implements CalculationsInterface {

    private CalculationsInterface[] calculations;

    public CompositeCalculation(CalculationsInterface... calculations) {
        this.calculations = calculations;
    }

    @Override
    public double calculate(PersonModel person, double quote) throws InvalidCoverTypeException, InvalidAgeException, InvalidYearsNoClaims {
        double total = quote;
        for (CalculationsInterface calculation : calculations) {
            total = calculation.calculate(person, total);
        }
        return total;
    }
}