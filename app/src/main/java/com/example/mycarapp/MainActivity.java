package com.example.mycarapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity  implements MakerFragment.OnMakerInteractionListener, ColorFragment.OnSpinnerInteractionListener, DescriptionFragment.OnDescriptionInteractionListener {

    FragmentManager FM;
    FragmentTransaction FT;
    private ApplicationPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setFragment(new MakerFragment());
        appPreferences.init(getApplicationContext());

    }

    private void setFragment(Fragment miFragment)
    {


        FM  = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.setCustomAnimations(R.anim.animation_2, R.anim
                .transition_1);

        FT.replace(R.id.mainContainer, miFragment);
        FT.commit();
    }




    @Override
    public void next(String value) {

        Log.e("MAIN ACTIIVITY", "NEXT" + value);

        appPreferences.saveCar(new CarModel("", value, ""));
        setFragment(new ColorFragment());


    }

    @Override
    public void setSelectedColor(String value) {

        CarModel car = appPreferences.readCar(null);
        car.setColor(value);
        appPreferences.saveCar(car);
        setFragment(new DescriptionFragment());


    }

    @Override
    public void setDescription(String value) {

        CarModel car = appPreferences.readCar(null);
        car.setDescription(value);
        appPreferences.saveCar(car);
        setFragment(new FinalFragment());

    }
}
