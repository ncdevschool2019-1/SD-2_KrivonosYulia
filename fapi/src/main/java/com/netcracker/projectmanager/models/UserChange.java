package com.netcracker.projectmanager.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserChange {
    private int id;
    private String email;
    private String newImagePath;
    private String oldImagePath;
    private String newPassword;

    private String oldPassword;
    private String newName;
    private String oldName;
    private String oldSurname;
    private String newSurname;

}
