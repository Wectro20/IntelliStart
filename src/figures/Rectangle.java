package figures;

import shape.Shape;

public class Rectangle extends Shape{
    public Rectangle(String name) {
        super(name);
    }

    public Rectangle() {
        this("Rectangle");
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

