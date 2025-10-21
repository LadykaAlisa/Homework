package homework3;

import homework2.Android;
import homework2.IOS;
import homework2.Phone;

public class CreateExeptions {
    public static void main(String[] args) {
        try {
            Phone newPhone3 = new IOS("17 Pro Max", null);
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone3_1 = new IOS(null, "Orange");
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone3_2 = new IOS("", "");
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4 = new Android(null, "");
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4_1 = new Android("Xiaomi", null);
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }

        try {
            Phone newPhone4_2 = new Android(null, null);
        } catch (IllegalArgumentException e) {
            System.out.println (e.getMessage());
        }
    }
}
