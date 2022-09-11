public class Person {
    private int height;
    private int weight;
    private int age;

    public Person(int height, int weight, int age) {
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int paramGetter(int getBy) {
        if (getBy == 0) return getAge();
        if (getBy == 1) return getWeight();
        if (getBy == 2) return getHeight();
        return -1;
    }

    public void paramSetter(int setBy, int value) {
        if (setBy == 0) setAge(value);
        if (setBy == 1) setWeight(value);
        if (setBy == 2) setHeight(value);
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
