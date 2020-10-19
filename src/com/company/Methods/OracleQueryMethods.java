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


    @Override
    public void Create(Map<String, Object> hashMap) {

        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE ");
        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {

            Map.Entry pair = (Map.Entry) iter.next();

            if (pair.getKey().equals("TableName")) {
                query.append(pair.getValue());
                query.append("(");
            } else {

                query.append(pair.getKey());
                if (pair.getValue().getClass().equals(Integer.class))
                    query.append(" INTEGER,");

                else if (pair.getValue().getClass().equals(Float.class))

                    query.append(" FLOAT,");
                else if (pair.getValue().getClass().equals(String.class))
                    query.append(" VARCHAR(50),");

                else if (pair.getValue().getClass().equals(Boolean.class)) {

                    query.append(" NUMBER(1) CHECK (");
                    query.append(pair.getKey());
                    query.append(" IN (0,1)),");
                }

            }

        }
        query.deleteCharAt(query.length() - 1).append(");");
        System.out.println(query);
    }

    @Override
    public <T> void Insert(Map<String, Object> hashMap) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ");

        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            if (pair.getKey().equals("TableName")) {

                query.append(pair.getValue());
                query.append(" VALUES(");
            } else {
                if (pair.getValue().getClass().equals(String.class)) {

                    query.append("'");
                    query.append(pair.getValue());
                    query.append("',");
                } else if (pair.getValue().getClass().equals(Boolean.class)) {
                    if (pair.getValue().toString().equals(true)) {
                        query.append(1);
                        query.append(",");

                    } else {
                        query.append(0);
                        query.append(",");

                    }
                } else {
                    query.append(pair.getValue());
                    query.append(",");

                }


            }

        }

        query.deleteCharAt(query.length() - 1);
        query.append(");");
        System.out.println(query);

    }

    @Override
    public <T> void Update(String tableName, String field, T newvalue) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ");
        query.append(tableName);
        query.append(" SET ");
        query.append(field);
        if (newvalue.getClass().equals(Boolean.class)) {
            query.append("=");
            query.append(((Boolean) newvalue ? 1 : 0));
            query.append(";");

        } else if (newvalue.getClass().equals(String.class)) {
            query.append("='");
            query.append(newvalue);
            query.append("';");

        } else {
            query.append("=");
            query.append(newvalue);
            query.append(";");

        }
        System.out.println(query);
    }

    @Override
    public <T> void Delete(String tableName, String fieldname, T conditionvalue) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(tableName);
        query.append(" WHERE ");
        query.append(fieldname);
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query.append("=");
            query.append(((Boolean) conditionvalue ? 1 : 0));


        } else if (conditionvalue.getClass().equals(String.class)) {
            query.append("='");
            query.append(conditionvalue);

        } else {
            query.append("=");
            query.append(conditionvalue);


        }
        query.append(";");
        System.out.println(query);
    }

    @Override
    public <T> void Find(String tableName, String fieldname, T conditionvalue, int limit) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM ");
        query.append(tableName);
        query.append(" WHERE ");
        query.append(fieldname);
        if (conditionvalue.getClass().equals(Boolean.class)) {
            query.append("=");
            query.append(((Boolean) conditionvalue ? 1 : 0));

        } else if (conditionvalue.getClass().equals(String.class)) {
            query.append("='");
            query.append(conditionvalue);

        } else {
            query.append("=");
            query.append(conditionvalue);

        }
        query.append(" AND ROWNUM<=");
        query.append(limit);
        query.append(";");
        System.out.println(query);

    }
}
