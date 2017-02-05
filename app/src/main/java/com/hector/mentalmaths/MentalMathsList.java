package com.hector.mentalmaths;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MentalMathsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_maths_list);
        ListView listView = (ListView) findViewById(R.id.List2);
        final String[] values = new String[] { "+", "-","*", "/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(MentalMathsList.this, MentalMaths.class);
                int itemPosition = position;
                intent.putExtra("Operation", values[position]);
                switch (itemPosition){
                    case 0:
                        intent.putExtra("FirstNumberLength", 5);
                        intent.putExtra("SecondNumberLength", 5);
                    case 1:
                        intent.putExtra("FirstNumberLength", 5);
                        intent.putExtra("SecondNumberLength", 5);
                    case 2:
                        intent.putExtra("FirstNumberLength", 2);
                        intent.putExtra("SecondNumberLength", 2);
                    case 3:
                        intent.putExtra("FirstNumberLength", 5);
                        intent.putExtra("SecondNumberLength", 2);

                }
                startActivity(intent);


            }

        });
    }
}
