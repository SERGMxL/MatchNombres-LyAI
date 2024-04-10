import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PctoUnidad2 {
    private static final String CSV_FILE = "\\nombres.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Leer archivo");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por año de ingreso al tecnológico");
            System.out.println("4. Buscar por dominio de correo");
            System.out.println("5. Buscar por fecha (mes y día) de nacimiento");
            System.out.println("6. Imprimir edades de los mayores de edad");
            System.out.println("7. Imprimir los menores de edad que están en el ITSZN");
            System.out.println("8. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    try {
                        leerArchivo();
                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    buscarPorNombre();
                    break;
                case 3:
                    buscarPorAnioIngreso();
                    break;
                case 4:
                    buscarPorDominioCorreo();
                    break;
                case 5:
                    buscarPorFechaNacimiento();
                    break;
                case 6:
                    imprimirMayoresEdad();
                    break;
                case 7:
                    imprimirMenoresITSZN();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void leerArchivo() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void buscarPorNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre a buscar:");
        String nombreBuscado = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(nombreBuscado.toLowerCase())) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void buscarPorAnioIngreso() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el año de ingreso a buscar:");
        int anioBuscado = scanner.nextInt();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int anioIngreso = Integer.parseInt(parts[2]);
                if (anioIngreso == anioBuscado) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void buscarPorDominioCorreo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dominio de correo a buscar:");
        String dominioBuscado = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String correo = parts[3];
                if (correo.endsWith(dominioBuscado)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void buscarPorFechaNacimiento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la fecha de nacimiento (mes y día) a buscar (en formato MM-DD):");
        String fechaBuscada = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String fechaNacimiento = parts[4];
                if (fechaNacimiento.endsWith(fechaBuscada)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void imprimirMayoresEdad() {
        // Implementar la impresión de edades de los mayores de edad aquí
        System.out.println("Opción 'Imprimir edades de los mayores de edad' seleccionada.");
    }

    private static void imprimirMenoresITSZN() {
        // Implementar la impresión de los menores de edad que están en el ITSZN aquí
        System.out.println("Opción 'Imprimir los menores de edad que están en el ITSZN' seleccionada.");
    }
}
