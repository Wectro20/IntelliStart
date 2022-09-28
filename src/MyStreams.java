import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.*;

public class MyStreams {
    public static String oddWords(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(n -> n % 2 != 0)
                .mapToObj(names::get).toList()
                .toString();
    }

    public static List<String> upperCaseSortedWords(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String sortedArray(String[] numbers) {
        return Arrays.stream(numbers)
                .flatMap(Pattern.compile(",\\s*")::splitAsStream)
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
    }

    public static LongStream infiniteStream(long a, long c, long m) {
        return LongStream.iterate(5, x -> (a * x + c)%m).limit(100);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        return zipper(first, second, Stream::of)
                .flatMap(Function.identity());
    }

    private static <A, B, C> Stream<C> zipper(Stream<A> streamA, Stream<B> streamB, BiFunction<A, B, C> zipper) {
        final Iterator<A> iteratorA = streamA.iterator();
        final Iterator<B> iteratorB = streamB.iterator();
        final Iterator<C> iteratorC = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iteratorA.hasNext() && iteratorB.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(iteratorA.next(), iteratorB.next());
            }
        };
        final boolean parallel = streamA.isParallel() || streamB.isParallel();
        return iteratorToFiniteStream(iteratorC, parallel);
    }

    private static <T> Stream<T> iteratorToFiniteStream(Iterator<T> iterator, boolean parallel) {
        final Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Andrii", "John", "Mike", "Leon", "Jerry");
        System.out.println(oddWords(names));
        System.out.println(upperCaseSortedWords(names));
        String[] numbers = {"1, 2, 0", "4, 5"};
        System.out.println(sortedArray(numbers));
        System.out.println(infiniteStream(25214903917L, 11L, (long) Math.pow(2, 48)).mapToObj(Long::toString).toList());
        System.out.println(zip(Stream.of("a", "b", "c"), Stream.of("1", "2", "3", "4", "5")).collect(Collectors.toList()));
    }
}
