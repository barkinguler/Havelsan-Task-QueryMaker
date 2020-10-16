package com.company;

import com.company.Context.Context;
import com.company.Data.Fields;
import com.company.Methods.ClassInformationHelper;
import com.company.Methods.OracleQueryMethods;
import com.company.Methods.PostgreQueryMethods;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Context context=null;
        Fields fields1 = new Fields("TABLEE1", "pname1", "lastname1", 25, "developer", true);
        ClassInformationHelper classInformationHelper = new ClassInformationHelper();
        Map map=classInformationHelper.getHashMap("Fields", "Data",fields1);

		System.out.println("Oracle için örnek sorgular");

        context=new Context(new OracleQueryMethods());

        context.executeCreate(map);
        context.executeInsert(map);
        context.executeFind("TAABLEE1", "age", 12,5);
        context.executeDelete("TABLEE1","pname","denemeisim");
        context.executeUpdate("TABLEE1","decision",false);


        System.out.println("\nPostgre  için örnek sorgular");

		context=new Context(new PostgreQueryMethods());

        context.executeCreate(map);
        context.executeInsert(map);
        context.executeFind("TAABLEE1", "age", 12,5);
        context.executeDelete("TABLEE1","pname","denemeisim");
        context.executeUpdate("TABLEE1","decision",false);



    }


}
