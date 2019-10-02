package edu.daffodil.cdc.resources;

import com.google.gson.annotations.SerializedName;

public class Announcement {
    @SerializedName("notice_id")
    String noticeId;

    @SerializedName("notice_title")
    String noticeTitle;

    @SerializedName("notice_slug")
    String noticeSlug;

    @SerializedName("department")
    String depeartment;

    @SerializedName("main_contant")
    String mainContent;

    @SerializedName("fileName")
    String fileName;

    @SerializedName("fileNames")
    String fileNames;

    @SerializedName("status")
    String status;

    @SerializedName("date")
    String date;

    @SerializedName("counter")
    String counter;

    @SerializedName("creator")
    String creator;

    public Announcement() {

    }

    public String getNoticeId() {
        return noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public String getNoticeSlug() {
        return noticeSlug;
    }

    public String getDepeartment() {
        return depeartment;
    }

    public String getMainContent() {
        return mainContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileNames() {
        return fileNames;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getCounter() {
        return counter;
    }

    public String getCreator() {
        return creator;
    }
}
