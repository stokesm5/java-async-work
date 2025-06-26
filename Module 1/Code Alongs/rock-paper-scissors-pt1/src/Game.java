import java.util.Scanner;

public class Game {
    //We will take to take an input from the user - userChoice
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        //Rules of Rock Paper Scissors
        //Paper beats Rock
        //Rock beats Scissors
        //Scissors beats Papers

        boolean exit = false;

        //Human vs Computer
        do {
            int userMove = getUserChoice();
            int computerMove = getComputerChoice();
            String userChoice = generateMove(userMove);
            String computerChoice = generateMove(computerMove);
            determineWinner(userChoice, computerChoice);
            exit = playAgain();
        } while (!exit);

        //Human vs Human
        do {
            int userOneMove = getUserChoice();
            int userTwoMove = getUserChoice();
            String userOneChoice = generateMove(userOneMove);
            String userTwoChoice = generateMove(userTwoMove);
            determineWinner(userOneChoice, userTwoChoice);
            exit = playAgain();
        } while (!exit);

        //Computer vs Computer
        int computerOneMove = getComputerChoice();
        int computerTwoMove = getComputerChoice();
        String computerOneChoice = generateMove(computerOneMove);
        String computerTwoChoice = generateMove(computerTwoMove);
        determineWinner(computerOneChoice, computerTwoChoice);
    } //this closes the main method

    //We are going to refactor our game
    // grab the user choice
    public static int getUserChoice(){
        //variable for valid choice
        boolean validChoice = false;
        //Get user choice
        int userChoice;
        do {
            System.out.println("Please select your move [0.rock, 1.paper, or 2.scissors]:");
            userChoice = Integer.parseInt(console.nextLine());
            if (userChoice == 0 || userChoice == 1 || userChoice == 2) {
                validChoice = true;
            } else {
                System.out.println("Error: Invalid choice");
            }
        } while (!validChoice);  //the loop with run as long as validChoice remains flase
        return userChoice;
    }

    // grab the computer choice
    public static int getComputerChoice(){
        //randomly generate an options - computerChoice
        int random = (int) Math.floor(Math.random() * 3);  //a random number between 0 1 and 2
        return random;
    }

    // generate a move
    public static String generateMove(int playerChoice){
        String move = null;

        switch (playerChoice) {
            case 0:
                move = "rock";
                break;
            case 1:
                move = "paper";
                break;
            case 2:
                move = "scissors";
                break;
            default:
                move = null;
                break;
        }
        return move;
    }

    // determine a win
    public static void determineWinner(String userOneChoice, String userTwoChoice){
        String graphic = "L O A D I N G";
        for (int i = 0; i < graphic.length(); i++) {
            System.out.println(graphic.charAt(i));
        }

        if (userTwoChoice.equalsIgnoreCase(userOneChoice)) {
            System.out.printf("You both picked %s, it's a tie.%n", userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("rock") && userOneChoice.equalsIgnoreCase("paper")) {
            System.out.printf("You picked %s and the computer picked %s, you win!", userOneChoice, userTwoChoice);
        } else if (userTwoChoice.equalsIgnoreCase("scissors") && userOneChoice.equalsIgnoreCase("rock")) {
            System.out.printf("You picked %s and the computer picked %s, you win!", userOneChoice, userTwoChoice);
        } else if (userTwoChoice.equalsIgnoreCase("paper") && userOneChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("You picked %s and the computer picked %s, you win!", userOneChoice, userTwoChoice);
        } else {
            System.out.printf("You picked %s and the computer picked %s, you lose :(", userOneChoice, userTwoChoice);
        }
    }

    // play again
    public static boolean playAgain(){
        // Give the user a way to exit the game

        System.out.println("Would you like to play again? [y/n]");
        String playAgain = console.nextLine();

        if(playAgain.equalsIgnoreCase(playAgain)){
            System.out.println("Thanks for playing! Goodbye");
            return true;
        } else {
            return false;
        }
    }
} //this closes the class
