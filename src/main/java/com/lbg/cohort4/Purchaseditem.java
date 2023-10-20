package com.lbg.cohort4;

public class Purchaseditem {

    private float price = 0.0f;
    private int quantity = 0 ;

    private float vat = 0.0f;


    public Purchaseditem (float price , int quantity, float vat){
        this.price = price;
        this.quantity =quantity;
        this.vat = vat;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public float finalPrice (){
        return price*quantity + ((price * vat/100)*quantity);
    }
}
