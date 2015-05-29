package com.vl.android.databinding;

public class MainPresenter {

    MainView mView;
    MainUseCase mUseCase;

    public void attachView(MainView view) {
        mView = view;
        mUseCase = new MainUseCase() {
            @Override
            protected void onStart() {
                if (mView != null) mView.setLoading(true);
            }

            @Override
            protected void onCompleted(String result) {
                if (mView != null) {
                    mView.setLoading(false);
                    mView.setText(result);
                }
            }
        };
    }

    public void detachView() {
        mView = null; // release reference of view
    }

    public void onDoClicked() {
        mUseCase.execute(); // doing long work
    }
}
