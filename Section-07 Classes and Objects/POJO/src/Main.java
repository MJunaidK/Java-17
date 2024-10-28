public class Main {

    public static void main(String[] args) {

        for(int i=1; i<=5; i++){
            Student s = new Student("S92300" + i,
                    switch (i){
                        case 1 -> "Jawaid";
                        case 2 -> "Salma";
                        case 3 -> "Junaid";
                        case 4 -> "Haroon";
                        case 5 -> "Fahmida";
                        default -> "Anonymous";
                    },
                     "1/1/1900",
                    "Java MAster Class");
            System.out.println(s);
        }
    }
}
