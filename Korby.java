import java.util.Arrays;
import java.util.List;

/**
 * 
 * korby personaje que copia habilidades al comerse enemigos 
 */
public class Korby extends Personaje {

    private static final int VIDA_INICIAL = 100;

    public Korby() {
        super("Korby", VIDA_INICIAL, new EstandarKorby());
    }

    @Override
    public List<Habilidad> getPoderesDisponibles() {
        return Arrays.asList(new Zectata(), new ReyDeQue(), new Krico());
    }
}
