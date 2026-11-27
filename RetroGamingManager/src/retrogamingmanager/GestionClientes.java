package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public class GestionClientes {
    private Clientes[] clientes = new Clientes[100];
    private int contador = 0; 
    public static final int COMPRAS_PARA_FRECUENTE = 5;
    
    public Clientes buscarPorDni(String DNI)
    {
        for (int i = 0; i < contador; i++) 
        {
            if (clientes[i].getDNI().equals(DNI)) return clientes[i];
        }
        return null;
    } 
    
    public String registrar(Clientes c) 
    { 
        String val = Validaciones.validarDatosCliente(c.getDNI(), c.getNombres(), c.getApellidos(), c.getTelefono(), c.getCorreo());
        if (val != null)
            return val;
        if ( buscarPorDni(c.getDNI()) != null)
            return "Se encontró DNI duplicado";
        if (contador == clientes.length) 
            return "No hay espacio para más clientes";
        if (c.getTipo() == null)
            return "Tipo no declarado";
        clientes[contador++] = c; 
        return null;
    }
    public Clientes obtener(int i)
    {
        if (i >= 0 && contador > i)
            return clientes[i];
        return null;
    }
    
    public String modificar(String DNI, String nombres, String apellidos, String telefono, String correo) 
    { 
        Clientes cliente = buscarPorDni(DNI);
        if (cliente == null)
        {
            return "No se encontró cliente con ese DNI";
        }
        String resultado = Validaciones.validarDatosCliente(DNI, nombres, apellidos, telefono, correo);
        if (resultado != null)
        {
            return resultado;
        }
        cliente.setCorreo(correo); 
        cliente.setTelefono(telefono);
        cliente.setNombres(nombres);
        cliente.setApellidos(apellidos); 
        return null;
    }
    public boolean eliminar(String DNI) 
    {
        for (int i = 0; i < contador; i++) 
        {
            if (clientes[i].getDNI().equals(DNI)) 
            {
                for (int j = i; j < contador - 1; j++) 
                {
                    clientes[j] = clientes[j+1];
                }
                contador--;
                clientes[contador] = null;
                return true;
            } 
        }
        return false;
    }
    
    private int buscarIndicePorDni(String DNI)
    {
        for (int i = 0; i < contador; i++) 
        {
            if (clientes[i].getDNI().equals(DNI)) 
            { 
                return i;
            } 
        }
        return -1;
    }
    public String registrarCompraFinalizada(String DNI)
    {
        int clienteidx = buscarIndicePorDni(DNI);
        if (clienteidx == -1)
            return "No se encontró cliente con ese DNI";
        clientes[clienteidx].sumarCompraFinalizada();
        if (clientes[clienteidx].getTipo().equals("Regular") && COMPRAS_PARA_FRECUENTE <= clientes[clienteidx].getComprasFinalizadas() )
        {
            Clientes micliente = clientes[clienteidx];
            ClienteFrecuente clientef = new ClienteFrecuente(micliente.getDNI(), micliente.getNombres(), micliente.getApellidos(), micliente.getTelefono(), micliente.getCorreo());
            clientef.setComprasFinalizadas(micliente.getComprasFinalizadas());
            clientes[clienteidx] = clientef;
        }
        return null;
    }
     
    
    public int getContador() {
        return this.contador;
    }
}
