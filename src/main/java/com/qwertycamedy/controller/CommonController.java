package com.qwertycamedy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qwertycamedy.service.RecordService;
import com.qwertycamedy.entity.ERecordStatus;
import com.qwertycamedy.entity.Record;

@Controller
public class CommonController {
    private final RecordService recordService;

    @Autowired
    public CommonController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/home")
    public String getMainPage(Model model) {
        List<Record> records = recordService.findAllRecords();
        int numberOfDone = (int) records.stream().filter(record -> record.getStatus() == ERecordStatus.DONE).count();
        int numberOfActive = (int) records.stream().filter(record -> record.getStatus() == ERecordStatus.ACTIVE)
                .count();

        model.addAttribute("numberOfDoneRecords", numberOfDone);
        model.addAttribute("numberOfActiveRecords", numberOfActive);

        return "main-page";
    }
}
