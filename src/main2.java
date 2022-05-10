import java.io.File;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        File file = File.listRoots()[0];
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Ejercicio2 directoriosDisponibles = new Ejercicio2();
        do {
            if (option == 0) {
                directoriosDisponibles.listDirectorios(file);
            }
            System.out.println("Selecciona un indice para acceder a el");
            if ((option = scanner.nextInt()) >= 0 && (option <= directoriosDisponibles.getDirectorios().size() - 1)) {
                directoriosDisponibles.accedeDirectorio(option);
            } else {
                System.out.println("El indice introducido no es posible");
            }
            System.out.println("Para terminar el programa introduce -1");
        } while (option != -1);
    }
}
