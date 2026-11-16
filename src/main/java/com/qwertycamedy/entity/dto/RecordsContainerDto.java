package com.qwertycamedy.entity.dto;

import java.util.List;

import com.qwertycamedy.entity.Record;

public class RecordsContainerDto {
    private final List<Record> records;
    private final int numberOfDone;
    private final int numberOfActive;

    public RecordsContainerDto(List<Record> records, int numberOfDone, int numberOfActive) {
        this.records = records;
        this.numberOfDone = numberOfDone;
        this.numberOfActive = numberOfActive;
    }

    public List<Record> getRecords() {
        return records;
    }

    public int getNumberOfDone() {
        return numberOfDone;
    }

    public int getNumberOfActive() {
        return numberOfActive;
    }
}
