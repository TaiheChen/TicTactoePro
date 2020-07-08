import java.util.InputMismatchException;
import java.util.Scanner;

public class Play   {
    public static void main(String args[]) {
        Board board = new Board();
        Scanner alg = new Scanner(System.in);
        System.out.println("What algrithm do you want to use?");
        System.out.println("1.Q-Learning 2.MC 3.Mini-max");
        int opt = alg.nextInt();
        if (opt == 1){
        Q q = new Q();
        Scanner input = new Scanner(System.in);
        Boolean firstTurn = true;
        int games = 0;
        System.out.println("How many games to train for Q-learning?");
        int max_train;
        while (true) {
            try {
                max_train = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number");
            }
        }

        while (true) {
            if (firstTurn) { //prints the board in the first turn a game
                if (games >= max_train)
                    board.printBoard();
                firstTurn = false;
            }
            if (games < max_train) { //just to train a bit
                board.play(board.playRandom(), 'X');
                //System.out.println("plays -> "+ plays);
            } else {
                //System.out.println("whats your play?");
                while (true) {
                    try {
                        int humanPlay = input.nextInt();
                        if (board.emptyPosition(humanPlay)) {
                            board.play(humanPlay, 'X');
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid play.");
                    }
                }
            }
            q.savePlay(String.valueOf(board.board));
            if (games > max_train)
                board.printBoard();
            //
            //if human player ended game
            if (board.isFull() || board.whoWon() != 'n') {
                //q.printThisGame();
                if (board.whoWon() != 'n') {
                    if (games >= max_train)
                        System.out.println("X won the game.\n");
                    q.gameEnded(-1);
                } else {
                    if (games >= max_train)
                        System.out.println("It's a draw.\n");
                    q.gameEnded(1);
                }
                board = new Board();
                firstTurn = true;
                //q.printQ();
                games++;
                //System.out.println("games ->"+games);
            }
            //end of if the human player ended game
            //
            else { //if human didnt end the game
                if (q.hasState(String.valueOf(board.board))) {          //has data
                    int AIPlay = q.checkNext(board.board);
                    //System.out.println("AI play = " +AIPlay);
                    if (AIPlay == -1)
                        board.play(board.playRandom(), 'O');
                    else
                        board.play(AIPlay, 'O');
                } else {                                                //no data
                    board.play(board.playRandom(), 'O');
                }
                q.savePlay(String.valueOf(board.board));
                if (games >= max_train)
                    board.printBoard();
                //
                //if AI ended game
                if (board.isFull() || board.whoWon() != 'n') {
                    //q.printThisGame();
                    if (board.whoWon() != 'n') {
                        if (games >= max_train)
                            System.out.println("O won the game.\n");
                        q.gameEnded(2);
                    } else {
                        if (games >= max_train)
                            System.out.println("It's a draw.\n");
                        q.gameEnded(1);
                    }
                    board = new Board();
                    firstTurn = true;
                    //q.printQ();
                    games++;
                    //System.out.println("games ->"+games);
                }
                //end of if AI ended game
                //
            }

        }
    }
        else if (opt == 2){
            Mc game = new Mc();
            game.startGame();
        }
        else if (opt == 3){
            miniMax m = new miniMax();
            m.start();
        }
    }
}
