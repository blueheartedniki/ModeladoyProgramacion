import java.util.Random;

/**
 * estrategia base de Meganman:  cañón de brazo
 * 
 */
public class EstandarMeganMan implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 9 + random.nextInt(6); // 9-14
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " quiere pelea y le dispara su mega buster normalito a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        
        return (int) Math.round(danioRecibido * 0.9);
    }

    @Override
    public String getNombre() {
        return "Estándar de MeganMan";
    }
}
