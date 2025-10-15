package homework3;

//TODO: Add model name and color to Android and IOS classes
//TODO: add equals and hashcode methods.
//TODO: create android/ios with null model and/or hashcode,
// and try to handle exceptions if they appear

import homework2.Android;
import homework2.IOS;
import homework2.Phone;

public class ProMax {

    public static void main(String[] args) {
        Phone newPhone1 = new IOS("17 Pro Max", "Orange");
        Phone newPhone1_1= new IOS("17 Pro Max", "Orange");
        Phone newPhone1_2 = new IOS("17 Pro", "Black");

        Phone newPhone2 = new Android("Xiaomi", "Blue");
        Phone newPhone2_1 = new Android("Xiaomi", "Blue");
        Phone newPhone2_2 = new Android("Xiaomi", "Red");

        System.out.println();
        newPhone1.call();
        newPhone1.unlockScreen();
        newPhone1.blockScreen();

        System.out.println();
        newPhone1_2.call();
        newPhone1_2.unlockScreen();
        newPhone1_2.blockScreen();

        System.out.println();
        newPhone2.call();
        newPhone2.unlockScreen();
        newPhone2.blockScreen();

        System.out.println("newPhone1.equals(newPhone1_1): " + newPhone1.equals(newPhone1_1));
        System.out.println("newPhone1.equals(newPhone1_2): " + newPhone1.equals(newPhone1_2));

        System.out.println("newPhone2.equals(newPhone2_1): " + newPhone2.equals(newPhone2_1));
        System.out.println("newPhone2.equals(newPhone2_2): " + newPhone2.equals(newPhone2_2));

        System.out.println("newPhone1 hashCode: " + newPhone1.hashCode());
        System.out.println("newPhone1_1 hashCode: " + newPhone1_1.hashCode());
        System.out.println("newPhone1_2 hashCode: " + newPhone1_2.hashCode());

        System.out.println("newPhone2 hashCode: " + newPhone2.hashCode());
        System.out.println("newPhone2_2 hashCode: " + newPhone2_1.hashCode());
        System.out.println("newPhone2_1 hashCode: " + newPhone2_2.hashCode());

    }

    }


