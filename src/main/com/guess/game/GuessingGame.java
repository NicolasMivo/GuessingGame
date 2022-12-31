package com.guess.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1;
   private int counter = 0;

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a number: ");
            if ("q".equals(input)){
                return;
            }
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if (output.contains("you got it") || output.contains("over")){
                loopShouldContinue = false;
            }

        } while (loopShouldContinue);

    }
    public String guess(int guessedNumber) {
        counter++;
        String tryText = counter==1? "try":"tries";
        String winningMsg = String.format("you got it in %d %s", counter,tryText);
       String response = null;
        if (counter == 4 && guessedNumber != getRandomNumber()){
            response = String.format("you didn´t get it, and you had %d %s, game over",counter,tryText);
        }else if (counter > 4){
           response =  "Sorry, you are limited to just 4 tries, game over";
        }
           else {
               String tooLowOrHighText = null;
               if(guessedNumber < getRandomNumber()){
                   tooLowOrHighText = "- you´re too low";
               } else if (guessedNumber > getRandomNumber()){
                   tooLowOrHighText = "- you´re too high";
               }
               else {
                   tooLowOrHighText = "";
               }

            String loseText = String.format("you didn´t get it %s",tooLowOrHighText);
            response = guessedNumber == getRandomNumber() ? winningMsg : loseText.trim();
        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;

    }


}
