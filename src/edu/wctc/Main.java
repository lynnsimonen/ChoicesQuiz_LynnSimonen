package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //set up scanner
        Scanner keyboard = new Scanner(System.in);
        String doAgain;
        //print welcome and instructions for quiz
        do {
            //Print out quiz intro
            System.out.println("Welcome to the Preference Quiz!");
            System.out.println("--------------------------------");
            System.out.println("If you prefer the answer on the left -  Enter 0");
            System.out.println("If you prefer the answer on the right -  Enter 1");
            //string arrays for choice prompts:
            String[][] Choices = {{"winter", "skiing", "movies", "Lake Michigan", "Hamburgers"},
            {"summer", "snorkeling", "boating", "Pacific Ocean", "seafood"}};
            //new numbers array to hold quiz answers
            int [] numbers = new int[5];
            //initialize counter for quiz answers' sum
            double sum = 0;
            //initialize acceptable answer boolean
            boolean acceptable = true;
            //loop to ask and collect quiz answers and tally sum
            for (int i = 0; i < 5; i++) {
                //String interpolation for quiz questions
                System.out.printf("Do you prefer 0 - %s OR 1 - %s? > ", Choices[0][i], Choices[1][i]);
                //parse the answers and put into array
                numbers[i] = Integer.parseInt(keyboard.nextLine());
                //get the sum of all answers if 1 or 0 is entered
                if (numbers[i] ==1 || numbers[i]==0) {
                sum += numbers[i];
                }
                else {
                    //an answer other than 0 or 1 was entered
                    acceptable = false;
                    break;
                }
            }
            if (acceptable) {
                //Messages for different sums
                String[] message = {"You prefer mountains and sunshine!", "You like balance in your life!", "You enjoy warm sea breezes!"};
                //Print message depending on sum score
                String answer = sum==3 ? message[1] : (sum>3 ? message[2] : message[0]);
                System.out.println();
                System.out.println(answer);
                System.out.println();
            } else {
                //User entered unacceptable answer
                System.out.println("Unacceptable answer.");
            }
            //Ask whether they want to play again
            System.out.println("Would you like to try the quiz again? Y or N");
            doAgain = keyboard.nextLine();
        }
        //Play again do...while loops
        while(!doAgain.equalsIgnoreCase("n"));
    }
}