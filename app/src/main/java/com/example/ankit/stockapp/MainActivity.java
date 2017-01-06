package com.example.ankit.stockapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.Series;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private int count;
    private Firebase ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        final TextView txt=(TextView)findViewById(R.id.txt);
        ref = new Firebase("https://stocktest.firebaseio.com");
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        graph.addSeries(series);
        count=0;

//        while (count<390)
//        {
//            ref.child("0").child("data").child("1").child(count+"").addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    AllStock astock=dataSnapshot.getValue(AllStock.class);
//                    series.appendData(new DataPoint(count,astock.getC()),false, count);
//                    count++;
//                }
//
//                @Override
//                public void onCancelled(FirebaseError firebaseError) {
//
//                }
//            });
//        }
//
        ref.child("0").child("data").child("1").child(count+"").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AllStock as=dataSnapshot.getValue(AllStock.class);
                if(dataSnapshot.getValue()!=null) {
                    String temp=as.getC()+"";
                    txt.setText(count+"");
                    series.appendData(new DataPoint(count, as.getC()), false, count + 1);
                    count++;
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6),
//                new DataPoint(5, 2),
//                new DataPoint(6, 12),
//                new DataPoint(7, 10),
//                new DataPoint(8, 1),
//                new DataPoint(9, 7)
//
//        });
//        graph.addSeries(series);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
