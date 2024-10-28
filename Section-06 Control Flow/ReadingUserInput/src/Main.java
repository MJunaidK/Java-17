import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int currentYear = 2024;
//        String usersDateOfBirth = "1999";
//
//        int dateOfBirth = Integer.parseInt(usersDateOfBirth);
//
//        System.out.println("Age= "+ (currentYear - dateOfBirth));
//
//        String usersAgeWithPartialYear = "22.5";
//        double ageWithPartialYear = Double.parseDouble(usersAgeWithPartialYear);
//        System.out.println("The user says he's "+ ageWithPartialYear);
          try {
              System.out.println(getInputFromConsole(currentYear));
          } catch (NullPointerException e) {
              System.out.println(getInputFromScanner(currentYear));
          }


    }

    public static String getInputFromConsole(int currentYear){

        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", Thanks for taking this course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);
        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi, What's your Name? ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + ", Thanks for taking the course!");

        System.out.println("What Year were you born? ");
        //String dateOfBirth = scanner.nextLine();

        int age = 0;
        boolean validDOB = false;

        do{
            System.out.println("Enter a year of birth >= " +
                    (currentYear -125) + " and <= " + (currentYear));
           try {
               age = checkData(currentYear, scanner.nextLine());
               validDOB = age < 0 ? false : true;
           } catch (NumberFormatException exception){
               System.out.println("Characters not allowed!!! Try again");
           }
        }while (!validDOB);

        return "So you are " + age + " years old";
    }

    public static int checkData(int currentYear, String dateOfBirth){

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if((dob < minimumYear) || (dob > currentYear)){
            return -1;
        }

        return (currentYear - dob);
    }
}
