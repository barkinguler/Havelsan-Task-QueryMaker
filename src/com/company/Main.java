package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	Fields f=new Fields("TABLEE","pname1","lastname",25,"developer",true);
	System.out.println("Tablo Oluşturma-- "+f.OracleCreateStatement(f.getTableName()));
	System.out.println("Ekleme işlemi-- "+f.OracleInsertStatement(f.getTableName(),f.getPname(),f.getLastName(),f.getAge(),f.getPosition(),f.isDecision()));
	System.out.println("Güncelleme işlemi-- "+f.OracleUpdateStatement(f.isDecision(),f.getPname(),f.getTableName()));
	System.out.println("Silme işlemi-- "+f.OracleDeleteStatement(f.getPname(),f.getTableName()));
    System.out.println("Select işlemi--"+f.OracleSelectStatement(f.getPname(),f.getTableName()));


    }


}
