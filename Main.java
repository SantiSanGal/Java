import java.util.*;

public class Main {
    public static void main(String[] args) {
        PlantelDocente plantel = new PlantelDocente();
        plantel.mostrarMenu();
    }

    static class Profesor {
        private String cedula;
        private String nombreCompleto;
        private int edad;
        private String direccion;
        private String telefono;
        private String email;
        private String titulo;
        private String materia;
        private int antiguedad;

        public Profesor(String cedula, String nombreCompleto, int edad, String direccion, String telefono, String email, String titulo, String materia, int antiguedad) {
            this.cedula = cedula;
            this.nombreCompleto = nombreCompleto;
            this.edad = edad;
            this.direccion = direccion;
            this.telefono = telefono;
            this.email = email;
            this.titulo = titulo;
            this.materia = materia;
            this.antiguedad = antiguedad;
        }

        public String getCedula() {
            return cedula;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getMateria() {
            return materia;
        }

        public int getAntiguedad() {
            return antiguedad;
        }

        public void setMateria(String materia) {
            this.materia = materia;
        }

        public void setAntiguedad(int antiguedad) {
            this.antiguedad = antiguedad;
        }

        @Override
        public String toString() {
            return "Cédula: " + cedula + ", Nombre: " + nombreCompleto + ", Edad: " + edad + ", Dirección: " + direccion + ", Teléfono: " + telefono + ", Email: " + email + ", Título: " + titulo + ", Materia: " + materia + ", Antigüedad: " + antiguedad;
        }
    }

    static class PlantelDocente {
        private Map<String, Profesor> profesores;

        public PlantelDocente() {
            profesores = new HashMap<>();
        }

        public void agregarProfesor(Profesor profesor) {
            profesores.put(profesor.getCedula(), profesor);
        }

        public void actualizarMateriaYAntiguedad(String cedula, String nuevaMateria, int nuevaAntiguedad) {
            if (profesores.containsKey(cedula)) {
                Profesor profesor = profesores.get(cedula);
                profesor.setMateria(nuevaMateria);
                profesor.setAntiguedad(nuevaAntiguedad);
            } else {
                System.out.println("No se encontró un profesor con la cédula proporcionada.");
            }
        }

        public void eliminarProfesoresPorTitulo(String titulo) {
            Iterator<Map.Entry<String, Profesor>> iterator = profesores.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Profesor> entry = iterator.next();
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    iterator.remove();
                }
            }
        }

        public List<Profesor> ordenarPorAntiguedad() {
            List<Profesor> listaOrdenada = new ArrayList<>(profesores.values());
            listaOrdenada.sort(Comparator.comparingInt(Profesor::getAntiguedad).reversed());
            return listaOrdenada;
        }

        public List<Profesor> obtenerProfesoresPorMateria(String materia) {
            List<Profesor> profesoresMateria = new ArrayList<>();
            for (Profesor profesor : profesores.values()) {
                if (profesor.getMateria().equalsIgnoreCase(materia)) {
                    profesoresMateria.add(profesor);
                }
            }
            return profesoresMateria;
        }

        public void imprimirLista() {
            for (Profesor profesor : profesores.values()) {
                System.out.println(profesor);
            }
        }

        public void mostrarMenu() {
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\nMenú de Opciones:");
                System.out.println("1. Agregar Profesor");
                System.out.println("2. Actualizar Materia y Antigüedad de un Profesor");
                System.out.println("3. Eliminar Profesores por Título");
                System.out.println("4. Ordenar Profesores por Antigüedad");
                System.out.println("5. Mostrar Profesores por Materia");
                System.out.println("6. Imprimir Lista de Profesores");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                switch (opcion) {
                    case 1:
                        agregarProfesorDesdeConsola(scanner);
                        break;
                    case 2:
                        actualizarMateriaYAntiguedadDesdeConsola(scanner);
                        break;
                    case 3:
                        eliminarProfesoresPorTituloDesdeConsola(scanner);
                        break;
                    case 4:
                        List<Profesor> listaOrdenada = ordenarPorAntiguedad();
                        System.out.println("\nProfesores Ordenados por Antigüedad:");
                        for (Profesor profesor : listaOrdenada) {
                            System.out.println(profesor);
                        }
                        break;
                    case 5:
                        mostrarProfesoresPorMateriaDesdeConsola(scanner);
                        break;
                    case 6:
                        imprimirLista();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } while (opcion != 7);
        }

        public void agregarProfesorDesdeConsola(Scanner scanner) {
            // Lógica para agregar un profesor desde la consola
            System.out.println("Ingrese los datos del profesor:");
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Nombre completo: ");
            String nombreCompleto = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Materia que enseña: ");
            String materia = scanner.nextLine();
            System.out.print("Antigüedad: ");
            int antiguedad = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            Profesor nuevoProfesor = new Profesor(cedula, nombreCompleto, edad, direccion, telefono, email, titulo, materia, antiguedad);
            agregarProfesor(nuevoProfesor);
            System.out.println("Profesor agregado con éxito.");
        }

        public void actualizarMateriaYAntiguedadDesdeConsola(Scanner scanner) {
            // Lógica para actualizar materia y antigüedad desde la consola
            System.out.print("Ingrese la cédula del profesor a actualizar: ");
            String cedula = scanner.nextLine();

            if (profesores.containsKey(cedula)) {
                System.out.print("Nueva materia que enseña: ");
                String nuevaMateria = scanner.nextLine();
                System.out.print("Nueva antigüedad: ");
                int nuevaAntiguedad = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea

                actualizarMateriaYAntiguedad(cedula, nuevaMateria, nuevaAntiguedad);
                System.out.println("Datos actualizados con éxito.");
            } else {
                System.out.println("No se encontró un profesor con la cédula proporcionada.");
            }
        }

        public void eliminarProfesoresPorTituloDesdeConsola(Scanner scanner) {
            // Lógica para eliminar profesores por título desde la consola
            System.out.print("Ingrese el título a buscar y eliminar: ");
            String titulo = scanner.nextLine();
            eliminarProfesoresPorTitulo(titulo);
            System.out.println("Profesores con título '" + titulo + "' eliminados con éxito.");
        }

        public void mostrarProfesoresPorMateriaDesdeConsola(Scanner scanner) {
            // Lógica para mostrar profesores por materia desde la consola
            System.out.print("Ingrese la materia a buscar: ");
            String materia = scanner.nextLine();
            List<Profesor> profesoresMateria = obtenerProfesoresPorMateria(materia);

            if (!profesoresMateria.isEmpty()) {
                System.out.println("Profesores que enseñan " + materia + ":");
                for (Profesor profesor : profesoresMateria) {
                    System.out.println(profesor);
                }
            } else {
                System.out.println("No se encontraron profesores que enseñen " + materia);
            }
        }
    }
}
