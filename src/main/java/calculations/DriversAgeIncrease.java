package calculations;

import exceptions.InvalidAgeException;
import models.AgeRangeModel;
import models.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class DriversAgeIncrease implements CalculationsInterface {

    public double calculate(PersonModel person, double quote) throws InvalidAgeException {
        int age = person.getAge();
        List<AgeRangeModel> ageBands = new ArrayList<>();
        ageBands.add(new AgeRangeModel(17, 21, 70));
        ageBands.add(new AgeRangeModel(22, 24, 30));
        ageBands.add(new AgeRangeModel(25, 35, 20));
        ageBands.add(new AgeRangeModel(36, 55, 10));
        ageBands.add(new AgeRangeModel(56, 70, 20));
        ageBands.add(new AgeRangeModel(71, 100, 70));

        for (AgeRangeModel band : ageBands) {
            if (band.includes(age)) {
                quote += band.ageIncrease(quote);
                return quote;
            }
        }
        throw new InvalidAgeException(age);
    }
}
