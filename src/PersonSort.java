public class PersonSort {
    public interface Sorter {
        int get(Person p);
    }

    Person[] people = PersonGenerator.createPerson(10000);

    private int partition(int begin, int end, Sorter sorter) {
        int pivot = sorter.get(people[end]);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (sorter.get(people[j]) <= pivot) {
                i++;

                var tmp = people[i];
                people[i] = people[j];
                people[j] = tmp;
            }
        }

        var tmp = people[i + 1];
        people[i + 1] = people[end];
        people[end] = tmp;

        return i + 1;
    }

    public void quickSort(int begin, int end, Sorter sorter) {
        if (begin < end) {
            int partitionIndex = partition(begin, end, sorter);

            quickSort(begin, partitionIndex - 1, sorter);
            quickSort(partitionIndex + 1, end, sorter);
        }
    }

    public int getUniqueValues() {
        quickSort(0, people.length - 1, Person::getWeight);
        int maxHeight = 300;
        int i = 0;
        int counter = 0;

        boolean[] height = new boolean[maxHeight];
        int weight = people[i].getWeight();
        height[people[i].getHeight()] = true;

        counter++;

        for (i = 1; i < people.length; i++) {
            if (weight == people[i].getWeight()) {
                if (height[people[i].getHeight()]) {
                    continue;
                }
                height[people[i].getHeight()] = true;
                counter++;
            } else {
                weight = people[i].getWeight();
                height = new boolean[maxHeight];
                height[people[i].getHeight()] = true;
                counter++;
            }
        }
        return counter;
    }
}
