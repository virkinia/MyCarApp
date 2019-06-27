package com.example.mycarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ColorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ColorFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private OnSpinnerInteractionListener mListener;
    private String color;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_color, container, false);

        Spinner spinner = (Spinner) v.findViewById(R.id.color_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.colores_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button sigColor = v.findViewById(R.id.sigColor);
        sigColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setSelectedColor(color);

            }
        });
        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.color = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSpinnerInteractionListener) {
            mListener = (OnSpinnerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSpinnerInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSpinnerInteractionListener {
        // TODO: Update argument type and name
        void setSelectedColor(String value);
    }
}
