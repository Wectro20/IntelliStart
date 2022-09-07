package shape;

public abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public Shape() {}

    public abstract String getName();
    public abstract void setName(String name);
}
