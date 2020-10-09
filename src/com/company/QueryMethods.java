package com.company;

public interface QueryMethods {

    String OracleInsertStatement();
    String OracleDeleteStatement(String pname);
    String OracleUpdateStatement(boolean decision,String pname);
    String OracleCreateStatement();
    String OracleSelectStatement(String pname);
}
