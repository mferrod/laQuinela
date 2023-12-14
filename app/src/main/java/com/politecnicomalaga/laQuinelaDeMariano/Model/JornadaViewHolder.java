package com.politecnicomalaga.laQuinelaDeMariano.Model;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.NasdaqOilPrices.R;

public class JornadaViewHolder extends RecyclerView.ViewHolder {

    //ESTADO
    final JornadaAdapter mAdapter;
    private TextView tvEquipo1;
    private TextView tvEquipo2;
    private TextView tvRes;


    //COMPORTAMIENTO
    public JornadaViewHolder(View itemView, JornadaAdapter adapter) {
        super(itemView);

        tvEquipo1 = itemView.findViewById(R.id.equipo1);
        tvEquipo2 = itemView.findViewById(R.id.equipo2);
        tvRes = itemView.findViewById(R.id.resultado);
        this.mAdapter = adapter;
    }

    public void setEquipo1(String data) {
        tvEquipo1.setText(data);
    }

    public void setEquipo2(String data) {
        tvEquipo2.setText(data);
    }
    public void setResultado(String data) {tvRes.setText(data);}
}
