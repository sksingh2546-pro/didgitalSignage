package com.digitalSignage.manageFolder;

import javax.persistence.*;

@Entity
@Table(name = "manage_folder")
public class ManageFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String user_name;
    private String parent_folder;
    private String folder_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getParent_folder() {
        return parent_folder;
    }

    public void setParent_folder(String parent_folder) {
        this.parent_folder = parent_folder;
    }

    public String getFolder_name() {
        return folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }
}
