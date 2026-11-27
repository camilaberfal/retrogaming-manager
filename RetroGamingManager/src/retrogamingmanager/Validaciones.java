package retrogamingmanager;

/**
 *
 * @author emmanuel
 */
public class Validaciones {
    public static boolean esVacio(String texto) 
    {
        if (texto == null || texto.trim().length() == 0)
        {
            return true;
        }
        return false;
    }
    public static boolean soloDigitos(String texto) 
    {
        if (esVacio(texto)) {
            return false;
        } 
        for (int i = 0; texto.length() > i; i++)
        {
            if (!(texto.charAt(i) >= '0' && '9' >= texto.charAt(i) ))
            {
                return false;
            }
         }
         return true; 
    }
    
    public static boolean tieneLongitud(String texto, int entero) 
    {
        if (texto == null) {
            return false;
        } 
        if (texto.length() != entero) {
            return false;
        }  
        return true;
    }
    
    public static boolean esCorreoValido(String texto) 
    { 
        if (esVacio(texto) ) {
            return false;
        } 
        int arrobas = 0;
        int arroba_pos = 0;
        int puntoDespuesArroba = 0;
        for (int a=0; texto.length()>a;a++)
        {
            if (' ' == texto.charAt(a))
            { 
                return false;  
            }
            if ('@' == texto.charAt(a))
            {
                arrobas ++;
                arroba_pos = a;
                if (a == 0)
                    return false; 
                if (a == texto.length()-1)
                    return false; 
                continue;
            }
             if ('.' == texto.charAt(a) && arrobas > 0 )
            {
                puntoDespuesArroba ++;
                if (a == arroba_pos + 1 || a == texto.length() - 1)
                    return false;  
            }
        }
        if (arrobas == 1 && puntoDespuesArroba >= 1)
        {
            return true;
        } 
        return false;
    }
    
    
    public static boolean esTipoClienteValido(String texto) 
    { 
        if (texto == null)
            return false;
        if (texto.equals("Regular") || texto.equals("Coleccionista Frecuente")) 
            return true;   
        return false;
    }
    
    public static boolean esRolValido(String texto) 
    { 
        if (texto == null)
            return false;
        if (texto.equals("Administrador") || texto.equals("Vendedor") || texto.equals("Almacenero")) 
            return true;  
        return false;
    } 
    
    
    
    
    public static String validarObligatorio(String texto, String Campo) 
    { 
        if (esVacio(texto)) 
            return "El campo " + Campo + " es obligatorio"; 
        return null;
    }
    
    public static String validarDNI(String texto) 
    { 
        String obl = validarObligatorio(texto, "DNI");
        if (obl != null) 
            return obl; 
        if (!soloDigitos(texto)) 
            return "El DNI solo debe contener digitos"; 
        if (!tieneLongitud(texto, 8)) 
            return "El DNI debe tener 8 dígitos"; 
        return null;
    } 
    
    
    public static String validarTelefono(String texto) 
    {  
        String obl = validarObligatorio(texto, "Telefono");
        if (obl != null) 
            return obl; 
        if (!soloDigitos(texto)) 
            return "El teléfono solo debe contener números"; 
        if (!tieneLongitud(texto, 9)) 
            return "El teléfono debe tener 9 dígitos"; 
        return null;
    } 
    
    public static String validarCorreo(String texto) 
    { 
        
        String obl = validarObligatorio(texto, "Correo");
        if (obl != null) 
            return obl; 
        if (!esCorreoValido(texto)) 
            return "El correo no tiene un formato válido";  
        return null;
    } 
    
    public static String validarDatosCliente(String DNI, String nombres, String apellidos, String telefono, String correo) 
    { 
        String[] miarray = new String[5];
        miarray[0] = validarDNI(DNI); 
        miarray[1] = validarObligatorio(nombres, "nombre");
        miarray[2] = validarObligatorio(apellidos, "apellidos");
        miarray[3] = validarTelefono(telefono);
        miarray[4] = validarCorreo(correo);  
        for (int a = 0; miarray.length > a ; a ++)
        {
            if (miarray[a] != null)
            {
                return miarray[a];
            }
        }
        return null;
    } 
    
    public static String validarDatosEmpleado(String DNI, String nombres, String apellidos, String usuario, String password, String rol) 
    { 
        
        String[] miarray = new String[6];
        miarray[0] = validarDNI(DNI); 
        miarray[1] = validarObligatorio(nombres, "nombre");
        miarray[2] = validarObligatorio(apellidos, "apellidos");
        miarray[3] = validarObligatorio(usuario, "usuario");
        miarray[4] = validarObligatorio(password, "contraseña");  
        miarray[5] = null;  
        if (!esRolValido(rol))
        {
            miarray[5] = "El rol debe ser Administrador, Vendedor o Almacenero";
        }
        for (int a = 0; miarray.length > a ; a ++)
        {
            if (miarray[a] != null)
            {
                return miarray[a];
            }
        }
        return null;
    } 
    
} 