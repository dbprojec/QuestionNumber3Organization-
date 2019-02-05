package com.mo.merkatoonline.compositepatter.CompositeDesingPattern;

public interface AbstarctEmployee {
    float getEmpSalary();
    String getEmpName();
//    boolean isLeaf
    void addEmployee(Empolyee empolyee);
    void removeEmployee(Empolyee empolyee);
    float getSalaries();

    String print();

}


