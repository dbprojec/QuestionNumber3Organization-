package com.mo.merkatoonline.compositepatter.Controller;

import com.mo.merkatoonline.compositepatter.CompositeDesingPattern.CompositeDesingPatternClass;
import com.mo.merkatoonline.compositepatter.Model.Model;

public class Controller {
    String userName;
    String password;
    String hey;
    Model model = new Model();
    boolean sucess;

    private static CompositeDesingPatternClass compositeDesingPatternClass = new CompositeDesingPatternClass();

    public Controller(String user, String  password){
        this.userName = user;
        this.password = password;
        this.hey = "hey";
    }

    public boolean validate(){
        String userNameStored = model.returnUserName();
        String passwordStored = model.returnPassword();


        if(userName.equals("") || password.equals("")){
            sucess = false;
        }else if(userNameStored.equals("") || passwordStored.equals("")){
            sucess = false;
        }else if(userNameStored.equals(this.userName) && passwordStored.equals(this.password)){
            sucess = true;
        }

        return sucess;
    }

    public String getSalariesOfUsers(String upperManagement){
        compositeDesingPatternClass.makeEmployeeList();
        String controlSpan ="";
        if(upperManagement.equals("Sales manager")){
            controlSpan = String.valueOf(compositeDesingPatternClass.salesMananger.getSalaries());
        }else if(upperManagement.equals("Advertising Manager")){
            controlSpan = String.valueOf(compositeDesingPatternClass.advertManager.getSalaries());
        }else if(upperManagement.equals("Production manager")){
            controlSpan = String.valueOf(compositeDesingPatternClass.productionManager.getSalaries());
        }else if(upperManagement.equals("Shipment Manager")){
            controlSpan = String.valueOf(compositeDesingPatternClass.shippingManager.getSalaries());
        }else if(upperManagement.equals("CEO")){
            controlSpan = String.valueOf(compositeDesingPatternClass.boss.getSalaries());
        }else if(upperManagement.equals("Marketing Vice President")){
            controlSpan = String.valueOf(compositeDesingPatternClass.marketingEmpVP.getSalaries());
        }else if(upperManagement.equals("Production Vice President")){
            controlSpan = String.valueOf(compositeDesingPatternClass.productionVP.getSalaries());
        }
        return controlSpan;
    }

    public float getSalaryOfEmp(String employe){
        compositeDesingPatternClass.makeEmployeeList();

        float topRankingEmpoyeesSalary = 0;
        if(employe.equals("CEO")){
            topRankingEmpoyeesSalary = compositeDesingPatternClass.boss.getEmpSalary();
        }else if(employe.equals("Marketing Vice President")){
            topRankingEmpoyeesSalary = compositeDesingPatternClass.marketingEmpVP.getEmpSalary();
        }else if(employe.equals("Production Vice President")){
            topRankingEmpoyeesSalary = compositeDesingPatternClass.productionVP.getEmpSalary();
        }
        return topRankingEmpoyeesSalary;
    }

    public String getEmployessUnderYou(String upperManagement){
        String subEmplyeee ="";
        if(upperManagement.equals("Sales manager")){
            subEmplyeee = String.valueOf(compositeDesingPatternClass.salesMananger.printWithNewLine());
        }else if(upperManagement.equals("Advertising Manager")){
            subEmplyeee = String.valueOf(compositeDesingPatternClass.advertManager.printWithNewLine());
        }else if(upperManagement.equals("Production manager")){
            subEmplyeee = String.valueOf(compositeDesingPatternClass.productionManager.printWithNewLine());
        }else if(upperManagement.equals("Shipment Manager")){
            subEmplyeee = String.valueOf(compositeDesingPatternClass.shippingManager.printWithNewLine());
        }
        return subEmplyeee;
    }
}
