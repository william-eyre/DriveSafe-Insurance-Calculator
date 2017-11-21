import calculations.Calculations;
import calculations.CalculationsInterface;
import models.PersonModel;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        CalculationsInterface c = new Calculations();

        System.out.println("Please enter your name: ");
        String name = scanner.next();

        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Please enter the cover type you require: ");
        String insuranceType = scanner.next();

        System.out.println("Please enter your years no claims");
        int yearsNoClaims = scanner.nextInt();

        PersonModel person = new PersonModel(name, age, yearsNoClaims, insuranceType);

        System.out.println("Insurance Quote: " + c.calculate(person));
    }
}

