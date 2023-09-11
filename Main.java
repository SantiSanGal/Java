import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Vehiculo {
    private String matricula;
    private String marca;
    private String tipo;
    private int km;

    public Vehiculo(String matricula, String marca, String tipo, int km) {
        this.matricula = matricula;
        this.marca = marca;
        this.tipo = tipo;
        this.km = km;
    }

    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Marca: " + marca + ", Tipo: " + tipo + ", Kilómetros: " + km;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de vehículos: ");
        int cantidadVehiculos = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < cantidadVehiculos; i++) {
            Vehiculo vehiculo = new Vehiculo();

            System.out.println("Ingrese los datos del vehículo " + (i + 1) + ":");
            System.out.print("Matrícula: ");
            vehiculo.setMatricula(scanner.nextLine());

            System.out.print("Marca: ");
            vehiculo.setMarca(scanner.nextLine());

            System.out.print("Tipo: ");
            vehiculo.setTipo(scanner.nextLine());

            System.out.print("Kilómetros: ");
            vehiculo.setKm(scanner.nextInt());
            scanner.nextLine(); 

            vehiculos.add(vehiculo);
        }

        System.out.println("\nCantidad de vehículos introducidos: " + vehiculos.size());

        System.out.println("\nVehículos que son coches:");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipo().equalsIgnoreCase("coche")) {
                System.out.println(vehiculo);
            }
        }

        int maxKm = 10000; 
        System.out.println("\nVehículos con menos de " + maxKm + " kilómetros:");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getKm() < maxKm) {
                System.out.println(vehiculo);
            }
        }

        String marcaDeseada = "Toyota";
        System.out.println("\nVehículos de la marca " + marcaDeseada + ":");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equalsIgnoreCase(marcaDeseada)) {
                System.out.println(vehiculo);
            }
        }

        ArrayList<Vehiculo> camionetas = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipo().equalsIgnoreCase("camioneta")) {
                camionetas.add(vehiculo);
            }
        }

        Collections.sort(camionetas, Comparator.comparingInt(Vehiculo::getKm));

        System.out.println("\nCamionetas ordenadas por número de kilómetros de menor a mayor:");
        for (Vehiculo camioneta : camionetas) {
            System.out.println(camioneta);
        }
    }
}
