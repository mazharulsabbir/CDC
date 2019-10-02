package edu.daffodil.cdc.resources;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    String BASE_JOBS_URL = "http://test.skill.jobs/api/jobs";

    String BASE_ANNOUNCEMENT_API = "http://daffodilvarsity.edu.bd/noticeboard/noticeApi/";

    @GET("jobs")
    Call<AllJobs> getAllJobs();

    @GET("job/{id}")
    Call<String> getJobDetails(
            @Path("id") int jobId);

    @GET("cse")
    Call<AllAnnouncement> getAnnouncements();
}


