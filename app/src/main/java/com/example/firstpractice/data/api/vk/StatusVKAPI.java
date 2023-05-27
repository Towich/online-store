package com.example.firstpractice.data.api.vk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StatusVKAPI {
    @GET("status.get?access_token=vk1.a.C-_WshzaTXaiJrcCiiuPCdx5Wlbh7La5udsQNyk5Sf8KsbeGFiibPksGq-7ktToA1q5Tok1BQdHfTEpr6JzR_srJIuLzl5-rgWgHSIkLxWdAo6_3d_99qRPaJTy8ZX12WFNORmksE-E3_Na-rJS24VNja156RUR95e5hl1jmdp9goXM-08invIMyblRYecoNWYOgQq9M4YHYQTNzWUXoAg&v=5.131")
    Call<PlaceholderVK> getStatus();

    @FormUrlEncoded
    @POST("status.set?access_token=vk1.a.C-_WshzaTXaiJrcCiiuPCdx5Wlbh7La5udsQNyk5Sf8KsbeGFiibPksGq-7ktToA1q5Tok1BQdHfTEpr6JzR_srJIuLzl5-rgWgHSIkLxWdAo6_3d_99qRPaJTy8ZX12WFNORmksE-E3_Na-rJS24VNja156RUR95e5hl1jmdp9goXM-08invIMyblRYecoNWYOgQq9M4YHYQTNzWUXoAg&v=5.131")
    Call<PlaceholderVK> setStatus(@Field("text") String text);

    @FormUrlEncoded
    @POST("wall.addlike?access_token=vk1.a.C-_WshzaTXaiJrcCiiuPCdx5Wlbh7La5udsQNyk5Sf8KsbeGFiibPksGq-7ktToA1q5Tok1BQdHfTEpr6JzR_srJIuLzl5-rgWgHSIkLxWdAo6_3d_99qRPaJTy8ZX12WFNORmksE-E3_Na-rJS24VNja156RUR95e5hl1jmdp9goXM-08invIMyblRYecoNWYOgQq9M4YHYQTNzWUXoAg&v=5.131")
    Call<ResponseWall> addLike(@Field("post_id") int post_id);

}
