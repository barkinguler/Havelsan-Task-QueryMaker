package com.company;

public class QueryMethods {

    public String OracleInsertStatement(String tableName,String pname,String lastName,int age,String position,boolean decision) {
        String query="INSERT INTO "+tableName+" VALUES('"+pname+"','"+lastName+"',"+age+",'"+position+"',"+(decision ? 1 : 0)+");";
        return query;
    }


    public String OracleDeleteStatement(String pname,String tableName) {
        String query="DELETE FROM "+tableName+" WHERE "+ "pname='"+ pname+"';";
        return query;
    }


     public String OracleUpdateStatement(boolean decision,String pname,String tableName) {
        String query= "UPDATE "+tableName+" SET "+ "decision="+(decision ? 1 : 0)+ " WHERE pname='"+pname+"';";
        return query;
    }


     public String OracleCreateStatement(String tableName) {
        String query="CREATE TABLE "+tableName+"(pname VARCHAR(50),lastName VARCHAR(50), age INTEGER, position VARCHAR(50), decision NUMBER(1) CHECK (decision IN (0,1) ),PRIMARY KEY (pname) );";
        return query;
    }


     public String OracleSelectStatement(String pname,String tableName) {
        String query="SELECT * FROM "+tableName +" WHERE PNAME='"+pname+"';";
        return query;
    }
}
