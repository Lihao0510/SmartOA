package com.oridway.oridwayoa.api;

import com.oridway.oridwayoa.entity.EnterpriseNotice;
import com.oridway.oridwayoa.entity.ResponseObject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lihao on 2017/8/7.
 */

public interface NewsService {

    @GET("/notice/list")
    Observable<ResponseObject<List<EnterpriseNotice>>> getAllNotice();

}
