public class Main {

    public static void main(String[] args) {

        System.out.println("New score is "+ calculateScore("Junaid", 500));
        System.out.println("New score is "+ calculateScore(10));
    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player "+ playerName+ " scored " + score +  " points");
        return score * 100;
    }

    public static int calculateScore(int score){
       return calculateScore("Anonymous", score);
        // System.out.println("Unamed Player scored " + score +  " points");
        //return score * 100;
    }

    public static int calculateScore(){
        System.out.println("No player name, no player score");
        return 0;
    }


}
