package com.mulia754.dataperssatria;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MyModel> arrayList = new ArrayList<>();
    public EditText mTvSearchview;
    public RecyclerView mRecyclerList;
    String urlKet = " ";
    DataAdapter dataAdapter;
    public Spinner mSpinner;
    //filter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getSupportActionBar().hide();
        addData();

//dibawah ini berfungsi untuk pencarian
        mTvSearchview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });
    }


    private void filter(String text) {
        ArrayList<MyModel> filteredList = new ArrayList<>();

        for (MyModel myModel : arrayList) {
            if (myModel.getNama_pers().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(myModel);
            }
        }

        dataAdapter.filterList(filteredList);
        //sampai disini berfungsi untuk pencarian

    }
//menambahkan data pada Recyclerview
    private void addData() {
        MyModel myModel1 = new MyModel("Mulia Adi Dharma");
        MyModel myModel2 = new MyModel("Rangga Rajasa");
        MyModel myModel3 = new MyModel("Araya Rajasa");
        MyModel myModel4 = new MyModel("Jaya Wardhana");
        MyModel myModel5 = new MyModel("Karna Kartanagara");
        MyModel myModel6 = new MyModel("Dipa Kartarajasa");

        arrayList.add(myModel1);
        arrayList.add(myModel2);
        arrayList.add(myModel3);
        arrayList.add(myModel4);
        arrayList.add(myModel5);
        arrayList.add(myModel6);

        Log.d("arraylist", String.valueOf(arrayList.size()));

        dataAdapter = new DataAdapter(this, arrayList);

        ArrayAdapter<MyModel> arrayAdapter=new ArrayAdapter<MyModel>(this,
                android.R.layout.simple_spinner_dropdown_item,arrayList);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(arrayAdapter);

        mRecyclerList.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerList.setHasFixedSize(true);
        mRecyclerList.setAdapter(dataAdapter);


//menambahkan data pada Recyclerview
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                MyModel myModel= (MyModel) parent.getSelectedItem();

                Toast.makeText(MainActivity.this, ""+position+" "+myModel.getNama_pers(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



            /*perintah klik recyclerview*/
        mRecyclerList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }
                });

                @Override
                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && gestureDetector.onTouchEvent(e)){
                        int position = rv.getChildAdapterPosition(child);
                        Intent i;
                        i = new Intent(getApplicationContext(), keterangan.class);
                        urlKet = arrayList.get(position).getNama_pers().toString();
                        i.putExtra("Value",urlKet);
                        startActivity(i);

                    }
                    return false;
                }

                @Override
                public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                }
            })
            ;
        }


    private void initView() {
        mTvSearchview = findViewById(R.id.tv_searchview);
        mRecyclerList = (RecyclerView) findViewById(R.id.recyclerList);
        mSpinner = (Spinner) findViewById(R.id.spinner);
    }


}
