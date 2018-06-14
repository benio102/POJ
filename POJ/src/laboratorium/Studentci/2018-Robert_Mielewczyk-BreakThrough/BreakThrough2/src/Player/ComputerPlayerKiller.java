package Player;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayerKiller implements Player {
    ArrayList<Position> position;
    public ComputerPlayerKiller(){
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
            if(position.get(i).getX() == x && position.get(i).getY() == y){
                position.remove(i);
            }
        }
    }


    @Override
    public void debug() {
        System.out.println("\n\nComputer Player Killer: ");
        for (int i = 0; i < position.size(); i++) {
            position.get(i).dump();
        }
    }

    @Override
    public void makeMove(Player opponent) {
        Random random = new Random();
        int pickPawn=1;
        Position pickedPawn;
        ArrayList<Moves> moves = new ArrayList<Moves>();
        boolean forward;
        boolean left;
        boolean right;
        boolean kill;
        boolean end;
        do {
            forward = true;
            left = false;
            right = false;
            end = false;
            kill = false;
            pickPawn = random.nextInt(position.size());
            //Picking pawn
            for(int i=0;i<position.size();i++){
                //opponent pawn next to player pawn
                for(int j=0;j<opponent.getPosition().size();j++) {
                    if (position.get(i).getY()-1 == opponent.getPosition().get(j).getY()) {
                        if(position.get(i).getX()-1 == opponent.getPosition().get(j).getX() || position.get(i).getX()+1 == opponent.getPosition().get(j).getX()){
                            pickPawn = i;
                        }
                    }
                }

            }
            pickedPawn = position.get(pickPawn);

            //Check posibilities for killing
            for(int i=0;i<opponent.getPosition().size();i++){
                //player in front (left)
                if(pickedPawn.getY()-1 == opponent.getPosition().get(i).getY() && pickedPawn.getX()+1 == opponent.getPosition().get(i).getX() ){
                    moves.add(new Moves(pickedPawn.getY()-1,pickedPawn.getX()+1));
                    kill = true;
                    left = true;
                    end = true;
                }
                //Player in front (right)
                if(pickedPawn.getY()-1 == opponent.getPosition().get(i).getY() && pickedPawn.getX()+1 == opponent.getPosition().get(i).getX()){
                    moves.add(new Moves(pickedPawn.getY()+1, pickedPawn.getX()+1));
                    kill = true;
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

            //Check Posiblitity of moving
            //Forward
            if(!kill && forward){
                moves.add(new Moves(pickedPawn.getY(),pickedPawn.getX()+1));
                end = true;
            }
            if(!kill && !left && !(pickedPawn.getY()==0)){
                moves.add(new Moves(pickedPawn.getY()-1, pickedPawn.getX()+1));
            }
            if(!kill && !right && !(pickedPawn.getY()==7)){
                moves.add(new Moves(pickedPawn.getY()+1, pickedPawn.getX()+1));
            }


        }while(!end);
        //Perform killer move
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
