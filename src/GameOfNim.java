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
    private int numMarbles;

    /**
     * Constructor
     *
     * @param minMarbles is the minimum amount of marbles for the game of nim
     * @param maxMarbles is the maximum amount of marbles for the game of nim
     */
    public GameOfNim(int minMarbles, int maxMarbles) {
        int numMarbles = (int) Math.round(Math.random() * ((maxMarbles - minMarbles) + 1) + minMarbles);
        this.numMarbles = numMarbles;
    }

    /**
     * Interacts with user inputs to play a game of nim in one of two modes: smart or stupid. The first turn is randomly selected.
     */
    public void play() {
        System.out.printf("Game begins\nInitially there are " + numMarbles + " in the pile.\n");

        int compOrUserTurn = (int) Math.round(Math.random());
        if (compOrUserTurn == 0) {
            int playStyle = (int) Math.round(Math.random());
            if (playStyle == 0) {
                int i = 0;
                while (numMarbles > 1) {
                    System.out.printf("Human's turn:\t");
                    int marblesRemoved = console.nextInt();
                    while (marblesRemoved < 1 || marblesRemoved > numMarbles / 2) {
                        System.out.println("Invalid number of marbles. Please enter a different number.");
                        System.out.printf("Human's turn:\t");
                        marblesRemoved = console.nextInt();
                    }
                    numMarbles -= marblesRemoved;
                    System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                    i++;
                    if (numMarbles > 1) {
                        System.out.printf("Computer's turn:\n");
                        if (numMarbles > 63) {
                            marblesRemoved = numMarbles - 63;
                        }
                        else if (numMarbles == 63) {
                            marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                        }
                        else if (numMarbles > 31) {
                            marblesRemoved = numMarbles - 31;
                        }
                        else if (numMarbles == 31) {
                            marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                        }
                        else if (numMarbles > 15) {
                            marblesRemoved = numMarbles - 15;
                        }
                        else if (numMarbles == 15) {
                            marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                        }
                        else if (numMarbles > 7) {
                            marblesRemoved = numMarbles - 7;
                        }
                        else if (numMarbles == 7) {
                            marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                        }
                        else if (numMarbles > 3) {
                            marblesRemoved = numMarbles - 3;
                        }
                        else {
                            marblesRemoved = 1;
                        }
                        numMarbles -= marblesRemoved;
                        System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                        i++;
                    }
                }
                if (i % 2 == 1) {
                    System.out.println("Human Wins!!");
                }
                else {
                    System.out.println("Computer Wins!!");
                }
            }
            else {
                int i = 0;
                while (numMarbles > 1) {
                    System.out.printf("Human's turn:\t");
                    int marblesRemoved = console.nextInt();
                    while (marblesRemoved < 1 || marblesRemoved > numMarbles / 2) {
                        System.out.println("Invalid number of marbles. Please enter a different number.");
                        System.out.printf("Human's turn:\t");
                        marblesRemoved = console.nextInt();
                    }
                    numMarbles -= marblesRemoved;
                    System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                    i++;
                    if (numMarbles > 1) {
                        System.out.printf("Computer's turn:\n");
                        marblesRemoved = (int) (Math.random() * (numMarbles / 2 - 1) + 1);
                        numMarbles -= marblesRemoved;
                        System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                        i++;
                    }
                }
                if (i % 2 == 1) {
                    System.out.println("Human Wins!!");
                }
                else {
                    System.out.println("Computer Wins!!");
                }
            }
        }
        else {
            int playStyle = (int) Math.round(Math.random());
            if (playStyle == 0) {
                int i = 0;
                while (numMarbles > 1) {
                    System.out.printf("Computer's turn:\n");
                    int marblesRemoved;
                    if (numMarbles > 63) {
                        marblesRemoved = numMarbles - 63;
                    }
                    else if (numMarbles == 63) {
                        marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                    }
                    else if (numMarbles > 31) {
                        marblesRemoved = numMarbles - 31;
                    }
                    else if (numMarbles == 31) {
                        marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                    }
                    else if (numMarbles > 15) {
                        marblesRemoved = numMarbles - 15;
                    }
                    else if (numMarbles == 15) {
                        marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                    }
                    else if (numMarbles > 7) {
                        marblesRemoved = numMarbles - 7;
                    }
                    else if (numMarbles == 7) {
                        marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                    }
                    else if (numMarbles > 3) {
                        marblesRemoved = numMarbles - 3;
                    }
                    else {
                        marblesRemoved = 1;
                    }
                    numMarbles -= marblesRemoved;
                    System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                    i++;
                    if (numMarbles > 1) {
                        System.out.printf("Human's turn:\t");
                        marblesRemoved = console.nextInt();
                        while (marblesRemoved < 1 || marblesRemoved > numMarbles / 2) {
                            System.out.println("Invalid number of marbles. Please enter a different number.");
                            System.out.printf("Human's turn:\t");
                            marblesRemoved = console.nextInt();
                        }
                        numMarbles -= marblesRemoved;
                        System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                        i++;
                    }
                }
                if (i % 2 == 1) {
                    System.out.println("Computer Wins!!");
                }
                else {
                    System.out.println("Human Wins!!");
                }
            }
            else {
                int i = 0;
                while (numMarbles > 1) {
                    System.out.printf("Computer's turn:\n");
                    int marblesRemoved = (int) (Math.random() * ((numMarbles / 2 - 1) + 1) + 1);
                    numMarbles -= marblesRemoved;
                    System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                    if (numMarbles > 1) {
                        System.out.printf("Human's turn:\t");
                        marblesRemoved = console.nextInt();
                        while (marblesRemoved < 1 || marblesRemoved > numMarbles / 2) {
                            System.out.println("Invalid number of marbles. Please enter a different number.");
                            System.out.printf("Human's turn:\t");
                            marblesRemoved = console.nextInt();
                        }
                        numMarbles -= marblesRemoved;
                        System.out.printf("Removed " + marblesRemoved + " marble(s).\tCurrent number of marbles: " + numMarbles + "\n");
                    }
                }
                if (i % 2 == 1) {
                    System.out.println("Computer Wins!!");
                }
                else {
                    System.out.println("Human Wins!!");
                }
            }
        }
    }
}