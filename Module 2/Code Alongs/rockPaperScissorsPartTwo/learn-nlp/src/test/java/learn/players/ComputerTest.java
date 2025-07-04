package learn.players;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer;
    @BeforeEach
    void setUp(){
        computer = new Computer();
    }

    @Test
    void generateMoveShouldGenerateRandomMove(){
        for(int i = 0; i < 1000; i++){
            String result = computer.generateMove();

            assertTrue(result.equals(PlayerHelper.ROCK) || result.equals(PlayerHelper.PAPER) || result.equals(PlayerHelper.SCISSORS));
        }
    }
}