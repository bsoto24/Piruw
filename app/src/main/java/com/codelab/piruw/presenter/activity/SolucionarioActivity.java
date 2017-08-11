package com.codelab.piruw.presenter.activity;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codelab.piruw.R;
import com.codelab.piruw.data.entity.PreguntaTO;
import com.codelab.piruw.presenter.adapter.ResultadoAdapter;

import java.util.ArrayList;

public class SolucionarioActivity extends AppCompatActivity {


    private RecyclerView rvResultados;
    private ResultadoAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private ArrayList<PreguntaTO> preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solucionario);

        preguntas = (ArrayList<PreguntaTO>) getIntent().getSerializableExtra("preguntas");

        rvResultados = (RecyclerView) findViewById(R.id.rv_solucionario);

        rvResultados.setLayoutManager(new LinearLayoutManager(this));
        rvResultados.setAdapter(new ResultadoAdapter(preguntas, this));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            finish();
        }

    }
}
