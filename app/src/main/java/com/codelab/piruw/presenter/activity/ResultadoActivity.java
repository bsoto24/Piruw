package com.codelab.piruw.presenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codelab.piruw.R;
import com.codelab.piruw.data.entity.PreguntaTO;
import com.codelab.piruw.presenter.adapter.ResultadoAdapter;

import java.util.ArrayList;

public class ResultadoActivity extends AppCompatActivity {

    private RecyclerView rvResultados;
    private ResultadoAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private ArrayList<PreguntaTO> preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        preguntas = (ArrayList<PreguntaTO>) getIntent().getSerializableExtra("preguntas");

        rvResultados = (RecyclerView) findViewById(R.id.rv_respuestas);

        rvResultados.setLayoutManager(new LinearLayoutManager(this));
        rvResultados.setAdapter(new ResultadoAdapter(preguntas, this));
    }
}
