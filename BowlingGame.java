package test.KK_ROUGH_Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BowlingGame {

    @DataProvider(name = "BowlingResultGameScenarios")     //Data Inputs using TestNG
    public Object[][] BowlingResultGameScenarios() {
        return new Object[][]{
                {"--------------------"},    //That's a looser test case
                {"3-------------------"},
                {"3/------------------"},      //Spare Test Case
                {"3-5-----------------"},
                {"X-------------------"},      //Strike Test Case
                {"X3/----------------1"},      //Strike Test Case
                {"XX-----------------1"},      //Strike Test Case
                {"XXXXXXXXXXXX"},       //Acceptance Full Strike Test Case
                {"9-9-9-9-9-9-9-9-9-9-"},       //Acceptance Test Case
                {"5/5/5/5/5/5/5/5/5/5/5"}       //Acceptance Test Case

        };
    }

    @Test(dataProvider = "BowlingResultGameScenarios")
    public void testkishore(String[] GameScenario) {

        char[] ThrowingBall = GameScenario[0].toCharArray();        // Splitting string into an array

        int TotalThrowCount = ThrowingBall.length;
        
        GameThrows[] throwsList = new GameThrows[2 + ThrowingBall.length];       // Creating an array to cater all throws.

        int throwNum = -1;
        while(TotalThrowCount > ++throwNum) {
            throwsList[throwNum] = new GameThrows(ThrowingBall[throwNum]);
        }

        throwsList[throwNum++] = null;      // Adding two entries for last round
        throwsList[throwNum++] = null;

        int totalScore = 0, roundCount = 0;     // Initialize counter variables.
        GameRounds theRound;        // Keeps track of current round of play.
        throwNum = 0;

        do {
            roundCount++;

            GameThrows first = throwsList[throwNum];
            GameThrows second = throwsList[1 + throwNum];
            GameThrows third = throwsList[2 + throwNum];

            theRound = new GameRounds(first, second, third);       // Adding rounds

            totalScore += theRound.score;        // Adding round's score to the final score.

            throwNum += theRound.consumed;       // Consumed throws

            System.out.format("Round_No."+ roundCount + "  Score: "+ theRound.score + "  Bonus_Amount: " + theRound.bonus + "\n");

        } while(TotalThrowCount - theRound.bonus > ++throwNum);

        System.out.format("\nTotal Rounds: " + roundCount + "    Total Score: " + totalScore + "\n" );
    }


}




