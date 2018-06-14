package StateChoices;


import Global.Reference;
import Player.Player;

import java.util.Scanner;

public class Select implements State {

    Scanner scan;
    String input;

    public void doChoice(Player player, Player opponent) {
        scan = new Scanner(System.in);
        System.out.println("Wchich player would you like to choose type(x,y)?\n");
        player.debug();
        System.out.println();
        input = scan.nextLine();
        if(input.matches("^[0-7],[0-7]$")){
                for(int i=0;i<player.getPosition().size();i++){
                    if(player.getPosition().get(i).getX() == ((int)input.charAt(0)-48) && player.getPosition().get(i).getY() == ((int)input.charAt(2))-48){
                        System.out.println(Reference.ANSI_PURPLE+"SUCCESFULLY SELECTED: ("+input+")"+Reference.ANSI_RESET);
                        System.out.println("Would you like to make a move? yes/select/exit: ");
                        String input2 = scan.nextLine();
                        if(input2.equalsIgnoreCase("yes")){
                            System.out.println("Which position would you like to take?");
                            input2 = scan.nextLine();
                            if(input2.matches("^[0-7],[0-7]$")){
                                //Stworzenie pozycji
                                boolean breaker = false;
                                int oldy = input.charAt(0)-48; //
                                int oldx = input.charAt(2)-48; // [oldy][oldx]
                                int newy = input2.charAt(0)-48;//
                                int newx = input2.charAt(2)-48;// [newy][newx]
                                if((oldx == newx || oldx == newx+1 || oldx == newx-1) && newy-oldy==-1){
                                    System.out.println("Pozycja w zakresie");

                                    //If your player blocks your way
                                    for(int j=0;j<player.getPosition().size();j++){
                                        if(player.getPosition().get(j).getX() == newy && player.getPosition().get(j).getY() == newx){
                                            System.out.println(Reference.ANSI_PURPLE+"Your Player Blocks Your Way"+Reference.ANSI_RESET);
                                            breaker = true;
                                            break;
                                        }
                                    }

                                    //if your enemy is infront of you
                                    for(int j=0;j<opponent.getPosition().size();j++){
                                        if(newy == opponent.getPosition().get(j).getX() && newx == opponent.getPosition().get(j).getY()){
                                            //Check if you can move to his position
                                            if(newx == oldx){ //Przeciwnik, przed graczem
                                                System.out.println(Reference.ANSI_PURPLE+"You can't kill opponent in front"+Reference.ANSI_RESET);
                                                breaker = true;
                                                break;
                                            }
                                            else if(newx == oldx-1 || newx == oldx+1){
                                                System.out.println(Reference.ANSI_PURPLE+"You killed that pawn"+Reference.ANSI_RESET);
                                                opponent.getPosition().remove(j);
                                                break;
                                            }
                                            else{
                                                breaker = true;
                                            }
                                        }
                                    }


                                    //If anycode above breakes player wont be set
                                    if(breaker) {
                                        doChoice( player, opponent);
                                        break;
                                    }
                                    System.out.println("Succes your pawn moved"+newy+newx);
                                        player.getPosition().get(i).setX(newy);
                                        player.getPosition().get(i).setY(newx);
                                }
                            }else{
                                doChoice( player, opponent);
                            }
                        }
                        else if(input2.equalsIgnoreCase("select")){
                            doChoice( player, opponent);
                        }
                        break; //your selection was found --> end
                    }
                }
        }
        else{
            doChoice( player, opponent);
        }

    }

    public void update(Player player, Player opponent){

    }


    @Override
    public void doAction(Context context) {
        context.setState(this);

    }
}
