package com.netcracker.projectmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attachment {

    private Task task;

    private Long id;
    private String documents;

    public Attachment() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }


    @Override
    public String toString() {
        return "Attachment{" +
                "task=" + task +
                ", id=" + id +
                ", documents='" + documents + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return task.equals(that.task) &&
                id.equals(that.id) &&
                documents.equals(that.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, id, documents);
    }
}
