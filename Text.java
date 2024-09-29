public class Text {
    String welcomeBanner = """
            ======================
            || BOAT RACING GAME ||
            ======================
            """;
    String rules = """ 
            ********************************************************
            ||              RULES AND INSTURCTIONS                ||
            || Rules:                                             ||
            || 1. Two players will race each other in a river,    ||
            ||    whoever reaches the finish line first wins.     ||
            || 2. In the river thre will be traps and currents,   ||
            ||    currents will boost the player fowards whreas   ||
            ||    traps will send the player backwards.           ||
            || 3. Each round players will move fowards based on   ||
            ||    a roll of a 6-faced dice.                       ||
            || 4. Currents will add 5 points to the player,       ||
            ||    traps will instead deduct 5 points.             ||
            || 5. At the begining of the game each player will    ||
            ||    start with 100 points, each roll of a dice will ||
            ||    add 5 points to the player                      ||
            || 5. Game ends when a boat passes the 100th step and ||
            ||    the player with most points wins the game.      ||
            ********************************************************
    """;;

    String action = """
            1 = Begin Game;
            2 = Display rules and instructions;
            3 = View Highscores;
            4 = Exit Game;
            """;

    String legend = """
            //   Legends: S - Stacked Boat, 1 - Player 1's boat, 2 - Player 2's boat, C - Current, T - Trap, _ - Empty River   //
            """;
    String exitGame = """
            --------------------------------------
            || GAME TERMINATED, HAVE A NICE DAY ||
            --------------------------------------
            """;

    String gameOver = """
            ===============
            || GAME OVER ||
            ===============
            """;

    String scoreBoard = """
            +-+-+-+-+-+-+-+-+-+-+-+-+-+
            +         Scores          +
            +-+-+-+-+-+-+-+-+-+-+-+-+-+
            """;

    public String getRule(){
        return rules;
    }        

    public String getAction(){
        return action;
    }

    public String getLegend(){
        return legend;
    }
    public String getExit(){
        return exitGame;
    }
    public String getWelcomeBanner(){
        return welcomeBanner;
    }
    public String getGameOver(){
        return gameOver;
    }
    public String getScoreBoard(){
        return scoreBoard;
    }
}
