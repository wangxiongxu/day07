package com.example.myapplication.presenter;

import com.example.myapplication.base.BaseCallBack;
import com.example.myapplication.bean.HotBean;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.model.Model;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public class Presenter implements Contract.Presenter {
    @Override
    public void setSoution(final Contract.View view) {
        Model model = new Model();
        model.getModel((RxAppCompatActivity) view.getContextObject(), new BaseCallBack<HotBean>() {
            @Override
            public void getCallback(HotBean hotBean) {
                view.getIfView(hotBean);
            }
        });
    }
}
