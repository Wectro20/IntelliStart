package figures;

import shape.Shape;

public class Square extends Shape{
    public Square(String name) {
        super(name);
    }

    public Square() {
        this("Square");
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
