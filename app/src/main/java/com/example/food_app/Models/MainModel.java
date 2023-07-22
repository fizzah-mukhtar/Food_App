package com.example.food_app.Models;

public class MainModel {
    int image;
    String foodName,userName, price, description;;

    public MainModel(int image, String foodName, String price, String description) {
        this.image = image;
        this.foodName = foodName;
        this.price = price;
       // this.userName=userName;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setImage(int image) {
        this.image = image;
    }

   // public String getUserName() {
     //   return userName;
   // }

   // public void setUserName(String userName) {
     //   this.userName = userName;
    //}

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
