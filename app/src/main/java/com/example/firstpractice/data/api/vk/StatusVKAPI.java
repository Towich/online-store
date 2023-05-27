package com.example.firstpractice.data.api.vk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StatusVKAPI {
    @GET("status.get?access_token=vk1.a.odRrSeqrgPR1YP8Sa1_j003CAQhU41OG1Ra9OfHkwVvLTuOrLZAkc5wirElN5nGVCLAOSH5vJhe9A7ycoT0Y1IvoBPzqV_5UzGReRfhDVCgO5Re1pROIHae9lf5cgtsqHdlDoTa_D9v-Kzhwg3ITBUs1AZADsN7epPevBpusG85_BIhAO89i0dPqwBfoT0zCEBJxu_H1oY-YIw9O1cZHcg&v=5.131")
    Call<PlaceholderVK> getStatus();

    @FormUrlEncoded
    @POST("status.set?access_token=vk1.a.odRrSeqrgPR1YP8Sa1_j003CAQhU41OG1Ra9OfHkwVvLTuOrLZAkc5wirElN5nGVCLAOSH5vJhe9A7ycoT0Y1IvoBPzqV_5UzGReRfhDVCgO5Re1pROIHae9lf5cgtsqHdlDoTa_D9v-Kzhwg3ITBUs1AZADsN7epPevBpusG85_BIhAO89i0dPqwBfoT0zCEBJxu_H1oY-YIw9O1cZHcg&v=5.131")
    Call<PlaceholderVK> setStatus(@Field("text") String text);

    @FormUrlEncoded
    @POST("wall.addlike?access_token=vk1.a.odRrSeqrgPR1YP8Sa1_j003CAQhU41OG1Ra9OfHkwVvLTuOrLZAkc5wirElN5nGVCLAOSH5vJhe9A7ycoT0Y1IvoBPzqV_5UzGReRfhDVCgO5Re1pROIHae9lf5cgtsqHdlDoTa_D9v-Kzhwg3ITBUs1AZADsN7epPevBpusG85_BIhAO89i0dPqwBfoT0zCEBJxu_H1oY-YIw9O1cZHcg&v=5.131")
    Call<ResponseWall> addLike(@Field("post_id") int post_id);

}
