package com.example.lenovo.fetchgrouplistwithimage;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lENOVO on 7/25/2017.
 */

public interface MyApi {
//http://nimbyisttechnologies.com/jaskirat/ci/p&p/

    @FormUrlEncoded
    @POST("group/fetch_group_list")
    Call<MyPojo> fetchGroupList(@FieldMap HashMap<String, String> map);
}
