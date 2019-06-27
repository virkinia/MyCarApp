package com.example.mycarapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DescriptionFragment.OnDescriptionInteractionListener} interface
 * to handle interaction events.
 */
public class DescriptionFragment extends Fragment {

    EditText descriptionText;

    private OnDescriptionInteractionListener mListener;

    public DescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

                View v = inflater.inflate(R.layout.fragment_description, container, false);

        descriptionText= v.findViewById(R.id.descriptionText);
        Button buttonSig = v.findViewById(R.id.sigDescription);

        buttonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setDescription(descriptionText.getText().toString());
            }
        });
                return v;

    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDescriptionInteractionListener) {
            mListener = (OnDescriptionInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDescriptionInteractionListener");
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
    public interface OnDescriptionInteractionListener {
        // TODO: Update argument type and name
        void setDescription(String value);
    }
}
