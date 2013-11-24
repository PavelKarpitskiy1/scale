package com.example.scale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import com.example.test_project.R;

/**
 * Created with IntelliJ IDEA.
 * User: Павел
 * Date: 13.11.13
 * Time: 17:12
 */

public class Auto_Activity extends Activity implements OnItemSelectedListener {
    String[] data;
    ImageView image;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);
        image = (ImageView) findViewById(R.id.picture);
        final ImageView.ScaleType[] scaleTypes = ImageView.ScaleType.values();

        data = new String[scaleTypes.length];

        for (int i = 0; i < scaleTypes.length; i++) {
            data[i] = scaleTypes[i].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        spinner.setPrompt("Title");


        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {

        Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
        image.setScaleType(ImageView.ScaleType.valueOf(data[position]));

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
