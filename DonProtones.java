import java.util.Random;

/**
 * poder de Don Protones, tiene Proto Buster y un buen escudo 
 * 
 * 
 */
public class DonProtones implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 12 + random.nextInt(7); // 12-18
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " con el poder de Don Protones le dispara su proto buster a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        // Usa su escudo característico.
        return (int) Math.round(danioRecibido * 0.65);
    }

    @Override
    public String getNombre() {
        return "Don Protones";
    }
}
