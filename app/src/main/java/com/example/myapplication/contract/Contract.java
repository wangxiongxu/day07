package com.example.myapplication.contract;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.BaseView;
import com.example.myapplication.bean.HotBean;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public interface Contract {
    interface Model {
        void getModel(RxAppCompatActivity activity, BaseCallBack<HotBean> hotBeanBaseCallBack);
    }

    interface View extends BaseView<Presenter> {
        void getIfView(HotBean hotBean);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
