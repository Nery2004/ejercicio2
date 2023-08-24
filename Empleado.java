import java.util.Scanner;

class Empleado {
    // Metodo para recibir entrada del empleado
    public String recibirEntradaEmpleado() {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Devolver la siguiente linea de entrada del usuario
        return scanner.nextLine();
    }

    // Metodo para mostrar un mensaje al empleado
    public void mostrarMensaje(String mensaje) {
        // Imprimir el mensaje en la consola
        System.out.println(mensaje);
    }
}
