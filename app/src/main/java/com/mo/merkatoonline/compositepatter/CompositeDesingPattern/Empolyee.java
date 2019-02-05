package com.mo.merkatoonline.compositepatter.CompositeDesingPattern;

import java.util.Enumeration;
import java.util.Vector;

public class Empolyee implements AbstarctEmployee {
    //This class will store the name and salary of each employee
    private String empName;
    private float empSalary;
    private Vector suboridinates = new Vector();

    public Empolyee(){

    }
    public Empolyee(String empName, float empSalary) {
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }


    public void addEmployee(Empolyee empolyee){
        suboridinates.add(empolyee);
    }

    @Override
    public void removeEmployee(Empolyee empolyee) {

    }

    public void remove(Empolyee empolyee){
        suboridinates.remove(empolyee);
    }

    //Used to get the list of empplouees of a given supersvior
    public Enumeration elments(){
        return suboridinates.elements();
    }

    //Used to return the sum of salaries for employee and his subordinates
    public float getSalaries(){
        float sum = empSalary;
        for(int i = 0; i<suboridinates.size(); i++){
            sum += ((Empolyee)suboridinates.elementAt(i)).getSalaries();
        }
        return sum;
    }

    @Override
    public String print() {
        String sum = empName;
        for(int i = 0; i<suboridinates.size(); i++){
            sum += "\n"+((Empolyee)suboridinates.elementAt(i)).getEmpName() + "\n";
        }
        return sum;
    }
}
