package com.mo.merkatoonline.compositepatter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mo.merkatoonline.compositepatter.CompositeDesingPattern.CompositeDesingPatternClass;
import com.mo.merkatoonline.compositepatter.Controller.Controller;
import com.mo.merkatoonline.compositepatter.Views.LoginActivity;
import com.mo.merkatoonline.compositepatter.helper.CustomExpandableListAdapter;
import com.mo.merkatoonline.compositepatter.helper.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    TextView controleSpan, empSalary, logout;
    CompositeDesingPatternClass compositeDesingPatternClass = new CompositeDesingPatternClass();
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ExpandableListDataPump expandableListDataPump = new ExpandableListDataPump(MainActivity.this);
        final Controller controller = new Controller("","");


        compositeDesingPatternClass.makeEmployeeList();

        empSalary = findViewById(R.id.employeeSalary);
        controleSpan = findViewById(R.id.contorl_span);

        logout = findViewById(R.id.logout_Button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogOut= new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLogOut);
                finish();
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
//        boolean isCEO = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).getBoolean("isCEO", false);

        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);

        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                System.out.println("Under " + compositeDesingPatternClass.boss.print());
                String showMessage = "";
                String showControlSpan="";
                if(expandableListTitle.get(groupPosition).equals("CEO")){
                    float salary =  controller.getSalaryOfEmp("CEO");
                    showMessage ="CEO Salary --- "+ salary;
                    showControlSpan ="Control Span Salaries of Employees "+ controller.getSalariesOfUsers("CEO");
                    controleSpan.setText(showControlSpan);
                    empSalary.setText(showMessage);
                }else if(expandableListTitle.get(groupPosition).equals("Marketing Vice President")){
                    float salary = controller.getSalaryOfEmp("Marketing Vice President");
                    showMessage = "Marking VP Salary --- "+ salary;
                    showControlSpan ="Control Span Salaries of Employees "+ controller.getSalariesOfUsers("Marketing Vice President");
                    controleSpan.setText(showControlSpan);
                    empSalary.setText(showMessage);
                }else if(expandableListTitle.get(groupPosition).equals("Production Vice President")){
                    float salary =  controller.getSalaryOfEmp("Production Vice President");
                    showMessage ="Production Vice President --- "+ salary;
                    showControlSpan = "Control Span Salaries of Employees "+ controller.getSalariesOfUsers("Production Vice President");
                    controleSpan.setText(showControlSpan);
                    empSalary.setText(showMessage);
                }
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        expandableListTitle.get(groupPosition) + " List Collapsed.",
//                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        expandableListTitle.get(groupPosition)
//                                + " -> "
//                                + expandableListDetail.get(
//                                expandableListTitle.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT
//                ).show();

                String getChild =  expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition);
                if(getChild.contains("Salary")){
                    getChild = getChild.replace(" Salary : "  , "");
                    int index = getChild.indexOf("-");
                    getChild = getChild.substring(0, index);

                    System.out.println("####################### Child " + getChild);
                }

                ExpandableListDataPump  expandableListDataPump = new ExpandableListDataPump(MainActivity.this);

                String emp = controller.getEmployessUnderYou(getChild);


                if(emp.contains("[")){
                    emp = emp.replace("[" , "");
                    if(emp.contains("]")){
                        emp = emp.replace("]" , "");
                    }

                    if(emp.contains(",")){
                        emp = emp.replace("," , "");
                    }
                }
//                if(getChild.contains("Salary")){
//                    int indexOfCar = emp.indexOf("Salary")-3;
//
//                    getChild = getChild.substring(0, indexOfCar);
//                    System.out.println("################## employee "+ getChild + "____ " + indexOfCar);
//                    System.out.println("@@@@@@@@@@@@@@@@@@ Substring Value " + getChild.substring(0, indexOfCar));
//
//                }

                System.out.println("###################3 Employees Salaries " + controller.getSalariesOfUsers(getChild));

                String conrolSpanValue = emp + "\n##Control Span Salaries " + controller.getSalariesOfUsers(getChild) +"##";
                showAlertDialog(MainActivity.this, "Employees Under you "+ getChild, conrolSpanValue, "Exit");

                return false;
            }
        });

    }


    public static void showAlertDialog(Context context, String title, String message, String negBtnMsg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNegativeButton(negBtnMsg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
