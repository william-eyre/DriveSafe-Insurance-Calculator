//package calculations;

//public class Calculations implements CalculationsInterface {

    /*
    Calculations order = base premium + (300/100 * cover type) + (new price/100 * age increase) - (new price/100 * no claims discount)

    Example calculation           Cover Type     Age increase    No claims discount
                            300 + (300 * 0.40) + (420 * 0.70) - (714 * 0.20) = 571.20
     */

//    private static DecimalFormat df2 = new DecimalFormat(".##");
//
//    public double calculate(PersonModel person, double quote) throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims {
//        double coverType = coverTypeCalculations.calculate(person, quote);
//        double ageIncrease = driversAgeIncrease.calculate(person, coverType);
//        double noClaims = noClaimsDiscount.calculate(person, ageIncrease);
//        double insuranceQuote = ageIncrease - noClaims;
//
//        return Double.parseDouble(df2.format(insuranceQuote));
//    }
//}
