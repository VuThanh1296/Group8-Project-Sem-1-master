package dev.manhnx.persistance;

public class Cafe {
    private int cafeId;
    private int cafeStatus;
    private int cafeAvailable;
    private String cafeName;
    private double cafePrice;
    private int amount;
    public Cafe(){

    }
    public Cafe(int cafeId,int cafeStatus,int cafeAvailable,String cafeName,double cafePrice,int amount){
        this.cafeId = cafeId;
        this.cafeStatus = cafeStatus;
        this.cafeAvailable = cafeAvailable;
        this.cafeName = cafeName;
        this.cafePrice = cafePrice;
        this.amount = amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
    public void setCafeId(int cafeId){
        this.cafeId = cafeId;
    }
    public int getCafeId(){
        return cafeId;
    }
    public void setCafeName(String cafeName){
        this.cafeName = cafeName;
    }
    public String getCafeName() {
        return cafeName;
    }
    public void setCafeStatus(int cafeStatus){
        this.cafeStatus = cafeStatus;
    }
    public int getCafeStatus(){
        return cafeStatus;
    }
    public void setCafePrice(double cafePrice){
        this.cafePrice = cafePrice;
    }
    public double getCafePrice() {
        return cafePrice;
    }
    public void setCafeAvailable(int cafeAvailable){
        this.cafeAvailable = cafeAvailable;
    }
    public int getCafeAvailable(){
        return cafeAvailable;
    }
    // @Override
    // public String toString() {
    //     return cafeId + " - " + cafeName + " - " + cafePrice + " - " + cafeStatus;
    // }
}