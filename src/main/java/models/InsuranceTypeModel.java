package models;

public class InsuranceTypeModel {

    private String insuranceType;
    private double percentageModifier;

    public InsuranceTypeModel(String insuranceType, int percentageModifier) {
        this.insuranceType = insuranceType;
        this.percentageModifier = percentageModifier;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double coverTypeIncrease(double premium) {
        return premium/100 * percentageModifier;
    }
}
