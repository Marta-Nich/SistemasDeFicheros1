import java.io.File;
import java.text.DateFormat;
import java.util.LinkedList;
import java.util.Locale;

public class Ejercicio2 {
    private LinkedList<File> directorios = new LinkedList<>();

    public LinkedList<File> getDirectorios() {
        return directorios;
    }

    private File accesoDirectorio;

    public void addDirectorios(File file) {
        directorios.add(file);
        for (File files : file.listFiles()) {
            directorios.add(files);
        }
    }

    public void listDirectorios(File directorio) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());
        Locale.getDefault();
        directorios.clear();
        addDirectorios(directorio);
        System.out.println("Lista de directorios y ficheros:");
        System.out.println("" + 0 + "-. Directorio Padre");
        for (int i = 1; i < directorios.size(); i++) {
            String d = "-";
            String r = "-";
            String w = "-";
            String x = "-";
            if (directorios.get(i).isDirectory()) {
                d = "d";
            }
            if (directorios.get(i).canRead()) {
                r = "r";
            }
            if (directorios.get(i).canWrite()) {
                w = "w";
            }
            if (directorios.get(i).canExecute()) {
                x = "x";
            }
            String flags = d + r + w + x;
            System.out.print("" + (i) + "-. ");
            System.out.println(flags + "    " + String.format("%-15d", directorios.get(i).length()) + dateFormat.format(directorios.get(i).lastModified()) + "\t       " + directorios.get(i).getName());
            ;
        }
    }

    public void accedeDirectorio(int indiceDirectorio) {
        accesoDirectorio = directorios.get(indiceDirectorio);
        if (accesoDirectorio.canRead()) {
            listDirectorios(directorios.get(indiceDirectorio));
        } else {
            System.out.println("No tienes permisos de lectura");
        }
    }
}
