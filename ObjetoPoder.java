import java.util.List;
import java.util.Random;

/**
 * objeto de poder: objeto de combate asignado a un personaje 
 * específico que cuando se crea define  uno de sus tres poderes para obtenerlo 
 * al consumirse
 * 
 */
public class ObjetoPoder {

    private final Personaje propietario;
    private final Habilidad poderAsignado;

    /**
     * asignación de poder: cea el objeto y elige al azar uno de los tres poderes disponibles 
     *
     * @param propietario personaje al que pertenece este objeto
     * @param random      generador aleatorio compartido por el combate
     */
    public ObjetoPoder(Personaje propietario, Random random) {
        this.propietario = propietario;
        List<Habilidad> opciones = propietario.getPoderesDisponibles();
        this.poderAsignado = opciones.get(random.nextInt(opciones.size()));
    }

    /**
     * consume el objeto y entrega la habilidad que le fue asignada
     *
     * @return la {@link Habilidad} obtenida al azar en la creación
     */
    public Habilidad consumir() {
        return poderAsignado;
    }

    public Personaje getPropietario() {
        return propietario;
    }

    public Habilidad getPoderAsignado() {
        return poderAsignado;
    }
}
