import static java.lang.StrictMath.floor;

public class Board {
    char board[];

    public Board(){
        board = new char[100];
        for(int i=0;i<100;i++)
            board[i]=' ';
    }

    public boolean emptyPosition(int position){
        if(position<0 || position>99)
            return false;
        if(board[position]==' ')
            return true;
        return false;
    }

    public void play(int position,char player){
        board[position]=player;
    }

    public int playRandom(){
        while(true) {
            int guess= (int) Math.floor(Math.random() * 100);
            if(emptyPosition(guess)) {
                //play(guess, 'O');
                return guess;
            }

        }
    }

    public void printBoard(){
        System.out.println(" -------------");
        for(int i = 0;i<100;i++){

            if(board[i]==' ')
                System.out.print(" | "+i);
            else
                System.out.print(" | "+board[i]);
            if(i%10==9) {
                System.out.println(" |");
                System.out.println(" -------------");
            }
            if(i==99)
                System.out.println();
        }
    }

    public boolean isFull() {
        for(int i=0;i<100;i++)
            if(board[i]==' ')
                return false;
        return true;
    }

    public char whoWon(){
        char result;
        if((result=checkHorizontal())!='n' && result!=' ')
            return result;
        else if((result=checkVertical())!='n' && result!=' ')
            return result;
        else if((result=checkDiagonal())!='n' && result!=' ')
            return result;
        else
            return 'n';

    }

    private char checkHorizontal(){
        for(int i =0;i<10;i++){
            for(int j=0;j<5;j++){
                if(board[j+10*i]==board[1+j+10*i]&&board[1+j+10*i]==board[2+j+10*i]&&board[2+j+10*i]==board[3+j+10*i]&&board[3+j+10*i]==board[4+j+10*i]&&board[j+10*i]!=' '){
                    return board[j+10*i];
                }
            }
        }
        return 'n';
    }

    private char checkVertical(){
        for(int i =0;i<10;i++){
            for(int j=0;j<5;j++){
                if(board[i+10*j]==board[i+10*(j+1)]&&board[i+10*(j+1)]==board[i+10*(j+2)]&&board[i+10*(j+2)]==board[i+10*(j+3)]&&board[i+10*(j+3)]==board[i+10*(j+4)]&&board[i+10*j]!=' '){
                    return board[i+10*j];
                }
            }
        }

     /*   if(board[0]==board[3] && board[3]==board[6] && board[0]!=' ')
            return board[0];
        else if(board[1]==board[4] && board[4]==board[7] && board[1]!=' ')
            return board[1];
        else if(board[2]==board[5] && board[5]==board[8] && board[2]!=' ')
            return board[2];*/
        return 'n';
    }

    private char checkDiagonal(){
        for(int i =0;i<5;i++){
            for(int j=0;j<5;j++){
                if(board[i+10*j]==board[1+i+10*(j+1)]&&board[1+i+10*(j+1)]==board[2+i+10*(j+2)]&&board[2+i+10*(j+2)]==board[3+i+10*(j+3)]&&board[3+i+10*(j+3)]==board[4+i+10*(j+4)]&&board[i+10*j]!=' '){
                    return board[i+10*j];
                }
            }
        }

       /* if(board[0]==board[4] && board[4]==board[8] && board[0]!=' ')
            return board[0];
        else if(board[2]==board[4] && board[4]==board[6] && board[2]!=' ')
            return board[2];*/
        return 'n';
    }
}



