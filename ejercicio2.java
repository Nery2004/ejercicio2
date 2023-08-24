import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Inicialización de habitaciones del hotel
        for (int numeroHabitacion = 100; numeroHabitacion < 400; numeroHabitacion++) {
            int capacidadMaxima;
            double precioPorNoche;

            if (numeroHabitacion >= 100 && numeroHabitacion < 200) {
                capacidadMaxima = 2;
                precioPorNoche = 100.0;
            } else if (numeroHabitacion >= 200 && numeroHabitacion < 300) {
                capacidadMaxima = 4;
                precioPorNoche = 150.0;
            } else {
                capacidadMaxima = 3;
                precioPorNoche = 200.0;
            }

            Habitacion habitacion = new Habitacion(numeroHabitacion, capacidadMaxima, precioPorNoche);
            hotel.agregarHabitacion(habitacion);
        }

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Recibir cliente");
            System.out.println("2. Asignar habitacion");
            System.out.println("3. Mostrar habitaciones disponibles");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese el numero de visitas al hotel: ");
                    int visitasCliente = scanner.nextInt();
                    Cliente cliente = new Cliente(nombreCliente, visitasCliente);
                    hotel.recibirCliente(cliente);
                    System.out.println("Cliente recibido.");
                    break;
                case 2:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el nombre del cliente a asignar: ");
                    String nombreClienteAsignar = scanner.nextLine();
                    Cliente clienteAsignar = buscarClienteEnListaEspera(hotel, nombreClienteAsignar);

                    if (clienteAsignar != null) {
                        asignarHabitacionSegunVisitas(hotel, clienteAsignar);
                    } else {
                        System.out.println("El cliente no se encuentra en la lista de espera.");
                    }
                    break;
                case 3:
                    System.out.println(hotel.mostrarHabitacionesDisponibles());
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor ingrese una opcion valida.");
            }
        } while (opcion != 4);
    }

    private static Cliente buscarClienteEnListaEspera(Hotel hotel, String nombreCliente) {
        for (Cliente cliente : hotel.getListaEspera()) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }

    private static void asignarHabitacionSegunVisitas(Hotel hotel, Cliente cliente) {
        int visitas = cliente.getVisitasAlHotel();
        if (visitas >= 10) {
            asignarHabitacionVIP(hotel, cliente);
        } else if (visitas >= 5) {
            asignarHabitacionDeluxe(hotel, cliente);
        } else {
            asignarHabitacionRegular(hotel, cliente);
        }
    }

    private static void asignarHabitacionVIP(Hotel hotel, Cliente cliente) {
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            if (!habitacion.isOcupada() && habitacion.getNumeroHabitacion() >= 300 && habitacion.getNumeroHabitacion() < 400) {
                habitacion.setOcupada(true);
                hotel.getListaEspera().remove(cliente);
                System.out.println("Habitacion VIP asignada al cliente: " + cliente.getNombre());
                return;
            }
        }
        System.out.println("No hay habitaciones VIP disponibles para el cliente.");
    }

    private static void asignarHabitacionDeluxe(Hotel hotel, Cliente cliente) {
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            if (!habitacion.isOcupada() && habitacion.getNumeroHabitacion() >= 200 && habitacion.getNumeroHabitacion() < 300) {
                habitacion.setOcupada(true);
                hotel.getListaEspera().remove(cliente);
                System.out.println("Habitacion Deluxe asignada al cliente: " + cliente.getNombre());
                return;
            }
        }
        asignarHabitacionRegular(hotel, cliente); // Si no hay Deluxe disponibles, asignar Regular
    }

    private static void asignarHabitacionRegular(Hotel hotel, Cliente cliente) {
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            if (!habitacion.isOcupada() && habitacion.getNumeroHabitacion() >= 100 && habitacion.getNumeroHabitacion() < 200) {
                habitacion.setOcupada(true);
                hotel.getListaEspera().remove(cliente);
                System.out.println("Habitacion Regular asignada al cliente: " + cliente.getNombre());
                return;
            }
        }
        System.out.println("No hay habitaciones Regular disponibles para el cliente.");
    }
}
