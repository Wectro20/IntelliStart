public class Triangle extends Shape{

    private String name= "Triangle";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Triangle() {}

    @Override
    public void print() {
        System.out.println("I am " + getName());
    }
}
