public class TicTacToe {
    private static final int ROWS = 3;
    public static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        clearBoard();
        display();
        board[1][1] = "O";
        board[0][0] = "X";
        board[1][0] = "X";
        board[2][0] = "X";
        board[0][1] = "O";
        board[2][1] = "O";
        display();
        System.out.println("Column 1 should be a win for O: " + isColWin("O"));
        System.out.println("Column 0 should be a win for X: " + isColWin("X"));

        clearBoard();

        board[0][0] = "X";
        board[0][1] = "X";
        board[0][2] = "X";
        System.out.println("Should be a loss for O: " + isRowWin("O"));
        board[1][0] = "O";
        board[1][1] = "O";
        board[1][2] = "O";
        System.out.println("Row 0 should be a win for X: " + isRowWin("X"));
        System.out.println("Row 1 should be a win for O: " + isRowWin("O"));


        display();
    }

    /*
    Clears the TicTacToe Board
     */
    private static void clearBoard(){
        //Enters " " into all spaces on the board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";
            }
        }
    }

    /*
    Displays the TicTacToe Board
     */
    private static void display(){
        System.out.printf("\n");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf(" %s ", board[i][j]);
                if (j < 2)
                    System.out.printf("|");
            }
            if (i < 2)
                System.out.printf("\n------------");
            System.out.println("");
        }
    }

    /*
    Checks if space is " " to see if move a move is allowed
     */
    private static boolean isValidMove(int row, int col){
        boolean validMove = board[row][col].equals(" ");
        return validMove;
    }

    /*
    Checks all win conditions
     */
    private static boolean isWin(String player){
        return false;
    }

    /*
    Checks all column for a player win
     */
    private static boolean isColWin(String player){
        for (int i = 0; i < COLS; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)){
                return true;
            }
        }
        return false;
    }

    /*
    Checks all rows for a player win
     */
    private static boolean isRowWin(String player){
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)){
                return true;
            }
        }
        return false;
    }
}
