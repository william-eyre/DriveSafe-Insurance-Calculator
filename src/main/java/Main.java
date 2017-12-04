import calculations.*;
import exceptions.InvalidAgeException;
import exceptions.InvalidCoverTypeException;
import exceptions.InvalidYearsNoClaims;
import models.PersonModel;

import java.text.ParseException;

public class Main {

    public static void main(String args[]) throws InvalidAgeException, InvalidCoverTypeException, InvalidYearsNoClaims, ParseException {

        double basePremium = 300;
        CalculationsInterface composite = new CompositeCalculation(
                new CoverTypeCalculations(),
                new DriversAgeIncrease(),
                new NoClaimsDiscount()
        );
//                new NoClaimsDiscount());
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter your name: ");
//        String name = scanner.next();
//
//        System.out.println("Please enter your age: ");
//        int age = scanner.nextInt();
//
//        System.out.println("Please enter the cover type you require: ");
//        String insuranceType = scanner.next();
//
//        System.out.println("Please enter your years no claims");
//        int yearsNoClaims = scanner.nextInt();

        PersonModel person = new PersonModel("Will", "05/03/1996", 3, "Comprehensive");

        String output = String.format("Insurance Quote:  %.2f", composite.calculate(person, basePremium));
        System.out.println(output);
    }
}

