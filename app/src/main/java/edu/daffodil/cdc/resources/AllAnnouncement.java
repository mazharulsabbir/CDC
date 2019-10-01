package edu.daffodil.cdc.resources;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllAnnouncement {

    @SerializedName("notice")
    List<Announcement> announcements;

    public AllAnnouncement(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }
}
