package com.oridway.oridwayoa.model;

import com.oridway.oridcore.network.RetrofitManager;
import com.oridway.oridwayoa.api.NewsService;
import com.oridway.oridwayoa.entity.EnterpriseNotice;
import com.oridway.oridwayoa.entity.ResponseObject;

import java.util.List;

import rx.Observable;

/**
 * Created by lihao on 2017/8/7.
 */

public class MainFragmentModel {

    public Observable<ResponseObject<List<EnterpriseNotice>>> getNoticeList(int pageCount) {
        return RetrofitManager.getInstance().createReq(NewsService.class).getAllNotice();
    }

}
