package homework2;

public class Android implements Phone {

    public String modelName;
    public String color;

    public Android (String modelName, String color) {
        this.modelName = modelName;
        this.color = color;
    }
    @Override
    public void call() {
        System.out.println(color + " " + modelName + " " + "Дінь - дінь");
    }

    @Override
    public void unlockScreen() {
        System.out.println(color + " " + modelName + " " + "Заблоковано");
    }

    @Override
    public void blockScreen() {
        System.out.println(color + " " + modelName + " " + "Розблоковано");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Android) {
            Android b = (Android) obj;
            return this.color.equals(b.color) && this.modelName.equals(b.modelName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (modelName + color).hashCode();
    }
}
