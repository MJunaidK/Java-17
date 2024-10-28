public class Main {

    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            RecordStudent s = new RecordStudent("S92300" + i,
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

        POJOStudent pojoStudent = new POJOStudent("S92300","Mohammad", "5/11/1985", "Java MasterClass");
        RecordStudent recordStudent = new RecordStudent("S92300","Junaid", "5/11/1985", "Java MasterClass");

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
        // recordStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
    }
}
