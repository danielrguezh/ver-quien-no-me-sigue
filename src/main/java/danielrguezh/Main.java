package danielrguezh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> seguidores=new ArrayList<>();
    static final String PATH_SEGUIDORES="src/main/resources/seguidores.csv";
    static List<String> seguidos=new ArrayList<>();
    static final String PATH_SEGUIDOS="src/main/resources/seguidos.csv";
    public static void main(String[] args) {
        seguidores=obtenerData(PATH_SEGUIDORES);
        seguidos=obtenerData(PATH_SEGUIDOS);
        seguidos.removeAll(seguidores);
        for (String string : seguidos) {
            System.out.println(string);
        }
        
        
    }

    /**
     * Funcion que lee el fichero csv (o txt)
     * @param PATH del fichero
     * @return lista con los datos
     */
    private static List<String> obtenerData(String PATH) {
        List<String> lista=new ArrayList<>();
        File archivo = new File(PATH);
        if (!archivo.exists()) {
            System.err.println("Archivo CSV no encontrado: " + PATH);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
                
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return lista;
    }
}