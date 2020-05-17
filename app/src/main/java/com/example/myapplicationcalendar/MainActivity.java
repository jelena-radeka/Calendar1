package com.example.myapplicationcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date today=new Date();
        Calendar nextYear=Calendar.getInstance();
        nextYear.add(Calendar.YEAR,1);

        CalendarPickerView datePicker=findViewById(R.id.calendar);
        datePicker.init(today,nextYear.getTime()).
                inMode(CalendarPickerView.SelectionMode.RANGE).
                withSelectedDate(today);


        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

              //  String selectedDate= DateFormat.getInstance(DateFormat.FULL).format(date);

                Calendar calenderSelected=Calendar.getInstance();
                calenderSelected.setTime(date);

                String selectedDate=" "+ calenderSelected.get(Calendar.DAY_OF_MONTH)
                + " " + (calenderSelected.get(Calendar.MONTH)+1)
                + " " + calenderSelected.get(Calendar.YEAR);
                Toast.makeText(MainActivity.this, selectedDate,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

    }
}
