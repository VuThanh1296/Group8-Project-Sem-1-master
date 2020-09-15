package dev.manhnx.persistance;

public class Cafe {
    private Integer cafeId;
    private int cafeStatus;
    private String cafeName;
    private double cafePrice;
    private int amount;
    private int cafeAmount;
    private int table;
    public Cafe(){

    }
    public Cafe(int cafeId,int cafeStatus,int cafeAmount,String cafeName,double cafePrice,int amount){
        this.cafeId = cafeId;
        this.cafeStatus = cafeStatus;
        this.cafeAmount = cafeAmount;
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
    public void setCafeId(Integer cafeId){
        this.cafeId = cafeId;
    }
    public Integer getCafeId(){
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
    public void setCafeAmount(int cafeAmount){
        this.cafeAmount = cafeAmount;
    }
    public int getCafeAmount(){
        return cafeAmount;
    }
    public void setTable(int table) {
        this.table = table;
    }

    public int getTable() {
        return table;
    }
    // @Override
    // public String toString() {
    //     return cafeId + " - " + cafeName + " - " + cafePrice + " - " + cafeStatus;
    // }
}