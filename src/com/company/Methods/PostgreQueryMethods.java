package com.company.Methods;

import com.company.Strategy.Strategy;

import java.util.Map;

public class PostgreQueryMethods implements Strategy {
    @Override
    public void Create(Map<String, Object> hashMap) {

    }

    @Override
    public <T> void Insert(Map<String, Object> hashMap) {

    }

    @Override
    public <T> void Update(String tableName, String field, T newvalue) {

    }

    @Override
    public <T> void Delete(String tableName, String fieldname, T conditionvalue) {

    }

    @Override
    public <T> void Find(String tableName, String fieldname, T conditionvalue) {

    }
}
