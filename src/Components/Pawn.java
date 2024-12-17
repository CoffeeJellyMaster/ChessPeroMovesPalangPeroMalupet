package Components;

import java.util.List;
public class Pawn extends Piece {

    public Pawn(String[][] game_array) {
        super(game_array);
    }
    private boolean IsFirstMove;

    @Override
    public List<String> get_all_moves_combinations(int row, int column, int color_move)
    {
        clear_valid_moves();
        String notation = "";
        boolean isOccupied = false;
        if (color_move == 0)
        {

                //first move
                if (row == 6)
                {

                       for(int i = 1; i < 3; i++)
                       {
                                isOccupied = IsTileOccupied(row - i, column);
                                if(isOccupied)
                                {
                                    continue;
                                }
                                else
                                {
                                    notation = notation_converter(row - i, column);
                                    All_valid_moves.add(notation);
                                }
                        }

                }
                else
                {
                        isOccupied = IsTileOccupied(row - 1, column);
                        if(!isOccupied)
                        {
                            notation = notation_converter(row - 1, column);
                            All_valid_moves.add(notation);
                        }
                }
        }
        //WHITE
        else
        {

            //first move
            if (row == 1)
            {
                for(int i = 1; i < 3; i++)
                {
                    isOccupied = IsTileOccupied(row + i, column);
                    if(isOccupied)
                    {
                        continue;
                    }
                    else
                    {
                        notation = notation_converter(row + i, column);
                        All_valid_moves.add(notation);
                    }
                }

            }
            else
            {
                isOccupied = IsTileOccupied(row + 1, column);
                if(!isOccupied)
                {
                    notation = notation_converter(row + 1, column);
                    All_valid_moves.add(notation);
                }
            }

        }
        return All_valid_moves;
    }
    public List<String> get_all_capture_combinations(int row, int column, int color_move)
    {
        boolean IsValidCapture = false;
        String GetValue = "";
        String notation = "";
        if(color_move == 0)
        {
        //left capture
            GetValue = pieceInarray(row-1,column +1);
            if(GetValue.charAt(0) == 'B' && GetValue != "0")
            {
                notation = notation_converter(row-1,column +1);
                All_valid_captures.add(notation);
            }

            //right capture
            GetValue = pieceInarray(row+1,column +1);
            if(GetValue.charAt(0) == 'B' && GetValue != "0")
            {
                notation = notation_converter(row+1,column +1);
                All_valid_captures.add(notation);
            }
        }

        else
        {
            GetValue = pieceInarray(row-1,column -1);

            if(GetValue.charAt(0) == 'B' && GetValue != "0")
            {
                notation = notation_converter(row-1,column -1);
                All_valid_captures.add(notation);
            }

            //right capture
            GetValue = pieceInarray(row+1,column -1);
            if(GetValue.charAt(0) == 'B' && GetValue != "0")
            {
                notation = notation_converter(row+1,column -1);
                All_valid_captures.add(notation);
            }
        }
        return All_valid_captures;
    }

}
