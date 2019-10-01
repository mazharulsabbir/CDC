package edu.daffodil.cdc.resources;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    String BASE_JOBS_URL = "http://skill.jobs/api/";

    @GET("jobs")
    Call<AllJobs> getAllJobs();

    @GET("job/{id}")
    Call<String> getJobDetails(
            @Path("id") int jobId);

}
