package org.example;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Tienda tienda = crearTienda(); // Crear la tienda
        agregarDepartamentos(tienda);  // Agregar departamentos a la tienda
        mostrarMenu(tienda);           // Mostrar el menú principal
    }

    private static Tienda crearTienda() {
        System.out.print("Ingrese el nombre de la tienda: ");
        String nombreTienda = scanner.nextLine();
        return new Tienda(nombreTienda);
    }

    private static void agregarDepartamentos(Tienda tienda) {
        System.out.print("¿Cuántos departamentos desea agregar?: ");
        int numDepartamentos = leerEntero();

        for (int i = 0; i < numDepartamentos; i++) {
            System.out.println("\nDepartamento " + (i + 1));
            System.out.print("Ingrese el ID del departamento: ");
            int idDepartamento = leerEntero();

            System.out.print("Ingrese el nombre del departamento: ");
            String nombreDepartamento = scanner.nextLine();

            Departamento departamento = new Departamento(idDepartamento, nombreDepartamento);
            tienda.getDepartamentodata().add(departamento);
            agregarProductosADepartamento(departamento);
        }
    }

    private static void agregarProductosADepartamento(Departamento departamento) {
        boolean agregarMasProductos;
        do {
            System.out.println("\nAñadiendo producto al departamento: " + departamento.getNombredep());
            System.out.print("Ingrese el ID del producto: ");
            int idProducto = leerEntero();

            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = leerDouble();

            System.out.print("Ingrese el stock (cantidad) del producto: ");
            int cantidadProducto = leerEntero();

            Producto producto = new Producto(idProducto, nombreProducto, precioProducto, cantidadProducto);

            // Aquí llamamos al agregarProducto de Departamento
            departamento.agregarProducto(producto);

            System.out.print("¿Desea agregar otro producto a este departamento? (s/n): ");
            agregarMasProductos = scanner.nextLine().equalsIgnoreCase("s");
        } while (agregarMasProductos);
    }

    private static void mostrarMenu(Tienda tienda) {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Consultar departamentos de la tienda");
            System.out.println("2. Consultar productos de los departamentos");
            System.out.println("3. Consultar stock de un producto");
            System.out.println("4. Actualizar precio de un producto");
            System.out.println("5. Eliminar un producto de un departamento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();


            // tienda.getDepartamentodata() recorre todos los departamentos obtenidos mediante tienda.getDepartamentodata()
            switch (opcion) {
                case 1:
                    tienda.consultarDepartamentos(); // Llama a consultarDepartamentos de Tienda
                    break;
                case 2:
                    System.out.println("Productos en todos los departamentos:");
                    for (Departamento departamento : tienda.getDepartamentodata()) {
                        System.out.println("\nDepartamento: " + departamento.getNombredep());
                        departamento.consultarProductos();  // Llama a consultarProductos de cada Departamento
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto para consultar stock: ");
                    int idProductoConsulta = leerEntero();
                    for (Departamento dep : tienda.getDepartamentodata()) {
                        dep.consultarStock(idProductoConsulta); // Llama a consultarStock de Departamento
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el ID del producto para actualizar precio: ");
                    int idProductoActualiza = leerEntero();
                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = leerDouble();
                    for (Departamento dep : tienda.getDepartamentodata()) {
                        dep.actualizarPrecio(idProductoActualiza, nuevoPrecio); // Llama a actualizarPrecio de departamento
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el ID del producto para eliminar: ");
                    int idProductoEliminar = leerEntero();
                    for (Departamento dep : tienda.getDepartamentodata()) {
                        dep.eliminarProducto(idProductoEliminar); // Llama a eliminarProducto de departamento
                    }
                    System.out.println("Producto eliminado (si existía).");
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
                // Si ocurre una excepción es decir, si la entrada no es un número entero VALIDO
                // se captura y se muestra el mensaje de error
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingrese un número entero: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingrese un número decimal: ");
            }
        }
    }
}