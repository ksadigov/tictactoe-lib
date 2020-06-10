package com.sadigov.tictactoe;

public class TicTacToe {

    PlayerMark[][] board;
    int size;

    public TicTacToe(PlayerMark[][] board, int size) {
        if (size < 3) {
            throw new IllegalArgumentException();
        } else {
            this.board = board;
            this.size = size;
        }
    }

    public static void main(String[] args) {

        PlayerMark[][] board = new PlayerMark[][]{
                {PlayerMark.O, PlayerMark.O, PlayerMark.X},
                {PlayerMark.X, PlayerMark.O, PlayerMark.O},
                {PlayerMark.X, PlayerMark.X, PlayerMark.O},
        };


        TicTacToe game = new TicTacToe(board, 3);
        game.printBoard();
        System.out.println("com.sadigov.tictactoe.Result: " + game.checkRightDiagonal());

    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public Result checkColumns() {
        //this loop for columns
        for (int i = 0; i < size; i++) {
            int match = 0;
            //this loop for rows
            for (int j = 0; j < size; j++) {
                //if one cell of matrix is nothing we should return continue
                if (board[i][j] == PlayerMark._) {
                    return Result.CONTINUE;
                }
                //we check our columns first parameters with others parameters of columns
                if (board[0][i] == board[j][i] && ++match == size) {
                    if (board[0][i] == PlayerMark.O) {
                        return Result.O_WINNER;
                    } else if (board[0][i] == PlayerMark.X) {
                        return Result.X_WINNER;
                    }
                }
            }
        }
        return Result.DRAW;
    }

    public Result checkRows() {
        //this loop for rows
        for (int i = 0; i < size; i++) {
            int match = 0;
            //this loop for columns
            for (int j = 0; j < size; j++) {
                //if one cell of matrix is nothing we should return continue
                if (board[i][j] == PlayerMark._) {
                    return Result.CONTINUE;
                }
                //we check all rows first parameter with  others in row
                if (board[i][0] == board[i][j] && ++match == size) {
                    if (board[i][0] == PlayerMark.O) {
                        return Result.O_WINNER;
                    } else if (board[i][0] == PlayerMark.X) {
                        return Result.X_WINNER;
                    }
                }
            }
        }
        return Result.DRAW;
    }

    public Result checkLeftDiagonal() {
        if (checkForContinue()) {
            return Result.CONTINUE;
        } else {
            int match = 0;
            for (int i = 0; i < size; i++) {
                if (board[0][0] == board[i][i] && ++match == size) {
                    if (board[0][0] == PlayerMark.O) {
                        return Result.O_WINNER;
                    } else if (board[0][0] == PlayerMark.X) {
                        return Result.X_WINNER;
                    }
                }
            }
        }
        return Result.DRAW;
    }

    public Result checkRightDiagonal() {
        if (checkForContinue()) {
            return Result.CONTINUE;
        } else {
            int match = 0;
            for (int i = 0; i < size; i++) {
                if ((board[size - 1][0] == board[size - (i + 1)][i]) &&
                        (++match == size)) {
                    if (board[size - 1][0] == PlayerMark.O) {
                        return Result.O_WINNER;
                    } else if (board[size - 1][0] == PlayerMark.X) {
                        return Result.X_WINNER;
                    }
                }
            }
        }
        return Result.DRAW;
    }

    public boolean checkForContinue() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == PlayerMark._) {
                    return true;
                }
            }
        }
        return false;
    }


}
