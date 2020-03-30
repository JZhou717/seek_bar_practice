package com.jakezhou.timestable;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myNumberList = findViewById(R.id.myNumberList);
        final ArrayList<Integer> numberList = new ArrayList<Integer>();
        //For some reason, the adapter or something is cutting off the last number for large nums. So only nums up to 20 show up, despite 21 being i the list if i <= 21. This isn't true if you put a small number like 10 in though
        for(int i = 1; i <= 10; i++) {
            Log.i("num", "" + i);
            numberList.add(i);
        }
        final ArrayAdapter<Integer> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberList);
        myNumberList.setAdapter(myArrayAdapter);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                final int MIN = 1;
                int multiple;

                if(progress < MIN) {
                    seekBar.setProgress(MIN);
                    multiple = MIN;
                }
                else {
                    multiple = progress;
                }

                for(int i = 1; i <= 10; i++) {
                    numberList.set((i-1), (i*multiple));
                    myArrayAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
