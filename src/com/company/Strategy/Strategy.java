package com.company.Strategy;

import java.util.Map;

public interface Strategy {
    public void Create(Map<String, Object> hashMap);
    public <T> void Insert(Map<String, Object> hashMap);
    public <T> void Update(String tableName, String field, T newvalue);
    public <T> void Delete(String tableName, String fieldname, T conditionvalue);
    public <T> void Find(String tableName, String fieldname, T conditionvalue);

}
