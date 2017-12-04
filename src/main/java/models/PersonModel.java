package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PersonModel {


    private String name;
    private int age;
    private String dateOfBirth;
    private int yearsNoClaims;
    private String insuranceType;
    private double quote;

    public PersonModel(String name, String dateOfBirth, int yearsNoClaims, String insuranceType) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.yearsNoClaims = yearsNoClaims;
        this.insuranceType = insuranceType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age = (int) ageFromDateOfBirth(dateOfBirth);
    }

    public int getYearsNoClaims() {
        return yearsNoClaims;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }


    private long ageFromDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        //convert String to LocalDate
        LocalDate birthday = LocalDate.parse(dateOfBirth, formatter);
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(birthday, now);
    }
}
