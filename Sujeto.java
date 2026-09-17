/**
 * INterfaz::  mantiene la lista de observadores
 *  del combate y maneja  su seguimiento al combate
 * 
 */
public interface Sujeto {

    /**
     * registra un observador para que reciba las notificaciones del combate
     *
     * @param obs 
     */
    void registrar(Observador obs);

    /**
     * elimina un observador de la lista de notificados
     *
     * @param obs 
     */
    void remover(Observador obs);

    /**
     * avisa a todos los observadores registrados con un mensaje sobre lo
     * que pasa en el combate
     *
     * @param mensaje 
     */
    void notificar(String mensaje);
}
