package com.example.myapplication.base;

public interface BasePresenter<V extends BaseView> {
    void setSoution(V v);
}
