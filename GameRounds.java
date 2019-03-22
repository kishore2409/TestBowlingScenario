package test.KK_ROUGH_Tests;

    public class GameRounds {

        public final int score;
        public final int bonus;
        public final int consumed;

        private int getScore(GameThrows ItsAThrow) {
            return null == ItsAThrow ? 0 : ItsAThrow.score;
        }

        /**
         * @param first first throw
         * @param second second throw
         * @param third third throw
         */
        public GameRounds(GameThrows first, GameThrows second, GameThrows third) {
            assert null != first;

            int MyfirstScore = getScore(first);
            int MysecondScore = getScore(second);
            int MythirdScore = getScore(third);

            if(first.IsItAStrike) {
                score = first.score + MysecondScore + MythirdScore;
                bonus = 2;
                consumed = 0;
            } else if(null != second && second.IsItASpare) {
                score = second.score + MythirdScore;
                bonus = 1;
                consumed = 1;
            } else {
                score = MyfirstScore + MysecondScore;
                bonus = 0;
                consumed = 1;
            }
        }

}
