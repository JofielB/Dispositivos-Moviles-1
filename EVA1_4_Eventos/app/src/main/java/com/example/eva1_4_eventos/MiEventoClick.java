package com.example.eva1_4_eventos;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MiEventoClick implements View.OnClickListener {
    Context contexto;

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(contexto,"Brindemos por clase externa",Toast.LENGTH_SHORT).show();
    }
}
