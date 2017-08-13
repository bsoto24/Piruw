package com.codelab.piruw.presenter.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.codelab.piruw.R;
import com.codelab.piruw.data.entity.PreguntaTO;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ResultadoActivity extends AppCompatActivity {

    private ArrayList<PreguntaTO> preguntas;

    private Button btnNext;
    private PieChartView pieChart;
    private PieChartData data;
    private boolean hasLabels = false;
    private boolean hasLabelsOutside = true;
    private boolean hasLabelForSelected = true;
    private int correctas = 0, incorrectas = 0, no_respondidas = 0;

    private TextView tvCorrecta, tvIncorrecta, tvNoRespondida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvCorrecta = (TextView) findViewById(R.id.tv_correcta);
        tvIncorrecta= (TextView) findViewById(R.id.tv_incorrecta);
        tvNoRespondida = (TextView) findViewById(R.id.tv_no_respondida);

        btnNext = (Button) findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        preguntas = (ArrayList<PreguntaTO>) getIntent().getSerializableExtra("preguntas");

        pieChart = (PieChartView) findViewById(R.id.chart);

        calcularPuntajes(preguntas);

        pieChart.setOnValueTouchListener(new ResultadoActivity.ValueTouchListener());
        toggleLabels();
        generateData();
    }

    private void calcularPuntajes(ArrayList<PreguntaTO> preguntas) {
        for (PreguntaTO p : preguntas) {
            if (p.getRespuesta().equals("")) {
                no_respondidas++;
                p.setPutaje(0);
            } else if (p.getRespuesta().equals(p.getCorrecta())) {
                correctas++;
                p.setPutaje(1);
            } else {
                incorrectas++;
                p.setPutaje(-1);
            }
        }

        tvCorrecta.setText(correctas+"");
        tvIncorrecta.setText(incorrectas+"");
        tvNoRespondida.setText(no_respondidas+"");

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private class ValueTouchListener implements PieChartOnValueSelectListener {

        @Override
        public void onValueSelected(int arcIndex, SliceValue value) {

        }

        @Override
        public void onValueDeselected() {

        }
    }

    private void toggleLabels() {
        hasLabels = !hasLabels;
        if (hasLabels) {
            hasLabelForSelected = false;
            pieChart.setValueSelectionEnabled(hasLabelForSelected);
            if (hasLabelsOutside) {
                pieChart.setCircleFillRatio(0.7f);
            } else {
                pieChart.setCircleFillRatio(1.0f);
            }
        }
        generateData();
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<>();
        if (correctas > 0) {
            SliceValue sliceValueBuenas = new SliceValue((float) correctas, getResources().getColor(R.color.correct));
            values.add(sliceValueBuenas);
        }
        if (incorrectas > 0) {
            SliceValue sliceValueMalas = new SliceValue((float) incorrectas, getResources().getColor(R.color.incorrect));
            values.add(sliceValueMalas);
        }
        if (no_respondidas > 0) {
            SliceValue sliceValueNoRespondidas = new SliceValue((float) no_respondidas, getResources().getColor(R.color.normal));
            values.add(sliceValueNoRespondidas);
        }
        data = new PieChartData(values);
        data.setHasLabels(hasLabels); // Muesta el valor de la particion
        pieChart.setPieChartData(data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(ResultadoActivity.this, SolucionarioActivity.class);
            intent.putExtra("preguntas", preguntas);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

}