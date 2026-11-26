package retrogamingmanager;

public abstract class GestionPersonas {
    protected Persona[] personas;
    protected int cont;
    private final String tipoPersona;

    protected GestionPersonas(Persona[] personas, String tipoPersona) {
        this.personas = personas;
        this.tipoPersona = tipoPersona;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }


    public int buscar(String identificador) {
        for (int i = 0; i < cont; i++) {
            if (identificador.equals(personas[i].getDni())) {
                return i;
            }
        }
        return -1;
    }

    protected int buscar(String identificador, int indiceExcluido) {
        for (int i = 0; i < cont; i++) {
            if (i != indiceExcluido && identificador.equals(personas[i].getDni())) {
                return i;
            }
        }
        return -1;
    }

    protected boolean indiceValido(int indice) {
        return indice >= 0 && indice < cont;
    }

    protected boolean estaLleno() {
        return cont == personas.length;
    }

    protected void agregar(Persona registro) {
        personas[cont] = registro;
        cont++;
    }

    public String eliminar(int indice) {
        if (!indiceValido(indice)) {
            return "Selecciona un " + tipoPersona + " para eliminar.";
        }
        for (int i = indice; i < cont - 1; i++) {
            personas[i] = personas[i + 1];
        }
        cont--;
        personas[cont] = null;
        return "Exitoso";
    }
}
