import java.util.List;
import java.util.Random;

/**
 * clase personaje para manejar la estrategia de combate 
 * activa de un personaje y permite cambiarla al consumir un objeto
 */
public abstract class Personaje {

    
    protected String nombre;

    
    protected int vida;

    protected Habilidad estrategiaActual;

    protected final Habilidad estrategiaEstandar;

    /** ndica si ya consumio su objeto especial durante la pelea */
    
    
    protected boolean poderConsumido;

    /**
     * @param nombre             nombre del personaje
     * @param vidaInicial        puntos de vida con los que inicia el combate
     * @param estrategiaEstandar comportamiento del personaje
     */
    public Personaje(String nombre, int vidaInicial, Habilidad estrategiaEstandar) {
        this.nombre = nombre;
        this.vida = vidaInicial;
        this.estrategiaEstandar = estrategiaEstandar;
        this.estrategiaActual = estrategiaEstandar;
        this.poderConsumido = false;
    }

    /**
     *cambia el comportamiento de combate (ataque y defensa) del personaje al tener una nueva habilidad
     *
     
     * @param nuevaHabilidad nueva estrategia a utilizar
     */
    public void cambiarEstrategia(Habilidad nuevaHabilidad) {
        this.estrategiaActual = nuevaHabilidad;
    }

    /**
     * @param objetivo personaje al que se ataca
     * @param random   
     * @return descripción del ataque
     */
    public String atacar(Personaje objetivo, Random random) {
        return estrategiaActual.atacar(this, objetivo, random);
    }

    /**
     * baja los puntos de salud del personaje segun el daño recibido según el valor
     * de su  defensa de su estrategia 
     *
     * @param danioBruto daño antes de aplicar la defensa
     */
    public void recibirDanio(int danioBruto) {
        int danioNeto = estrategiaActual.defender(this, danioBruto);
        if (danioNeto < 0) {
            danioNeto = 0;
        }
        vida -= danioNeto;
        if (vida < 0) {
            vida = 0;
        }
    }

    /** @return {@code true} si el personaje sigue con vida */
    public boolean estaVivo() {
        return vida > 0;
    }

    /**
     * @return la lista de las 3 habilidades que puede obtener 
     *          
     */
    public abstract List<Habilidad> getPoderesDisponibles();

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public Habilidad getEstrategiaActual() {
        return estrategiaActual;
    }

    public Habilidad getEstrategiaEstandar() {
        return estrategiaEstandar;
    }

    public boolean isPoderConsumido() {
        return poderConsumido;
    }

    public void setPoderConsumido(boolean poderConsumido) {
        this.poderConsumido = poderConsumido;
    }
}
