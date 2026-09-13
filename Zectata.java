import java.util.Random;

/**
 * 
 * poder de zectata, ataques mágicos  muy poderoso  con poca defensa 
 */
public class Zectata implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 16 + random.nextInt(8); // 16-23
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " usa el poder de Zectata y le tira unos petalos re filosos a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        // Poder ofensivo, casi no protege.
        return (int) Math.round(danioRecibido * 1.05);
    }

    @Override
    public String getNombre() {
        return "Zectata";
    }
}
