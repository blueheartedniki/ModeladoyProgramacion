import java.util.Random;

/**
 * 
 *poder de Mr mimo, ataques psíquicos con una barrera defensiva muy fuerte
 * 
 */
public class MrMimo implements Habilidad {

    @Override
    public String atacar(Personaje atacante, Personaje objetivo, Random random) {
        int danio = 10 + random.nextInt(6); // 10-15
        objetivo.recibirDanio(danio);
        return atacante.getNombre() + " se transforma en Mr. Mimo y le pega un psiquico a "
                + objetivo.getNombre() + " (" + danio + " de daño), le queda "
                + objetivo.getVida() + " de vida a " + objetivo.getNombre();
    }

    @Override
    public int defender(Personaje defensor, int danioRecibido) {
        
        return (int) Math.round(danioRecibido * 0.55);
    }

    @Override
    public String getNombre() {
        return "Mr. Mimo";
    }
}
