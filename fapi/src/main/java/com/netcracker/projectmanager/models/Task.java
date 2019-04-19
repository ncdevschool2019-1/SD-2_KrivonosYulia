package com.netcracker.projectmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {


    private Long id;
    private Integer ticketCode;

     private String description;

    private Priority priority;

    private Project projectCode;

    private Status status;

    private Long dueDate;

    private Long estimation;

    private Long createdDate;

    private Long updatedDate;


    private User reporter;


    private User assignedUser;

//
//    private Integer id;
//    private String description;
//    private String priority;
//    private String status;
//    private Long due_date;
//    private Long created_date;
//    private Long updated_date;
//    private Long estimation;
//    private int ticketCode;
//    private String projectCode;
//    private Integer userReporter;
//    private Integer assignedUser;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaskCode() {
        return ticketCode;
    }

    public void setTaskCode(Integer taskCode) {
        this.ticketCode = taskCode;
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

    public Project getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(Project projectCode) {
        this.projectCode = projectCode;
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
                ticketCode.equals(task.ticketCode) &&
                projectCode.equals(task.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketCode, projectCode);
    }
}
