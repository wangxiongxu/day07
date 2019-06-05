package com.example.myapplication.net;

import com.example.myapplication.bean.HotBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

//http://news-at.zhihu.com/api/4/news/hot
public interface Api {
    public String uri="http://news-at.zhihu.com/api/4/";
    @GET("news/hot")
    Observable<HotBean> list();
}
