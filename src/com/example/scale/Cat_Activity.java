package com.example.scale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.test_project.R;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 09.11.13
 * Time: 17:20
 */
public class Cat_Activity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    String[] data;
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cat);
        final Button buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(this);
        image = (ImageView) findViewById(R.id.cat);
        final ImageView.ScaleType[] scaleTypes = ImageView.ScaleType.values();
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        data = new String[scaleTypes.length];

        for (int i = 0; i < scaleTypes.length; i++) {
            data[i] = scaleTypes[i].toString();

            final RadioButton button = new RadioButton(this);
            button.setText(data[i]);
            radioGroup.addView(button);
        }

        radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        final int position = group.indexOfChild(group.findViewById(checkedId));
        Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

        image.setScaleType(ImageView.ScaleType.valueOf(data[position]));
    }
}