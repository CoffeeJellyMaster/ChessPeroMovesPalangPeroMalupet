package Components;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(String[][] game_array) {
        super(game_array);
    }

    public List<String> get_all_moves_combinations(int row, int column, int color_move)
    {

        int initial_row = row;

        int counter_left = 0;
        int counter_right = 0;

        String notation= "";
        boolean IsOccupied = false;
        boolean sequence_left_north = false;
        boolean sequence_right_north = false;
        boolean sequence_left_south = false;
        boolean sequence_right_south = false;
        //north
        while (initial_row < 8)
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

                if (IsOccupied)
                {
                    sequence_right_south = true;
                }
                if(!sequence_right_south) {
                    notation = notation_converter(initial_row, (column + counter_right));

                    All_valid_moves.add('B' + notation);
                }
            }
        }

        return All_valid_moves;
    }




    public List<String> get_all_capture_combinations(int row, int column, int color_move)
    {
        int initial_row = row;
        int counter_left = 0;
        int counter_right = 0;

        String notation= "";
        String GetValue = "";
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
                        GetValue = pieceInarray(initial_row, column - counter_left);
                        if ((color_move == 0 && GetValue.charAt(0) == 'B') || (color_move == 1 && GetValue.charAt(0) == 'W')) {
                            if (GetValue.length() == 4) {
                                All_valid_captures.add(GetValue.charAt(1) + notation);

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
                        GetValue = pieceInarray(initial_row, column + counter_right);
                        if ((color_move == 0 && GetValue.charAt(0) == 'B') || (color_move == 1 && GetValue.charAt(0) == 'W')) {
                            if (GetValue.length() == 4) {
                                All_valid_captures.add(GetValue.charAt(1) + notation);

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
                        GetValue = pieceInarray(initial_row, column - counter_left);
                        if ((color_move == 0 && GetValue.charAt(0) == 'B') || (color_move == 1 && GetValue.charAt(0) == 'W')) {
                            if (GetValue.length() == 4) {
                                All_valid_captures.add(GetValue.charAt(1) + notation);
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
                        GetValue = pieceInarray(initial_row, column + counter_right);
                        if ((color_move == 0 && GetValue.charAt(0) == 'B') || (color_move == 1 && GetValue.charAt(0) == 'W')) {
                            if (GetValue.length() == 4) {
                                All_valid_captures.add(GetValue.charAt(1) + notation);
                            } else {
                                All_valid_captures.add(notation);
                            }
                        }
                    }
                    stop_sequence_right = true;
                }

            }
        }


        return All_valid_captures;
    }




         }
