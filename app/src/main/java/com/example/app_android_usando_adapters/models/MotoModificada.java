package com.example.app_android_usando_adapters.models;

public class MotoModificada extends Moto {
    private String tipoModificacion; // escape, motor, estética
    private int valor;
    private String img;

    public MotoModificada(String marca, String modelo, int añoFabricacion, double precioBase, double kilometraje, int cilindradaCc, String tipoManejo, String tipoModificacion, int valor, String img) {
        super(marca, modelo, añoFabricacion, precioBase, kilometraje, cilindradaCc, tipoManejo);
        this.tipoModificacion = tipoModificacion;
        this.valor = valor;
        this.img = img;
    }

    public String getTipoModificacion() {
        return tipoModificacion;
    }

    public int getValor() {
        return valor;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String obtenerTipo() {
        return "Moto Modificada";
    }
}
