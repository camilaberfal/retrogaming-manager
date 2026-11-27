package retrogamingmanager;

/**
 *
 * @author camila
 */
public class Hora {
    private final int hora;
    private final int minuto;

    public Hora(int hora, int minuto) {
        if (hora < 0 || hora > 23 || minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("La hora no es válida.");
        }
        this.hora = hora;
        this.minuto = minuto;
    }

    public int enMinutos() {
        return hora * 60 + minuto;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }
}
