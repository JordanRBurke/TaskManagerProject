package com.jordanburke.taskmanagerproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class RemoveTaskFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remove_task_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static RemoveTaskFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RemoveTaskFragment fragment = new RemoveTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
