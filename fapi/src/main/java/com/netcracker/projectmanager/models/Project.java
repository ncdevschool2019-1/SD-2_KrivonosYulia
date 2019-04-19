package com.netcracker.projectmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private Integer id;
    private String projectCode;
    private String summary;

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(projectCode, project.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectCode);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectCode='" + projectCode + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
