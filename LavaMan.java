import java.util.Random;

/**
 * 
 * poder de lavaman: ataques de lava de gran daño y defensa baja por vulnerabilidad al calor
 */
public class LavaMan implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 17 + random.nextInt(8); 
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " con el poder de Lava Man le avienta una bola de lava a "
                + objetivo.getNombre() + ", UFF (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        return (int) Math.round(danioRecibido * 1.0);
    }

    @Override
    public String getNombre() {
        return "Lava Man";
    }
}
