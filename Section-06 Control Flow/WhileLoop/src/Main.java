public class Main {

    public static void main(String[] args) {

        int j=1;
        while(true){
            if (j > 5){
                break;
            }
            System.out.println(j);
            j++;
        }
        int k=1;
        boolean isReady =false;
        do{
            if(k > 5){
                break;
            }
            System.out.println(k);
            k++;
            isReady = ( k > 0);
        } while (isReady);

        int number = 0;
        while (number < 50){
            number += 5;
            if(number % 25 == 0){
                continue;
            }
            System.out.println(number + "_");
        }
    }
}
