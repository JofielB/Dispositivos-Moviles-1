package com.example.kipo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GardenFragment extends Fragment {
    Button addPlant;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View theInflatedView = inflater.inflate(R.layout.fragment_garden,container,false);
        addPlant = theInflatedView.findViewById(R.id.btnAddPlant);
        addPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenAdd = new Intent(getActivity(),AddPlant.class);
                startActivity(intenAdd);
            }
        });
        return  theInflatedView;
    }
}

