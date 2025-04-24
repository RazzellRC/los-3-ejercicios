package com.example.app_android_usando_adapters.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_android_usando_adapters.MainActivity;
import com.example.app_android_usando_adapters.R;
import com.example.app_android_usando_adapters.models.AutoNuevo;
import com.example.app_android_usando_adapters.models.Moto;
import com.example.app_android_usando_adapters.models.MotoModificada;
import com.example.app_android_usando_adapters.models.Vehiculo;
import java.text.DecimalFormat;


import java.util.List;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvTipo, tvMarcaModelo, tvAñoPrecioKm, tvExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ImageView imgDetalle = findViewById(R.id.imgDetalle);

        tvTipo = findViewById(R.id.tvTipoDetalle);
        tvMarcaModelo = findViewById(R.id.tvMarcaModeloDetalle);
        tvAñoPrecioKm = findViewById(R.id.tvAñoPrecioKmDetalle);
        tvExtra = findViewById(R.id.tvExtraDetalle);

        // Recibimos la posición y accedemos a la lista desde MainActivity
        int posicion = getIntent().getIntExtra("vehiculo", -1);
        List<Vehiculo> lista = VehiculoActivity.listaVehiculos; // Hazla pública si es necesario

        if (posicion >= 0 && posicion < lista.size()) {
            Vehiculo v = lista.get(posicion);
            String tipo = v.obtenerTipo();
            switch (tipo) {
                case "Auto Nuevo":
                    findViewById(R.id.tvTipoDetalle).setBackgroundColor(Color.parseColor("#D0F0C0")); // Verde claro
                    break;
                case "Moto":
                    findViewById(R.id.tvTipoDetalle).setBackgroundColor(Color.parseColor("#CDE8FF")); // Azul claro
                    break;
                case "Moto Modificada":
                    findViewById(R.id.tvTipoDetalle).setBackgroundColor(Color.parseColor("#FFE2C4")); // Naranja claro
                    break;
            }

            tvTipo.setText(v.obtenerTipo());
            tvMarcaModelo.setText("Marca: " + v.getMarca() + " | Modelo: " + v.getModelo());

            // tvAñoPrecioKm.setText("Año: " + v.getAñoFabricacion() + " | Precio: Bs. " + v.getPrecioBase() + " | Km: " + v.getKilometraje());
            DecimalFormat formato = new DecimalFormat("#,###.00");
            tvAñoPrecioKm.setText("Año: " + v.getAñoFabricacion() + " | Precio: Bs. " + formato.format(v.getPrecioBase()) + " | Km: " + formato.format(v.getKilometraje()));


            // Mostrar datos extra según el tipo
            String extra = "";
            if (v instanceof AutoNuevo) {
                AutoNuevo a = (AutoNuevo) v;
                extra = "Garantía: " + a.getGarantiaAnios() + " años\nDescuento: " + a.getDescuentoPromocional() + "%";
                imgDetalle.setImageResource(0); // no mostrar imagen
            } else if (v instanceof MotoModificada) {
                MotoModificada m = (MotoModificada) v;
                extra = "Cilindrada: " + m.getCilindradaCc() + " cc\nManejo: " + m.getTipoManejo() + "\nModificación: " + m.getTipoModificacion()  + "\n"
                        + "Valor: Bs. " + m.getValor();
                imgDetalle.setImageResource(R.drawable.moto); // mostrar moto.webp
            } else if (v instanceof Moto) {
                Moto m = (Moto) v;
                extra = "Cilindrada: " + m.getCilindradaCc() + " cc\nManejo: " + m.getTipoManejo();
                imgDetalle.setImageResource(0); // no mostrar imagen
            }


            tvExtra.setText(extra);
        }
    }

}