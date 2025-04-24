package com.example.app_android_usando_adapters.models;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int añoFabricacion;
    protected double precioBase;
    protected double kilometraje;


    public Vehiculo(String marca, String modelo, int añoFabricacion, double precioBase, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
        this.precioBase = precioBase;
        this.kilometraje = kilometraje;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAñoFabricacion() { return añoFabricacion; }
    public double getPrecioBase() { return precioBase; }
    public double getKilometraje() { return kilometraje; }

    public String obtenerTipo() {
        return "Vehículo";
    }

    @Override
    public String toString() {
        return obtenerTipo() + ": " + marca + " " + modelo + " (" + añoFabricacion + ")";
    }

}
