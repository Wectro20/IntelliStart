package figures;

import shape.Shape;

public class Circle extends Shape{
    public Circle(String name) {
        super(name);
    }

    public Circle() {
        this("Circle");
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
