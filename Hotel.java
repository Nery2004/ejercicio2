import java.util.ArrayList;
import java.util.List;

class Hotel {
    // Atributos de la clase Hotel
    private List<Habitacion> habitaciones = new ArrayList<>(); // Lista de habitaciones del hotel
    private List<Reservacion> reservaciones = new ArrayList<>(); // Lista de reservaciones realizadas en el hotel
    private List<Cliente> listaEspera = new ArrayList<>(); // Lista de clientes en espera de ser asignados a una habitación

    // Métodos para agregar habitaciones y recibir clientes
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }
    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void recibirCliente(Cliente cliente) {
        listaEspera.add(cliente);
    }

    // Método para asignar una habitación a un cliente
    public void asignarHabitacion(Cliente cliente) {
        Habitacion habitacionAsignada = buscarHabitacionDisponible(cliente);

        if (habitacionAsignada != null) {
            Reservacion reservacion = new Reservacion(cliente, habitacionAsignada);
            reservaciones.add(reservacion);
            habitacionAsignada.setOcupada(true);
            listaEspera.remove(cliente);
            System.out.println("Habitacion asignada al cliente: " + cliente.getNombre());
        } else {
            System.out.println("No se pudo asignar una habitacion al cliente.");
        }
    }

    // Metodo privado para buscar una habitacion disponible para un cliente
    private Habitacion buscarHabitacionDisponible(Cliente cliente) {
        String tipoCliente = obtenerTipoCliente(cliente);

        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.isOcupada() && puedeReservar(tipoCliente, habitacion)) {
                return habitacion;
            }
        }
        return null;
    }

    // Método privado para verificar si un cliente puede reservar una habitación
    private boolean puedeReservar(String tipoCliente, Habitacion habitacion) {
        if (tipoCliente.equals("VIP")) {
            return habitacion.getCapacidadMaxima() >= 4;
        } else if (tipoCliente.equals("Frecuente")) {
            return habitacion.getCapacidadMaxima() >= 3;
        } else {
            return habitacion.getCapacidadMaxima() >= 2;
        }
    }

    // Método privado para obtener el tipo de cliente basado en el número de visitas
    private String obtenerTipoCliente(Cliente cliente) {
        if (cliente.getVisitasAlHotel() >= 10) {
            return "VIP";
        } else if (cliente.getVisitasAlHotel() >= 5) {
            return "Frecuente";
        } else {
            return "Regular";
        }
    }

    // Método para mostrar habitaciones disponibles
    public String mostrarHabitacionesDisponibles() {
        StringBuilder disponibles = new StringBuilder("Habitaciones disponibles:\n");
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.isOcupada()) {
                disponibles.append("Habitacion ").append(habitacion.getNumeroHabitacion()).append("\n");
            }
        }
        return disponibles.toString();
    }

    // Método para obtener la lista de espera
    public List<Cliente> getListaEspera() {
        return listaEspera;
    }
}
