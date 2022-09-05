public class Circle extends Shape{

    private String name = "Circle";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circle() {}

    @Override
    public void print() {
        System.out.println("I am " + getName());
    }
}
