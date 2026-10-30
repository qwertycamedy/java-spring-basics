package com.qwertycamedy.spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("parking")
public class Parking {
    private List<Vehicle> list;
    private Map<String, Vehicle> map;

    @Autowired
    public Parking(List<Vehicle> list, Map<String, Vehicle> map) {
        this.list = list;
        this.map = map;
    }

    public List<Vehicle> getList() {
        return this.list;
    }

    public Map<String, Vehicle> getMap() {
        return this.map;
    }
}
