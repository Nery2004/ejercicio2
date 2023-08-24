class Cliente {
    // Atributos de la clase Cliente
    private String nombre; // Nombre del cliente
    private int visitasAlHotel; // Numero de veces que el cliente ha visitado el hotel

    // Constructor de la clase Cliente
    public Cliente(String nombre, int visitasAlHotel) {
        // Inicializar los atributos del objeto Cliente con los valores de los argumentos
        this.nombre = nombre;
        this.visitasAlHotel = visitasAlHotel;
    }

    // Metodo para obtener el numero de visitas al hotel del cliente
    public int getVisitasAlHotel() {
        return visitasAlHotel;
    }

    // Metodo para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }
}

