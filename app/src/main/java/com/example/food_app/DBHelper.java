package com.example.food_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.food_app.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBName = "Food.db";
    final static int DBVersion = 2;
    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table FoodOrder" +
                        "(id integer primary key autoincrement," +
                         "name text," +
                        "phone text," +
                        "price int," +
                        "image text," +
                        "quantity int," +
                        "description text," +
                        "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists FoodOrder");
        onCreate(db);
    }

    public boolean insertorder(String username, String phone, int price, int image, int quantity, String description, String foodname)
    {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",description);
        values.put("quantity",quantity);
        values.put("foodname",foodname);
      long id = database.insert("orders", null, values);
      if(id <= 0)
      {
          return  false;
      }
      else
      {
          return true;
      }
    }

    public ArrayList<OrdersModel> getorders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select id,foodname,image,price from orders", null);
        if(cursor.moveToFirst())
        {
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItem(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);

            }

        }
        cursor.close();
        database.close();
        return orders;
    }



}
