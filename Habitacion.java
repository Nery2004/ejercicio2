class Habitacion {
    // Atributos de la clase Habitacion
    private int numeroHabitacion; // Numero de la habitacion
    private int capacidadMaxima; // Capacidad maxima de personas que pueden alojarse en la habitacion
    private double precioPorNoche; // Precio por noche de la habitacion
    private boolean ocupada; // Indica si la habitacion esta ocupada o no

    // Constructor de la clase Habitacion
    public Habitacion(int numeroHabitacion, int capacidadMaxima, double precioPorNoche) {
        // Inicializar los atributos del objeto Habitacion con los valores de los argumentos
        this.numeroHabitacion = numeroHabitacion;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.ocupada = false; // Inicializar el atributo ocupada en false para indicar que la habitacion esta disponible
    }

    // Metodos getters y setters

    // Metodo para saber si la habitacion esta ocupada o no
    public boolean isOcupada() {
        return ocupada;
    }

    // Metodo para establecer si la habitacion esta ocupada o no
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    // Metodo para obtener el precio por noche de la habitacion
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    // Metodo para obtener el numero de la habitacion
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    // Metodo para obtener la capacidad maxima de personas que pueden alojarse en la habitacion
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
