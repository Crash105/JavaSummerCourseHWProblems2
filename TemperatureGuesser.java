import java.util.Random;
import java.util.Scanner;

public class TemperatureGuesser{
	public static void main(String[] args) {
     		try (Scanner input = new Scanner(System.in);){
			System.out.println("I picked a random tempertaure value between 1-100, let's see if you can guess.");
			System.out.println("To exit, type something that's not a number.");
            int number = new Random().nextInt(99)+1;
            System.out.println("Type a number and press enter");
			while(input.hasNext()) {
				int guess = input.nextInt();
				System.out.println("You guessed " + guess);
				if(guess == number) {
					System.out.println("That's right!");
					System.out.println("I picked a random number between 1-10, let's see if you can guess.");
					number = new Random().nextInt(99)+1;
            } 
          
           else if((guess >= (number -10) && guess <= (number -6))  ) {
               System.out.println("To Cold");
               System.out.println("That's wrong");
        
			}
         else if((guess <= (number + 10) && guess >= (number +6))  ) {
               System.out.println("To Cold");
               System.out.println("That's wrong");
        
			}

         
         
         
          else if(guess >= (number - 5) && guess <= (number -3)  ) {
               System.out.println("To Warm");
               System.out.println("That's wrong");
        
			}
         else if(guess <= (number + 5) && guess >= (number + 3)  ) {
               System.out.println("To Warm");
               System.out.println("That's wrong");
        
			}

          else if(guess >= (number - 2) && guess <= (number - 1)  ) {
               System.out.println("To Hot");
               System.out.println("That's wrong");
        
			}
         else if(guess <= (number + 2) && guess >= (number + 1)  ) {
               System.out.println("To Hot");
               System.out.println("That's wrong");
        
			}

         //If Guess is 11 numbers greater than actual number
         else {
            System.out.println("Not Close");
		}
      }
      }
		catch(Exception e) {
			System.out.println("Oh no! What are you going? That's not a number, I can't handle this.");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}