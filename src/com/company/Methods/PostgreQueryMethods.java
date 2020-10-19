package com.company.Methods;

import com.company.Strategy.Strategy;

import java.util.Iterator;
import java.util.Map;

public class PostgreQueryMethods implements Strategy {

    @Override
    public void Create(Map<String, Object> hashMap) {
        StringBuilder query = new StringBuilder();
        Iterator iter = hashMap.entrySet().iterator();

        query.append("CREATE TABLE IF NOT EXISTS ");
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

                else if (pair.getValue().getClass().equals(Boolean.class))

                    query.append(" BOOLEAN,");

            }

        }

        System.out.println(query.deleteCharAt(query.length() - 1).append(");"));
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
                        query.append(true);
                        query.append(",");
                    } else {
                        query.append(false);
                        query.append(",");
                    }
                } else {
                    query.append(pair.getValue());
                    query.append(",");
                }
            }

        }


        System.out.println(query.deleteCharAt(query.length() - 1).append(") RETURNING *;"));
    }

    @Override
    public <T> void Update(String tableName, String field, T newvalue) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ");
        query.append(tableName);
        query.append(" SET ");
        if (newvalue.getClass().equals(Boolean.class)) {

            query.append(field);
            query.append("=");
            query.append((Boolean) newvalue ? true : false);
        } else if (newvalue.getClass().equals(String.class)) {

            query.append(field);
            query.append("='");
            query.append(newvalue);
            query.append("'");

        } else {

            query.append(field);
            query.append("=");
            query.append(newvalue);
        }
        query.append(" RETURNING ");
        query.append(field);
        query.append(";");
        System.out.println(query);
    }

    @Override
    public <T> void Delete(String tableName, String fieldname, T conditionvalue) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(tableName);
        query.append(" WHERE ");
        if (conditionvalue.getClass().equals(Boolean.class)) {

            query.append(fieldname);
            query.append("=");
            query.append((Boolean) conditionvalue ? true : false);

        } else if (conditionvalue.getClass().equals(String.class)) {

            query.append(fieldname);
            query.append("='");
            query.append(conditionvalue);
            query.append("'");
        } else {

            query.append(fieldname);
            query.append("=");
            query.append(conditionvalue);

        }
        query.append(" RETURNING ");
        query.append(fieldname);
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
            query.append(((Boolean) conditionvalue ? true : false));

        } else if (conditionvalue.getClass().equals(String.class)) {

            query.append("='");
            query.append(conditionvalue);

        } else {

            query.append("=");
            query.append(conditionvalue);

        }

        query.append(" LIMIT ");
        query.append(limit);
        query.append(";");
        System.out.println(query);
    }
}
