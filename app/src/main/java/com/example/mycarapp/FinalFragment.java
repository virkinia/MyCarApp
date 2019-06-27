package com.example.mycarapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FinalFragment extends Fragment {

    private ApplicationPreferences appPreferences;

    public FinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_final, container, false);

        CarModel car = appPreferences.readCar(null);



        TextView text = v.findViewById(R.id.finalText);

        String value = "Tienes un " + car.getMaker();
        value += " de color " + car.getColor();
        value += " con las siguientes características " + car.getDescription();

        text.setText(value);




        return v;
    }

}
