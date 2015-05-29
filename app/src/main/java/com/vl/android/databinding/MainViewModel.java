package com.vl.android.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainViewModel extends BaseObservable implements MainView {

    CharSequence text;
    boolean loading;

    // Data Binding
    @Bindable
    public CharSequence getText() {
        return text;
    }

    // Data Binding
    @Bindable
    public boolean isLoading() {
        return loading;
    }

    @Override
    public void setText(CharSequence text) {
        this.text = text;
        // Data Binding - notifying that property has changed
        notifyPropertyChanged(BR.text);
    }

    @Override
    public void setLoading(boolean loading) {
        this.loading = loading;
        // Data Binding - notifying that property has changed
        notifyPropertyChanged(BR.loading);
    }
}
