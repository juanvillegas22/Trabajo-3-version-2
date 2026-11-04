# Trabajo 3 - Colecciones en Java y Programación Funcional

## Tema asignado (Fila 32)
- **Estudiante:** VILLEGAS LLANO JUAN DIEGO
- **Tema de la interface:** la acción de atacar
- **Clase (Columna C):** `Ataque`
- **Enum con 5 opciones (Columna D):** `EnumAtaque`
- **Enum Categoria con 3 categorías (Columna E):** `Categoria`
- **Clase contenedora (Columna F):** `OleadaDeAtaques`

### Tecnologías
- Java 21
- Spring Boot
- Spring Web / MVC
- Thymeleaf
- Spring Boot DevTools
- Maven

### Estructura de Paquetes
- `modelo`: `EnumAtaque`, `Categoria`, `Ataque`, `OleadaDeAtaques`, `AccionAtacar`.
- `repositories`: `RepositorioAtaques` con los 5 objetos `Ataque`, el `Stack<Ataque>`, y el objeto `OleadaDeAtaques` con su `Deque<Ataque> ataques`.
- `controlador`: `ControladorAtaque` con las peticiones para cada punto del trabajo.
- `templates`: vistas Thymeleaf (`ataques.html`, `punto1.html`, `punto2.html`, `punto3.html`, `punto4.html`, `punto5.html`) con el diseño visual del Trabajo 2.

### Peticiones
- `/` → Presentación general de `OleadaDeAtaques` y las tarjetas de los 5 objetos `Ataque`.
- `/punto1` (o `/peticion1`) → Enums `EnumAtaque` y `Categoria`, 5 objetos `Ataque` con su `Stack<Integer> conteo`, `Stack<Ataque>` y `OleadaDeAtaques` con su `Deque<Ataque> ataques`.
- `/punto2` (o `/peticion2`) → Recorrido con `ListIterator` sobre el `Stack<Ataque>` y recorrido con `Iterator` (`iterator()`) sobre el `Deque<Ataque>` de `OleadaDeAtaques`.
- `/punto3` (o `/peticion3`) → Conversión de `Stack` a `Deque` (`Deque<Ataque> deque = new ArrayDeque<>(pilaDeAtaques);`) e impresión con programación funcional filtrando por un enum específico (`EnumAtaque.MAGICO`).
- `/punto4` (o `/peticion4`) → Función con `Function<Ataque, Integer>` que retorna la suma de los enteros del `Stack<Integer> conteo` e invocación con `apply()`.
- `/punto5` (o `/peticion5`) → Método `verTotales(Function<Ataque, Integer>)` en la clase `Ataque`, invocado desde un objeto `Ataque` creado previamente.
