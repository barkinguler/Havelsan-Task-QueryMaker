package com.company;

import com.company.Data.Fields;
import com.company.Data.Fields2;
import com.company.Methods.Helper;
import com.company.Methods.QueryMethods;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Signature;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Fields fields1 = new Fields("TABLEE1", "pname1", "lastname1", 25, "developer", true);
        Fields2 fields2 = new Fields2("TABLEE2", 12, "bekir", "hatice");

        QueryMethods q = new QueryMethods();
        Helper helper = new Helper();
		System.out.println("Birinci sınıf için örnek sorgular");
        Class cls1 = helper.ClassInformation("Fields", "Data");

        q.OracleCreate(helper.getHashMap(cls1,fields1));
        q.OracleInsert(helper.getHashMap(cls1, fields1));
        q.OracleFind("TAABLEE1", "age", 12);
        q.OracleDelete("TABLEE1","pname","denemeisim");
        q.OracleUpdate("TABLEE1","decision",false);

		System.out.println("\nİkinci sınıf için örnek sorgular");
		Class cls2 = helper.ClassInformation("Fields2", "Data");

		q.OracleCreate(helper.getHashMap(cls2,fields2));
		q.OracleInsert(helper.getHashMap(cls2, fields2));
		q.OracleFind("TAABLEE2", "id", 12);
		q.OracleDelete("TABLEE2","fathername","denemeisim");
		q.OracleUpdate("TABLEE2","mothername","denemeanneisim");



    }


}
