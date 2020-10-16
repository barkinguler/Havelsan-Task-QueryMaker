package com.company.Methods;

import com.company.Strategy.Strategy;

import java.util.Iterator;
import java.util.Map;

public class PostgreQueryMethods implements Strategy {
    @Override
    public void Create(Map<String, Object> hashMap) {
        String query = "CREATE TABLE IF NOT EXISTS ";
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
                    query = query + " BOOLEAN,";


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
                        query = query + true + ",";
                    else
                        query = query + false + ",";

                } else
                    query = query + pair.getValue() + ",";

            }

        }


        System.out.println(query = query.substring(0, query.length() - 1) + ") RETURNING *;");
    }

    @Override
    public <T> void Update(String tableName, String field, T newvalue) {
        String query;
        if (newvalue.getClass().equals(Boolean.class)) {
            query = "UPDATE " + tableName + " SET " + field + "=" + ((Boolean) newvalue ? true : false);
        } else if (newvalue.getClass().equals(String.class)) {
            query = "UPDATE " + tableName + " SET " + field + "='" + newvalue;
        } else {
            query = "UPDATE " + tableName + " SET " + field + "=" + newvalue;
        }
        System.out.println(query + " RETURNING " + field + ";");
    }

    @Override
    public <T> void Delete(String tableName, String fieldname, T conditionvalue) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? true : false);
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue+"'";
        } else {
            query = "DELETE FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue;
        }
        System.out.println(query + " RETURNING " + fieldname + ";");
    }

    @Override
    public <T> void Find(String tableName, String fieldname, T conditionvalue, int limit) {
        String query;
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + ((Boolean) conditionvalue ? true : false) + ";";
        } else if (conditionvalue.getClass().equals(String.class)) {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "='" + conditionvalue + "';";
        } else {
            query = "SELECT * FROM " + tableName + " WHERE " + fieldname + "=" + conditionvalue + ";";
        }
        System.out.println(query + " LIMIT " + limit + ";");
    }
}
