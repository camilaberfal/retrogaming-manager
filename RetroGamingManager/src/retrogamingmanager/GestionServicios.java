/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;


public class GestionServicios {
    
    private ServicioAdicional[] servicios;
    private int contador;
    private String mensaje;

    public GestionServicios() {
        servicios = new ServicioAdicional[100];
        contador = 0;
        mensaje = "";
    }

    public int getContador() {
        return contador;
    }

    public ServicioAdicional getServicio(int posicion) {
        if (posicion >= 0 && posicion < contador) {
            return servicios[posicion];
        }
        return null;
    }

    public String getMensaje() {
        return mensaje;
    }

   
    public ServicioAdicional buscar(String codigo) {
        if (codigo == null) {
            return null;
        }

        for (int i = 0; i < contador; i++) {
            if (servicios[i].getCodigo().equalsIgnoreCase(codigo)) {
                return servicios[i];
            }
        }
        return null;
    }

    
    public void registrar(ServicioAdicional s) {

        if (validarDatos(s) == false) {
            return;
        }

        if (contador == servicios.length) {
            mensaje = "No hay espacio para registrar más servicios.";
            return;
        }

        if (buscar(s.getCodigo()) != null) {
            mensaje = "Ya existe un servicio con ese código.";
            return;
        }

        servicios[contador] = s;
        contador++;

        mensaje = "Servicio registrado correctamente.";
    }

    
    public void modificar(String codigoOriginal, ServicioAdicional nuevo) {

        for (int i = 0; i < contador; i++) {

            if (servicios[i].getCodigo().equalsIgnoreCase(codigoOriginal)) {

                if (validarDatos(nuevo) == false) {
                    return;
                }

                ServicioAdicional encontrado = buscar(nuevo.getCodigo());

                if (encontrado != null && encontrado != servicios[i]) {
                    mensaje = "El nuevo código ya está registrado.";
                    return;
                }

                servicios[i] = nuevo;

                mensaje = "Servicio modificado correctamente.";
                return;
            }
        }

        mensaje = "No se encontró el servicio.";
    }

    
    public void eliminar(String codigo) {

        for (int i = 0; i < contador; i++) {

            if (servicios[i].getCodigo().equalsIgnoreCase(codigo)) {

                for (int j = i; j < contador - 1; j++) {
                    servicios[j] = servicios[j + 1];
                }

                servicios[contador - 1] = null;
                contador--;

                mensaje = "Servicio eliminado correctamente.";
                return;
            }
        }

        mensaje = "No se encontró el servicio.";
    }

    
    private boolean validarDatos(ServicioAdicional s) {

        if (s == null) {
            mensaje = "El servicio no puede ser nulo.";
            return false;
        }

        if (s.getCodigo() == null || s.getCodigo().trim().isEmpty()) {
            mensaje = "El código es obligatorio.";
            return false;
        }

        if (s.getNombre() == null || s.getNombre().trim().isEmpty()) {
            mensaje = "El nombre es obligatorio.";
            return false;
        }

        if (s.getPrecioUnitario() <= 0) {
            mensaje = "El precio debe ser mayor a cero.";
            return false;
        }

        if (s.getStock() < 0) {
            mensaje = "El stock no puede ser negativo.";
            return false;
        }

        return true;
    }
    
}
