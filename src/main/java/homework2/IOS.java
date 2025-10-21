package homework2;

public class IOS implements Phone {

    public String modelName;
    public String color;

    public IOS (String modelName, String color) {
        if (modelName== null || modelName.isEmpty()) {
            throw new IllegalArgumentException("Значення модель відсутнє");
        }
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Значення колір відсутнє");
        }
        this.modelName = modelName;
        this.color = color;
    }

    @Override
    public void call() {
        System.out.println(color + " " + modelName + " " + "Рінг - рінг");
    }

    @Override
    public void unlockScreen() {
        System.out.println(color + " " + modelName + " " + "Розблоковано");
    }

    @Override
    public void blockScreen() {
        System.out.println(color + " " + modelName + " " + "Заблоковано");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IOS) {
            IOS c = (IOS) o;
            return this.color.equals(c.color) && this.modelName.equals(c.modelName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (modelName + color).hashCode();
    }
}
