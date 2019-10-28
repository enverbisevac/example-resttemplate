package com.bisevac.enver.azure.graph;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
    public String id;
    public String givenName;
    public String surname;
    public String displayName;
    public String userPrincipalName;
    public String jobTitle;
    public String mail;
    public String mobilePhone;
    public String officeLocation;
    public String preferredLanguage;

    public List<String> businessPhones = null;
}