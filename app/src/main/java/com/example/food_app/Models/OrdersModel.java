package com.example.food_app.Models;

public class OrdersModel {

    int OrderImage;
    String SoldItem;
    String Price;
    String OrderNumber;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    String Description;
    String foodName;

    public OrdersModel() {

    }

    public int getOrderImage() {
        return OrderImage;
    }

    public void setOrderImage(int orderImage) {
        OrderImage = orderImage;
    }

    public String getSoldItem() {
        return SoldItem;
    }

    public void setSoldItem(String soldItem) {
        SoldItem = soldItem;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }


    public String getfoodName() {
        return foodName;
    }
}

