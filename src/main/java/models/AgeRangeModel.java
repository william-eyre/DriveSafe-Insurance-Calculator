package models;

public class AgeRangeModel {

    private int lowerBound;
    private int upperBound;
    private double percentageAdjustment;

    public AgeRangeModel(int lowerBound, int upperBound, double percentageAdjustment) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.percentageAdjustment = percentageAdjustment;
    }

    public boolean includes(int age) {
        return age > lowerBound && age <= upperBound;
    }

    public double ageIncrease(double newPrice) {
        return newPrice + (newPrice / 100 * percentageAdjustment);

    }

}
