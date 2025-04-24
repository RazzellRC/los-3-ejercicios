package com.example.app_android_usando_adapters.models;

public class Moto extends Vehiculo {
    private int cilindradaCc;
    private String tipoManejo; // urbano, off-road, mixto

    public Moto(String marca, String modelo, int añoFabricacion, double precioBase, double kilometraje,
                int cilindradaCc, String tipoManejo) {
        super(marca, modelo, añoFabricacion, precioBase, kilometraje);
        this.cilindradaCc = cilindradaCc;
        this.tipoManejo = tipoManejo;
    }

    public int getCilindradaCc() { return cilindradaCc; }
    public String getTipoManejo() { return tipoManejo; }

    @Override
    public String obtenerTipo() {
        return "Moto";
    }
}
