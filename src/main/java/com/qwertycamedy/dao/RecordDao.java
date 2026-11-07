package com.qwertycamedy.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qwertycamedy.entity.ERecordStatus;
import com.qwertycamedy.entity.Record;

@Repository 
public class RecordDao {
    public final List<Record> records = new ArrayList<>(
            Arrays.asList(
                    new Record("take a shower", ERecordStatus.ACTIVE),
                    new Record("buy flowers", ERecordStatus.DONE),
                    new Record("go to the gym", ERecordStatus.ACTIVE)));

    public List<Record> findAllRecords() {
        return new ArrayList<>(records);
    }
}
