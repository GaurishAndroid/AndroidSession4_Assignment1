package com.example.abhisheki.androidsession4_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    String[] MonthsArray = {"Jan","Feb","March","April",
                            "May","June","July","August",
                            "Sep","Oct","Nov","Dec"};
    List<String> MonthList;

    Button btnAscTemp;
    Button btnDscTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAscTemp = (Button) findViewById(R.id.btnAsc);
        btnAscTemp.setOnClickListener(MainActivity.this);
        btnDscTemp = (Button) findViewById(R.id.btnDsc);
        btnDscTemp.setOnClickListener(MainActivity.this);
        MonthList = new ArrayList<String>(Arrays.asList(MonthsArray));
        MakeList(true);
    }

    @Override
    public void onClick(View v) {
        MakeList(v.getId() == R.id.btnAsc);
    }
    public void MakeList(boolean IsAsc)
    {
        if(IsAsc)
            Collections.sort(MonthList);
        else
            Collections.reverse(MonthList);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,MonthList);
        ListView listView = (ListView) findViewById(R.id.MyList);
        listView.setAdapter(adapter);
    }
}
