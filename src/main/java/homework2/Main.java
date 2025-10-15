package homework2;

public class Main {
    public static void main(String[] args) {
        Phone iPhone = new IOS("Air", "Silver");
        iPhone.call();
        iPhone.blockScreen();
        iPhone.unlockScreen();

        Phone motorola = new Android("Lenovo", "Black");
        motorola.call();
        motorola.unlockScreen();
        motorola.blockScreen();
    }
}
