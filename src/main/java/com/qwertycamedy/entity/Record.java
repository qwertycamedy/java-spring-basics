package com.qwertycamedy.entity;

public class Record {
    private final String title;
    private ERecordStatus status;

    public Record(String title) {
        this.title = title;
        this.status = ERecordStatus.ACTIVE;
    }

    public Record(String title, ERecordStatus status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public ERecordStatus getStatus() {
        return status;
    }

    public void setStatus(ERecordStatus status) {
        this.status = status;
    }
}
