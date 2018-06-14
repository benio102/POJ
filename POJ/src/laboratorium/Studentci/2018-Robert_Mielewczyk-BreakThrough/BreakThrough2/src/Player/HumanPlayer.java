package Player;

import Global.Reference;

import java.util.ArrayList;

public class HumanPlayer implements Player {

    private ArrayList<Position> position;
    public HumanPlayer(){
        position = new ArrayList<Position>();
        for(int i=6;i<8;i++){
            for(int j=0;j<8;j++){
                position.add(new Position(i,j));
            }
        }
    }


    @Override
    public void set(int oldx,int oldy, int newx, int newy) {
        System.out.println(Reference.ANSI_PURPLE +"DEBUG");
        //Say all positions
        for(int i=0;i<position.size();i++){
            System.out.print(position.get(i).getX()+" ,Y:"+position.get(i).getY());
        }

        //Find old position change it to new
        for(int i=0;i<position.size();i++){

            if(position.get(i).getX() == oldx && position.get(i).getY() == oldy){
                position.remove(i);
                position.add(new Position(newx, newy));
            }
        }

        //Say all positions
        for(int i=0;i<position.size();i++){
            System.out.print(position.get(i).getX()+" ,Y:"+position.get(i).getY());
        }

        System.out.println(Reference.ANSI_RESET);
    }

    @Override
    public void delete(int x, int y) {
        for(int i=0;i<position.size();i++){
            if(position.get(i).getX() == x && position.get(i).getY() == y){
                position.remove(i);
            }
        }
    }

    @Override
    public void debug() {
        System.out.println("Human Player: ");
        for(int i=0;i<position.size();i++){
            position.get(i).dump();
        }
    }

    @Override
    public void makeMove(Player opponent) {

    }

    public ArrayList<Position> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Position> position) {
        this.position = position;
    }
}
