package Components;
import java.util.List;

public class Queen extends Piece
{
    public Queen(String[][] game_array)
    {
        super(game_array);
    }

    public List<String> get_all_moves_combinations(int row, int column, int color_move)
    {

        int initial_row = row;
        int initial_column = column;
        int counter_left = 0;
        int counter_right = 0;

        String notation= "";
        boolean IsOccupied = false;
        boolean sequence_left_north = false;
        boolean sequence_right_north = false;
        boolean sequence_left_south = false;
        boolean sequence_right_south = false;
        //north
        while (initial_row < 7)
        {
            initial_row++;
            counter_left++;
            if (column-counter_left < 0) {

            } else {

                IsOccupied = IsTileOccupied(initial_row, (column - counter_left));

                if (IsOccupied) {
                    sequence_left_north = true;

                }
                if(!sequence_left_north)
                {

                    notation = notation_converter(initial_row, column - counter_left);

                    All_valid_moves.add('B' + notation);
                }
            }

            counter_right++;

            if (column+counter_right >= 7)
            {

            }
            else
            {
                IsOccupied = IsTileOccupied(initial_row, (column + counter_right));
                if (IsOccupied) {
                    sequence_right_north = true;
                }
                if(!sequence_right_north)
                {
                    notation = notation_converter(initial_row, (column + counter_right));

                    All_valid_moves.add('B' + notation);
                }
            }
        }


        initial_row = row;
        counter_right = 0;
        counter_left = 0;

        //south
        while (initial_row > 0)
        {
            initial_row--;

            counter_left++;
            if (column-counter_left < 0)
            {

            } else {

                IsOccupied = IsTileOccupied(initial_row, (column - counter_left));

                if (IsOccupied)
                {
                    sequence_left_south = true;
                }
                if(!sequence_left_south)
                {

                    notation = notation_converter(initial_row, column - counter_left);

                    All_valid_moves.add('Q' + notation);
                }
            }

            counter_right++;
            if (column+counter_right >= 7)
            {

            }
            else
            {
                IsOccupied = IsTileOccupied(initial_row, (column + counter_right));

                if (IsOccupied)
                {
                    sequence_right_south = true;
                }
                if(!sequence_right_south) {
                    notation = notation_converter(initial_row, (column + counter_right));

                    All_valid_moves.add('Q' + notation);
                }
            }
        }

        initial_row = row;

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
                All_valid_moves.add('Q' + notation);
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
                All_valid_moves.add('Q' + notation);
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
                All_valid_moves.add('Q' + notation);
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
                All_valid_moves.add('Q' + notation);
            }
        }


        return All_valid_moves;
    }

    public List<String> get_all_capture_combinations(int row, int column, int color_move)
    {
        int initial_row = row;
        int counter_left = 0;
        int counter_right = 0;
        int initial_column = column;

        String notation= "";
        String GetPiece = "";
        boolean IsOccupied = false;

        boolean stop_sequence_left = false;
        boolean stop_sequence_right = false;

        //north
        while (initial_row < 8)
        {
            initial_row++;
            counter_left++;
            if (column-counter_left < 0) {

            } else {

                IsOccupied = IsTileOccupied(initial_row, (column - counter_left));

                if (IsOccupied) {

                    if(!stop_sequence_left)
                    {

                        notation = notation_converter(initial_row, column - counter_left);
                        GetPiece = pieceInarray(initial_row, column - counter_left);
                        if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                            if (GetPiece.length() == 4) {
                                All_valid_captures.add(GetPiece.charAt(1) + notation);

                            } else {
                                All_valid_captures.add(notation);
                            }
                        }
                    }


                    stop_sequence_left = true;

                }


            }

            counter_right++;

            if (column+counter_right >= 7)
            {

            }
            else
            {
                IsOccupied = IsTileOccupied(initial_row, (column + counter_right));
                if (IsOccupied)
                {
                    if(!stop_sequence_right)
                    {
                        notation = notation_converter(initial_row, (column + counter_right));
                        GetPiece = pieceInarray(initial_row, column + counter_right);
                        if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                            if (GetPiece.length() == 4) {
                                All_valid_captures.add(GetPiece.charAt(1) + notation);

                            } else {
                                All_valid_captures.add(notation);
                            }
                        }
                    }
                    stop_sequence_right = true;
                }

            }
        }


        initial_row = row;
        counter_right = 0;
        counter_left = 0;
        stop_sequence_right = false;
        stop_sequence_left = false;

        //south
        while (initial_row > 0)
        {
            initial_row--;

            counter_left++;
            if (column-counter_left < 0)
            {

            } else {

                IsOccupied = IsTileOccupied(initial_row, (column - counter_left));

                if (IsOccupied)
                {
                    if(!stop_sequence_left)
                    {
                        notation = notation_converter(initial_row, column - counter_left);
                        GetPiece = pieceInarray(initial_row, column - counter_left);
                        if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                            if (GetPiece.length() == 4) {
                                All_valid_captures.add(GetPiece.charAt(1) + notation);
                            } else {
                                All_valid_captures.add(notation);
                            }
                        }
                    }
                    stop_sequence_left = true;
                }

            }

            counter_right++;
            if (column+counter_right >= 7)
            {

            }
            else
            {
                IsOccupied = IsTileOccupied(initial_row, (column + counter_right));

                if (IsOccupied)
                {
                    if(!stop_sequence_right)
                    {
                        notation = notation_converter(initial_row, (column + counter_right));
                        GetPiece = pieceInarray(initial_row, column + counter_right);
                        if ((color_move == 0 && GetPiece.charAt(0) == 'B') || (color_move == 1 && GetPiece.charAt(0) == 'W')) {
                            if (GetPiece.length() == 4) {
                                All_valid_captures.add(GetPiece.charAt(1) + notation);
                            } else {
                                All_valid_captures.add(notation);
                            }
                        }
                    }
                    stop_sequence_right = true;
                }

            }
        }

        initial_row = row;

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

        return All_valid_captures;
    }







}

