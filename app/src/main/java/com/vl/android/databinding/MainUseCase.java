package com.vl.android.databinding;

import android.os.AsyncTask;

public class MainUseCase {

    public void execute() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                onStart();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(10000l);
                } catch (InterruptedException ignore) {
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                onCompleted("Hello MVP and Data Binding on Android");
            }
        }.execute();
    }

    protected void onStart() {
    }

    protected void onCompleted(String result) {
    }
}
