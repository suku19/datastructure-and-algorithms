package com.suku.array;

import java.util.Set;
import java.util.TreeSet;

public class ValidateSudoku {

    public static boolean isValidSudoku(char[][] board) {
        if (board == null && board.length != 9 && board[0].length != 9)
            return false;

        //validate row
        for (int i = 0; i < board.length; i++) {
            Set<Character> unique = new TreeSet();
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != '.') {
                    if(unique.contains(board[i][j])){
                        return false;
                    }
                    unique.add(board[i][j]);
                }
            }
        }

        //validate column
        for (int j = 0; j < board.length; j++) {
            Set<Character> unique = new TreeSet();
            for (int i = 0; i< board.length; i++) {
                if(board[i][j] != '.') {
                    if(unique.contains(board[i][j])){
                        return false;
                    }
                    unique.add(board[i][j]);
                }
            }
        }

        //validate blocks
        for(int block =0; block<9; block++) {
            Set<Character> unique = new TreeSet();
            for (int i = block/3*3; i < block/3*3+3; i++){
                for (int j = block%3*3; j < block%3*3+3; j++){
                    if(board[i][j] != '.') {
                        if(unique.contains(board[i][j])){
                            return false;
                        }
                        unique.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        char board[][] = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(board));
    }



}
