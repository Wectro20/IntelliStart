package figures;

import shape.Shape;

public class Triangle extends Shape{
    public Triangle(String name) {
        super(name);
    }

    public Triangle() {
        this("Triangle");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
