package Canvas;

import Global.Reference;
import Player.PlayerFactory;
import Player.Position;

import java.util.ArrayList;

public class Board implements BoardI {

    private int[][] board;
    public Board(){
        board = new int[8][8];
    }

    @Override
    public void set(ArrayList<Position> player1, ArrayList<Position> player2) {
        //Clear
        initialize();

        //Set player 1
        for(int i=0;i<player1.size();i++){
            board[player1.get(i).getX()][player1.get(i).getY()] = 1;
        }

        //Set player 2
        for(int i=0;i<player2.size();i++){
            board[player2.get(i).getX()][player2.get(i).getY()] = 2;
        }

    }

    @Override
    public void display() {
        System.out.println("\n\nYour game now looks like this:");
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                //Set colors
                if(board[i][j] == 0) System.out.print(Reference.ANSI_BLUE);
                else if(board[i][j] == 1) System.out.print(Reference.ANSI_GREEN);
                else if(board[i][j] == 2) System.out.print(Reference.ANSI_RED);
                //output pawns
                System.out.print(board[i][j]);
            }
            System.out.println(Reference.ANSI_RESET);
        }
    }

    @Override
    public void initialize() {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

}
