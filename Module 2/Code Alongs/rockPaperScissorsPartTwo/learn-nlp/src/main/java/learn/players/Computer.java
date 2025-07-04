package learn.players;

import java.util.Random;

public class Computer implements Player{

    @Override
    public String generateMove() {
        Random random = new Random();
        int choice = random.nextInt(3) + 1; //bound 3 will return 0-2+1(1-3)
        return PlayerHelper.getPlayerMove(choice);
    }
}
