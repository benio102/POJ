package Player;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayerRandom implements Player {
    ArrayList<Position> position;
    public ComputerPlayerRandom(){
        position = new ArrayList<Position>();
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                position.add(new Position(i,j));
            }
        }
    }


    @Override
    public void set(int oldx, int oldy, int newx, int newy) {

    }

    @Override
    public void delete(int x, int y) {
        for(int i=0;i<position.size();i++){
            if(position.get(i).getY() == x && position.get(i).getX() == y){
                position.remove(i);
            }
        }
    }

    @Override
    public void debug() {
        System.out.println("\n\nComputer Player Random: ");
        for (int i = 0; i < position.size(); i++) {
            position.get(i).dump();
        }
    }

    public void makeMove(Player opponent){
        Random random = new Random();
        int pickPawn;
        Position pickedPawn;
        ArrayList<Moves> moves = new ArrayList<Moves>();
        boolean forward = true;
        boolean left = false;
        boolean right = false;
        boolean kill = false;
        boolean end = false;
        do {
            forward = true;
            left = false;
            right = false;
            end = false;
            pickPawn = random.nextInt(position.size());
            System.out.println(pickPawn);
            pickedPawn = position.get(pickPawn);

            //Check posibilities for killing
            for(int i=0;i<opponent.getPosition().size();i++){
                //player in front (left)
                if(pickedPawn.getY()-1 == opponent.getPosition().get(i).getY() && pickedPawn.getX()+1 == opponent.getPosition().get(i).getX() ){
                    moves.add(new Moves(pickedPawn.getY()-1,pickedPawn.getX()+1));
                    left = true;
                    end = true;
                }
                //Player in front (right)
                if(pickedPawn.getY()-1 == opponent.getPosition().get(i).getY() && pickedPawn.getX()+1 == opponent.getPosition().get(i).getX()){
                    moves.add(new Moves(pickedPawn.getY()+1, pickedPawn.getX()+1));
                    right = true;
                    end = true;
                }
                if(pickedPawn.getY() == opponent.getPosition().get(i).getY() && pickedPawn.getX()+1 == opponent.getPosition().get(i).getX()){
                    forward = false;
                }
            }

            //Check your pawns
            for(int i=0;i<position.size();i++){
                //Check if your pawn is in front of you
                if(position.get(i).getY() == pickedPawn.getY() && position.get(i).getX() == pickedPawn.getX()+1){
                    forward = false;
                }
                //Check if you pawn is left or right
                if(position.get(i).getY() == pickedPawn.getY()-1 && position.get(i).getX() == pickedPawn.getX()+1){
                    left = true;
                }
                if(position.get(i).getY() == pickedPawn.getY()+1 && position.get(i).getX() == pickedPawn.getX()+1){
                    right = true;
                }
            }

            //Check Posiblitity for moving
            //Forward
            if(forward){
                moves.add(new Moves(pickedPawn.getY(),pickedPawn.getX()+1));
                end = true;
            }
            if(!left && !(pickedPawn.getY()==0)){
                moves.add(new Moves(pickedPawn.getY()-1, pickedPawn.getX()+1));
            }
            if(!right && !(pickedPawn.getY()==7)){
                moves.add(new Moves(pickedPawn.getY()+1, pickedPawn.getX()+1));
            }


        }while(!end);
        //Perform random move
        int finalMove = random.nextInt(moves.size());
        pickedPawn.setX(moves.get(finalMove).getY());
        pickedPawn.setY(moves.get(finalMove).getX());

        //check if player was killed
        //find opponent with x, and y of this position
        for(int i=0;i<opponent.getPosition().size();i++){
            if(pickedPawn.getX() == opponent.getPosition().get(i).getX() && pickedPawn.getY() == opponent.getPosition().get(i).getY()){
                opponent.getPosition().remove(i);
                break;
            }
        }

    }

    @Override
    public ArrayList<Position> getPosition() {
        return position;
    }
}
