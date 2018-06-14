import Canvas.Board;
import Decorator.StarDecorator;
import Global.Reference;
import Player.Player;
import Player.PlayerFactory;
import StateChoices.Context;
import StateChoices.Delete;
import StateChoices.Select;

import java.util.Scanner;

public class BreakThrough {
    Board board;
    StarDecorator starBoard;
    PlayerFactory playerFactory;
    Player player1;
    Player player2;
    Context context;
    Scanner scan;
    String input="";
    Boolean end=false;
    public BreakThrough(){


        //All Choices
        context = new Context();
        Select select = new Select();
        Delete delete = new Delete();


        //Create Scanner
        scan = new Scanner(System.in);

        //Initialize Player Factory
        playerFactory = new PlayerFactory();

        //Board System
        board = new Board();
        starBoard = new StarDecorator(new Board());

        //Create Players
        player1 = playerFactory.getPlayer("HumanPlayer");
        player2 = playerFactory.getPlayer("ComputerPlayerKiller");

        while(!input.equals("exit") && !end) {
            //Check if game is over player1
            for(int i=0;i<player1.getPosition().size();i++){
                if(player1.getPosition().get(i).getX() == 0){
                    System.out.println("Player1 WON!!!");
                    end = true;
                    break;
                }
            }
            //check if game is over player2
            for(int i=0;i<player2.getPosition().size();i++){
                if(player2.getPosition().get(i).getX() == 7){
                    System.out.println("Player2 WON!!!");
                    end = true;
                    break;
                }
            }

            //Check if everything works
            System.out.print(Reference.ANSI_YELLOW);
            player1.debug();
            player2.debug();
            System.out.print(Reference.ANSI_RESET);

            //Board
            board.set(player1.getPosition(), player2.getPosition());
            board.display();

            //Ask Player what to do (select, delete, exit)
            System.out.println("\n\nType what you want to do: (select, exit): ");
            input = scan.nextLine();
            if(input.equalsIgnoreCase("select")){
                select.doChoice(player1, player2);
            }
            else if(input.equalsIgnoreCase("delete")){

                delete.doAction(context);
                context.doAction();
            }
            else if(input.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println(Reference.ANSI_RED+"The game has set"+Reference.ANSI_RESET);


            //Player2 move
            player2.makeMove(player1);



        }
        System.out.println("Thank you for playing!");
    }

    //Create Player me

    //Create computer Choice 1 or 2? choice from code

    //Create Board System (Sending new Board, displaying that board)

    //Create Player 1 and 2 with start positions


    //LOOP
    //Send Player info to board and display Board

    //Ask player to make move (check input,check logic, send move)

    //If gameover or next move == exit --> END GAME


}
