package com.qwertycamedy.entity;

public class Record {
    private static int counterSequence = 0;

    private final int id;
    private final String title;
    private ERecordStatus status;

    public Record(String title) {
        this.id = counterSequence++;
        this.title = title;
        this.status = ERecordStatus.ACTIVE;
    }

    public Record(String title, ERecordStatus status) {
        this.id = counterSequence++;
        this.title = title;
        this.status = status;
    }

    public int getId() {
        return id;
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
