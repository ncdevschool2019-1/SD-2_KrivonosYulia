package com.netcracker.projectmanager.models;

import java.util.Objects;

public class TaskViewModel {


    private Long id;
    private Integer ticketCode;

    private String description;

    private String priority;

    private String projectCode;

    private String status;

    private Long dueDate;

    private Long estimation;

    private Long createdDate;

    private Long updatedDate;

    private  Integer reporter;

    private Integer assignedUser;

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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Integer getReporter() {
        return reporter;
    }

    public void setReporter(Integer reporter) {
        this.reporter = reporter;
    }

    public Integer getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(Integer assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskViewModel that = (TaskViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ticketCode, that.ticketCode) &&
                Objects.equals(description, that.description) &&
                Objects.equals(priority, that.priority) &&
                Objects.equals(projectCode, that.projectCode) &&
                Objects.equals(status, that.status) &&
                Objects.equals(dueDate, that.dueDate) &&
                Objects.equals(estimation, that.estimation) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(updatedDate, that.updatedDate) &&
                Objects.equals(reporter, that.reporter) &&
                Objects.equals(assignedUser, that.assignedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketCode, description, priority, projectCode, status, dueDate, estimation, createdDate, updatedDate, reporter, assignedUser);
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id=" + id +
                ", taskCode=" + ticketCode +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", projectCode='" + projectCode + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", estimation=" + estimation +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", reporter=" + reporter +
                ", assignedUser=" + assignedUser +
                '}';
    }

    public TaskViewModel() {
    }
}
