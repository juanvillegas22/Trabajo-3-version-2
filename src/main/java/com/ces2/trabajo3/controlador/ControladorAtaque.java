package com.ces2.trabajo3.controlador;

import com.ces2.trabajo3.modelo.Ataque;
import com.ces2.trabajo3.modelo.Categoria;
import com.ces2.trabajo3.modelo.EnumAtaque;
import com.ces2.trabajo3.modelo.OleadaDeAtaques;
import com.ces2.trabajo3.repositories.RepositorioAtaques;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

@Controller
public class ControladorAtaque {

    private final RepositorioAtaques repositorioAtaques;

    // PUNTO 4: Función que utiliza la interface Function<T,R>, recibe como parámetro un objeto
    // del tipo de la clase Ataque (Columna C) y retorna la suma de todos los datos que tiene en su Stack conteo.
    public static final Function<Ataque, Integer> funcionSumaConteo = ataque ->
            ataque.getConteo().stream()
                    .mapToInt(Integer::intValue)
                    .sum();

    public ControladorAtaque(RepositorioAtaques repositorioAtaques) {
        this.repositorioAtaques = repositorioAtaques;
    }

    @GetMapping({"/", "/todos"})
    public String inicio(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();
        OleadaDeAtaques oleada = repositorioAtaques.getOleadaDeAtaques();

        Map<String, Integer> sumasPorAtaque = new LinkedHashMap<>();
        Map<String, String> totalesTextoPorAtaque = new LinkedHashMap<>();
        Map<String, String> accionesPorAtaque = new LinkedHashMap<>();

        pilaDeAtaques.forEach(ataque -> {
            sumasPorAtaque.put(ataque.getNombre(), funcionSumaConteo.apply(ataque));
            totalesTextoPorAtaque.put(ataque.getNombre(), ataque.verTotales(funcionSumaConteo));
            accionesPorAtaque.put(ataque.getNombre(), RepositorioAtaques.accionAtacar.ejecutarAtaque(ataque));
        });

        model.addAttribute("ataques", pilaDeAtaques);
        model.addAttribute("oleada", oleada);
        model.addAttribute("enumsAtaque", Arrays.asList(EnumAtaque.values()));
        model.addAttribute("categorias", Arrays.asList(Categoria.values()));
        model.addAttribute("sumasPorAtaque", sumasPorAtaque);
        model.addAttribute("totalesTextoPorAtaque", totalesTextoPorAtaque);
        model.addAttribute("accionesPorAtaque", accionesPorAtaque);

        return "ataques";
    }

    @GetMapping({"/punto1", "/peticion1"})
    public String punto1(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();
        OleadaDeAtaques oleada = repositorioAtaques.getOleadaDeAtaques();

        // Demostración de constructor vacío y métodos set en la clase Ataque y OleadaDeAtaques
        Ataque ataquePruebaSet = new Ataque();
        ataquePruebaSet.setNombre("Ataque Configurado con Setters");
        ataquePruebaSet.setObjetivo("Objetivo Secundario");
        ataquePruebaSet.setPotenciaBase(100);
        ataquePruebaSet.setEnumAtaque(EnumAtaque.MAGICO);
        ataquePruebaSet.setCategoria(Categoria.CRITICO);
        ataquePruebaSet.setConteo(new Stack<>());
        ataquePruebaSet.agregarConteo(10);

        model.addAttribute("enumsAtaque", Arrays.asList(EnumAtaque.values()));
        model.addAttribute("categorias", Arrays.asList(Categoria.values()));
        model.addAttribute("stackAtaques", pilaDeAtaques);
        model.addAttribute("oleada", oleada);
        model.addAttribute("dequeAtaques", oleada.getAtaques());

        return "punto1";
    }

    @GetMapping({"/punto2", "/peticion2"})
    public String punto2(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();
        OleadaDeAtaques oleada = repositorioAtaques.getOleadaDeAtaques();

        // 1. ListIterator con el Stack de los 5 objetos creados anteriormente
        List<Ataque> recorridoListIterator = new ArrayList<>();
        List<String> detalleListIterator = new ArrayList<>();
        ListIterator<Ataque> listIterator = pilaDeAtaques.listIterator();
        int idx1 = 1;
        while (listIterator.hasNext()) {
            Ataque a = listIterator.next();
            recorridoListIterator.add(a);
            detalleListIterator.add("Objeto #" + idx1 + " -> Nombre: " + a.getNombre()
                    + " | Objetivo: " + a.getObjetivo()
                    + " | Potencia Base: " + a.getPotenciaBase()
                    + " | Stack conteo: " + a.getConteo()
                    + " | EnumAtaque: " + a.getEnumAtaque()
                    + " | Categoria: " + a.getCategoria());
            idx1++;
        }

        // 2. Iterator con el Deque del objeto de la clase OleadaDeAtaques usando iterator()
        List<Ataque> recorridoIteratorDeque = new ArrayList<>();
        List<String> detalleIteratorDeque = new ArrayList<>();
        Iterator<Ataque> iterator = oleada.getAtaques().iterator();
        int idx2 = 1;
        while (iterator.hasNext()) {
            Ataque a = iterator.next();
            recorridoIteratorDeque.add(a);
            detalleIteratorDeque.add("Objeto #" + idx2 + " -> Nombre: " + a.getNombre()
                    + " | Objetivo: " + a.getObjetivo()
                    + " | Potencia Base: " + a.getPotenciaBase()
                    + " | Stack conteo: " + a.getConteo()
                    + " | EnumAtaque: " + a.getEnumAtaque()
                    + " | Categoria: " + a.getCategoria());
            idx2++;
        }

        model.addAttribute("recorridoListIterator", recorridoListIterator);
        model.addAttribute("detalleListIterator", detalleListIterator);
        model.addAttribute("recorridoIteratorDeque", recorridoIteratorDeque);
        model.addAttribute("detalleIteratorDeque", detalleIteratorDeque);
        model.addAttribute("oleada", oleada);

        return "punto2";
    }

