package com.company.Context;

import com.company.Strategy.Strategy;

import java.util.Map;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){

        this.strategy=strategy;
    }
    public void executeCreate(Map<String, Object> hashMap){

    strategy.Create(hashMap);
    }
    public void executeInsert(Map<String, Object> hashMap){


        strategy.Insert(hashMap);
    }
    public <T>void executeUpdate(String tableName, String field, T newvalue){

        strategy.Update(tableName,field,newvalue);
    }
    public <T> void executeDelete(String tableName, String fieldname, T conditionvalue){


        strategy.Delete(tableName,fieldname,conditionvalue);
    }

    public <T> void executeFind(String tableName, String fieldname, T conditionvalue,int limit){


        strategy.Find(tableName,fieldname,conditionvalue,limit);
    }

}
