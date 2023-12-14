package com.politecnicomalaga.laQuinelaDeMariano.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.politecnicomalaga.laQuinelaDeMariano.Model.JornadaAdapter;
import com.politecnicomalaga.laQuinelaDeMariano.Controller.MainController;
import com.politecnicomalaga.laQuinelaDeMariano.Model.Partido;
import com.politecnicomalaga.NasdaqOilPrices.R;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Partido> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private JornadaAdapter mAdapter;

    private static MainActivity myActiveActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.rv_prices);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new JornadaAdapter(this, mList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainController.getSingleton().requestDataFromQuiniela();

        MainActivity.myActiveActivity = this;
        MainController.setActivity(this);
    }

    public void accessData() {
        //Get data from servers throgh controller-model classes
        List<Partido> nuevaLista = MainController.getSingleton().getDataFromQuiniela();

        //Put data in adapter
        mList.clear();
        for (Partido item:nuevaLista) {
            mList.add(item);
        }
        mAdapter.notifyDataSetChanged();
        TextView tv = (TextView) findViewById(R.id.tv_oilDesc);
        tv.setText("OBTENIDOS 15 ÚLTIMOS RESULTADOS DE LOS PARTIDOS");
    }

    public void errorData(String error) {
        TextView tv = (TextView) findViewById(R.id.tv_oilDesc);
        tv.setText(error);

    }


}
