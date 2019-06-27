package com.example.mycarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MakerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MakerFragment extends Fragment {

    private OnMakerInteractionListener mListener;
    private TextView editTextMaker;

    public MakerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_name, container, false);

        Button nextButton = v.findViewById(R.id.sigMaker);
        editTextMaker = v.findViewById(R.id.editTextMaker);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MAKER", "PULSADO");
              onButtonPressed();
            }
        });
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mListener.next(editTextMaker.getText().toString());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMakerInteractionListener) {
            mListener = (OnMakerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMakerInteractionListener");
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
    public interface OnMakerInteractionListener {
        // TODO: Update argument type and name
        void next(String value);
    }
}
