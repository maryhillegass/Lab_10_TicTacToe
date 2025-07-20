public class TicTacToe {
    private static final int ROWS = 3;
    public static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        clearBoard();
        board[0][2] = "O";
        board[1][1] = "O";
        board[2][0] = "O";
        System.out.println("Should be a win for O: " + isWin("O"));
        display();
        clearBoard();
        display();
        System.out.println("Should be a loss for O: " + isWin("O"));

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
        return isDiagonalWin(player) || isColWin(player) || isRowWin(player);
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

    /*
    Checks both diagonals for a player win
    */
    private static boolean isDiagonalWin(String player){
        //first diagonal
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
            return true;
        //Second Diagonal
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            return true;
        return false;
    }

    /*
    Tests for a tie...needs testing
     */
    private static boolean isTie(){
        boolean oPresent = false;
        boolean xPresent = false;
        //rows
        for (int i = 0; i < ROWS; i++) {
            oPresent = board[i][0].equals("O") || board[i][1].equals("O") || board[i][2].equals("O");
            xPresent = board[i][0].equals("X") || board[i][1].equals("X") || board[i][2].equals("X");
            if (!oPresent || !xPresent)
                return false;

        }
        //columns
        for (int i = 0; i < COLS; i++) {
            oPresent = board[0][i].equals("O") || board[1][i].equals("O") || board[2][i].equals("O");
            xPresent = board[0][i].equals("X") || board[1][i].equals("X") || board[2][i].equals("X");
            if (!oPresent || !xPresent)
                return false;
        }
        //Diagonal 1
        oPresent = board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O");
        xPresent = board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X");
        if (!oPresent || !xPresent)
            return false;

        //Diagonal 2
        oPresent = board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O");
        xPresent = board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X");
        if (!oPresent || !xPresent)
            return false;

        //All ties are present
        return true;


    }
}
