import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RandomGuesserGame {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in);) {

            int max = -1;

            GameSettings game1 = new GameSettings();
            max = game1.getMaxStrikes();
            System.out.println(max);
            int initialmax = max;

            System.out.println("I picked a random number between 15-100, let's see if you can guess.");
            System.out.println("To exit, type something that's not a number.");
            int number = new Random().nextInt(86) + 15;
            System.out.println("Number: " + number);
            System.out.println("Type a number and press enter");
            while (input.hasNext()) {
                int guess = input.nextInt();
                System.out.println("You guessed " + guess);

                max--;
                String name = String.valueOf(max);
                game1.writeMethod(name);
                if (max == 0) {
                    System.out.println("You have ran out of attempts");
                    game1 = new GameSettings();
                    max = game1.getMaxStrikes();
                    System.out.println(max);
                    initialmax = max;
                    number = new Random().nextInt(86) + 15;
                    System.out.println("Number: " + number);
                } else if (max == initialmax - 2) {
                    int range1 = 40;
                    int range2 = 40;

                    System.out.println("You have exceeded two strikes");
                    while (number - range1 <= 15) {
                        range1 = range1 - 5;
                    }
                    while (number + range2 > 100) {
                        range2 = range2 - 5;
                    }

                    System.out.println("Range is: " + (number - range1) + " - " + (number + range2));

                }

                if (guess == number) {
                    System.out.println("That's right!");
                    System.out.println("I picked a random number between 15-100, let's see if you can guess.");
                    number = new Random().nextInt(86) + 15;
                } else if (guess > number) {

                    System.out.println("To High");
                    System.out.println("That's wrong");
                    if (guess >= number + 10) {
                        System.out.println("Number Cold: Guess is more than 10 numbers away");
                    } else if (guess >= number + 5 && guess < number + 10) {
                        System.out.println("Number is Warm: Guess is between 5 to 9 numbers away");
                    } else if (guess >= number + 2 && guess < number + 5) {
                        System.out.println("Number is Hot: Guess is between 2 to 4 numbers away");

                    }

                } else if (guess < number) {
                    System.out.println("To Low");
                    System.out.println("That's wrong");

                    if (guess <= number - 10) {
                        System.out.println("Number Cold: Guess is more than 10 numbers away");
                    } else if (guess <= number - 5 && guess > number - 10) {
                        System.out.println("Number is Warm: Guess is between 5 to 9 numbers away");
                    } else if (guess <= number - 2 && guess > number - 5) {
                        System.out.println("Number is Hot: Guess is between 2 to 4 numbers away");

                    }

                }

            }
        } catch (Exception e) {
            System.out.println("Oh no! What are you going? That's not a number, I can't handle this.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
