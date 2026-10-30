package com.qwertycamedy.spring;

//пример синглтона
public class DBConnector {
    private static DBConnector instance;

    private final String url;
    private final String port;

    private DBConnector() {
        this.url = "http://localhost";
        this.port = "5432";
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }

        return instance;
    }

    public void executeSql(String sql) {
        System.out.println("Connecting to bd with address: " + url + ":" + port);
        System.out.println("Executing: " + sql);
    }
}
