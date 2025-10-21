package homework3;

import homework2.Android;
import homework2.IOS;
import homework2.Phone;

public class CreateExeptions {
    public static void main(String[] args) {
        try {
            Phone newPhone3 = new IOS("17 Pro Max", null);
            System.out.println();
            newPhone3.call();
            newPhone3.unlockScreen();
            newPhone3.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone3_1 = new IOS(null, "Orange");
            System.out.println();
            newPhone3_1.call();
            newPhone3_1.unlockScreen();
            newPhone3_1.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone3_2 = new IOS("", "");
            System.out.println();
            newPhone3_2.call();
            newPhone3_2.unlockScreen();
            newPhone3_2.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4 = new Android(null, "");
            System.out.println();
            newPhone4.call();
            newPhone4.unlockScreen();
            newPhone4.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4_1 = new Android("Xiaomi", null);
            System.out.println();
            newPhone4_1.call();
            newPhone4_1.unlockScreen();
            newPhone4_1.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4_2 = new Android(null, null);
            System.out.println();
            newPhone4_2.call();
            newPhone4_2.unlockScreen();
            newPhone4_2.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone5 = new Android("Meizu", "PRO");
            System.out.println();
            newPhone5.call();
            newPhone5.unlockScreen();
            newPhone5.blockScreen();
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }
    }
}
