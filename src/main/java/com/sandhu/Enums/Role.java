package com.sandhu.Enums;

public enum Role {
    PM("PM", "Product Manager"),
    PJM("PJM", "ProjectManager"),
    SE("SE", "Software engineer");



    private String code;
    private String description;

    private Role(String code, String description) {

        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
