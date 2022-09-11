public class PersonSort {
    Person[] people = PersonGenerator.createPerson();

    private int partition(int begin, int end, int sortBy) {
        int pivot = people[end].paramGetter(sortBy);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (people[j].paramGetter(sortBy) <= pivot) {
                i++;

                int swapTemp = people[i].paramGetter(sortBy);
                people[i].paramSetter(sortBy, people[j].paramGetter(sortBy));
                people[j].paramSetter(sortBy, swapTemp);
            }
        }

        int swapTemp = people[i + 1].paramGetter(sortBy);
        people[i + 1].paramSetter(sortBy, people[end].paramGetter(sortBy));
        people[end].paramSetter(sortBy, swapTemp);

        return i + 1;
    }

    public void quickSort(int begin, int end, int sortBy) {
        if (begin < end) {
            int partitionIndex = partition(begin, end, sortBy);

            quickSort(begin, partitionIndex - 1, sortBy);
            quickSort(partitionIndex + 1, end, sortBy);
        }
    }

    public int getUniqueValues() {
        quickSort(0, people.length - 1, 1);
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
