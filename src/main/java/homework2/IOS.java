package homework2;

import homework2.IPhone;

public class IOS implements IPhone{
    @Override
    public void call() {
        System.out.println("Рінг - рінг");
    }

    @Override
    public void unlockScreen() {
        System.out.println("Розблоковано");
    }

    @Override
    public void blockScreen() {
        System.out.println("Заблоковано");

    }
}
