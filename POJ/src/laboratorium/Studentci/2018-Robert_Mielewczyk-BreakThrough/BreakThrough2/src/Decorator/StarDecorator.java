package Decorator;

import Canvas.Board;
import Player.Position;

import java.util.ArrayList;

public class StarDecorator extends BoardDecorator {
    public StarDecorator(Board decoratedBoard) {
        super(decoratedBoard);
    }

    @Override
    public void set(ArrayList<Position> player1, ArrayList<Position> player2) {

    }

    @Override
    public void display() {
        decoratedBoard.display();
        setStars(decoratedBoard);
    }

    @Override
    public void initialize() {

    }

    private void setStars(Board decoratedBoard){
        //Gwiazdki odzielające plansze
        for(int i=0;i<15;i++){
            System.out.print("*");
        }
    }
}
