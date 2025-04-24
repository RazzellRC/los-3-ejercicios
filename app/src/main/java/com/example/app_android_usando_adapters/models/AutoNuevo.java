package com.example.app_android_usando_adapters.models;

public class AutoNuevo extends Vehiculo {
    private int garantiaAnios;
    private double descuentoPromocional;


    public AutoNuevo(String marca, String modelo, int añoFabricacion, double precioBase, double kilometraje,
                     int garantiaAnios, double descuentoPromocional) {
        super(marca, modelo, añoFabricacion, precioBase, kilometraje);
        this.garantiaAnios = garantiaAnios;
        this.descuentoPromocional = descuentoPromocional;
    }

    public int getGarantiaAnios() { return garantiaAnios; }
    public double getDescuentoPromocional() { return descuentoPromocional; }

    @Override
    public String obtenerTipo() {
        return "Auto Nuevo";
    }
}