package com.mo.merkatoonline.compositepatter.CompositeDesingPattern;

import java.util.ArrayList;

public interface AbstarctEmployee {
    float getEmpSalary();
    String getEmpName();
//    boolean isLeaf
    void addEmployee(Empolyee empolyee);
    void removeEmployee(Empolyee empolyee);
    float getSalaries();

    ArrayList print();
    ArrayList printWithNewLine();
    ArrayList printNameOnly();
}


