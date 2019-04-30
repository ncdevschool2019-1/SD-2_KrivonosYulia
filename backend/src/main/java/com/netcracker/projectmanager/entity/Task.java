package com.netcracker.projectmanager.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ticketcode", nullable = false)
    private Integer taskCode;

    @Column(name = "description",length = 255,  nullable = false)
    private String description;


    @OneToOne
    @JoinColumn(name = "priority", nullable = false)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private Project projectCode;

    @OneToOne
    @JoinColumn(name = "status", nullable = false)
    private Status status;

    @Column(name = "due_date", nullable = false)
    private Long dueDate;

    @Column(name = "estimation", nullable = false)
    private Long estimation;

    @Column(name = "created_date", nullable = false)
    private Long createdDate;

    @Column(name = "updated_date", nullable = false)
    private Long updatedDate;


    @ManyToOne
    @JoinColumn(name = "reporter", nullable = false)
    private User reporter;


    @ManyToOne
    @JoinColumn(name = "assigneduser", nullable = true)
    private User assignedUser;


    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(Integer taskCode) {
        this.taskCode = taskCode;
    }

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public Long getEstimation() {
        return estimation;
    }

    public void setEstimation(Long estimation) {
        this.estimation = estimation;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id) &&
                taskCode.equals(task.taskCode) &&
                projectCode.equals(task.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskCode, projectCode);
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskCode=" + taskCode +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", projectCode=" + projectCode +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", estimation=" + estimation +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", reporter=" + reporter +
                ", assignedUser=" + assignedUser +
                '}';
    }
}
