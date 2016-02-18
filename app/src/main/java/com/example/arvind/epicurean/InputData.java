package com.example.arvind.epicurean;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by arvind on 2/15/16.
 */
public class InputData extends Fragment{
    public InputData() {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_input_data, container,false);
        return in;
    }
}
