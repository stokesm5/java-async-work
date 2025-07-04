package learn;

import learn.players.Player;
import learn.players.PlayerHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 3 A's of testing
//Arrange - set up our test environment
//Act - this is where we invoke our methods, run our code, etc.
//Assert - check the output we get is what we are expecting
class GameTest {
    // arrange
    Game game = new Game();

    //ties are working
    @Test
    void twoOfTheSameInputShouldTie(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.ROCK, PlayerHelper.ROCK);
        //assert
        assertNotNull(result);
        assertEquals(String.format("You have picked %s -- its a tie!", PlayerHelper.ROCK), result);

        //arranging
        result = game.determineWinnter(PlayerHelper.PAPER, PlayerHelper.PAPER);
        //assert
        assertNotNull(result);
        assertEquals(String.format("You have picked %s -- its a tie!", PlayerHelper.PAPER), result);

        //arranging
        result = game.determineWinnter(PlayerHelper.SCISSORS, PlayerHelper.SCISSORS);
        //assert
        assertNotNull(result);
        assertEquals(String.format("You have picked %s -- its a tie!", PlayerHelper.SCISSORS), result);
    }

    //happy path - win conditions are working
    @Test
    void rockShouldBeatScissors(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.ROCK, PlayerHelper.SCISSORS);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you win!",PlayerHelper.SCISSORS, PlayerHelper.ROCK), result);
    }

    @Test
    void scissorsShouldBeatPaper(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.SCISSORS, PlayerHelper.PAPER);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you win!",PlayerHelper.PAPER, PlayerHelper.SCISSORS), result);
    }

    @Test
    void paperShouldBeatRock(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.PAPER, PlayerHelper.ROCK);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you win!",PlayerHelper.ROCK, PlayerHelper.PAPER), result);
    }

    //unhappy path - lose conditions are working as expected
    @Test
    void rockShouldNotBeatPaper(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.ROCK, PlayerHelper.PAPER);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you lose!",PlayerHelper.PAPER, PlayerHelper.ROCK), result);
    }

    @Test
    void paperShouldNotBeatScissors(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.PAPER, PlayerHelper.SCISSORS);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you lose!",PlayerHelper.SCISSORS, PlayerHelper.PAPER), result);
    }

    @Test
    void scissorsShouldNotBeatRock(){
        //arranging
        String result = game.determineWinnter(PlayerHelper.SCISSORS, PlayerHelper.ROCK);
        //assert
        assertNotNull(result);
        assertEquals(String.format("The computer picked %s and you have picked %s -- you lose!",PlayerHelper.ROCK, PlayerHelper.SCISSORS), result);
    }
}