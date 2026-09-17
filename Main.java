import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * corre un caso de prueba al azar, korby vs megaman vs dittu
 *  añade 4 espectadores y guarda sus bitácoras en la carpeta "bitacoras"  
 
*/
public class Main {

    public static void main(String[] args) {
        
        
        
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        int casoElegido = new Random().nextInt(3) + 1; // 1, 2 o 3

        System.out.println("Se seleccionó el caso de prueba " + casoElegido + " para este combate");
        System.out.println("Los detalles completos quedarán guardados en la carpeta 'bitacoras'");

        Combate combate = construirCasoDePrueba(casoElegido);
        List<Espectador> espectadores = registrarEspectadores(combate);

        Personaje ganador = combate.ejecutarCombate();

        for (Espectador espectador : espectadores) {
            espectador.agregarMensajeFinal(ganador.getNombre());
            espectador.guardarBitacora("bitacoras");
        }

        System.out.println("Terminó el combate!  El ganador es: " + ganador.getNombre());
        System.out.println("Bitácoras generadas para: ");
        for (Espectador espectador : espectadores) {
            System.out.println(" - " + espectador.getId()
                    + " (apoyaba a " + espectador.getPersonajeFavorito() + ")");
        }
    }

    /**
     * 
     * construcción del combate, crea la pelea según el caso de prueba elegido, 
     * usando una semilla distinta para cambiar el orden de poderes y el desarrollo del combate
     */
    private static Combate construirCasoDePrueba(int numeroCaso) {
        List<Personaje> peleadores = new ArrayList<>();
        peleadores.add(new Korby());
        peleadores.add(new MeganMan());
        peleadores.add(new Dittuu());

        switch (numeroCaso) {
            case 1:
                return new Combate(peleadores, "Caso de prueba 1: Arena clásica", 111L);
            case 2:
                return new Combate(peleadores, "Caso de prueba 2: Torneo relámpago", 222L);
            case 3:
            default:
                return new Combate(peleadores, "Caso de prueba 3: Duelo final", 1L);
        }
    }

    /**
     * registro de espectadores,crea 4 espectadores para seguir el combate, 
     * cada uno apoyando a un personaje
     * 
     */
    private static List<Espectador> registrarEspectadores(Combate combate) {
        List<Espectador> espectadores = new ArrayList<>();
        espectadores.add(new Espectador("Petra", "Korby"));
        espectadores.add(new Espectador("Snake", "MeganMan"));
        espectadores.add(new Espectador("Juventino", "Dittuu"));
        espectadores.add(new Espectador("Amlo", "Korby"));

        for (Espectador espectador : espectadores) {
            combate.registrar(espectador);
        }
        return espectadores;
    }
}
