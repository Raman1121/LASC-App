package com.example.raman.lasc_app;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by raman on 11/10/17.
 */

public interface QuestionsSpreadsheetWebService {

    @POST("1HEvFwx10XIMa4ZH6CuQzHFInuCgosaNzttMzU8sMnyg/formResponse")
    @FormUrlEncoded
    Call<Void> completeQuestionnaire(
            @Field("entry.188672219") String name,
            @Field("entry.1859048068") String answerQuestionCat
    );

}
