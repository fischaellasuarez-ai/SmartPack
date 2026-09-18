package com.example.smartpack.quarter2_MiniPeta3;

public class Roldan_Minipeta3 {
    // Member fields
    String uploadDate;
    String senderName;
    int targetGrade;
    String targetSection;
    boolean notificationSent;

    // Constructor to initialize the object
    Roldan_Minipeta3(String uploadDate, String senderName, int targetGrade, String targetSection, boolean notificationSent) {
        this.uploadDate = uploadDate;
        this.senderName = senderName;
        this.targetGrade = targetGrade;
        this.targetSection = targetSection;
        this.notificationSent = notificationSent;
    }

    // Getters to retrieve data for the UI
    String getUploadDate() {
        return uploadDate;
    }
    String getSenderName() {
        return senderName;
    }
    int getTargetGrade() {
        return targetGrade;
    }
    String getTargetSection() {
        return targetSection;
    }
    boolean isNotificationSent() {
        return notificationSent;
    }
}
