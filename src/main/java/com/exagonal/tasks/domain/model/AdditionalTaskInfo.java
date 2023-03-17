package com.exagonal.tasks.domain.model;

public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;

    public AdditionalTaskInfo(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
