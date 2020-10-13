package com.company.Data;

public class Fields2 {
    private String tableName;
    private int id;
    private String fathername;
    private String mothername;

    public Fields2() {
    }

    public Fields2(String tableName, int id, String fathername, String mothername) {
        this.tableName = tableName;
        this.id = id;
        this.fathername = fathername;
        this.mothername = mothername;
    }

    public String getTableName() {
        return tableName;
    }

    public int getId() {
        return id;
    }

    public String getFathername() {
        return fathername;
    }

    public String getMothername() {
        return mothername;
    }
}
