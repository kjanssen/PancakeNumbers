// File: Main.java
// Author: Kyle Janssen
// Contents: This is the game loop for the game Pancake Numbers.

package com.dynet.kjanssen.PancakeNumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        String choice = "y";

        while ("y".equals(choice)) {
            System.out.print("\nWelcome to Pancake Numbers! Enter the starting and ending indexes of the block you want" +
                    "to switch,\nand you win when all the numbers are in order. Input \"1 1\" to see as listing of neighbor states." +
                    "\n\nHow many numbers do you want to play with? ");
            int n = input.nextInt();

            PancakeNumbers pancakeNumbers = new PancakeNumbers(n);
            System.out.println(pancakeNumbers);

            int from = 1;
            int to = 1;

            while (!pancakeNumbers.done() && from != 0 && to != 0) {
                System.out.print("\nMake a move: ");
                from = input.nextInt();
                to = input.nextInt();

                if (from == 1 && to == 1)
                    System.out.println(pancakeNumbers.getMoves());
                else {
                    pancakeNumbers.move(from, to);
                    System.out.println(pancakeNumbers);
                }
            }

            System.out.println("\nYou took " + pancakeNumbers.getTurnCount() + " turns.");
            System.out.print("\nPlay again? (y/n): ");
            choice = input.next();
        }
    }
}
