package com.vl.android.databinding;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vl.android.databinding.databinding.FragmentBinding;

public class MainFragment extends Fragment {

    MainViewModel mViewModel;
    MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create presenter, it should be cached to handle configuration changes
        // but for sake of example, it does not
        mPresenter = new MainPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate layout, bind fields and etc
        FragmentBinding binding = DataBindingUtil.inflate(inflater,
                                                          R.layout.fragment,
                                                          container,
                                                          false);
        // bind ViewModel
        binding.setModel(mViewModel = new MainViewModel());
        // bind click listener
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onDoClicked();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(mViewModel);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }
}
