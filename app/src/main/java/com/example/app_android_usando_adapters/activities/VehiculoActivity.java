package com.example.app_android_usando_adapters.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_android_usando_adapters.R;
import com.example.app_android_usando_adapters.adapters.VehiculoAdapter;
import com.example.app_android_usando_adapters.models.AutoNuevo;
import com.example.app_android_usando_adapters.models.Moto;
import com.example.app_android_usando_adapters.models.MotoModificada;
import com.example.app_android_usando_adapters.models.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VehiculoActivity extends AppCompatActivity {

    private RecyclerView recyclerVehiculos;
    private VehiculoAdapter adapter;
    public static List<Vehiculo> listaVehiculos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);


        recyclerVehiculos = findViewById(R.id.recyclerVehiculos);
        recyclerVehiculos.setLayoutManager(new LinearLayoutManager(this));

        listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new AutoNuevo("Toyota", "Corolla", 2023, 25000, 0, 5, 10));
        listaVehiculos.add(new Moto("Yamaha", "FZ", 2020, 15000, 10000, 150, "urbano"));
        listaVehiculos.add(new Moto("KTM", "Adventure", 2022, 18000, 5000, 300, "off-road"));
        listaVehiculos.add(new MotoModificada("Suzuki", "GSX", 2019, 14000, 8000, 250, "mixto", "escape", 8000 , ""));
        listaVehiculos.add(new AutoNuevo("Hyundai", "i20", 2024, 22000, 0, 3, 8));

        adapter = new VehiculoAdapter(listaVehiculos, this);
        adapter.notifyDataSetChanged();
        recyclerVehiculos.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}