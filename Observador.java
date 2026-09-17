/**
 * 
 * interfaz observer, define el método de
 *  actualización que reciben los espectadores cuando ocurren eventos en el combate
 */
public interface Observador {

    /**
     * se avisa cada vez que el sujeto notifica un nuevo evento
     *
     * @param mensaje descripción del evento 
     */
    void actualizar(String mensaje);
}
