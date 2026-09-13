import java.util.Random;

/**
 * 
 * poder de krico:ataques eléctricos con nubes y defensa media 
 */
public class Krico implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 12 + random.nextInt(9); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " usa el poder de Krico y le manda un rayote fuerte a "
                + objetivo.getNombre() + " desde una nube (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 0.8);
    }

    @Override
    public String getNombre() {
        return "Krico";
    }
}
