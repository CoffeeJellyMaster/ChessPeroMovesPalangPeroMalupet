package Components;
import java.util.List;
public class King extends Piece {
    public King(String[][] game_array) {
        super(game_array);
    }

    public List<String> get_all_moves_combinations(int row, int column, int color_move) {
        boolean IsOccupied = false;

        for (int i = 0; i < 8; i++)
        {
            int initial_row = row;
            int initial_column = column;

            switch(i){
                case 0:
                    initial_row++;
                    initial_column++;
                    break;
                case 1:
                    initial_row++;
                    initial_column--;
                    break;
                case 2:
                    initial_row--;
                    initial_column++;
                    break;
                case 3:
                    initial_row--;
                    initial_column--;
                    break;
                case 4:
                    initial_row++;
                    break;
                case 5:
                    initial_row--;
                    break;
                case 6:
                    initial_column++;
                    break;
                case 7:
                    initial_column--;
                    break;
            }

            if (initial_row == 8 || initial_column == 8 || initial_row == -1 || initial_column == -1)
            {

            }
            else
            {
            IsOccupied = IsTileOccupied(initial_row, initial_column);
             if(!IsOccupied)
             {
                String notation = notation_converter(initial_row, initial_column);
                All_valid_moves.add('K' + notation);
             }

            }


        }
        return All_valid_moves;
    }
    public List<String> get_all_captures_combinations(int row, int column, int color_move) {
        boolean IsOccupied = false;
        String GetPiece = "";
        for (int i = 0; i < 8; i++)
        {
            int initial_row = row;
            int initial_column = column;

            switch(i){
                case 0:
                    initial_row++;
                    initial_column++;
                    break;
                case 1:
                    initial_row++;
                    initial_column--;
                    break;
                case 2:
                    initial_row--;
                    initial_column++;
                    break;
                case 3:
                    initial_row--;
                    initial_column--;
                    break;
                case 4:
                    initial_row++;
                    break;
                case 5:
                    initial_row--;
                    break;
                case 6:
                    initial_column++;
                    break;
                case 7:
                    initial_column--;
                    break;
            }

            if (initial_row == 8 || initial_column == 8 || initial_row == -1 || initial_column == -1)
            {

            }
            else
            {
                IsOccupied = IsTileOccupied(initial_row, initial_column);
                if(IsOccupied)
                {
                    GetPiece = pieceInarray(row, initial_column);
                    String notation = notation_converter(initial_row, initial_column);
                    if((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W'))
                    {
                        if (GetPiece.length() == 4) {
                            All_valid_captures.add(GetPiece.charAt(1) + notation);
                        } else {
                            All_valid_captures.add(notation);
                        }
                    }
                }

            }


        }
        return All_valid_captures;
    }

}