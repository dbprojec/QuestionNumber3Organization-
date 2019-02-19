package com.mo.merkatoonline.compositepatter.helper;

import android.content.Context;
import android.preference.PreferenceManager;

import com.mo.merkatoonline.compositepatter.CompositeDesingPattern.CompositeDesingPatternClass;
import com.mo.merkatoonline.compositepatter.CompositeDesingPattern.Empolyee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    private static CompositeDesingPatternClass compositeDesingPatternClass = new CompositeDesingPatternClass();

    static Context context;
    public ExpandableListDataPump(Context context){
        this.context = context;
    }
    public static HashMap<String, List<String>> getData() {
        compositeDesingPatternClass.makeEmployeeList();
        ArrayList<String> CEO= compositeDesingPatternClass.boss.print();
        ArrayList<String> CEOEmpty= compositeDesingPatternClass.boss.print();
        ArrayList<String> markeintVP = compositeDesingPatternClass.marketingEmpVP.print();
        ArrayList<String> productionManager = compositeDesingPatternClass.productionVP.print();
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        boolean isCEO = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("isCEO", false);
        if(isCEO){
            expandableListDetail.put("CEO", CEO);
            expandableListDetail.put("Marketing Vice President", markeintVP);
            expandableListDetail.put("Production Vice President", productionManager);
        }else{
//            expandableListDetail.put("CEO", CEOEmpty);
            expandableListDetail.put("Marketing Vice President", markeintVP);
            expandableListDetail.put("Production Vice President", productionManager);
        }

        return expandableListDetail;
    }


    public String getEmpolyeeName(){
        return String.valueOf(compositeDesingPatternClass.shippingManager.getEmpName());
    }



}