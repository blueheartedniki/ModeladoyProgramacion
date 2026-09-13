import java.util.Random;

/**
 * poder de chorizor:ataques de fuego muy potentes y defensa media
 
 */
public class Chorizor implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 18 + random.nextInt(8); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " se transforma en Chorizor y le vomita fuego a "
                + objetivo.getNombre() + ", esta muy rostizadito (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 0.82);
    }

    @Override
    public String getNombre() {
        return "Chorizor";
    }
}
