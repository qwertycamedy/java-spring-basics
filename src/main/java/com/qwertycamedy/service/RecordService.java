package com.qwertycamedy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwertycamedy.dao.RecordDao;
import com.qwertycamedy.entity.ERecordStatus;
import com.qwertycamedy.entity.Record;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<Record> findAllRecords() {
        return recordDao.findAllRecords();
    }

    public void saveRecord(String title) {
        if (title != null && !title.isBlank()) {
            recordDao.saveRecord(new Record(title));
        }
    }

    public void updateRecordStatus(int id, ERecordStatus newStatus) {
        recordDao.updateRecordStatus(id, newStatus);
    }

    public void removeRecord(int id) {
        recordDao.removeRecord(id);
    }
}
