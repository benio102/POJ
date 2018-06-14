package Decorator;

import Canvas.Board;
import Canvas.BoardI;

public abstract class BoardDecorator implements BoardI {
    protected Board decoratedBoard;

    public BoardDecorator(Board decoratedBoard){
        this.decoratedBoard = decoratedBoard;
    }

    public void draw(){
        decoratedBoard.display();
    }
}
