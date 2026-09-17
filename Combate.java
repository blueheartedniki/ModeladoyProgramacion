import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combate implements Sujeto {

    /**
     * clase que representa un combate entre 3 personajes, cada uno con su
     * estrategia de ataque y defensa, y que puede cambiarla al obtener un
     * objeto especial
     */
/**
 * **sujeto oncreto, define la pelea entre los 3 personajes y ejecuta sus reglas 
 * avisa de cada evento a los espectadores
 


    /** probabilidad  de que aparezca un objeto especial en un turno */
    private static final int PROBABILIDAD_OBJETO = 40;

    /** numero máximo de rondas que dura un combate */
    private static final int MAX_RONDAS = 3;

    private final List<Observador> espectadores;
    private final List<Personaje> peleadores;
    private final Random random;
    private final String nombreCaso;

    /**
     * @param peleadores lista de los personajes que participan
     * @param nombreCaso nombre del caso de prueba que se realiza 
     * @param semilla    asegura que cada pelea sea diferente, pero se pueda 
     *                   repetir exactamente igual para hacer pruebas
     *                
     */
    public Combate(List<Personaje> peleadores, String nombreCaso, long semilla) {
        this.peleadores = peleadores;
        this.nombreCaso = nombreCaso;
        this.random = new Random(semilla);
        this.espectadores = new ArrayList<>();
    }

    @Override
    public void registrar(Observador obs) {
        espectadores.add(obs);
    }

    @Override
    public void remover(Observador obs) {
        espectadores.remove(obs);
    }

    @Override
    public void notificar(String mensaje) {
        for (Observador obs : espectadores) {
            obs.actualizar(mensaje);
        }
    }

    /**
     * desarrolla el combate completo, ronda por ronda, hasta que sólo quede un
     * personaje con vida y luego avisa de cada evento a los espectadores
     *
     * @return 
     */
    public Personaje ejecutarCombate() {
        notificar("=========================================");
        notificar("   BIENVENIDOS A SMASH CHINGAZOS");
        notificar("   saquen sus apuestas y prepárense para este evento");
        notificar("=========================================");
        notificar("   EMPIEZA EL COMBATE - " + nombreCaso);
        notificar("=========================================");
        for (Personaje p : peleadores) {
            notificar(p.getNombre() + " llega a la arena con " + p.getVida()
                    + " de vida, se ve confiado y el público le echa porras");
        }

        int ronda = 1;
        while (contarVivos() > 1 && ronda <= MAX_RONDAS) {
            notificar("");
            notificar("--- Ronda " + ronda + " ---");

            for (Personaje atacante : peleadores) {
                if (!atacante.estaVivo()) {
                    continue;
                }
                if (contarVivos() <= 1) {
                    break;
                }

                intentarObtenerPoder(atacante, ronda == MAX_RONDAS);

                Personaje objetivo = elegirObjetivoAleatorio(atacante);
                if (objetivo == null) {
                    continue;
                }

                String descripcionAtaque = atacante.atacar(objetivo, random);
                notificar(descripcionAtaque);

                if (!objetivo.estaVivo()) {
                    notificar(">>> uy " + objetivo.getNombre() + " quedó fuera de combate, no puede más unu <<<");
                }
            }
            ronda++;
        }

        Personaje ganador = obtenerGanador();
        notificar("");
        notificar("=========================================");
        notificar("   hay un vencedor, el publico se volvio loco!!");
        notificar("   " + ganador.getNombre() + " gana el combate con "
                + ganador.getVida() + " de vida que le quedo, que crack");
        notificar("=========================================");
        return ganador;
    }

    /**
     * efecto de objeto especial: crea el objeto de un personaje para cambiar su estrategia y 
       si no ha salido antes, aparece a fuerzas en la ultima ronda
     *
     * @param personaje       personaje que podría obtener su objeto especial
     * @param esUltimaRonda   
     */
    private void intentarObtenerPoder(Personaje personaje, boolean esUltimaRonda) {
        if (personaje.isPoderConsumido()) {
            return;
        }
        if (!esUltimaRonda && random.nextInt(100) >= PROBABILIDAD_OBJETO) {
            return;
        }
        ObjetoPoder objeto = new ObjetoPoder(personaje, random);
        Habilidad nuevaHabilidad = objeto.consumir();
        personaje.cambiarEstrategia(nuevaHabilidad);
        personaje.setPoderConsumido(true);
        notificar(mensajeObtencionPoder(personaje, nuevaHabilidad.getNombre()));
    }

    /**
     * 
     * generador de bitácora: crea historias simples de cómo cada personaje 
     * consigue su poder según sus habilidades y los de su franquicia
     * 
     * @param personaje       personaje que obtiene el poder
     * @param nombreFuente    nombre del personaje del que se obtiene el poder
     * @return                mensaje ya armado para mandar a los espectadores
     */
    private String mensajeObtencionPoder(Personaje personaje, String nombreFuente) {
        if (personaje instanceof Korby) {
            return personaje.getNombre() + " se traga a " + nombreFuente
                    + " de un bocado y le roba el poder, ahora sabe pelear igualito o mejor!";
        }
        if (personaje instanceof MeganMan) {
            return personaje.getNombre() + " vence a " + nombreFuente
                    + " en la pelea y le copia su poder al toque";
        }
        if (personaje instanceof Dittuu) {
            return personaje.getNombre() + " ve pasar a " + nombreFuente
                    + " y se transforma en el copiandole todo tal cual, cero original";
        }
        return personaje.getNombre() + " obtiene el poder de " + nombreFuente + "!";
    }

    /**
     * escoge  aun rival  al azar que no sea el propio atacante
     */
    private Personaje elegirObjetivoAleatorio(Personaje atacante) {
        List<Personaje> candidatos = new ArrayList<>();
        for (Personaje p : peleadores) {
            if (p != atacante && p.estaVivo()) {
                candidatos.add(p);
            }
        }
        if (candidatos.isEmpty()) {
            return null;
        }
        return candidatos.get(random.nextInt(candidatos.size()));
    }

    private int contarVivos() {
        int vivos = 0;
        for (Personaje p : peleadores) {
            if (p.estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }

    /**
     * resultado del combate:g ana el único sobreviviente o quien tenga más vida
     * 
     */
    private Personaje obtenerGanador() {
        List<Personaje> vivos = new ArrayList<>();
        for (Personaje p : peleadores) {
            if (p.estaVivo()) {
                vivos.add(p);
            }
        }
        if (vivos.isEmpty()) {
            return null;
        }
        Personaje ganador = vivos.get(0);
        for (Personaje p : vivos) {
            if (p.getVida() > ganador.getVida()) {
                ganador = p;
            }
        }
        return ganador;
    }
}


