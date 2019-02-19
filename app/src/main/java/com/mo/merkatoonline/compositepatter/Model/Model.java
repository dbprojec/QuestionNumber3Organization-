package com.mo.merkatoonline.compositepatter.Model;

import java.util.ArrayList;

public class Model {

    //CEO
    String userName = "a@gmail.com";
    String password = "12345";




//    String [] userNameList = {"a@gmail.com", "12345"};
//    ArrayList<String> arrayListUser = new ArrayList<>();



    public String returnUserName(){
        return userName;
    }

    public String returnPassword(){
        return password;
    }
}
