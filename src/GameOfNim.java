import java.util.Scanner;
/**
 * Write a description of class GameOfNim here.
 *
 * @author Marcos Felipe
 * @version Version1
 */
public class GameOfNim
{
    Scanner console = new Scanner(System.in);
    private int totalMarbles;
    private int turnCounter;

    /**
     * Constructor
     *
     * @param minMarbles is the minimum amount of marbles for the game of nim
     * @param maxMarbles is the maximum amount of marbles for the game of nim
     */
    public GameOfNim(int minMarbles, int maxMarbles) {
        int totalMarbles = (int) (Math.random() * ((maxMarbles - minMarbles) + 1) + minMarbles);
        this.totalMarbles = totalMarbles;
        turnCounter = 0;
    }

    public void play() {
        System.out.printf("Game begins\nInitially there are " + totalMarbles + " in the pile.\n");
        int computerOrHumanFirstTurn = generateComputerOrHumanFirstTurn();
        int smartOrStupidComputer = generateSmartOrStupidMode();
        while (totalMarbles > 1) {
            takeTurn(computerOrHumanFirstTurn, smartOrStupidComputer);
        }
        printWinner(computerOrHumanFirstTurn);
    }

    private int generateComputerOrHumanFirstTurn(){
        return (int) Math.round(Math.random()); //returns 0 for computer to go first, 1 for computer
    }

    private int generateSmartOrStupidMode(){
        return (int) Math.round(Math.random()); //returns 0 for smart mode, 1 for stupid mode
    }

    private void takeTurn(int firstTurn, int computerMode){
        if (firstTurn == 0){
            computerTurn(computerMode);
            if (totalMarbles > 1)
                humanTurn();
        }
        else{
            humanTurn();
            if (totalMarbles > 1)
                computerTurn(computerMode);
        }
    }

    private void computerTurn(int computerMode){
        if (computerMode == 0) smartComputerTurn();
        else stupidComputerTurn();
    }

    private void smartComputerTurn(){
        int marblesRemoved;
        if (calculateTotalMarblesAreAPowerOfTwoMinusOne() == true){
            stupidComputerTurn();
            return;
        }
        System.out.printf("Computer's turn:\t");
        marblesRemoved = generateOptimalMarblesRemoved();
        removeMarbles(marblesRemoved);
        turnCounter++;
    }

    private boolean calculateTotalMarblesAreAPowerOfTwoMinusOne(){
        for (int i = 2; i < 7; i++){
            if (totalMarbles == Math.pow(2, i) - 1) return true;
        }
        return false;
    }

    private void stupidComputerTurn(){
        int marblesRemoved;
        System.out.printf("Computer's turn:\t");
        marblesRemoved = (int) (Math.random() * ((totalMarbles / 2 - 1) + 1) + 1);
        removeMarbles(marblesRemoved);
        turnCounter++;
    }

    private int generateOptimalMarblesRemoved(){
        int exponentOfTwo = 6;
        for (; exponentOfTwo > 1; exponentOfTwo--){
            if (totalMarbles > Math.pow(2, exponentOfTwo) - 1)
                return totalMarbles - (int) (Math.pow(2, exponentOfTwo) - 1);
        }
        return 1;
    }

    private void removeMarbles(int marblesRemoved){
        totalMarbles -= marblesRemoved;
        System.out.printf("Removed " + marblesRemoved + " marble(s).\t");
        System.out.printf("Current number of marbles: " + totalMarbles + "\n");
    }

    private void humanTurn(){
        int marblesRemoved;
        do{
            System.out.printf("Human's turn:\t");
            marblesRemoved = console.nextInt();
        } while (checkIfLegalMove(marblesRemoved) == false);
        removeMarbles(marblesRemoved);
        turnCounter++;
    }

    private boolean checkIfLegalMove(int marblesRemoved){
        if (marblesRemoved < 1 || marblesRemoved > totalMarbles / 2){
            System.out.println("Invalid number of marbles. Please enter a different number.");
            return false;
        }
        else return true;
    }

    private void printWinner(int firstTurn){
        if (firstTurn == 0){
            if (turnCounter % 2 == 1) System.out.println("Computer Wins!!!");
            else System.out.println("Human Wins!!");
        }
        else {
            if (turnCounter % 2 == 1) System.out.println("Human Wins!!!");
            else System.out.println("Computer Wins!!!");
        }
    }


}