package com.example.app_android_usando_adapters.models;

public class MenuItem {
    private String titulo;
    private int iconoResId;

    public MenuItem(String titulo, int iconoResId) {
        this.titulo = titulo;
        this.iconoResId = iconoResId;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIconoResId() {
        return iconoResId;
    }
}
