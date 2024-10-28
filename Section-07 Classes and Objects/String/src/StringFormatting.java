public class StringFormatting {

    public static void main(String[] args) {

        String bulletIt = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\u2022 Sub Point\n";

        System.out.println(bulletIt);

        String textBlock = """
                Print a Bulleted List: 
                        \u2022 First Point
                            \u2022 Sub Point    
                """;
        System.out.println(textBlock);

        int age =40;
        System.out.printf("Your age is %d%n", age);

        int yearofBirth = 2024 - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearofBirth);

        System.out.printf("Your age is %.2f%n", (float)age);

        for(int i = 1; i <= 100000; i*= 10 ){
            System.out.printf("Printing %6d %n", i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        String formattedString1 = "Your age is %d".formatted(age); // jdk 15
        System.out.println(formattedString1);
    }
}
