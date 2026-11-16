package com.qwertycamedy.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwertycamedy.dao.RecordDao;
import com.qwertycamedy.entity.ERecordStatus;
import com.qwertycamedy.entity.Record;
import com.qwertycamedy.entity.dto.RecordsContainerDto;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public RecordsContainerDto findAllRecords(String filterMode) {
        List<Record> records = recordDao.findAllRecords();
        int numberOfDone = (int) records.stream()
                .filter(record -> record.getStatus() == ERecordStatus.DONE)
                .count();
        int numberOfActive = (int) records.stream()
                .filter(record -> record.getStatus() == ERecordStatus.ACTIVE)
                .count();

        if (filterMode == null || filterMode.isBlank()) {
            return new RecordsContainerDto(records, numberOfDone, numberOfActive);
        }

        String filterModeInUpperCase = filterMode.toUpperCase();
        List<String> allowedFilterModes = Arrays.stream(ERecordStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        if (allowedFilterModes.contains(filterModeInUpperCase)) {
            List<Record> filteredRecords = records.stream()
                    .filter(item -> item.getStatus() == ERecordStatus.valueOf(filterModeInUpperCase))
                    .collect(Collectors.toList());

            return new RecordsContainerDto(filteredRecords, numberOfDone, numberOfActive);
        } else {
            return new RecordsContainerDto(records, numberOfDone, numberOfActive);
        }
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