    @GetMapping({"/punto3", "/peticion3"})
    public String punto3(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();
        OleadaDeAtaques oleada = repositorioAtaques.getOleadaDeAtaques();

        // Código indicado en el enunciado para convertir un Stack en un Deque:
        Deque<Ataque> deque = new ArrayDeque<>(pilaDeAtaques);
        oleada.setAtaques(deque);

        EnumAtaque enumEspecifico = EnumAtaque.MAGICO;

        // Programación funcional que usa el Deque del objeto OleadaDeAtaques
        // para imprimir los datos de todos los objetos que sean de un enum específico
        List<Ataque> ataquesFiltrados = oleada.getAtaques().stream()
                .filter(ataque -> enumEspecifico.equals(ataque.getEnumAtaque()))
                .peek(ataque -> System.out.println("Imprimiendo funcionalmente desde Deque -> " + ataque))
                .toList();

        List<String> impresionFuncional = oleada.getAtaques().stream()
                .filter(ataque -> enumEspecifico.equals(ataque.getEnumAtaque()))
                .map(ataque -> "Nombre: " + ataque.getNombre()
                        + " | Objetivo: " + ataque.getObjetivo()
                        + " | Potencia Base: " + ataque.getPotenciaBase()
                        + " | EnumAtaque: " + ataque.getEnumAtaque()
                        + " | Categoria: " + ataque.getCategoria()
                        + " | Stack conteo: " + ataque.getConteo())
                .toList();

        model.addAttribute("enumFiltro", enumEspecifico);
        model.addAttribute("categoriaFiltro", oleada.getCategoria());
        model.addAttribute("ataquesFiltrados", ataquesFiltrados);
        model.addAttribute("impresionFuncional", impresionFuncional);
        model.addAttribute("oleada", oleada);

        return "punto3";
    }

    @GetMapping({"/punto4", "/peticion4"})
    public String punto4(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();

        // Llamar a la función Function<Ataque, Integer> con su método apply()
        Ataque objetoPrincipal = pilaDeAtaques.get(0);
        Integer resultadoPrincipal = funcionSumaConteo.apply(objetoPrincipal);

        Map<Ataque, Integer> resultadosFuncion = new LinkedHashMap<>();
        pilaDeAtaques.forEach(ataque -> resultadosFuncion.put(ataque, funcionSumaConteo.apply(ataque)));

        Integer sumaTotalGlobal = pilaDeAtaques.stream()
                .map(funcionSumaConteo)
                .reduce(0, Integer::sum);

        model.addAttribute("objetoPrincipal", objetoPrincipal);
        model.addAttribute("resultadoPrincipal", resultadoPrincipal);
        model.addAttribute("resultadosFuncion", resultadosFuncion);
        model.addAttribute("sumaTotalGlobal", sumaTotalGlobal);

        return "punto4";
    }

    @GetMapping({"/punto5", "/peticion5"})
    public String punto5(Model model) {
        repositorioAtaques.inicializarDatos();
        Stack<Ataque> pilaDeAtaques = repositorioAtaques.getPilaDeAtaques();

        // Hacer que un objeto de la clase de la columna C ya creado anteriormente
        // llame al método verTotales(funcionSumaConteo) y muestre su total de datos de tipo entero
        Ataque objetoSeleccionado = pilaDeAtaques.get(0);
        String salidaObjetoSeleccionado = objetoSeleccionado.verTotales(funcionSumaConteo);
        Integer totalObjetoSeleccionado = funcionSumaConteo.apply(objetoSeleccionado);

        List<String> totalesTodosLosObjetos = pilaDeAtaques.stream()
                .map(ataque -> ataque.verTotales(funcionSumaConteo))
                .toList();

        model.addAttribute("objetoSeleccionado", objetoSeleccionado);
        model.addAttribute("salidaObjetoSeleccionado", salidaObjetoSeleccionado);
        model.addAttribute("totalObjetoSeleccionado", totalObjetoSeleccionado);
        model.addAttribute("totalesTodosLosObjetos", totalesTodosLosObjetos);
        model.addAttribute("ataques", pilaDeAtaques);

        return "punto5";
    }
}
