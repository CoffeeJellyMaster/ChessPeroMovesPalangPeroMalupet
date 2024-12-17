package Game;
import Components.*;

import java.util.List;
import java.util.Scanner;

public class MoveEvaluator {
    String move_input;
    String current;
    String next;
    String move_method; //eh kung cpature or move lang


    char current_file;
    char current_rank;

    char next_file;
    char next_rank;

    int current_array_row;
    int current_array_column;

    char current_piece_type = ' ';
    char next_piece_type = ' ';

//sala yung data type HAHAHAH
    int next_array_row;
    int next_array_column;

    int total_game_moves;


    List<String> current_AllPossibleMoves;
    List<String> next_AllPossibleMoves;

    List<String> current_AllPossibleCaptures;
    List<String> next_AllPossibleCaptures;

    private String[][] game_array;

    // Constructor
    public MoveEvaluator(String[][] game_array, int game_moves) {
        this.game_array = game_array;
        this.total_game_moves = game_moves;
    }

    public void getInput() {
        Scanner Input = new Scanner(System.in);
        System.out.println("Enter your move: ");
        move_input = Input.nextLine();
    }

    private void setMove() {

        if (move_input == null || move_input.isEmpty()) {
            throw new IllegalArgumentException("Move input is empty. Please provide a valid move.");
        }

        String[] input_parts;
        if (move_input.contains("-")) {
            move_method = "move_piece";
            input_parts = move_input.split("-");
        } else if (move_input.contains("x")) {
            move_method = "capture_piece";
            input_parts = move_input.split("x");
        } else {
            throw new IllegalArgumentException("Invalid move input. Must contain '-' or 'x'.");
        }


        if (input_parts.length == 2) {
            current = input_parts[0];
            next = input_parts[1];
        } else {
            throw new IllegalArgumentException("Invalid move format. Input should have exactly two parts.");
        }
    }

    public void set_current_details() {
        for (int i = 0; i <current.length(); i++) {
        if(current.charAt(i) == 'a' ||current.charAt(i) == 'b' ||current.charAt(i) == 'c' ||current.charAt(i) == 'd' ||current.charAt(i) == 'e' ||current.charAt(i) == 'f' ||current.charAt(i) == 'g' ||current.charAt(i) == 'h')
        {
            current_file =current.charAt(i);
        }
        else if(current.charAt(i) == '1' ||current.charAt(i) == '2' ||current.charAt(i) == '3' ||current.charAt(i) == '4' ||current.charAt(i) == '5' ||current.charAt(i) == '6' ||current.charAt(i) == '7' ||current.charAt(i) == '8')
        {
            current_rank =current.charAt(i);
        }
        else if (current.charAt(i) == 'R' || current.charAt(i) == 'N' || current.charAt(i) == 'B' || current.charAt(i) == 'Q' || current.charAt(i) == 'K' || current.charAt(i) == 'P')
        {
            current_piece_type = current.charAt(i);
        }
            if(current_piece_type == ' '){
                current_piece_type = 'P';
            }

//

        switch (current_file)
        {
        case 'a':
            current_array_column = 0;
            break;
        case 'b':
            current_array_column = 1;
            break;
        case 'c':
            current_array_column = 2;
            break;
        case 'd':
            current_array_column = 3;
            break;
        case 'e':
            current_array_column = 4;
            break;
        case 'f':
            current_array_column = 5;
            break;
        case 'g':
            current_array_column = 6;
            break;
        case 'h':
            current_array_column = 7;
            break;
        }
        switch (current_rank)
        {
        case '1':
            current_array_row = 7;
            break;
        case '2':
            current_array_row = 6;
            break;
        case '3':
            current_array_row = 5;
            break;
        case '4':
            current_array_row = 4;
            break;
        case '5':
            current_array_row = 3;
            break;
        case '6':
            current_array_row = 2;
            break;
        case '7':
            current_array_row = 1;
            break;
        case '8':
            current_array_row = 0;
            break;
        }

        }

    }
    private void set_next_details()
    {
        for (int i = 0; i <next.length(); i++) {
            if(next.charAt(i) == 'a' ||next.charAt(i) == 'b' ||next.charAt(i) == 'c' ||next.charAt(i) == 'd' ||next.charAt(i) == 'e' ||next.charAt(i) == 'f' ||next.charAt(i) == 'g' ||next.charAt(i) == 'h')
            {
                next_file =next.charAt(i);
            }
            else if(next.charAt(i) == '1' ||next.charAt(i) == '2' ||next.charAt(i) == '3' ||next.charAt(i) == '4' ||next.charAt(i) == '5' ||next.charAt(i) == '6' ||next.charAt(i) == '7' ||next.charAt(i) == '8')
            {
                next_rank =next.charAt(i);
            }
            else if (next.charAt(i) == 'R' || next.charAt(i) == 'N' || next.charAt(i) == 'B' || next.charAt(i) == 'Q' || next.charAt(i) == 'K')
            {
                next_piece_type = next.charAt(i);
            }

            if(next_piece_type == ' '){
                next_piece_type = 'P';
            }
//

            switch (next_file)
            {
                case 'a':
                    next_array_column = 0;
                    break;
                case 'b':
                    next_array_column = 1;
                    break;
                case 'c':
                    next_array_column = 2;
                    break;
                case 'd':
                    next_array_column = 3;
                    break;
                case 'e':
                    next_array_column = 4;
                    break;
                case 'f':
                    next_array_column = 5;
                    break;
                case 'g':
                    next_array_column = 6;
                    break;
                case 'h':
                    next_array_column = 7;
                    break;
            }
            switch (next_rank)
            {
                case '1':
                    next_array_row = 7;
                    break;
                case '2':
                    next_array_row = 6;
                    break;
                case '3':
                    next_array_row = 5;
                    break;
                case '4':
                    next_array_row = 4;
                    break;
                case '5':
                    next_array_row = 3;
                    break;
                case '6':
                    next_array_row = 2;
                    break;
                case '7':
                    next_array_row = 1;
                    break;
                case '8':
                    next_array_row = 0;
                    break;
            }

        }
    }

