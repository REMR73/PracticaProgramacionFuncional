package practica_ejercicios;

import models.ejercicio2.Empleado;
import models.ejercicio2.Producto;

import java.util.List;

public class PracticaEjerciciosGuiados {

    public static void EjerciciosPracticos(List<Producto> productos, List<Empleado> empleados, List<Integer> numeros) {
        System.out.println("=== PRÁCTICA DE JAVA STREAMS ===\n");
        System.out.println("\n1.1 - Números pares:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. numeros.stream() - Convierte la lista en un stream para poder procesarla
         * 2. .filter(n -> n % 2 == 0) - OPERACIÓN INTERMEDIA que mantiene solo elementos que cumplen la condición
         *    - Toma cada número 'n' y verifica si es par (resto de división por 2 es 0)
         *    - Solo los números que retornen 'true' pasan al siguiente paso
         * 3. .collect(Collectors.toList()) - OPERACIÓN TERMINAL que convierte el stream de vuelta a una Lista
         *    - Sin esta operación, el stream no se ejecuta (evaluación perezosa)
         */
        /**
         * Hay 10 tipos de personas que conocen binario, los que lo entienen y los que no
         */

        // Ejercicio 1.2: Transformar a cuadrados
        System.out.println("\n1.2 - Cuadrados de números:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. numeros.stream() - Crea el stream de números
         * 2. .map(n -> n * n) - OPERACIÓN INTERMEDIA que transforma cada elemento
         *    - Toma cada número 'n' y lo convierte en su cuadrado (n * n)
         *    - El stream ahora contiene los cuadrados en lugar de los números originales
         * 3. .collect(Collectors.toList()) - Recolecta los resultados en una nueva lista
         *
         * CONCEPTO CLAVE: map() cambia cada elemento, filter() decide cuáles mantener
         */

        // Ejercicio 1.3: Productos con precio > 100
        System.out.println("\n1.3 - Productos con precio > $100:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Crea stream de objetos Producto
         * 2. .filter(p -> p.getPrecio().compareTo(new BigDecimal("100")) > 0)
         *    - Filtra productos cuyo precio sea mayor a $100
         *    - compareTo() retorna: negativo si menor, 0 si igual, positivo si mayor
         * 3. .forEach(System.out::println) - OPERACIÓN TERMINAL que ejecuta una acción para cada elemento
         *    - System.out::println es una "referencia de metodo" equivalente a: p -> System.out.println(p)
         *
         * NOTA: forEach no retorna nada, solo ejecuta efectos secundarios (como imprimir)
         */


        // NIVEL 2: OPERACIONES INTERMEDIAS
        System.out.println("\n\nNIVEL 2: OPERACIONES INTERMEDIAS");
        System.out.println("--------------------------------");

        // Ejercicio 2.1: Ordenar productos por precio
        System.out.println("2.1 - Productos ordenados por precio (ascendente):");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Crea el stream de productos
         * 2. .sorted(Comparator.comparing(Producto::getPrecio)) - OPERACIÓN INTERMEDIA de ordenamiento
         *    - Comparator.comparing() crea un comparador basado en una función
         *    - Producto::getPrecio es una referencia de metodo que extrae el precio de cada producto
         *    - Por defecto ordena ascendente (menor a mayor)
         * 3. .forEach(System.out::println) - Imprime cada elemento en el orden establecido
         *
         * CONCEPTO CLAVE: sorted() no modifica la colección original, crea un nuevo stream ordenado
         */
        // Ordena por precio ascendente
        // Imprime en orden

        // Ejercicio 2.2: Primeros 3 empleados con mayor salario
        System.out.println("\n2.2 - Top 3 empleados con mayor salario:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. empleados.stream() - Crea stream de empleados
         * 2. .sorted(Comparator.comparing(Empleado::getSalario).reversed())
         *    - Ordena por salario en orden DESCENDENTE (mayor a menor)
         *    - .reversed() invierte el orden natural del comparador
         * 3. .limit(3) - OPERACIÓN INTERMEDIA que toma solo los primeros 3 elementos
         *    - Muy útil para "Top N" consultas
         * 4. .forEach() - Imprime los 3 empleados con mayor salario
         *
         * FLUJO: Todos los empleados → Ordenados por salario DESC → Solo los primeros 3 → Imprimir
         */


        // Ejercicio 2.3: Nombres de productos únicos por categoría
        System.out.println("\n2.3 - Categorías únicas de productos:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Stream de productos
         * 2. .map(Producto::getCategoria) - Extrae solo las categorías (String)
         *    - Transforma stream de Producto a stream de String
         * 3. .collect(Collectors.toSet()) - OPERACIÓN TERMINAL que recolecta en un Set
         *    - Set automáticamente elimina duplicados
         *    - Resultado: solo categorías únicas
         *
         * CONCEPTO CLAVE: Combinamos map() para extraer datos + Set para eliminar duplicados
         */


        // NIVEL 3: OPERACIONES DE REDUCCIÓN
        System.out.println("\n\nNIVEL 3: OPERACIONES DE REDUCCIÓN");
        System.out.println("---------------------------------");

        // Ejercicio 3.1: Suma de todos los números
        System.out.println("3.1 - Suma de todos los números:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. numeros.stream() - Stream de números
         * 2. .reduce(0, Integer::sum) - OPERACIÓN TERMINAL de reducción
         *    - Parámetro 1 (0): Valor inicial/identidad
         *    - Parámetro 2 (Integer::sum): Función acumuladora (equivale a: (a,b) -> a + b)
         *    - Proceso: 0 + 1 = 1, luego 1 + 2 = 3, luego 3 + 3 = 6, etc.
         *
         * CONCEPTO CLAVE: reduce() combina todos los elementos en un solo valor
         * Otros ejemplos: multiplicación, encontrar máximo, concatenar strings, etc.
         */


        // Ejercicio 3.2: Valor total del inventario
        System.out.println("\n3.2 - Valor total del inventario:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Stream de productos
         * 2. .map(p -> p.getPrecio().multiply(BigDecimal.valueOf(p.getStock())))
         *    - Para cada producto, calcula: precio × stock = valor total del producto
         *    - Transforma stream de Producto a stream de BigDecimal (valores)
         * 3. .reduce(BigDecimal.ZERO, BigDecimal::add)
         *    - Suma todos los valores individuales para obtener valor total del inventario
         *    - BigDecimal.ZERO es el valor inicial (equivale a 0.00)
         *
         * FLUJO: Productos → Valores individuales (precio×stock) → Suma total
         */

        // Ejercicio 3.3: Empleado con mayor salario
        System.out.println("\n3.3 - Empleado con mayor salario:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. empleados.stream() - Stream de empleados
         * 2. .max(Comparator.comparing(Empleado::getSalario)) - Encuentra el máximo
         *    - Comparator.comparing() define CÓMO comparar (por salario en este caso)
         *    - max() retorna Optional<Empleado> porque podría no haber elementos
         * 3. Optional<Empleado> - Contenedor que puede tener un valor o estar vacío
         * 4. .ifPresent() - Solo ejecuta la acción si hay un valor presente
         *
         * CONCEPTO CLAVE: Optional evita NullPointerException cuando no hay resultados
         * Alternativas: .orElse(), .orElseThrow(), .isPresent(), etc.
         */

        // NIVEL 4: AGRUPACIONES Y COLECCIONES
        System.out.println("\n\nNIVEL 4: AGRUPACIONES Y COLECCIONES");
        System.out.println("-----------------------------------");

        // Ejercicio 4.1: Agrupar productos por categoría
        System.out.println("4.1 - Productos agrupados por categoría:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Stream de productos
         * 2. .collect(Collectors.groupingBy(Producto::getCategoria))
         *    - groupingBy() es un COLLECTOR avanzado que agrupa elementos
         *    - Función clasificadora: Producto::getCategoria (define CÓMO agrupar)
         *    - Resultado: Map<String, List<Producto>>
         *      - Clave: nombre de categoría (String)
         *      - Valor: lista de productos de esa categoría
         *
         * CONCEPTO CLAVE: groupingBy() es como "GROUP BY" en SQL
         * Es la forma más elegante de agrupar elementos por algún criterio
         */

        /**
         * ITERACIÓN SOBRE EL MAP RESULTANTE:
         * - forEach en Map recibe (clave, valor) como parámetros
         * - categoria: String con el nombre de la categoría
         * - lista: List<Producto> con todos los productos de esa categoría
         */

        // Ejercicio 4.2: Empleados por departamento con salario promedio
        System.out.println("\n4.2 - Salario promedio por departamento:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. empleados.stream() - Stream de empleados
         * 2. .collect(Collectors.groupingBy(...)) - Agrupa por departamento
         * 3. Collectors.averagingDouble(e -> e.getSalario().doubleValue())
         *    - COLLECTOR DOWNSTREAM: se aplica a cada grupo creado por groupingBy
         *    - averagingDouble(): calcula el promedio de valores numéricos
         *    - e.getSalario().doubleValue(): extrae el salario como double
         *
         * RESULTADO: Map<String, Double>
         * - Clave: nombre del departamento
         * - Valor: salario promedio de empleados en ese departamento
         *
         * CONCEPTO CLAVE: Collectors se pueden componer (groupingBy + averagingDouble)
         */


        // Ejercicio 4.3: Contar productos por categoría
        System.out.println("\n4.3 - Cantidad de productos por categoría:");
        /**
         * EXPLICACIÓN PASO A PASO:
         * 1. productos.stream() - Stream de productos
         * 2. .collect(Collectors.groupingBy(...)) - Agrupa por categoría
         * 3. Collectors.counting() - COLLECTOR DOWNSTREAM que cuenta elementos en cada grupo
         *
         * RESULTADO: Map<String, Long>
         * - Clave: nombre de categoría
         * - Valor: cantidad de productos en esa categoría (Long)
         *
         * ALTERNATIVA más simple: productos.stream().collect(groupingBy(getCategoria)).mapValues(List::size)
         * Pero counting() es más directo y eficiente
         */

        // NIVEL 5: OPERACIONES AVANZADAS
        System.out.println("\n\nNIVEL 5: OPERACIONES AVANZADAS");
        System.out.println("------------------------------");

        // Ejercicio 5.1: FlatMap - Obtener todas las letras de los nombres
        System.out.println("5.1 - Letras únicas en nombres de empleados:");
        /**
         * EXPLICACIÓN PASO A PASO - FLATMAP:
         * 1. empleados.stream() - Stream de empleados
         * 2. .map(Empleado::getNombre) - Extrae nombres: Stream<String>
         * 3. .flatMap(nombre -> ...)  - OPERACIÓN COMPLEJA que aplana streams anidados
         *
         *    DENTRO DEL FLATMAP:
         *    a) nombre.toLowerCase() - Convierte a minúsculas
         *    b) .chars() - Convierte String a IntStream de códigos ASCII
         *    c) .filter(Character::isLetter) - Solo mantiene códigos de letras (no espacios/números)
         *    d) .mapToObj(c -> (char) c) - Convierte códigos ASCII de vuelta a caracteres
         *
         *    RESULTADO DEL FLATMAP: todos los caracteres de todos los nombres en un solo stream
         * 4. .collect(Collectors.toSet()) - Elimina duplicados automáticamente
         *
         * CONCEPTO CLAVE: flatMap() convierte Stream<Stream<T>> en Stream<T>
         * Útil cuando cada elemento produce múltiples elementos (como chars de un string)
         */


        // Ejercicio 5.2: Partición - Productos caros vs baratos
        System.out.println("\n5.2 - Partición de productos (caros > $200 vs baratos):");
        /**
         * EXPLICACIÓN PASO A PASO - PARTITIONING:
         * 1. productos.stream() - Stream de productos
         * 2. .collect(Collectors.partitioningBy(...))
         *    - partitioningBy() divide elementos en EXACTAMENTE 2 grupos: true y false
         *    - Función predicado: p -> p.getPrecio().compareTo(new BigDecimal("200")) > 0
         *    - Si precio > $200 → va al grupo "true" (caros)
         *    - Si precio ≤ $200 → va al grupo "false" (baratos)
         *
         * RESULTADO: Map<Boolean, List<Producto>>
         * - Clave true: productos caros (> $200)
         * - Clave false: productos baratos (≤ $200)
         *
         * CONCEPTO CLAVE: partitioningBy() es un caso especial de groupingBy() con solo 2 grupos
         * Más eficiente que groupingBy() cuando solo necesitas dividir en 2
         */

        // Ejercicio 5.3: Estadísticas de precios
        System.out.println("\n5.3 - Estadísticas de precios:");
        /**
         * EXPLICACIÓN PASO A PASO - ESTADÍSTICAS:
         * 1. productos.stream() - Stream de productos
         * 2. .mapToDouble(p -> p.getPrecio().doubleValue())
         *    - Convierte Stream<Producto> a DoubleStream de precios
         *    - DoubleStream tiene métodos especializados para números
         * 3. .summaryStatistics() - OPERACIÓN TERMINAL que calcula múltiples estadísticas:
         *    - count: cantidad de elementos
         *    - min: valor mínimo
         *    - max: valor máximo
         *    - sum: suma total
         *    - average: promedio aritmético
         *
         * CONCEPTO CLAVE: summaryStatistics() calcula todo en una sola pasada
         * Más eficiente que hacer múltiples operaciones separadas
         */

//        // EJERCICIOS PARA RESOLVER
//        System.out.println("\n\n=== EJERCICIOS PARA RESOLVER ===");
//        practica_ejercicios.Ejercicios.resolverEjercicios(productos, empleados, numeros);
    }
}
