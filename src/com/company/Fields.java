package com.company;

import java.util.ArrayList;
import java.util.List;

public class Fields extends QueryMethods {
   private String tableName;
   private String pname;
   private String lastName;
   private int age;
   private String position;
   private boolean decision;


    public Fields(String tableName, String pname, String lastName, int age, String position, boolean decision) {
        this.tableName = tableName;
        this.pname = pname;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.decision = decision;
    }

    public String getTableName() {
        return tableName;
    }

    public String getPname() {
        return pname;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public boolean isDecision() {
        return decision;
    }



}
