/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;


public class GestionJuguetes {
    
    private Juguete[] juguetes;
    private int contador;
    private String mensaje;

    public GestionJuguetes() {
        juguetes = new Juguete[100];
        contador = 0;
        mensaje = " ";
    }
    
    
    public int getContador() {
        return contador;
    }

    public Juguete getJuguete(int posicion) {
        if (posicion >= 0 && posicion < contador) {
            return juguetes[posicion];
        }
        return null;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    public Juguete buscar(String codigo){
        for(int i = 0; i < contador; i++){
            if(juguetes[i].getCodigo().equalsIgnoreCase(codigo)){
                return juguetes[i];
            }
        }
        return null;
    }
    
    public void registrar(Juguete j) {
        if (validarDatos(j) == false) {
            return;
        }

        if (contador == juguetes.length) {
            mensaje = "No hay espacio para registrar más juguetes.";
            return;
        }

        if (buscar(j.getCodigo()) != null) {
            mensaje = "Ya existe un juguete con ese código.";
            return;
        }

        juguetes[contador] = j;
        contador++;

        mensaje = "Juguete registrado correctamente.";
    }
    
    
    public void modificar(String codigoOriginal, Juguete nuevo) {
        for (int i = 0; i < contador; i++) {
            if (juguetes[i].getCodigo().equalsIgnoreCase(codigoOriginal)) {

                if (validarDatos(nuevo) == false) {
                return;
                }

                Juguete encontrado = buscar(nuevo.getCodigo());

                if (encontrado != null && encontrado != juguetes[i]) {
                    mensaje = "El nuevo código ya está registrado.";
                    return;
                }

                juguetes[i] = nuevo;

                mensaje = "Juguete modificado correctamente.";
                return;
            }
        }

        mensaje = "No se encontró el juguete.";
    }
    
    
    public void eliminar(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (juguetes[i].getCodigo().equalsIgnoreCase(codigo)) {

                for (int j = i; j < contador - 1; j++) {
                    juguetes[j] = juguetes[j + 1];
                }

                juguetes[contador - 1] = null;
                contador--;

                mensaje = "Juguete eliminado correctamente.";
                return;
            }
        }

        mensaje = "No se encontró el juguete.";
    }
    
    
    
    private boolean validarDatos(Juguete j) {
        if (j == null) {
            mensaje = "El juguete no puede ser nulo.";
            return false;
        }

        if (j.getCodigo() == null || j.getCodigo().trim().isEmpty()) {
            mensaje = "El código es obligatorio.";
            return false;
        }

        if (j.getNombre() == null || j.getNombre().trim().isEmpty()) {
            mensaje = "El nombre es obligatorio.";
            return false;
        }

        if (j.getAnioFabricacion() <= 0 || j.calcularAntiguedad() < 0) {
            mensaje = "El año de fabricación no es válido.";
            return false;
        }

        if (j.getPrecioBase() <= 0) {
            mensaje = "El precio debe ser mayor a cero.";
            return false;
        }

        if (j.getStock() < 0) {
            mensaje = "El stock no puede ser negativo.";
            return false;
        }

        if (j.getEstado() == null) {
            mensaje = "El estado es obligatorio.";
            return false;
        }
        
        if (j.getEstado().equalsIgnoreCase("Disponible") == false && j.getEstado().equalsIgnoreCase("Vendido") == false && j.getEstado().equalsIgnoreCase("En Restauración") == false) {
            mensaje = "El estado ingresado no es válido.";
            return false;
        }

        return true;
    }
    
    
    
}
