import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        //Rules of Rock Paper Scissors
        //Paper beats Rock
        //Rock beats Scissors
        //Scissors beats Papers

        //We will take to take an input from the user - userChoice
        Scanner console = new Scanner(System.in);
        String userChoice;
        System.out.println("Please select your move [rock, paper, or scissors]:");
        userChoice = console.nextLine();

        //randomly generate an options - computerChoice
        int random = (int)Math.floor(Math.random() * 3);  //a random number between 0 1 and 2
        String computerChoice = null;

        switch(random){
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


        if(computerChoice.equalsIgnoreCase(userChoice)){
            System.out.printf("You both picked %s, it's a tie.%n", computerChoice);
        }else if(computerChoice.equalsIgnoreCase("rock") && userChoice.equalsIgnoreCase("paper")){
            System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
        }else if(computerChoice.equalsIgnoreCase("scissors") && userChoice.equalsIgnoreCase("rock")){
            System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
        }else if(computerChoice.equalsIgnoreCase("paper") && userChoice.equalsIgnoreCase("scissors")){
            System.out.printf("You picked %s and the computer picked %s, you win!", userChoice, computerChoice);
        }else{
            System.out.printf("You picked %s and the computer picked %s, you lose :(", userChoice, computerChoice);
        }
    } //this closes the main method
} //this closes the class
