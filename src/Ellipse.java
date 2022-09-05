public class Ellipse extends Shape{
    private String name = "Ellipse";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ellipse() {}

    @Override
    public void print() {
        System.out.println("I am " + getName());
    }
}
