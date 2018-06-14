package StateChoices;

import Player.Position;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete implements State{
    Scanner scan;
    String input;
    public void delero(){

    }
    public void delete(ArrayList<Position> player1, ArrayList<Position> player2) {
        scan = new Scanner(System.in);
        System.out.println("Who would you like to delete? player1, or player2?");
        input = scan.nextLine();
        if (input.equals("player1")) {
            System.out.println("Which pawn would you like to delete? type(x,y): ");
            input = scan.nextLine();
            if (input.matches("^[0-7],[0-7]$")) {
                for (int i = 0; i < player1.size(); i++) {
                    if (player1.get(i).getX() == ((int) input.charAt(0) - 48) && player1.get(i).getY() == ((int) input.charAt(2)) - 48) {
                        player1.remove(i);
                    }
                }
            }
        } else if (input.equals("player2")) {
            System.out.println("Which pawn would you like to delete? type(x,y): ");
            input = scan.nextLine();
            if (input.matches("^[0-7],[0-7]$")) {
                for (int i = 0; i < player2.size(); i++) {
                    if (player2.get(i).getX() == ((int) input.charAt(0) - 48) && player2.get(i).getY() == ((int) input.charAt(2)) - 48) {
                        player2.remove(i);
                    }
                }
            }
        } else {
            System.out.println("\nSorry you didn't delete any pawns\n");
        }
    }

    @Override
    public void doAction(Context context) {
        context.setState(this);

    }
}
