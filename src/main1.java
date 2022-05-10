import java.io.File;
import java.util.Scanner;

public class main1 {
    private static boolean optionValida(int option, File file) {
        return option >= 0 && (option <= (file.listFiles() != null ? file.listFiles().length - 1 : 0));
    }

    public static void main(String[] args) {
        File f_in = File.listRoots()[0];
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Ejercicio1 muestraDirectorios = new Ejercicio1();
        File currentFile = File.listRoots()[0];
        do {
            System.out.println("Selecciona un indice para acceder a el: ");
            muestraDirectorios.listaDirectorios(currentFile);
            option = scanner.nextInt();
            if (optionValida(option, currentFile)) {
                if (currentFile != File.listRoots()[0]) {
                    currentFile = option == 0 ? currentFile.getParentFile() : currentFile.listFiles()[option - 1];
                } else {
                    System.out.println("La opcion introducida no es valida");
                }
                System.out.println("Para terminar el programa introduce -1");
            }
        } while (option != -1);
    }
}
