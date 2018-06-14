package Canvas;

import Player.PlayerFactory;
import Player.Position;

import java.util.ArrayList;

public interface BoardI {
    void set(ArrayList<Position> player1, ArrayList<Position> player2);
    void display();
    void initialize();
}
