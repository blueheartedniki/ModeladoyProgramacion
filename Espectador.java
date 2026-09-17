import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 * observador  (espectador): guarda en su bitácora los eventos del combate que recibe del sujeto 
 * y al final pone un mensaje según si gano o no su personaje favorito y lo guarda en un archivo .txt
 */
public class Espectador implements Observador {

    private final String id;
    private final String personajeFavorito;
    private final StringBuilder bitacora;

    /**
     * @param id                identificador único del espectador 
     * @param personajeFavorito nombre del personaje al que apoya
     */
    public Espectador(String id, String personajeFavorito) {
        this.id = id;
        this.personajeFavorito = personajeFavorito;
        this.bitacora = new StringBuilder();
    }

    @Override
    public void actualizar(String mensaje) {
        bitacora.append(mensaje).append(System.lineSeparator());
    }

    /**
     * agrega el mensaje final de la bitácora de que si su personaje gano o perdio 
     * 
     *
     * @param nombreGanador nombre del personaje que ganó el combate
     */
    public void agregarMensajeFinal(String nombreGanador) {
        bitacora.append(System.lineSeparator());
        if (personajeFavorito.equalsIgnoreCase(nombreGanador)) {
            bitacora.append("aaaaa ").append(id).append(" ganaste!! tu personaje ")
                    .append(personajeFavorito).append(" se rifo un chorro y se llevo la victoria, felicidades!")
                    .append(System.lineSeparator());
        } else {
            bitacora.append("ash que mal ").append(id).append(", tu personaje ")
                    .append(personajeFavorito).append(" perdióoo jaja, el ganador fué:")
                    .append(nombreGanador).append(", a la siguiente le apuestas e alguien más chido")
                    .append(System.lineSeparator());
        }
    }

    /**
     * guarda la bitácora completa de este espectador en un archivo .txt
     * 
     *
     * @param carpetaDestino carpeta donde se guardarán las bitácoras
     */
    public void guardarBitacora(String carpetaDestino) {
        File carpeta = new File(carpetaDestino);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        File archivo = new File(carpeta, "bitacora_" + id + ".txt");
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8)) {
            writer.write(bitacora.toString());
        } catch (IOException e) {
            System.out.println("No se pudo guardar la bitácora de " + id + ": " + e.getMessage());
        }
    }

    public String getId() {
        return id;
    }

    public String getPersonajeFavorito() {
        return personajeFavorito;
    }
}
