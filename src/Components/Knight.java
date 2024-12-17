package Components;
import java.util.List;
public class Knight extends Piece
{
    public Knight(String[][] game_array)
    {
        super(game_array);
    }

    public List<String> get_all_moves_combinations(int row, int column, int color_move)
    {
    //1x-2y
    // 2x-1y
    boolean IsOccupied = false;
    boolean opposite_search_x = false;
        boolean opposite_search_y = false;
    //initial
    int y_search = row +1;
    int x_search = column;

    int initial_row = 1;
    int initial_column = 2;


    int search_counter = 0;
    String notation = "";
    //row + i
        //1y
        while(search_counter != 8)
        {
            if(search_counter == 4)
            {
                initial_row++;
                initial_column--;
            }

            if(opposite_search_x)
            {
                //para maging negative
              x_search = column - initial_column;

            }
            else
            {
                x_search = column + initial_column;

            }

            if(search_counter == 2 || search_counter ==6)
            {
                y_search = row - initial_row;
            }

            if(search_counter == 4)
            {
                y_search = row + initial_row;
            }


//opposite direction, mag modulo ka sana





            //2y


            if(x_search <= 7 && x_search >= 0 && y_search <= 7 && y_search >= 0)
            {
                IsOccupied = IsTileOccupied(y_search, x_search);
                if(!IsOccupied)
                {
                    notation = notation_converter(y_search, x_search);
                    All_valid_moves.add("N" + notation);
                }
            }


            search_counter++;
            opposite_search_x = !opposite_search_x;

        }


        return All_valid_moves;
    }

    public List<String> get_all_captures_combinations(int row, int column, int color_move)
    {
        //1x-2y
        // 2x-1y
        boolean IsOccupied = false;
        boolean opposite_search_x = false;
        boolean opposite_search_y = false;
        //initial
        int y_search = row +1;
        int x_search = column;

        int initial_row = 1;
        int initial_column = 2;


        int search_counter = 0;
        String notation = "";
        String GetPiece = "";
        //row + i
        //1y
        while(search_counter != 8)
        {
            if(search_counter == 4)
            {
                initial_row++;
                initial_column--;
            }

            if(opposite_search_x)
            {
                //para maging negative
                x_search = column - initial_column;

            }
            else
            {
                x_search = column + initial_column;

            }

            if(search_counter == 2 || search_counter ==6)
            {
                y_search = row - initial_row;
            }

            if(search_counter == 4)
            {
                y_search = row + initial_row;
            }


//opposite direction, mag modulo ka sana





            //2y


            if(x_search <= 7 && x_search >= 0 && y_search <= 7 && y_search >= 0)
            {
                IsOccupied = IsTileOccupied(y_search, x_search);
                if(IsOccupied)
                {
                    GetPiece = pieceInarray(y_search, x_search);
                    notation = notation_converter(y_search, x_search);
                    if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W'))
                    {
                        if (GetPiece.length() == 4) {
                            All_valid_captures.add(GetPiece.charAt(1) + notation);
                        } else {
                            All_valid_captures.add(notation);
                        }
                    }
                    }

            }


            search_counter++;
            opposite_search_x = !opposite_search_x;

        }


        return All_valid_captures;
    }
}
