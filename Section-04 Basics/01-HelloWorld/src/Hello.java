public class Hello {
    public static void main(String[] args) {

        System.out.println("Hello, Junaid");
        System.out.println("Hello World");

        boolean isAlien =false;
        if(isAlien == false){
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens");
        }

        int topScore = 80;
        if(topScore <= 100){
            System.out.println("You got the highest score");
        }

        int secondTopScore = 60;
        if((topScore > secondTopScore) && (topScore < 100)){
            System.out.println("Greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
             System.out.println("Either or both of the  conditions are true");
        }

        int newValue = 50;
        if(newValue == 50){
            System.out.println("This is True");
        }

        boolean isCar = false;
        if(!isCar){
            System.out.println("this is not a car");
        }

        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if(isDomestic){
            System.out.println("This Car is domestic to our country");
        }

        String s = (isDomestic) ? "This Car is domestic" : "This Car is not domestic";

        System.out.println(s);

        double myFirstValue = 20.00d;
        double mySecondValue = 80.00d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00d;
        System.out.println("MyValuesTotal ="+ myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;
        System.out.println("theRemainder = "+ theRemainder);
        boolean isNoRemainder = (theRemainder == 0)? true : false;
        System.out.println("isNoRemainder = " + isNoRemainder);
        if (!isNoRemainder){
            System.out.println("Got some remainder");
        }
    }
}
