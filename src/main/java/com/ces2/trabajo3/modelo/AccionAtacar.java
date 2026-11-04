package com.ces2.trabajo3.modelo;

/**
 * Interface funcional sobre el tema asignado "la acción de atacar".
 */
@FunctionalInterface
public interface AccionAtacar {
    String ejecutarAtaque(Ataque ataque);
}
