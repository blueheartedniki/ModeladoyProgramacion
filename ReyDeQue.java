import java.util.Random;

/**
 * 
 * Poder de reydeque, ataques pesados de martillo con alta defensa por ser muy pesado 
 */
public class ReyDeQue implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 14 + random.nextInt(7); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " con el poder de Rey De Que le da un martillazo bien pesado a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre() + "queda bien aplastado como estampa";
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 0.75);
    }

    @Override
    public String getNombre() {
        return "Rey De Que";
    }
}
