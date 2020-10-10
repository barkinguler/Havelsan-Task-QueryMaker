package com.company;

import com.company.Data.Fields;
import com.company.Methods.QueryMethods;

public class Main {

    public static void main(String[] args) {
	Fields f=new Fields("TABLEE","pname1","lastname",25,"developer",true);
	QueryMethods q=new QueryMethods();
	System.out.println("Tablo Oluşturma-- "+q.OracleCreateStatement(f.getTableName()));
	System.out.println("Ekleme işlemi-- "+q.OracleInsertStatement(f.getTableName(),f.getPname(),f.getLastName(),f.getAge(),f.getPosition(),f.isDecision()));
	System.out.println("Güncelleme işlemi-- "+q.OracleUpdateStatement(f.isDecision(),f.getPname(),f.getTableName()));
	System.out.println("Silme işlemi-- "+q.OracleDeleteStatement(f.getPname(),f.getTableName()));
    System.out.println("Select işlemi--"+q.OracleSelectStatement(f.getPname(),f.getTableName()));


    }


}
