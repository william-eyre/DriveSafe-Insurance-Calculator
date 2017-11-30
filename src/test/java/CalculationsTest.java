import calculations.Calculations;
import calculations.CalculationsInterface;
import models.PersonModel;
import org.junit.Assert;
import org.junit.Test;

public class CalculationsTest {

    @Test
    public void calculationsTest_17To21AgeRange() {
        CalculationsInterface c = new Calculations();
        PersonModel person1 = new PersonModel("Dick Grayson", 21, 3, "Comprehensive");
        c.calculate(person1);

        Assert.assertEquals(person1.getQuote(), 571.2, 0);
    }

    @Test
    public void calculationsTest_22To24AgeRange() {
        CalculationsInterface c = new Calculations();
        PersonModel person2 = new PersonModel("Wally West", 23, 3, "Comprehensive");
        c.calculate(person2);

        Assert.assertEquals(person2.getQuote(), 436.8, 0);
    }
    @Test
    public void calculationsTest_25To35AgeRange() {
        CalculationsInterface c = new Calculations();
        PersonModel person3 = new PersonModel("Zatana", 30, 3, "Comprehensive");
        c.calculate(person3);

        Assert.assertEquals(person3.getQuote(), 403.2, 0);
    }


}
