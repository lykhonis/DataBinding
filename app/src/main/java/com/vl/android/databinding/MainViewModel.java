package com.vl.android.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainViewModel extends BaseObservable implements MainView {

    CharSequence text;
    boolean loading;

    @Bindable
    public CharSequence getText() {
        return text;
    }

    @Bindable
    public boolean isLoading() {
        return loading;
    }

    @Override
    public void setText(CharSequence text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Override
    public void setLoading(boolean loading) {
        this.loading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
