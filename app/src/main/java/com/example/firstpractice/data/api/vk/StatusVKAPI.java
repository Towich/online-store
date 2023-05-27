package com.example.firstpractice.data.api.vk;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StatusVKAPI {
    @GET("status.get?access_token=vk1.a.TZIrTZzSMNj0oeM40IProUH0gnb5B-v6VNkLnWRJhWL7HdxzerH47wJV99zlfcQPJbt6InXXmSMqr7fYb9KFpAHbLHyjwmIr-tn3f4Xq9_VQn0CrCI97xQPrlOi17REIVQorYBZCmlIP9eZawEKz3iBdHhVwmU5REv84p06hq9kscYWVDDuXOJQhvdLp8rVdf8-LL9gDLQ-PB-395CqMDA&v=5.131")
    Call<PlaceholderVK> getStatus();

    @FormUrlEncoded
    @POST("status.set?access_token=vk1.a.TZIrTZzSMNj0oeM40IProUH0gnb5B-v6VNkLnWRJhWL7HdxzerH47wJV99zlfcQPJbt6InXXmSMqr7fYb9KFpAHbLHyjwmIr-tn3f4Xq9_VQn0CrCI97xQPrlOi17REIVQorYBZCmlIP9eZawEKz3iBdHhVwmU5REv84p06hq9kscYWVDDuXOJQhvdLp8rVdf8-LL9gDLQ-PB-395CqMDA&v=5.131")
    Call<PlaceholderVK> setStatus(@Field("text") String text);

}
