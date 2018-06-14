package Player;

import java.util.ArrayList;

public interface Player {
    void set(int oldx, int oldy, int newx, int newy);
    void delete(int x, int y);
    void debug();
    void makeMove(Player opponent);
    ArrayList<Position> getPosition();
}
