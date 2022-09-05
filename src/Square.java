public class Square extends Shape{
    private String name = "Square";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Square() {}

    @Override
    public void print() {
        System.out.println("I am " + getName());
    }
}
