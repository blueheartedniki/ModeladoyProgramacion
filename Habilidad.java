/**
 * 
 * interfaz: define las distintas formas de pelear 
 * (ataque y defensa) de un personaje en su estado básico o un poder especial
 * 
 */
public interface Habilidad {

    /**
     * 
     * aplica el ataque:calcula y aplica el daño al objetivo atacado
     *
     * @param atacante personaje que realiza el ataque
     * @param objetivo personaje que recibe el ataque
     * @param random   controla el azar de la pelea para que se pueda repetir con la misma semilla
     *                 
     *                 
     * @return descripción  del ataque, para la bitácora
     */
    String atacar(Personaje atacante, Personaje objetivo, java.util.Random random);

    /**
     * calcula el daño  que recibe un personaje después de defenderse,
     * y se refleja como se reduce en el 
     *
     * @param defensor      personaje que se defiende
     * @param danioRecibido daño  antes de la defensa
     * @return daño  que se resta a la vida del defensor
     */
    int defender(Personaje defensor, int danioRecibido);

    /**
     * @return nombre de la habilidad
     *       
     */
    String getNombre();
}
