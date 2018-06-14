package Player;

public class PlayerFactory {

    public Player getPlayer(String playerType){
        if(playerType == null){
            return null;
        }
        else if(playerType.equalsIgnoreCase("HumanPlayer")){
            return new HumanPlayer();
        }
        else if(playerType.equalsIgnoreCase("ComputerPlayerRandom")){
            return new ComputerPlayerRandom();
        }
        else if(playerType.equalsIgnoreCase("ComputerPlayerKiller")){
            return new ComputerPlayerKiller();
        }

        return null;
    }
}
