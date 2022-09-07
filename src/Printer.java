import figures.*;
import shape.Shape;

public class Printer {
    public static void main(String[] args) {
        Shape[] s = new Shape[]{
                new Circle(),
                new Ellipse("myEllipse"),
                new Rectangle(),
                new Square(),
                new Triangle()};

        for (Shape shape: s) {
            printName(shape);
        }
    }

    public static void printName(Shape s) {
        System.out.println(s.getName());
    }
}
