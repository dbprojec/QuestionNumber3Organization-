package com.mo.merkatoonline.compositepatter.CompositeDesingPattern;

import java.util.Enumeration;

public class CompositeDesingPatternClass {

    public Empolyee boss;
    //VP's
    public Empolyee  marketingEmpVP, productionVP;


    //Under marketing VP employees
    public Empolyee salesMananger, advertManager;

    //Under production VP employees
    public Empolyee productionManager, shippingManager;

    public Empolyee tryThis;
    public void makeEmployeeList(){


        boss = new Empolyee("CEO", 200000);
        //Adding the VP of the organization
        boss.addEmployee(marketingEmpVP = new Empolyee("Marketing VP", 100000));
        boss.addEmployee(productionVP = new Empolyee("Production VP", 100000));

        marketingEmpVP.addEmployee(salesMananger = new Empolyee("Sales manager", 50000));
        for(int i = 0; i<5; i++){
            salesMananger.addEmployee(new Empolyee("Sales "+ Integer.toString(i), 30000.0F+(float)(Math.random()-0.5)*10000));
        }
        marketingEmpVP.addEmployee(advertManager = new Empolyee("Advertising Manager", 50000));
        advertManager.addEmployee(new Empolyee("Secy", 20000));

        productionVP.addEmployee(productionManager = new Empolyee("Production manager", 40000));

        for(int i=0; i<5; i++){
            productionManager.addEmployee(new Empolyee("Production Crew " + Integer.toString(i), 20000.0F + (float)(Math.random() - 0.5)+10000));
        }

        productionVP.addEmployee(shippingManager = new Empolyee("Shipment Manager", 40000));
        for (int i=0; i<5; i++){
            shippingManager.addEmployee(new Empolyee("Shpping Crew "+ Integer.toString(i), 20000.0F + (float)(Math.random()-0.5)+10000));
        }

    }
}
