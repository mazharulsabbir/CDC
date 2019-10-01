package edu.daffodil.cdc.model;

public class JobDetailsViewHelper {
    private String title, description;

    public JobDetailsViewHelper() {
    }

    public JobDetailsViewHelper(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
