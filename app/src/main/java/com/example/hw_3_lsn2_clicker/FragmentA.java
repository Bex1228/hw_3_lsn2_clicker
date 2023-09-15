package com.example.hw_3_lsn2_clicker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentA extends Fragment {

 private TextView tv ;
 int counter = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_a, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setupButtons(view);
        updateCounter();
    }

    private void initView(View view) {
        tv = view.findViewById(R.id.tv_result);
    }

    private void setupButtons(View view) {
        Button btnPlus = view.findViewById(R.id.btn_plus);
        Button btnMinus = view.findViewById(R.id.btn_minus);
        Button btnNextFragment = view.findViewById(R.id.btn_next_fragment);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIncreaseClick();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDecreaseClick();
            }
        });

         btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int FragmentTransaction = requireActivity().getSupportFragmentManager().
                        beginTransaction().replace(R.id.containerA, new FragmentB())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public void onIncreaseClick() {
        counter++;
        updateCounter();
    }

    public void onDecreaseClick() {
        counter--;
        updateCounter();
    }

    public void updateCounter() {
        tv.setText(String.valueOf(counter));
    }
}
