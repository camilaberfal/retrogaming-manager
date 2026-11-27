package retrogamingmanager;

/**
 *
 * @author camila
 */
public class Fecha {
    public static Fecha hoy() {
        java.util.Calendar reloj = java.util.Calendar.getInstance();
        return new Fecha(reloj.get(java.util.Calendar.YEAR), reloj.get(java.util.Calendar.MONTH) + 1, reloj.get(java.util.Calendar.DAY_OF_MONTH));
    }

    private final int anio;
    private final int mes;
    private final int dia;

    public Fecha(int anio, int mes, int dia) {
        if (anio < 1 || mes < 1 || mes > 12 || dia < 1 || dia > diasDelMes(anio, mes)) {
            throw new IllegalArgumentException("La fecha no es válida.");
        }
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    private static int diasDelMes(int anio, int mes) {
        if (mes == 2) {
            if (anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)) {
                return 29;
            }
            return 28;
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }
        return 31;
    }

    public long enDias() {
        long aniosCompletos = anio - 1L;
        long dias = aniosCompletos * 365 + aniosCompletos / 4
                - aniosCompletos / 100 + aniosCompletos / 400;
        for (int i = 1; i < mes; i++) {
            dias += diasDelMes(anio, i);
        }
        return dias + dia;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}
