import java.util.Random;

/**
 * poder de pikapika:aaques eléctricos,  con defensa débil
 * 
 */
public class PikaPika implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 15 + random.nextInt(10); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " se transforma en PikaPika y le suelta un impactrueno a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 0.95);
    }

    @Override
    public String getNombre() {
        return "PikaPika";
    }
}
