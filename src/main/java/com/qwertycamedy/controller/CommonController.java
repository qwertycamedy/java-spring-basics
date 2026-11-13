package com.qwertycamedy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getMainPage(Model model) {
        List<Record> records = recordService.findAllRecords();
        int numberOfDone = (int) records.stream().filter(record -> record.getStatus() == ERecordStatus.DONE).count();
        int numberOfActive = (int) records.stream().filter(record -> record.getStatus() == ERecordStatus.ACTIVE)
                .count();

        model.addAttribute("records", records);
        model.addAttribute("numberOfDoneRecords", numberOfDone);
        model.addAttribute("numberOfActiveRecords", numberOfActive);

        return "main-page";
    }

    @PostMapping("/add-record")
    public String addRecord(@RequestParam("title") String title) {
        recordService.saveRecord(title);
        return "redirect:/home";
    }

    @PostMapping("/make-record-done")
    public String makeRecordDone(@RequestParam("title") String title) {
        recordService.updateRecordStatus(title, ERecordStatus.DONE);
        return "redirect:/home";
    }

    @PostMapping ("/remove-record")
    public String removeRecord(@RequestParam("title") String title) {
        recordService.removeRecord(title);
        return "redirect:/home";
    }
}
