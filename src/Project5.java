import java.util.Scanner;
/**
 * Driver module for Game of Nim.
 *
 * @author CS140 Instructors
 * @version 3/28/2019
 */
public class Project5
{
    public static void main(String args[])
    {
        do {
            GameOfNim game = new GameOfNim(getMinMarblesInPile(), getMaxMarblesInPile());
            game.play();
        } while (checkPlayAgain() == true);

        System.out.println("Good bye!");
    }

    private static int getMinMarblesInPile(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the minimum number of marbles in your pile: ");
        return console.nextInt();
    }

    private static int getMaxMarblesInPile(){
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the maximum number of marbles in your pile: ");
        return console.nextInt();
    }

    private static boolean checkPlayAgain(){
        Scanner console = new Scanner(System.in);
        System.out.print("Do you want to play again? Enter Yes or No: ");
        if(console.next().equalsIgnoreCase("YES")) return true;
        else return false;
    }
}