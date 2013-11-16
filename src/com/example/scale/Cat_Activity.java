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
 * To change this template use File | Settings | File Templates.
 */
public class Cat_Activity extends Activity implements View.OnClickListener
{   String[] data;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cat);final Button buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(this);
        final ImageView image = (ImageView) findViewById(R.id.cat);
        final ImageView.ScaleType[] scaleTypes = ImageView.ScaleType.values();
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        data = new String[scaleTypes.length];

        for (int i =0; i < scaleTypes.length; i++)
        {
            data[i] = scaleTypes[i].toString();

            RadioButton button = new RadioButton(this);
            button.setText(data[i]);
            radioGroup.addView(button);
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                final int position = radioGroup.indexOfChild(radioGroup.findViewById(checkedId));
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();

                image.setScaleType(ImageView.ScaleType.valueOf(data[position]));

            }
        });

    }




    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_back:

                finish();
                break;

        }
    }
}
