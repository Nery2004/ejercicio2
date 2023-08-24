class Reservacion {
    private Cliente cliente;      // El cliente asociado a la reservacion
    private Habitacion habitacion; // La habitacion asociada a la reservacion

    // Constructor de la clase Reservacion
    public Reservacion(Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    // Metodo para calcular el costo total de la reservacion
    public double calcularCostoTotal() {
        return habitacion.getPrecioPorNoche(); // El costo total es igual al precio por noche de la habitacion
    }
}
