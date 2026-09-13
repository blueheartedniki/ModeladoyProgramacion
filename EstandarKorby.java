import java.util.Random;

/**
 * 
 estrategia de korby: ataca escupiendo una estrella y se defiende inflandose
 * 
 */
public class EstandarKorby implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 8 + random.nextInt(6); // 8-13
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " infla los cachetes bien fuerte y le escupe una estrella a "
                + objetivo.getNombre() + ",PUM (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        // Se infla como globo, amortiguando un poco el golpe.
        return (int) Math.round(danioRecibido * 0.85);
    }

    @Override
    public String getNombre() {
        return "Estándar de Korby";
    }
}
