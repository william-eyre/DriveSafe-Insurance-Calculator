package models;

public class PersonModel {

    //TODO: age should be calculated from date of birth.

    private String name;
    private int age;
    private int yearsNoClaims;
    private String insuranceType;

    public PersonModel(String name, int age, int yearsNoClaims, String insuranceType) {
        this.name = name;
        this.age = age;
        this.yearsNoClaims = yearsNoClaims;
        this.insuranceType = insuranceType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearsNoClaims() {
        return yearsNoClaims;
    }

    public String getInsuranceType() {
        return insuranceType;
    }
}
