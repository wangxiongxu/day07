package com.example.myapplication.model;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.HotBean;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.net.Api;
import com.example.myapplication.net.Dataserver;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Model extends BaseModel implements Contract.Model {
    @Override
    public void getModel(RxAppCompatActivity activity, BaseCallBack<HotBean> hotBeanBaseCallBack) {
        getRXOk(hotBeanBaseCallBack, activity, Dataserver.getRX(Api.uri).list(), new Function<HotBean, ObservableSource<HotBean>>() {
            @Override
            public ObservableSource<HotBean> apply(HotBean hotBean) throws Exception {
                if (hotBean != null) {
                    return Observable.just(hotBean);
                }
                return Observable.error(new NullPointerException("返回数据为空或者异常 : " + (hotBean == null ? "" : hotBean)));

            }
        });
    }
}
