//package calculations;

//public class Calculations implements CalculationsInterface {


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
