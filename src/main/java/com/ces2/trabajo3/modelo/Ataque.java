package com.ces2.trabajo3.modelo;

import java.util.Stack;
import java.util.function.Function;

/**
 * Columna C: Clase Ataque
 * Contiene atributos propios de la acción de atacar, los dos atributos de tipo enum
 * (EnumAtaque y Categoria) y el Stack de enteros que lo llame conteo.
 */
public class Ataque {

    private String nombre;
    private String objetivo;
    private int potenciaBase;
    private EnumAtaque enumAtaque;
    private Categoria categoria;
    private Stack<Integer> conteo;

    // Constructor vacío
    public Ataque() {
        this.conteo = new Stack<>();
    }

    // Constructor con los atributos necesarios y los dos atributos de tipo enum
    public Ataque(String nombre, String objetivo, int potenciaBase, EnumAtaque enumAtaque, Categoria categoria) {
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.potenciaBase = potenciaBase;
        this.enumAtaque = enumAtaque;
        this.categoria = categoria;
        this.conteo = new Stack<>();
    }

    // Método para agregar datos al Stack de enteros llamado conteo
    public void agregarConteo(int dato) {
        this.conteo.push(dato);
    }

    // ESTO ES DEL PUNTO 5: Método verTotales que recibe como parámetro la función del Punto 4 (Function<Ataque, Integer>)
    // y muestra el total de datos enteros del objeto que llame al método verTotales.
    public String verTotales(Function<Ataque, Integer> funcionSumaConteo) {
        Integer total = funcionSumaConteo.apply(this);
        String resultado = "Ataque [" + this.nombre + " -> Objetivo: " + this.objetivo
                + " | EnumAtaque: " + this.enumAtaque + " | Categoria: " + this.categoria
                + " | Datos en Stack conteo: " + this.conteo
                + "] => Total suma conteo: " + total;
        System.out.println(resultado);
        return resultado;
    }

    // Métodos SET para cada atributo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setPotenciaBase(int potenciaBase) {
        this.potenciaBase = potenciaBase;
    }

    public void setEnumAtaque(EnumAtaque enumAtaque) {
        this.enumAtaque = enumAtaque;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    // Métodos GET para cada atributo
    public String getNombre() {
        return nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public int getPotenciaBase() {
        return potenciaBase;
    }

    public EnumAtaque getEnumAtaque() {
        return enumAtaque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "nombre='" + nombre + '\'' +
                ", objetivo='" + objetivo + '\'' +
                ", potenciaBase=" + potenciaBase +
                ", enumAtaque=" + enumAtaque +
                ", categoria=" + categoria +
                ", conteo=" + conteo +
                '}';
    }
}
