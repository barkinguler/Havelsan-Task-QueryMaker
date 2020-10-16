package com.company.Methods;

import com.company.Data.Fields;
import com.company.Strategy.Strategy;
import com.sun.jdi.Value;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.Key;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class OracleQueryMethods implements Strategy {


   /* public <T> void OracleFind(String tableName, String fieldname, T conditionvalue) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? 1 : 0) + ";";
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue + "';";
        } else {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue + ";";
        }
        System.out.println(query);


    }


    public <T> void OracleDelete(String tableName, String fieldname, T conditionvalue) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? 1 : 0) + ";";
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue + "';";
        } else {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue + ";";
        }
        System.out.println(query);
    }


    public <T> void OracleUpdate(String tableName, String field, T newvalue) {
        String query;
        if (newvalue.getClass().equals(Boolean.class)) {
            query = "UPDATE " + tableName + " SET " + field + "=" + ((Boolean) newvalue ? 1 : 0) + ";";
        } else if (newvalue.getClass().equals(String.class)) {
            query = "UPDATE " + tableName + " SET " + field + "='" + newvalue + "';";
        } else {
            query = "UPDATE " + tableName + " SET " + field + "=" + newvalue + ";";
        }
        System.out.println(query);
    }


    public void OracleCreate(Map<String, Object> hashMap) {
        String query = "CREATE TABLE ";
        Iterator iter = hashMap.entrySet().iterator();
        int counter = 0;
        while (iter.hasNext()) {

            Map.Entry pair = (Map.Entry) iter.next();

            if (pair.getKey().equals("TableName"))
                query = query + pair.getValue() + "(";

            else {
                query = query + pair.getKey();

                if (pair.getValue().getClass().equals(Integer.class))
                    query = query + " INTEGER,";
                else if (pair.getValue().getClass().equals(Float.class))
                    query = query + " FLOAT,";
                else if (pair.getValue().getClass().equals(String.class))
                    query = query + " VARCHAR(50),";
                else if (pair.getValue().getClass().equals(Boolean.class))
                    query = query + " NUMBER(1) CHECK (" + pair.getKey() + " IN (0,1)),";


            }

        }
        System.out.println(query = query.substring(0, query.length() - 1) + ");");
    }


    public <T> void OracleInsert(Map<String, Object> hashMap) {

        String query = "INSERT INTO ";
        Iterator it = hashMap.entrySet().iterator();
        int counter = 0;
        while (it.hasNext()) {
            counter++;
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals("TableName"))
                query = query + pair.getValue() + " VALUES(";

            else {
                if (pair.getValue().getClass().equals(String.class))
                    query = query + "'" + pair.getValue() + "',";
                else if (pair.getValue().getClass().equals(Boolean.class)) {
                    if (pair.getValue().toString().equals(true))
                        query = query + 1 + ",";
                    else
                        query = query + 0 + ",";

                } else
                    query = query + pair.getValue() + ",";

            }

        }


        System.out.println(query = query.substring(0, query.length() - 1) + ");");

    }*/

    @Override
    public void Create(Map<String, Object> hashMap) {
        String query = "CREATE TABLE ";
        Iterator iter = hashMap.entrySet().iterator();
        int counter = 0;
        while (iter.hasNext()) {

            Map.Entry pair = (Map.Entry) iter.next();

            if (pair.getKey().equals("TableName"))
                query = query + pair.getValue() + "(";

            else {
                query = query + pair.getKey();

                if (pair.getValue().getClass().equals(Integer.class))
                    query = query + " INTEGER,";
                else if (pair.getValue().getClass().equals(Float.class))
                    query = query + " FLOAT,";
                else if (pair.getValue().getClass().equals(String.class))
                    query = query + " VARCHAR(50),";
                else if (pair.getValue().getClass().equals(Boolean.class))
                    query = query + " NUMBER(1) CHECK (" + pair.getKey() + " IN (0,1)),";


            }

        }
        System.out.println(query = query.substring(0, query.length() - 1) + ");");
    }

    @Override
    public <T> void Insert(Map<String, Object> hashMap) {
        String query = "INSERT INTO ";
        Iterator it = hashMap.entrySet().iterator();
        int counter = 0;
        while (it.hasNext()) {
            counter++;
            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals("TableName"))
                query = query + pair.getValue() + " VALUES(";

            else {
                if (pair.getValue().getClass().equals(String.class))
                    query = query + "'" + pair.getValue() + "',";
                else if (pair.getValue().getClass().equals(Boolean.class)) {
                    if (pair.getValue().toString().equals(true))
                        query = query + 1 + ",";
                    else
                        query = query + 0 + ",";

                } else
                    query = query + pair.getValue() + ",";

            }

        }


        System.out.println(query = query.substring(0, query.length() - 1) + ");");
    }

    @Override
    public <T> void Update(String tableName, String field, T newvalue) {
        String query;
        if (newvalue.getClass().equals(Boolean.class)) {
            query = "UPDATE " + tableName + " SET " + field + "=" + ((Boolean) newvalue ? 1 : 0) + ";";
        } else if (newvalue.getClass().equals(String.class)) {
            query = "UPDATE " + tableName + " SET " + field + "='" + newvalue + "';";
        } else {
            query = "UPDATE " + tableName + " SET " + field + "=" + newvalue + ";";
        }
        System.out.println(query);
    }

    @Override
    public <T> void Delete(String tableName, String fieldname, T conditionvalue) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? 1 : 0) + ";";
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue + "';";
        } else {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue + ";";
        }
        System.out.println(query);
    }

    @Override
    public <T> void Find(String tableName, String fieldname, T conditionvalue,int limit) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? 1 : 0) ;
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue ;
        } else {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue ;
        }
        System.out.println(query+" AND ROWNUM<="+limit+";");

    }
}
