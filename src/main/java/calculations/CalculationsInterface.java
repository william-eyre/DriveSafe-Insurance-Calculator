package calculations;

import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;

public interface CalculationsInterface {

   double calculate(PersonModel person, double quote) throws InvalidCoverTypeException, InvalidAgeException, InvalidYearsNoClaims;
}
