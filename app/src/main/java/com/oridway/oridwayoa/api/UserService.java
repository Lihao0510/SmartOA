package com.oridway.oridwayoa.api;

import com.oridway.oridwayoa.entity.ResponseObject;
import com.oridway.oridwayoa.entity.SysUser;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lihao on 2017/8/5.
 */

public interface UserService {

    @POST("/user/syslogin")
    @FormUrlEncoded
    Observable<ResponseObject<SysUser>> testLogin(@Field("userPhone") String userPhone, @Field("userPwd") String userPwd);

}
