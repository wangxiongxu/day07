package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.adap.AdAp;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.bean.HotBean;
import com.example.myapplication.contract.Contract;
import com.example.myapplication.presenter.Presenter;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View {

    private RecyclerView mHotrec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
//connect timed out
    @Override
    public void getIfView(HotBean hotBean) {
        List<HotBean.RecentBean> recent = hotBean.getRecent();
        AdAp adAp = new AdAp(recent);
        mHotrec.setAdapter(adAp);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        presenter.setSoution(this);

    }

    @Override
    public Context getContextObject() {
        return MainActivity.this;
    }

    private void initView() {
        mHotrec = (RecyclerView) findViewById(R.id.hotrec);
        mHotrec.setLayoutManager(new LinearLayoutManager(this));
        setPresenter(new Presenter());
    }
}
