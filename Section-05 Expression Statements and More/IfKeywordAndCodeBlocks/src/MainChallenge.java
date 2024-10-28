public class MainChallenge {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("The high Score is "+ highScore);

        score = 10000;
        levelCompleted = 8;
        bonus =200;

        System.out.println("The next highScore is "+calculateScore(true, 10000, 8, 200));

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
       int finalScore = score;

        if(gameOver){
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }
    }
}
