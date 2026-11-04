package com.ces2.trabajo3.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Columna F: Clase contenedora OleadaDeAtaques
 * Contiene atributos propios, dos atributos de tipo enum (EnumAtaque y Categoria),
 * y un Deque en plural llamado ataques para guardar objetos de la clase Ataque.
 */
public class OleadaDeAtaques {

    private String nombreOleada;
    private String zonaCombate;
    private EnumAtaque enumAtaque;
    private Categoria categoria;
    private Deque<Ataque> ataques;

    // Constructor vacío
    public OleadaDeAtaques() {
        this.ataques = new ArrayDeque<>();
    }

    // Constructor con los atributos necesarios y los dos atributos de tipo enum
    public OleadaDeAtaques(String nombreOleada, String zonaCombate, EnumAtaque enumAtaque, Categoria categoria) {
        this.nombreOleada = nombreOleada;
        this.zonaCombate = zonaCombate;
        this.enumAtaque = enumAtaque;
        this.categoria = categoria;
        this.ataques = new ArrayDeque<>();
    }

    // Método para agregar objetos de la clase Ataque al Deque ataques
    public void agregarAtaque(Ataque ataque) {
        this.ataques.add(ataque);
    }

    // Métodos SET para cada atributo
    public void setNombreOleada(String nombreOleada) {
        this.nombreOleada = nombreOleada;
    }

    public void setZonaCombate(String zonaCombate) {
        this.zonaCombate = zonaCombate;
    }

    public void setEnumAtaque(EnumAtaque enumAtaque) {
        this.enumAtaque = enumAtaque;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setAtaques(Deque<Ataque> ataques) {
        this.ataques = ataques;
    }

    // Métodos GET para cada atributo
    public String getNombreOleada() {
        return nombreOleada;
    }

    public String getZonaCombate() {
        return zonaCombate;
    }

    public EnumAtaque getEnumAtaque() {
        return enumAtaque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Deque<Ataque> getAtaques() {
        return ataques;
    }

    @Override
    public String toString() {
        return "OleadaDeAtaques{" +
                "nombreOleada='" + nombreOleada + '\'' +
                ", zonaCombate='" + zonaCombate + '\'' +
                ", enumAtaque=" + enumAtaque +
                ", categoria=" + categoria +
                ", ataques=" + ataques +
                '}';
    }
}
