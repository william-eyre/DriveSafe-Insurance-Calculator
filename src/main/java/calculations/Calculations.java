package calculations;

import models.AgeRangeModel;
import models.InsuranceTypeModel;
import models.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class Calculations implements CalculationsInterface {


    /*
    Calculations order = base premium + (300/100 * cover type) + (new price/100 * age increase) - (new price/100 * no claims discount)

    Example calculation           Cover Type     Age increase    No claims discount
                            300 + (300 * 0.40) + (420 * 0.70) - (714 * 0.20) = 571.20
     */

    private double basePremium = 300;

    private double coverTypeIncreaseAmount;
    private double driversAgeIncreaseAmount;
    private double noClaimsDiscount;

    private double coverTypeTotal;
    private double driversAgeTotal;

    private double coverTypeCalculations(String coverType) {
        List<InsuranceTypeModel> typeModels = new ArrayList<>();
        typeModels.add(new InsuranceTypeModel("Comprehensive", 40));
        typeModels.add(new InsuranceTypeModel("Third Party & Fire", 10));
        typeModels.add(new InsuranceTypeModel("Third Party", 10));

        for (InsuranceTypeModel type : typeModels) {
            if (type.getInsuranceType().equals(coverType)) {
//                System.out.println("Cover type increase:");
//                System.out.println(basePremium);
//                System.out.println(coverTypeIncreaseAmount = type.coverTypeIncrease(basePremium));
//                System.out.println(coverTypeTotal = basePremium + type.coverTypeIncrease(basePremium));
                coverTypeTotal = basePremium + type.coverTypeIncrease(basePremium);
                return coverTypeIncreaseAmount = type.coverTypeIncrease(basePremium);
            }
        }
        return 0;
    }

    private double driversAgeIncrease(int driversAge) {
        List<AgeRangeModel> ageBands = new ArrayList<>();
        ageBands.add(new AgeRangeModel(17, 21, 70));
        ageBands.add(new AgeRangeModel(22, 24, 30));
        ageBands.add(new AgeRangeModel(25, 35, 20));
        ageBands.add(new AgeRangeModel(36, 55, 10));
        ageBands.add(new AgeRangeModel(71, 100, 70));

        for (AgeRangeModel band : ageBands) {
            if (band.includes(driversAge)) {
//                System.out.println("age increase:");
//                System.out.println(coverTypeTotal);
//                System.out.println(driversAgeIncreaseAmount = band.ageIncrease(coverTypeTotal));
//                System.out.println(driversAgeTotal = coverTypeTotal + band.ageIncrease(coverTypeTotal));
                driversAgeTotal = coverTypeTotal + band.ageIncrease(coverTypeTotal);
                return driversAgeIncreaseAmount = band.ageIncrease(coverTypeTotal);
            }
        }
        return driversAge;
    }

    private double noClaimsDiscount(int yearsNoClaims) {
        int noClaimsBonus = yearsNoClaims * 7;
        if (noClaimsBonus % 5 == 0) {
            if (noClaimsBonus >= 60) {
                noClaimsBonus = 60;
                return noClaimsDiscount = driversAgeIncreaseAmount / 100 * noClaimsBonus;
            }
        }
        else if (noClaimsBonus % 5 != 0) {
            noClaimsBonus = (int) (5 * (Math.floor(noClaimsBonus / 5.0)));
//            System.out.println("No claims discount:");
//            System.out.println(driversAgeTotal);
//            System.out.println(Math.floor(noClaimsDiscount = driversAgeTotal / 100 * noClaimsBonus));
            return noClaimsDiscount = driversAgeTotal / 100 * noClaimsBonus;
        }
        return noClaimsBonus;
    }


    @Override
    public double calculate(PersonModel person) {
        return basePremium +
        coverTypeCalculations(person.getInsuranceType()) +
        driversAgeIncrease(person.getAge()) -
        noClaimsDiscount(person.getYearsNoClaims());
    }

//    @Override
//    public int driversAgeIncrease(int driversAge) {
//        if (driversAge >= 17 && driversAge <= 21) {
//            basePremium += (basePremium * 0.70);
//            return basePremium;
//        }
//        if (driversAge >= 22 && driversAge <= 24) {
//            basePremium += (basePremium * 0.30);
//            return basePremium;
//        }
//        if (driversAge >= 25 && driversAge <= 35) {
//            basePremium += (basePremium * 0.20);
//            return basePremium;
//        }
//        if (driversAge >= 36 && driversAge <= 55) {
//            basePremium += (basePremium * 0.10);
//            return basePremium;
//        }
//        if (driversAge >= 56 && driversAge <= 70) {
//            basePremium += (basePremium * 0.20);
//            return basePremium;
//        }
//        if (driversAge >= 71 && driversAge <= 100) {
//            basePremium += (basePremium * 0.70);
//            return basePremium;
//        }
//        else {
//            return basePremium;
//        }
//    }

}
