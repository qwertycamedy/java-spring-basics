package com.qwertycamedy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qwertycamedy.service.RecordService;
import com.qwertycamedy.entity.ERecordStatus;
import com.qwertycamedy.entity.dto.QueryParametersDto;
import com.qwertycamedy.entity.dto.RecordsContainerDto;

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
    public String getMainPage(Model model, @RequestParam(name = "filter", required = false) String filterMode) {
        RecordsContainerDto container = recordService.findAllRecords(filterMode);

        model.addAttribute("records", container.getRecords());
        model.addAttribute("numberOfDoneRecords", container.getNumberOfDone());
        model.addAttribute("numberOfActiveRecords", container.getNumberOfActive());

        return "main-page";
    }

    @PostMapping("/add-record")
    public String addRecord(@RequestParam("title") String title) {
        recordService.saveRecord(title);
        return "redirect:/home";
    }

    @PostMapping("/make-record-done")
    public String makeRecordDone(
            QueryParametersDto queryParameters) {
        int id = queryParameters.getId();
        String filter = queryParameters.getFilter();

        recordService.updateRecordStatus(id, ERecordStatus.DONE);

        return queryParameters.homeRequestString(filter);
    }

    @PostMapping("/remove-record")
    public String removeRecord(
            QueryParametersDto queryParameters) {
        int id = queryParameters.getId();
        String filter = queryParameters.getFilter();

        recordService.removeRecord(id);

        return queryParameters.homeRequestString(filter);
    }
}