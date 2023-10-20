package com.lbg.cohort4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the VAT calculator task");


        float totalCost = 0.0F;
        boolean continueCalculations = true;

        ArrayList<Purchaseditem> purchasedItems = new ArrayList<>();


        while(continueCalculations){

            float displayTotalCost = calculateTotalCost(purchasedItems, totalCost);
            System.out.println("Total Cost: $" + displayTotalCost);

            System.out.print("Press ENTER to continue entering prices or type 'QUIT' to quit: ");
            String input = sc.nextLine().trim();


            if (input.equalsIgnoreCase("QUIT")) {
                continueCalculations = false;

                Collections.sort(purchasedItems, Comparator.comparing(Purchaseditem::getPrice));


                for (Purchaseditem item : purchasedItems) {
                    System.out.println("----------------");
                    System.out.println("Cost Price: $" + item.getPrice());
                    System.out.println("Quantity: " + item.getQuantity());
                    System.out.println("VAT Amount: $" + item.getVat() * item.getQuantity());
                    System.out.println("Total Price: $" + item.finalPrice());
                    System.out.println("----------------");
                }
                System.out.println("The total cost for all items including VAT is $"+ displayTotalCost);

            }
            totalCost += displayTotalCost;

        }

        System.out.println("Goodbye!");

    }

    public static float calculateTotalCost(ArrayList<Purchaseditem> itemPrices, float totalCost){
        Scanner sc = new Scanner(System.in);
        float vatRate;
        while (true) {

            System.out.print("Enter item price (or 0 to finish): $");
            float price = sc.nextFloat();


            if (price == 0.0f) {

                break;
            }

            System.out.print("Please enter the VAT rate: %");
            vatRate = sc.nextFloat();


            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();


            Purchaseditem item = new Purchaseditem(0,0,0);
            item.setPrice(price);
            item.setQuantity(quantity);
            item.setVat(vatRate);

            itemPrices.add(item);
            totalCost += item.finalPrice();
            System.out.println("Running Total Cost: $" + totalCost);

        }

        return totalCost;
    }




}