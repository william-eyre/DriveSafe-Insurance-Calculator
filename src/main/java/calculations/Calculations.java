package calculations;

import models.AgeRangeModel;
import models.InsuranceTypeModel;
import models.PersonModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculations implements CalculationsInterface {


    /*
    Calculations order = base premium + (300/100 * cover type) + (new price/100 * age increase) - (new price/100 * no claims discount)
     */

    private final int basePremium = 300;

    private double coverTypePrice;
    private double driversAgePrice;
    NumberFormat formatter = new DecimalFormat("#0.00");

    private double coverTypeCalculations(String coverType) {
        List<InsuranceTypeModel> typeModels = new ArrayList<>();
        typeModels.add(new InsuranceTypeModel("Comprehensive", 40));
        typeModels.add(new InsuranceTypeModel("Third Party & Fire", 10));
        typeModels.add(new InsuranceTypeModel("Third Party", 10));

        for (InsuranceTypeModel type : typeModels) {
            if(type.getInsuranceType().equals(coverType)) {
                return coverTypePrice = type.coverTypeIncrease(basePremium);
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
                driversAgePrice = coverTypePrice + (coverTypePrice / 100 * band.getPercentageAdjustment());
                return driversAgePrice;
            }
        }
        return driversAge;
    }

    private double noClaimsDiscount(int yearsNoClaims) {
        int noClaimsBonus = yearsNoClaims * 7;
        if (noClaimsBonus % 5 == 0) {
            if (noClaimsBonus >= 60) {
                noClaimsBonus = 60;
                return noClaimsBonus;
            }
        }
        else if (noClaimsBonus % 5 != 0) {
            noClaimsBonus = (int) (5 * (Math.floor(noClaimsBonus / 5.0)));
            return driversAgePrice - (driversAgePrice / 100 * noClaimsBonus);
        }
        return -noClaimsBonus;
    }


    @Override
    public double calculate(PersonModel person) {
        return
        basePremium +
        coverTypeCalculations(person.getInsuranceType()) +
        driversAgeIncrease(person.getAge()) +
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
