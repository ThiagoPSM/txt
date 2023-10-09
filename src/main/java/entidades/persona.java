package entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


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
        cadenaDatos= dni +","+ nombre+","+apellido+","+edad; //estructura o modelo de como se va a guardar en el nombreArchivo
        // ahora procedemos a guardar los datos en un nombreArchivo
        FileWriter fichero;
        PrintWriter pw;
        
        try
        {
            /* el primer parametro ponemos el nombre del nombreArchivo a crear , y en el segundo si es true 
            * estamos diciendo que vamos a seguir agregando en el mismo nombreArchivo nuevos elementos
            * basicamente creamos la conexion al nombreArchivo
            */
            fichero = new FileWriter("Personas.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(cadenaDatos); // guarda en el nombreArchivo , segun el formato q nostros les pasamos en cadenaDatos
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
        String nombreArchivo = "Personas.txt";
        File file = new File(nombreArchivo);
        
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            
            String primeraLinea = br.readLine().trim();
            
            DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("DNI");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Edad");
            
            TblPersona.setModel(modelo);
            
            Object[] lineasTabla = br.lines().toArray();
            
            for (int i = 0; i < lineasTabla.length; i++) {
                String linea = lineasTabla[i].toString().trim();
                String[] datosFilas = linea.split(",");
                modelo.addRow(datosFilas);
                TblPersona.setModel(modelo);

            }
            
            
        } catch (Exception e )
        {
            JOptionPane.showMessageDialog(null, "ocurrio un error" + e.getMessage());
        }
        
    }
    
    public void seleccionarPersona(JTable tabla)
    {
        
        
        try
        {
            int fila = tabla.getSelectedRow();
        
        if(fila >= 0)
        {
            setDni(tabla.getValueAt(fila, 0).toString());
            setNombre(tabla.getValueAt(fila, 1).toString());
            setApellido(tabla.getValueAt(fila, 2).toString());
            setEdad(tabla.getValueAt(fila, 3).toString());
            
        }
       } catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, "ocurrio un error " + e.getMessage());
       }
        
        
    }
    
    public void Eliminar(JTable tablaPersona, JTextField dni)
    {
        DefaultTableModel modelo =(DefaultTableModel)tablaPersona.getModel();      
        for(int i =0; i< modelo.getRowCount(); i++)//recorre la tabla mientras i sea menor que la cantidad de columnas
        {
            if(((String)modelo.getValueAt(i, 0)).equals(dni.getText()))
  /*de la tabla se obtienen los valores de la primer columna iterando y si es igual al dni de la persona seleccionada lo elimina 
  *y sale del for */         
            {
                modelo.removeRow(i);
                break;
                //elimina visualmente 
            }
        }
        
        //limpieza del archivo
        
        try
        {
            PrintWriter wr = new PrintWriter("Personas.txt");
            wr.print("");
            wr.close();
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Ocurrio un error " +e.getMessage() );
        }
        
        //Creacion del nuevo registro luego de eliminar
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Personas.txt"))))
        {
           for(int fila=0 ; fila < tablaPersona.getRowCount(); fila++)
           {
               StringJoiner joiner = new StringJoiner(",");
               
               for(int col =0; col < tablaPersona.getColumnCount(); col++)
               {
                   Object obj = tablaPersona.getValueAt(fila, col);
                   String value = obj == null ? "null" :obj.toString();
                   joiner.add(value);
               }
               System.out.println(joiner.toString());
               bw.write(joiner.toString());
               bw.newLine();
           }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ocurrio un error " + e.getMessage());
        }
             
    }
    
   
    
    
    
}
