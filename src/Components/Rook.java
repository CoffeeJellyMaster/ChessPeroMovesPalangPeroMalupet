package Components;
import java.util.List;
public class Rook extends Piece {
    public Rook(String[][] game_array) {
        super(game_array);
    }

    public List<String> get_all_moves_combinations(int row, int column, int color_move)
    {
      int initial_row = row;
      int initial_column = column;
      boolean IsOccupied = false;
      String notation = "";
     //y-axis
      while(initial_row != 0)
      {
              initial_row--;
              IsOccupied = IsTileOccupied(initial_row, column);

              if (IsOccupied)
              {
                 break;
              }
              else
              {
                  notation = notation_converter(initial_row, column);
                  All_valid_moves.add('R' + notation);
              }


      }
      initial_row = row;

        while(initial_row != 7)
        {
            initial_row++;
            IsOccupied = IsTileOccupied(initial_row, column);

            if (IsOccupied)
            {
               break;
            }
            else
            {
                notation = notation_converter(initial_row, column);
                All_valid_moves.add('R' + notation);
            }


        }

     //X AXIS
        while(initial_column != 7)
        {
            initial_column++;
            IsOccupied = IsTileOccupied(row, initial_column);

            if (IsOccupied)
            {
                break;
            }
            else
            {
                notation = notation_converter(row, initial_column);
                All_valid_moves.add('R' + notation);
            }


        }
        initial_column = column;

        while(initial_column != 0)
        {
            initial_column--;
            IsOccupied = IsTileOccupied(row, initial_column);

            if (IsOccupied)
            {
                break;
            }
            else
            {
                notation = notation_converter(row, initial_column);
                All_valid_moves.add('R' + notation);
            }
        }
      return All_valid_moves;
    }

    public List<String> get_all_captures_combinations(int row, int column, int color_move)
    {
        int initial_row = row;
        int initial_column = column;
        boolean IsOccupied = false;
        String notation = "";
        String GetPiece = "";
        //y-axis
        while(initial_row != 0)
        {
            initial_row--;
            IsOccupied = IsTileOccupied(initial_row, column);

            if (IsOccupied)
            {
                GetPiece = pieceInarray(initial_row, column);
                notation = notation_converter(initial_row, column);
                if((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W'))
                {
                    if (GetPiece.length() == 4) {
                        All_valid_captures.add(GetPiece.charAt(1) + notation);
                    } else {
                        All_valid_captures.add(notation);
                    }
                    break;
                }
            }

        }
        initial_row = row;

        while(initial_row != 7)
        {
            initial_row++;
            IsOccupied = IsTileOccupied(initial_row, column);

            if (IsOccupied) {
                GetPiece = pieceInarray(initial_row, column);
                notation = notation_converter(initial_row, column);
                if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W'))
                {
                    if (GetPiece.length() == 4) {
                        All_valid_captures.add(GetPiece.charAt(1) + notation);
                    } else {
                        All_valid_captures.add(notation);
                    }
                    break;

                }
            }
        }

        //X AXIS
        while(initial_column != 0)
        {
            initial_column--;
            IsOccupied = IsTileOccupied(row, initial_column);

            if (IsOccupied)
            {
                GetPiece = pieceInarray(row, initial_column);
                notation = notation_converter(row, initial_column);
                if((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                    if (GetPiece.length() == 4) {
                        All_valid_captures.add(GetPiece.charAt(1) + notation);
                    } else {
                        All_valid_captures.add(notation);
                    }
                    break;
                }
            }

        }

        initial_column = column;
        while(initial_column != 7)
        {
            initial_column++;
            IsOccupied = IsTileOccupied(row, initial_column);

            if (IsOccupied) {
                GetPiece = pieceInarray(row, initial_column);
                notation = notation_converter(row, initial_column);
                if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                    if (GetPiece.length() == 4) {
                        All_valid_captures.add(GetPiece.charAt(1) + notation);
                    } else {
                        All_valid_captures.add(notation);
                    }
                    break;

                }
            }
        }

        return All_valid_moves;
    }
}
