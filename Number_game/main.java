package com.company;

import java.util.Scanner;
import java.util.Random;

class game{
    int game(){
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        int r = generator.nextInt(100) + 1;
        int K = 10, i;
        int ngo = 0;
        for (i=0; i<K; i++) {
            int guess = sc.nextInt();
            if (r == guess) {
                System.out.println("Its a match");
                System.out.println("You have guessed in " + ngo + " chances");
                break;
            }
            else if (guess > r && i != K - 1) {
                System.out.println("Your guess is greater than our number, so guess again");
            }
            else if (guess < r && i != K - 1) {
                System.out.println("Your guess is lower than our number, so guess again");
            }
            ngo++;
        }
        if (i == K){
            System.out.println("Your chances are completed");
            System.out.println("The correct number is "+r);
        }
        int score = 10-ngo;
        return score;
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("-----HEllO LET'S PLAY THE NUMBER GAME-----");
        System.out.println("   ");
        System.out.println("----WE HAVE 3 ROUNDS HERE----");
        System.out.println();
        int cs = 0;
        for (int j = 1; j < 4; j++) {
            System.out.println("----ROUND "+j+" ----");
            System.out.println("I am thinking of a number between 0 and 100 ");
            System.out.println("Could you guess what it is??");
            System.out.println("So what's your guess");
            game g = new game();
            int score = g.game();
            System.out.println("Round " + j + " completed");
            System.out.println("Your score is: "+score);
            System.out.println();
            cs = cs+score;
        }
        System.out.println("---YOUR COMPLETE SCORE IS "+cs+" ---");
        System.out.println("-----GAME OVER-----");
        System.out.println("---COME AGAIN!! ---");
    }
}
