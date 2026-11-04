package com.ces2.trabajo3.repositories;

import com.ces2.trabajo3.modelo.AccionAtacar;
import com.ces2.trabajo3.modelo.Ataque;
import com.ces2.trabajo3.modelo.Categoria;
import com.ces2.trabajo3.modelo.EnumAtaque;
import com.ces2.trabajo3.modelo.OleadaDeAtaques;
import org.springframework.stereotype.Repository;

import java.util.Stack;
import java.util.function.Function;

@Repository
public class RepositorioAtaques {

    private Stack<Ataque> pilaDeAtaques;
    private OleadaDeAtaques oleadaDeAtaques;

    // PUNTO 4: Función que utiliza la interface Function<T,R>, recibe un objeto Ataque (Columna C)
    // y retorna la suma de todos los datos que tiene en su Stack conteo usando programación funcional.
    public static final Function<Ataque, Integer> sumarConteoFunction = ataque ->
            ataque.getConteo().stream()
                    .reduce(0, Integer::sum);

    // Interface funcional del tema asignado (Columna B: la acción de atacar)
    public static final AccionAtacar accionAtacar = ataque ->
            "Ejecutando la acción de atacar con '" + ataque.getNombre()
                    + "' sobre '" + ataque.getObjetivo()
                    + "' [Tipo: " + ataque.getEnumAtaque()
                    + ", Categoría: " + ataque.getCategoria()
                    + ", Potencia Base: " + ataque.getPotenciaBase() + "]";

    public RepositorioAtaques() {
        inicializarDatos();
    }

    public final void inicializarDatos() {
        // PUNTO 1:
        // Crear 5 objetos de la clase Ataque (Columna C), todos con el mismo dato de EnumAtaque (Columna D)
        // y el mismo dato de Categoria (Columna E), asignando a cada objeto varios enteros en su Stack conteo.
        Ataque ataque1 = new Ataque("Tormenta Arcana", "Torre Principal", 120, EnumAtaque.MAGICO, Categoria.CRITICO);
        ataque1.agregarConteo(15);
        ataque1.agregarConteo(25);
        ataque1.agregarConteo(30);
        ataque1.agregarConteo(40);

        Ataque ataque2 = new Ataque("Rayo Astral", "Muralla Norte", 95, EnumAtaque.MAGICO, Categoria.CRITICO);
        ataque2.agregarConteo(10);
        ataque2.agregarConteo(20);
        ataque2.agregarConteo(35);

        Ataque ataque3 = new Ataque("Lluvia de Meteoros", "Fortaleza Central", 150, EnumAtaque.MAGICO, Categoria.CRITICO);
        ataque3.agregarConteo(50);
        ataque3.agregarConteo(45);
        ataque3.agregarConteo(60);
        ataque3.agregarConteo(55);
        ataque3.agregarConteo(70);

        Ataque ataque4 = new Ataque("Pulso Etéreo", "Generador de Escudos", 80, EnumAtaque.MAGICO, Categoria.CRITICO);
        ataque4.agregarConteo(12);
        ataque4.agregarConteo(18);
        ataque4.agregarConteo(22);

        Ataque ataque5 = new Ataque("Vórtice Oscuro", "Bastión Sur", 135, EnumAtaque.MAGICO, Categoria.CRITICO);
        ataque5.agregarConteo(30);
        ataque5.agregarConteo(45);
        ataque5.agregarConteo(50);
        ataque5.agregarConteo(65);

        // Crear un Stack con estos 5 objetos
        pilaDeAtaques = new Stack<>();
        pilaDeAtaques.push(ataque1);
        pilaDeAtaques.push(ataque2);
        pilaDeAtaques.push(ataque3);
        pilaDeAtaques.push(ataque4);
        pilaDeAtaques.push(ataque5);

        // Crear un objeto de tipo OleadaDeAtaques (Columna F) con los mismos dos tipos de enum asignados a los 5 objetos
        oleadaDeAtaques = new OleadaDeAtaques("Oleada Arcana Alfa", " Valle de las Sombras", EnumAtaque.MAGICO, Categoria.CRITICO);

        // Agregar a su atributo de tipo Deque (ataques) los 5 objetos Ataque usando su método asignado (agregarAtaque)
        pilaDeAtaques.forEach(oleadaDeAtaques::agregarAtaque);
    }

    public Stack<Ataque> getPilaDeAtaques() {
        return pilaDeAtaques;
    }

    public OleadaDeAtaques getOleadaDeAtaques() {
        return oleadaDeAtaques;
    }
}
