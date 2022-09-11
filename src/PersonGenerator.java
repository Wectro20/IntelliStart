import java.util.Random;

public class PersonGenerator {
    static Person[] p = new Person[1000];

    public static Person[] createPerson() {
        Random r = new Random();
        for (int i = 0; i < p.length; i++) {
            p[i] = new Person(
                    r.nextInt(220 - 160) + 160,
                    r.nextInt(200 - 50) + 50,
                    r.nextInt(100 - 18) + 18);
        }
        return p;
    }
}
