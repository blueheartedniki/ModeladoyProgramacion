import java.util.Arrays;
import java.util.List;

/**
 * meganman: personaje robot que copia habilidades de enemigos derrotados 
 * 
 */
public class MeganMan extends Personaje {

    private static final int VIDA_INICIAL = 100;

    public MeganMan() {
        super("MeganMan", VIDA_INICIAL, new EstandarMeganMan());
    }

    @Override
    public List<Habilidad> getPoderesDisponibles() {
        return Arrays.asList(new LavaMan(), new Cero(), new DonProtones());
    }
}
