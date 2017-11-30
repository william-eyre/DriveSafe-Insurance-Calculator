package calculations;

import exceptions.InvalidYearsNoClaims;
import models.PersonModel;

public class NoClaimsDiscount implements CalculationsInterface {

    @Override
    public double calculate(PersonModel person, double quote) throws InvalidYearsNoClaims {
        double yearsNoClaims = person.getYearsNoClaims();
        double noClaims = yearsNoClaims * 7;
        if (noClaims % 5 != 0) {
            noClaims = roundToNearestFive(noClaims);
        }
        if (noClaims >= 60) {
            noClaims = greaterThan60(noClaims);
        }
        quote = quote - quote/100 * noClaims;
        return quote;
    }

    private double roundToNearestFive(double yearsNoClaims) throws InvalidYearsNoClaims {
        if (yearsNoClaims % 5 != 0) {
            yearsNoClaims = (5 * (Math.floor(yearsNoClaims / 5.0)));
        }
        return yearsNoClaims;
    }

    private double greaterThan60(double number) {
        if (number >= 60) {
            number = 60;
        }
        else {
            return number;
        }
        return number;
    }
}


//   if (noClaimsBonus % 5 == 0) {
//            if (noClaimsBonus >= 60) {
//                noClaimsBonus = 60;
//                return quote - quote / 100 * noClaimsBonus;
//            }
//        }
//        else if (noClaimsBonus % 5 != 0) {
//            noClaimsBonus = (5 * (Math.floor(noClaimsBonus / 5.0)));
//            double output = quote - quote / 100 * noClaimsBonus;
//            return output;
//        }
//        throw new InvalidYearsNoClaims(noClaims);