    public void input_move()
    {
        boolean isLegalMove = false;

            getInput();
            setMove();
            set_current_details();
            set_next_details();
    }

    public boolean IsLegalMove()
    {
        boolean isLegalMove = false;
        boolean IsCurrentColorValid;
        boolean IsNextColorValid;

        IsCurrentColorValid = checkIfColorValid(total_game_moves, current_array_row, current_array_column);
        IsNextColorValid = checkIfColorValid(total_game_moves, next_array_row, next_array_column);

        if (move_method == "move_piece") {
            current_AllPossibleMoves = GetValidMove(current_array_row, current_array_column, current_piece_type);
            if (IsCurrentColorValid) {
                isLegalMove = determineValidmove(current_AllPossibleMoves, next);
            }
        }

        if (move_method == "capture_piece") {
            if (IsCurrentColorValid != IsNextColorValid) {
                current_AllPossibleCaptures = GetValidMove(current_array_row, current_array_column, current_piece_type);
                isLegalMove = determineValidCapture(current_AllPossibleCaptures, next);
            }
        }



        char Color = (total_game_moves % 2 == 0) ? 'W' : 'B';
      if (isLegalMove) {
                game_array[current_array_row][current_array_column] = "0";

                game_array[next_array_row][next_array_column] = Color + next;
                total_game_moves++;
                return true;
            }
      return false;

    }

    private boolean checkIfColorValid(int total_game_moves,int row, int column)
    {

        int color = total_game_moves % 2;
        String value_in_array = game_array[row][column];
        char piece_color = value_in_array.charAt(0);
        if(color == 0 && piece_color == 'W')
        {
        return true;
        }

        if (color == 1 && piece_color == 'B')
        {
            return true;
        }

        return false;
    }
    private boolean checkIfMovePieceValid()
    {

        if(current_piece_type == next_piece_type)
        {
            return true;
        }
        return false;
    }
    private boolean determineValidmove(List<String>AllPossibleMoves, String next)
    {
        for(int i = 0; i < AllPossibleMoves.size(); i++)
        {
            if(AllPossibleMoves.get(i).equals(next))
            {
                return true;
            }
        }
        return false;
    }

    private boolean determineValidCapture(List<String> AllPossibleCaptures, String next)
    {
        for(int i = 0; i < AllPossibleCaptures.size(); i++)
        {
            if(AllPossibleCaptures.get(i).equals(next))
            {
                return true;
            }
        }
        return false;
    }
    private List<String> GetValidMove(int row, int column, char piece_type)
    {
        List<String> AllPossibleMoves = null;
        switch (piece_type)
        {
            case 'P':
                Pawn pawn = new Pawn(game_array);
                pawn.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = pawn.getAllValidMoves();
                break;
            case 'B':
                Bishop bishop = new Bishop(game_array);
                bishop.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = bishop.getAllValidMoves();
                break;
            case 'N':
                Knight knight = new Knight(game_array);
                knight.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = knight.getAllValidMoves();
                break;
            case 'R':
                Rook rook = new Rook(game_array);
                rook.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = rook.getAllValidMoves();
                break;
                case 'Q':
                Queen queen = new Queen(game_array);
                queen.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = queen.getAllValidMoves();
                break;
            case 'K':
                King king = new King(game_array);
                king.get_all_moves_combinations(row, column, total_game_moves % 2);
                AllPossibleMoves = king.getAllValidMoves();
                break;


                //piece kung same type sa move
        }
        return AllPossibleMoves;
    };
    private boolean IsMoveLegal()
    {
        return true;
    }
}
