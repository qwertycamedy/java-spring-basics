package com.qwertycamedy.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dbConnector")
public class DatabaseConnector {
    @Value("${database-connector.host}")
    private String dbHost;
    @Value("${database-connector.port}")
    private String dbPort;
    @Value("${database-connector.credentials.username}")
    private String dbUser;
    @Value("${database-connector.credentials.password}")
    private String dbPassword;

    public void executeSql(String sql) {
        System.out.println(
                "Connecting: https://" + dbHost + ":" + dbPort + "?username=" + dbUser + "&password=" + dbPassword);
        System.out.println("Executing provided SQL: " + sql);
        System.out.println("Provided SQL was successfully executed!");
    }
}
