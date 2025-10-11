package homework2;

import homework2.IPhone;

public class Android implements IPhone{


    @Override
    public void call() {
        System.out.println("Дінь - дінь");
    }

    @Override
    public void unlockScreen() {
        System.out.println("Заблоковано");
    }

    @Override
    public void blockScreen() {
        System.out.println("Розблоковано");
    }
}
