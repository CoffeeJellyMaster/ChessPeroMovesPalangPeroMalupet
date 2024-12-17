package Components;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    protected String[][] game_array;
    public Piece(String[][] game_array) {
        this.game_array = game_array;
    }

    protected List<String> All_valid_moves = new ArrayList<>();
    protected List<String> All_valid_captures = new ArrayList<>();

    protected List<String> get_all_moves_combinations(int row, int column, int color)
    {
        return null;
    };
    protected  List<String> get_all_capture_combinations(int row, int column, int color)
    {
        return null;
    };

    public void clear_valid_moves() {
        All_valid_moves.clear();
    }

    public boolean IsTileOccupied(int row, int column) {
        if (game_array[row][column].equals("0")) {
            return false;
        } else {
            return true;
        }
    }
    public String pieceInarray(int row,int column)
    {
        String piece_value = game_array[row][column];
        return piece_value;
    }

    public String notation_converter(int row, int column) {
        char rank = '0';
        char file = '0';
        String notation;

        // Rank (1 to 8) mapping based on row
        switch (row) {
            case 0: rank = '8'; break;
            case 1: rank = '7'; break;
            case 2: rank = '6'; break;
            case 3: rank = '5'; break;
            case 4: rank = '4'; break;
            case 5: rank = '3'; break;
            case 6: rank = '2'; break;
            case 7: rank = '1'; break;
        }

        // File (a to h) mapping based on column
        switch (column) {
            case 0: file = 'a'; break;
            case 1: file = 'b'; break;
            case 2: file = 'c'; break;
            case 3: file = 'd'; break;
            case 4: file = 'e'; break;
            case 5: file = 'f'; break;
            case 6: file = 'g'; break;
            case 7: file = 'h'; break;
        }

        // Combine file and rank to get notation
        notation = file + "" + rank;
        return notation;
    }

    public List<String> getAllValidMoves() {
        return All_valid_moves;
    }
    public List<String> getAllValidCaptures() {
        return All_valid_captures;
    }
}
