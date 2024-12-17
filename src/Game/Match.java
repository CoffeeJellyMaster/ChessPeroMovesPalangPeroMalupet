package Game;

public class Match {
    String[][] game_array = {
            {"BRa8", "BNb8", "BBc8", "BQd8", "BKe8", "BBf8", "BNg8", "BRh8"},
            {"Ba7", "Bb7", "Bc7", "Bd7", "Be7", "Bf7", "Bg7", "Bh7"},
            {"0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0"},
            {"Wa2", "Wb2", "Wc2", "Wd2", "We2", "Wf2", "Wg2", "Wh2"},
            {"WRa1", "WNb1", "WBc1", "WQd1", "WKe1", "WBf1", "WNg1", "WRh1"}
    };

int game_moves = 0 ;
boolean GameOver = false;


    public void printboard() {
        for (int i = 0; i < game_array.length; i++) {
            for (int j = 0; j < game_array[i].length; j++) {
                // Print each element with a fixed width for alignment
                System.out.printf("%-6s", game_array[i][j]);
            }
            System.out.println(); // New line after each row
        }
    }
    public void DeclareWinner(String winner) {
        System.out.println("The winner is: " + winner);
    }
    public void StartGame()
    {
        MoveEvaluator moveEvaluator = new MoveEvaluator(game_array, game_moves);
        boolean LegalMove;
        while(true)
        {
            moveEvaluator.input_move();
            LegalMove = moveEvaluator.IsLegalMove();
           if(!LegalMove)
           {
               System.out.println("Illegal Move, input new move");

           }
           else
           {
               printboard();
           }
        }
    }
}


