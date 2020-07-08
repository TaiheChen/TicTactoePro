public class Board2 {
    public String[][] board =  {{"     ", "|", "     ", "|", "     "},
            {"- - -", "|", "- - -", "|", "- - -"},
            {"     ", "|", "     ", "|", "     "},
            {"- - -", "|", "- - -", "|", "- - -"},
            {"     ", "|", "     ", "|", "     "},
    };
    public Board2() {
        board = board;
    }
    public void printBoard2() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}