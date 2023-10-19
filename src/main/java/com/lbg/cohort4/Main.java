package com.lbg.cohort4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float vatRate;
        String input;

        System.out.println("Welcome to the VAT calculator task");
        System.out.println("Please enter the VAT rate");
        vatRate = sc.nextFloat();
        sc.nextLine();

        float totalCost = 0.0F;
        boolean continueCalculations = true;

        ArrayList<Float> itemPrices = new ArrayList<>();
        while(continueCalculations){

            float displayTotalCost = calculateTotalCost(itemPrices, vatRate, totalCost);
            System.out.println("Total Cost: $" + displayTotalCost);

            System.out.print("Press ENTER to continue entering prices or type 'QUIT' to quit: ");
            input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("QUIT")) {
                continueCalculations = false;

                Collections.sort(itemPrices);

                for (float value: itemPrices){
                    System.out.println(value);
                }
            }
            totalCost += displayTotalCost;

        }

        System.out.println("Goodbye!");

    }

    public static float calculateTotalCost(ArrayList<Float> itemPrices, float vatRate, float totalCost){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter item price (or 0 to finish): $");
            float price = sc.nextFloat();
            sc.nextLine();

            if (price == 0.0f) {

                break;
            }

            itemPrices.add(price);
            totalCost += price + (price * vatRate/100);
            System.out.println("Running Total Cost: $" + totalCost);

        }

        return totalCost;
    }




}