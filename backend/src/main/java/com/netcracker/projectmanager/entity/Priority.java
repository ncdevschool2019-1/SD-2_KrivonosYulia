package com.netcracker.projectmanager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "priorities")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private short id;

    @Column(name = "priority_name",length = 15, nullable = false)
    private String priorityName;


    public Priority() {

    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getPriority() {
        return priorityName;
    }

    public void setPriority(String priority) {
        this.priorityName = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority1 = (Priority) o;
        return Objects.equals(id, priority1.id) &&
                Objects.equals(priorityName, priority1.priorityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priorityName);
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", priority='" + priorityName + '\'' +
                '}';
    }


}
