import java.io.File;

public class Ejercicio1 {
    public void listaDirectorios(File directorio) {
        System.out.println("Lista de ficheros y directorios del directorio: " + directorio.getName());
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("" + 0 + "-." + (directorio.getParent() == null ? "<No Parent>" : directorio.getParent()));
        if (directorio.listFiles() == null) {
            return;
        }
        for (int i = 0; i < directorio.listFiles().length - 1; i++) {
            if (directorio.listFiles()[i].isDirectory()) {
                System.out.print("" + (i + 1) + "-. ");
                System.out.println(directorio.listFiles()[i].getName() + " (Directorio)");
            }
            if (directorio.listFiles()[i].isFile()) {
                System.out.print("" + (i + 1) + "-. ");
                System.out.println(directorio.listFiles()[i].getName() + " " + directorio.listFiles()[i].length());
            }
        }
    }
}
