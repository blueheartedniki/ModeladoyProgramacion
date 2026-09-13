import java.util.Random;

/**
 * 
 *estrategia de dittuu: ataque básico antes de transformarse
 */
public class EstandarDittuu implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 7 + random.nextInt(6); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + ", que todavia no tiene forma ni nada, se avienta como puede "
                + "contra " + objetivo.getNombre() + " y le pega un chingazo bien improvisado ("
                + danio + " de daño), le queda " + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        
        return (int) Math.round(danioRecibido * 0.88);
    }

    @Override
    public String getNombre() {
        return "Estándar de Dittuu";
    }
}
