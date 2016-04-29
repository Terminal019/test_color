package com.example.test_color;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumDialog;

public class MainActivity extends AppCompatActivity implements ViewMVP {


    private PresenterMVP presenterMVP;
    private Button mSelectColor;
    private Spinner mSelectTeachers;
    private EditText mNameLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSelectColor = (Button) findViewById(R.id.mSelectColor);
        mSelectTeachers = (Spinner) findViewById(R.id.mSelectTeachers);
        mNameLesson = (EditText) findViewById(R.id.mNameLesson);
        presenterMVP = new PresenterMVP(MainActivity.this);


        mSelectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SpectrumDialog.Builder(MainActivity.this)
                        .setColors(R.array.demo_colors)
                        .setSelectedColorRes(R.color.md_blue_500)
                        .setDismissOnColorSelected(false)
                        .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                            @Override public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                                    mSelectColor.setBackgroundColor(color);
                            }
                        }).build().show(getSupportFragmentManager(), "dialog_demo_1");
            }
        });

        presenterMVP.loadTeachers();
        mSelectTeachers.setPrompt("Title");
        mSelectTeachers.setSelection(2);
        mSelectTeachers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                //  Toast.makeText(MainActivity.this, "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }

    @Override
    public void showTeachers(String[] teachers) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, teachers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSelectTeachers.setAdapter(adapter);
    }

    @Override
    public void onSubjectSaved() {
        Toast.makeText(MainActivity.this, "Название урока " + mNameLesson.getText().toString() + " Имя учителя " + mSelectTeachers.getSelectedItem().toString() + " и цвет " +  mSelectColor.getBackground().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.saveLesson) {
            presenterMVP.saveSubject(mNameLesson.getText().toString(), mSelectTeachers.getSelectedItemPosition(), mSelectColor.getSolidColor());
        }

        return super.onOptionsItemSelected(item);
    }

}
