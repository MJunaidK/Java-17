import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main   {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for(String s: list){
            System.out.println(s);
        }

        System.out.println("---------------------");
        list.forEach((s) -> System.out.println(s)); // Consumer interface

        System.out.println("---------------------");
        String prefix = "hello";
        //String myString = "enclosing Method's signature";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString+ " means " + first);
        });
        //prefix = "NATO";

        int result = calculator((a,b)-> a+b,5,2);
        var result2 = calculator((a,b)-> a/b,10.0,2.5);
        var result3= calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Mohammad Junaid", "Khan");

        int result4 = calculator1((a,b)-> a+b,5,2);


        var coords = Arrays.asList(new double[]{45.98, -95.8531},
                new double[]{76.58, -85.3428},new double[]{35.1556, -90.0659});

        coords.forEach(s -> System.out.println(Arrays.toString(s))); // Consumer interface

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("---------------------");
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));
        list.removeIf(s -> s.equalsIgnoreCase("bravo")); // Predicate interface
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("---------------------");
        list.removeIf(s -> s.startsWith("ea")); // Predicate interface
        list.forEach(s -> System.out.println(s));

        list.replaceAll(s -> s.charAt(0) + " " + s.toUpperCase()); // Unary Operator
        System.out.println("---------------------");
        list.forEach(s -> System.out.println(s)); // Consumer

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i+1)+ "."); // IntFunction
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i+1)+ "."
                + switch (i) {
                        case 0 -> "one";
                        case 1 -> "two";
                        case 2 -> "three";
                        default -> "";
                }
        ); // IntFunction
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length)); // Supplier Interface
        System.out.println(Arrays.toString(randomList));
    }

    public static <T> T calculator1(BinaryOperator<T> function, T value1, T value2){

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: "+ result);
        return result;
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2){

        T result = function.operate(value1, value2);
        System.out.println("Result of operation: "+ result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String [] values, Supplier<Integer> s){
        String [] selctedValues = new String[count];
        for(int i=0; i< count; i++){
            selctedValues[i] = values[s.get()];
        }
        return selctedValues;
    }
}
