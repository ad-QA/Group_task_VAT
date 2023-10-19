package com.lbg.cohort4;

import java.text.DecimalFormat;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        float itemcost;
        float VATrate;

        Scanner sc = new Scanner(System.in);

        priceprompt();
        itemcost = sc.nextFloat();
        VATprompt();
        VATrate = sc.nextFloat();

        float finalPrice;
        finalPrice = VATcalculate(itemcost, VATrate);


//        System.out.println(df.format(finalPrice));



        results(itemcost, VATrate, finalPrice );


    }

    static public float VATcalculate(float a, float b){
        return a * ((100 + b)/100);
    }

    static private void priceprompt()
    {
        System.out.println("Please enter cost of item before VAT: ");
    }

    static private void VATprompt()
    {
        System.out.println("Please enter the VAT rate %: ");
    }
    static private void results(float cost, float vatRate, float totalPrice) {
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("cost of the item: $" + df.format(cost));
        System.out.println("VAT Rate: " + vatRate + "%");
        System.out.println("Total Price: $" + df.format(totalPrice));
    }


}