package com.netcracker.projectmanager.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "attachments_tasks")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "task", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Task task;

    @Column(name = "document", nullable = false, length = 255)
    private String document;

    public Attachment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return id.equals(that.id) &&
                task.equals(that.task) &&
                document.equals(that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, document);
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", task=" + task +
                ", document='" + document + '\'' +
                '}';
    }


}
