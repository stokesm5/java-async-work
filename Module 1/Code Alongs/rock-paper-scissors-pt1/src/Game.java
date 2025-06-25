import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        //Rules of Rock Paper Scissors
        //Paper beats Rock
        //Rock beats Scissors
        //Scissors beats Papers

        //We will take to take an input from the user - userChoice
        Scanner console = new Scanner(System.in);
        String userChoice;
        boolean exit = false;

        do {
            //variable for valid choice
            boolean validChoice = false;
            //Get user choice
            do {
                System.out.println("Please select your move [rock, paper, or scissors]:");
                userChoice = console.nextLine();
                if (userChoice.equalsIgnoreCase("rock") || userChoice.equalsIgnoreCase("paper") || userChoice.equalsIgnoreCase("scissors")) {
                    validChoice = true;
                } else {
                    System.out.println("Error: Invalid choice");
                }
            } while (!validChoice);  //the loop with run as long as validChoice remains flase

            //randomly generate an options - computerChoice
            int random = (int) Math.floor(Math.random() * 3);  //a random number between 0 1 and 2
            String computerChoice = null;

            switch (random) {
                case 0:
                    computerChoice = "rock";
                    break;
                case 1:
                    computerChoice = "paper";
                    break;
                case 2:
                    computerChoice = "scissors";
                    break;
                default:
                    computerChoice = null;
                    break;
            }

            //System.out.println(random + "\n" + computerChoice);

            //compare the choices and determine a winner

            String graphic = "L O A D I N G";
            for (int i = 0; i < graphic.length(); i++) {
                System.out.println(graphic.charAt(i));
            }

            if (computerChoice.equalsIgnoreCase(userChoice)) {
                System.out.printf("You both picked %s, it's a tie.%n", computerChoice);
            } else if (computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("paper")) {
                System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
            } else if (computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("rock")) {
                System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
            } else if (computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("scissors")) {
                System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
            } else {
                System.out.printf("You picked %s and the computer picked %s, you lose :(", userChoice, computerChoice);
            }

            // Give the user a way to exit the game

            System.out.println("Would you like to play again? [y/n]");
            String playAgain = console.nextLine();

            if(playAgain.equalsIgnoreCase(playAgain)){
                System.out.println("Thanks for playing! Goodbye");
                exit = true;
            } else {
                exit = false;
            }

        } while (!exit);
    } //this closes the main method
} //this closes the class
