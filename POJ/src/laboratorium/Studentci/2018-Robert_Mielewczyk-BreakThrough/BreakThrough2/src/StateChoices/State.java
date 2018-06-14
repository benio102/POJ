package StateChoices;


import Player.Player;
import Player.PlayerFactory;

public interface State {
    void doAction(Context context);
}
