import java.util.Arrays;
import java.util.List;

/**
 * dittuu es el personaje que se transforma en lo que ve, puede usar los poderes de
  pikaPika, Mr. mimo y chorizor
 * 
 */
public class Dittuu extends Personaje {

    private static final int VIDA_INICIAL = 100;

    public Dittuu() {
        super("Dittuu", VIDA_INICIAL, new EstandarDittuu());
    }

    @Override
    public List<Habilidad> getPoderesDisponibles() {
        return Arrays.asList(new PikaPika(), new MrMimo(), new Chorizor());
    }
}
