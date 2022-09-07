package figures;

import shape.Shape;

public class Ellipse extends Shape{
    public Ellipse(String name) {
        super(name);
    }

    public Ellipse() {
        this("Ellipse");
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
