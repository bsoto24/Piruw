package com.codelab.piruw.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codelab.piruw.R;
import com.codelab.piruw.data.entity.PreguntaTO;

import java.util.ArrayList;

/**
 * Created by Bryam Soto on 08/08/2017.
 */

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.ResultadoHolder> {

    private ArrayList<PreguntaTO> preguntas;
    private Context context;

    public ResultadoAdapter(ArrayList<PreguntaTO> preguntas, Context context) {
        this.preguntas = preguntas;
        this.context = context;
    }

    @Override
    public ResultadoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ResultadoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_resultado, parent, false));    }

    @Override
    public void onBindViewHolder(ResultadoHolder holder, int position) {

        PreguntaTO preguntaTO = preguntas.get(position);

        holder.respuesta.setText(preguntaTO.getRespuesta());
        holder.correcta.setText(preguntaTO.getCorrecta());

    }

    @Override
    public int getItemCount() {
        return preguntas.size();
    }

    public class ResultadoHolder extends RecyclerView.ViewHolder{

        TextView respuesta, correcta;

        public ResultadoHolder(View itemView) {
            super(itemView);

            respuesta = (TextView) itemView.findViewById(R.id.tv_respuesta);
            correcta = (TextView) itemView.findViewById(R.id.tv_correcta);
        }
    }
}
