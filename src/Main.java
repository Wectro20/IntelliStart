import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        PersonSort personSort = new PersonSort();
        personSort.quickSort(0, personSort.people.length - 1, Person::getWeight);
        PrintWriter out = new PrintWriter("sortedPeople.txt");
        for (int i = 0; i < personSort.people.length; i++) {
            out.println(personSort.people[i]);
        }
        System.out.println("Sorted array of people was written to file -> sortedPeople.txt\n");
        long startTime = System.nanoTime();
        System.out.println("Numbers of unique persons with same weight and different height: " + personSort.getUniqueValues());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("\nComplexity of method getUniqueValues() is n*log(n) with running time: " + duration / 1000000 + "ms");
    }
}
