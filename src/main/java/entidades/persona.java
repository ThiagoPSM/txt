package entidades;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class persona {
    private String dni;
    private String nombre;
    private String apellido;
    private String edad;

    public persona() {
    }

    public persona(String dni, String nombre, String apellido, String edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    
    public void EscribirArchivo (String dni , String nombre, String apellido, String edad)
    {
        String cadenaDatos = "";
        cadenaDatos= dni +","+ nombre+","+apellido+","+edad; //estructura o modelo de como se va a guardar en el archivo
        // ahora procedemos a guardar los datos en un archivo
        FileWriter fichero;
        PrintWriter pw;
        
        try
        {
            /* el primer parametro ponemos el nombre del archivo a crear , y en el segundo si es true 
            * estamos diciendo que vamos a seguir agregando en el mismo archivo nuevos elementos
            * basicamente creamos la conexion al archivo
            */
            fichero = new FileWriter("Personas.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos); // guarda en el archivo , segun el formato q nostros les pasamos en cadenaDatos
            pw.close();
            fichero.close();
            
            JOptionPane.showConfirmDialog(null,"se guardo correctamente","informacion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            /*
            *el primer parametro dice dondde va a estar centrada la pantalla , el segunddo el texto que este
            *va a mostrar , el tercero el nombre de la pestaña , el cuarto agrega boton de confirmar y el quinto
            *agregar un icono de informacion  a la pestaña
            */
            
        } catch (Exception e)
        {
            JOptionPane.showConfirmDialog(null,"ocurrio un error","informacion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void Mostrar(JTable TblPersona)
    {
        
    }
    
   
    
    
    
}
