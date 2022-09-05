public class Rectangle extends Shape{
    private String name = "Rectangle";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle() {}

    @Override
    public void print() {
        System.out.println("I am " + getName());
    }
}
