package com.example.timepickerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView mTimeTextView;

    Button mPickTimeButton;

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeTextView = (TextView) findViewById(R.id.TimeTextView);

        Calendar calendar = Calendar.getInstance();

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        mPickTimeButton = (Button) findViewById(R.id.PickTimeButton);
        mPickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTimeTextView.setText(hourOfDay + ":" + minute);
                    }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }
        });
    }
}
