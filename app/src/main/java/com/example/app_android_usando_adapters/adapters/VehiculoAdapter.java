package com.example.app_android_usando_adapters.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.app_android_usando_adapters.R;

import com.example.app_android_usando_adapters.activities.DetalleActivity;
import com.example.app_android_usando_adapters.models.MotoModificada;
import com.example.app_android_usando_adapters.models.Vehiculo;

import java.util.List;
public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.ViewHolder> {
    private List<Vehiculo> lista;
    private Context context;

    public VehiculoAdapter(List<Vehiculo> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_vehiculo, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehiculo vehiculo = lista.get(position);

        //holder.tvTipo.setText(vehiculo.obtenerTipo());
        String tipo = vehiculo.obtenerTipo();
        String icono = "";

        switch (tipo) {
            case "Auto Nuevo":
                icono = "🚗";
                break;
            case "Moto":
                icono = "🏍️";
                break;
            case "Moto Modificada":
                icono = "🔧🏍️";
                break;
            default:
                icono = "🚘";
        }

        holder.tvTipo.setText(icono + " " + tipo);

        if (vehiculo instanceof MotoModificada) {
            holder.imageView.setImageResource(R.drawable.moto);
        } else {
            holder.imageView.setImageResource(0); // O puedes ocultarla con setVisibility(View.GONE)
        }

        holder.tvMarcaModelo.setText(vehiculo.getMarca() + " - " + vehiculo.getModelo());
        holder.tvPrecioKm.setText("Bs. " + vehiculo.getPrecioBase() + " | " + vehiculo.getKilometraje() + " km");

        // Cambiar color según tipo
        switch (vehiculo.obtenerTipo()) {
            case "Auto Nuevo":
                holder.container.setBackgroundColor(Color.parseColor("#7ED957")); // verde claro
                break;
            case "Moto":
                holder.container.setBackgroundColor(Color.parseColor("#9B59B6")); // azul claro
                break;
            case "Moto Modificada":
                holder.container.setBackgroundColor(Color.parseColor("#4A90E2")); // naranja claro
                break;
            default:
                holder.container.setBackgroundColor(Color.LTGRAY); // gris por defecto
        }

        // Ir a pantalla de detalle
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetalleActivity.class);
            intent.putExtra("vehiculo", position); // Luego usaremos la posición
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipo, tvMarcaModelo, tvPrecioKm;
        LinearLayout container;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvMarcaModelo = itemView.findViewById(R.id.tvMarcaModelo);
            tvPrecioKm = itemView.findViewById(R.id.tvPrecioKm);
            container = itemView.findViewById(R.id.item_container);
            imageView = itemView.findViewById(R.id.imgVehiculo);
        }

    }
}
