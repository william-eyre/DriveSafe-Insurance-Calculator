package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;

public class CompositeCalculation implements CalculationsInterface {

     /*
    Calculations order = base premium + (300/100 * cover type) + (new price/100 * age increase) - (new price/100 * no claims discount)

    Example calculation           Cover Type     Age increase    No claims discount
                            300 + (300 * 0.40) + (420 * 0.70) - (714 * 0.20) = 571.20
     */

    private CalculationsInterface[] calculations;

    public CompositeCalculation(CalculationsInterface... calculations) {
        this.calculations = calculations;
    }

    @Override
    public double calculate(PersonModel person, double quote) throws InvalidCoverTypeException, InvalidAgeException, InvalidYearsNoClaims {
        double total = quote;
        for (CalculationsInterface calculation : calculations) {
            total = calculation.calculate(person, total);
            person.setQuote(total);
        }
        return total;
    }
}