package com.example.arvind.epicurean;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by arvind on 2/15/16.
 */
public class LatestRecipe extends Fragment {
    // two instances false: fragment hidden, true: fragment shown
    public boolean isOn = false;
    public LatestRecipe() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popup_recipe,
                container, false);

        // Create a button to click once recipe is needed
    /*    Button button = (Button) view.findViewById(R.id.but);
        TextView recipe = (TextView) view.findViewById(R.id.recipeBox);
        // new fragment pr
       final Fragment pr = new PopUpRecipe();
        // Begin the transaction
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, pr, "POPUP");
        ft.hide(pr);
        ft.commit();
        button.setOnLongClickListener(new Button.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FragmentTransaction f = getChildFragmentManager().beginTransaction();
                // two instances false: fragment hidden, true: fragment shown
                if (!isOn) {
                    f.show(pr);
                    isOn = true;
                } else {
                    f.hide(pr);
                    isOn = false;
                }
                f.commit();
                return true;
            }
        });*/
        return view;
    }
}

