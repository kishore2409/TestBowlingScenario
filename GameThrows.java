package test.KK_ROUGH_Tests;

public class GameThrows {

    public final static char MISS = '-';
    public final static char SPARE = '/';
    public final static char STRIKE = 'X';
    public final boolean IsItAMiss;
    public final boolean IsItASpare;
    public final boolean IsItAStrike;
    public final int score;

    public GameThrows(char result) {
        if(MISS == result) {
            IsItAMiss = true;
            IsItASpare = false;
            IsItAStrike = false;
            score = 0;
        } else if(SPARE == result) {
            IsItAMiss = false;
            IsItASpare = true;
            IsItAStrike = false;
            score = 10;
        } else if(STRIKE == result) {
            IsItAMiss = false;
            IsItASpare = false;
            IsItAStrike = true;
            score = 10;
        } else {
            IsItAMiss = false;
            IsItASpare = false;
            IsItAStrike = false;
            score = Character.getNumericValue(result);
        }
    }
}
