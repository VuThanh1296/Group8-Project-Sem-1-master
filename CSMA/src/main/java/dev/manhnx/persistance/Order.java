package dev.manhnx.persistance;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int CREATE_NEW_ORDER_STATUS = 1;
    private int OrderId;
    private int AccId;
    private int CafeId;
    private String CafeName;
    private int Amount;
    private Double Price;
    private int OrderStatus;
    private Date OrderDate;
    // private List<Cafe> cafes;
    // public Order(){
    //     OrderId = 0;
    //     OrderStatus = CREATE_NEW_ORDER_STATUS;
    //     cafes = new ArrayList<>();
        

    // }
    public void setCafeName(String CafeName) {
        this.CafeName = CafeName;
    }

    public String getCafeName() {
        return CafeName;
    }
    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getAmount() {
        return Amount;
    }
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Double getPrice() {
        return Price;
    }
    public void setOrderId(int orderId) {
        this.OrderId = orderId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderDate(Date orderDate) {
        this.OrderDate = orderDate;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderStatus(int orderStatus) {
        this.OrderStatus = orderStatus;
    }

    public int getOrderStatus() {
        return OrderStatus;
    }
    public void setAccId(int accId){
        this.AccId = accId;
    }
    public int getAccId(){
        return AccId;
    }
    public void setCafeId (int cafeId){
        this.CafeId = cafeId;
    }
    public int setCafeId(){
        return CafeId;
    }
    // public List<Cafe> getCafe(){
    //     return cafes;
    // }
    // public void addCafe(Cafe cafe){
    //     if (cafes ==null) {
    //         cafes = new ArrayList<>();
    //     } 
    //     cafes.add(cafe);
    // }
    public static void showTableClear(){
        
    }
}

   

   
    
