import java.util.Random;

/**
 *poder de Cero:ataques rápidos con sable de energía y defensa op 
 */

public class Cero implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 13 + random.nextInt(9); // 13-21
        objetivo.recibirDanio(danio);
        return "con el poder de Cero, " + atacante.getNombre() + " saca su sable de energia y le "
                + "tira un sablazo bien rapido a " + objetivo.getNombre() + " (" + danio
                + " de daño), le queda " + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 0.7);
    }

    @Override
    public String getNombre() {
        return "Cero";
    }
}
