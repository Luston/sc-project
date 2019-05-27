package com.springcloud.scclient.service.command;


import rx.Observer;

import java.util.ArrayList;
import java.util.List;

public class HyObserver implements Observer<String> {
    private List<String> list=new ArrayList();
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onNext(String o) {
        list.add(o);
    }

    public String sout(){
        return list.toString();
    }
}
