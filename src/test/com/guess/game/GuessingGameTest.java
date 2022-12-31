package com.guess.game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuessingGameTest {

    public static final int Game_retries = 100;
    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
    int randomNum = game.getRandomNumber();
    String message = game.guess(randomNum);
        assertEquals("you got it in 1 try",message);

}

@Test
    public void testOneWrongNegGuessSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(-5);
        assertEquals("you didn´t get it - you´re too low",message);

    }

    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals("you didn´t get it - you´re too high",message);

    }


    @RepeatedTest(10)
    public void testRandomNumberGeneration() {
        int[] rndNumCount = new int[11];
        for (int count = 0; count < Game_retries; count++){
            GuessingGame game = new GuessingGame();
            int randomNum = game.getRandomNumber();
                rndNumCount[randomNum] = 1;
        }

        int sum = 0;
        for (int count=0; count < 11; count++){
           sum += rndNumCount[count];
        }
        System.out.println(sum);
        assertEquals(10,sum);

    }

    @Test
    public void testFourWrongGuesses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message =  game.guess(-3);
assertEquals("you didn´t get it, and you had 4 tries, game over",message);
    }

    @Test
    public void testTenWrongGuesses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message =  game.guess(-3);
        assertEquals("Sorry, you are limited to just 4 tries, game over",message);
    }



    @Test
    public void testThreeWrongAndOneCorrectGuesses(){
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        int correctaswer = game.getRandomNumber();
        String message =  game.guess(correctaswer);
        assertEquals("you got it in 4 tries",message);
    }

    @Test
    public void testTwoWrongGuessesAndOneCorrectGuesses(){
        game.guess(-3);
        game.guess(-3);
        int correctaswer = game.getRandomNumber();
        String message =  game.guess(correctaswer);
        assertEquals("you got it in 3 tries",message);
        assertTrue(message.contains("3"),"should indicate 3");
    }

    


}