package com.company;

public class Fields implements QueryMethods{
    String tableName;
    String pname;
    String lastName;
    int age;
    String position;
    boolean decision;


    public Fields(String tableName, String pname, String lastName, int age, String position, boolean decision) {
        this.tableName = tableName;
        this.pname = pname;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.decision = decision;
    }

    @Override
    public String OracleInsertStatement() {
        String query="INSERT INTO "+tableName+" VALUES('"+pname+"','"+lastName+"',"+age+",'"+position+"',"+(decision ? 1 : 0)+");";
        return query;
    }

    @Override
    public String OracleDeleteStatement(String pname) {
        String query="DELETE FROM "+tableName+" WHERE "+ "pname='"+ pname+"';";
        return query;
    }

    @Override
    public String OracleUpdateStatement(boolean decision,String pname) {
        String query= "UPDATE "+tableName+" SET "+ "decision="+(decision ? 1 : 0)+ " WHERE pname='"+pname+"';";
        return query;
    }

    @Override
    public String OracleCreateStatement() {
        String query="CREATE TABLE "+tableName+"(pname VARCHAR(50),lastName VARCHAR(50), age INTEGER, position VARCHAR(50), decision NUMBER(1) CHECK (decision IN (0,1) ),PRIMARY KEY (pname) );";
        return query;
    }

    @Override
    public String OracleSelectStatement(String pname) {
        String query="SELECT * FROM "+tableName +" WHERE PNAME='"+pname+"';";
        return query;
    }
}
