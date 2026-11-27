/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public class GestionPersonal {
    private Empleados[] empleados = new Empleados[100];
    private int contador = 0; 
    
    public Empleados buscarPorDni(String DNI)
    {
        for (int i = 0; i < contador; i++) 
        {
            if (empleados[i].getDNI().equals(DNI)) return empleados[i];
        }
        return null;
    }
    public Empleados buscarPorUsuario(String usuario)
    {
        for (int i = 0; i < contador; i++) 
        {
            if (empleados[i].getUsuario().equals(usuario)) return empleados[i];
        }
        return null;
    }
    public String registrar(Empleados c) 
    {
        String val = Validaciones.validarDatosEmpleado(c.getDNI(), c.getNombres(), c.getApellidos(), c.getUsuario(), c.getPassword(), c.getRol());
        if (val != null)
            return val; 
        if ( buscarPorDni(c.getDNI()) != null || buscarPorUsuario(c.getUsuario()) != null)
            return "Se encontró DNI o Usuario duplicado";
        if (contador == empleados.length) 
            return "No hay espacio para más personal"; 
        empleados[contador++] = c; 
        return null;
    }
    
    public Empleados validarLogin(String usuario, String clave)
    {
        for (int i = 0; i < contador; i++) 
        {
            if (empleados[i].getUsuario().equals(usuario) && empleados[i].getPassword().equals(clave)) return empleados[i];
        }
        return null;
    } 
    
    public Empleados obtener(int i)
    {
        if (i >= 0 && contador > i)
            return empleados[i];
        return null;
    }
    
    public String modificar(String DNI, String nombres, String apellidos, String usuario, String password, String rol) 
    {
        Empleados empleado = buscarPorDni(DNI); 
        if (empleado == null)
        {
            return "No se encontró empleado con ese DNI";
        }
        String res = Validaciones.validarDatosEmpleado(DNI, nombres, apellidos, usuario, password, rol);
        if (res != null)
        {
            return res;
        } 
        if (usuario.equals(empleado.getUsuario()) == false )
        {
            if (buscarPorUsuario(usuario) == null) 
            { 
                empleado.setUsuario(usuario); 
            } 
            else
            { 
                return "Error modificando nombre de usuario: nombre de usuario ya usado";
            }
         }
        empleado.setPassword(password);
        empleado.setRol(rol);
        empleado.setNombres(nombres);
        empleado.setApellidos(apellidos); 
        
        return null;
    }
    public boolean eliminar(String DNI) 
    {
        for (int i = 0; i < contador; i++) 
        {
            if (empleados[i].getDNI().equals(DNI)) 
            {
                for (int j = i; j < contador - 1; j++) 
                {
                    empleados[j] = empleados[j+1];
                }
                contador--;
                empleados[contador] = null;
                return true;
            } 
        }
        return false;
    }
    public int getContador() {
        return this.contador;
    }
}
