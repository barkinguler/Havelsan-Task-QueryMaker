package com.company;

public class Main {

    public static void main(String[] args) {
	Fields f=new Fields("TABLEE","pname1","lastname",25,"developer",true);
	System.out.println("Tablo Oluşturma-- "+f.OracleCreateStatement());
	System.out.println("Ekleme işlemi-- "+f.OracleInsertStatement());
	System.out.println("Güncelleme işlemi-- "+f.OracleUpdateStatement(false,"pname1"));
	System.out.println("Silme işlemi-- "+f.OracleDeleteStatement("pname1"));
    System.out.println("Select işlemi--"+f.OracleSelectStatement("pname1"));
    }
}
