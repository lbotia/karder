package kardex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.UIManager;
import kardex.controlador.CLogin;
import kardex.modelo.Conexion;
import kardex.modelo.Usuario;

public class Kardex
{
    public static Conexion con;
    public static Usuario user;
    
    public Kardex()
    {
        try
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            
            String [] conexion_data = new String[4];
            FileReader fr = new FileReader("conexion.dat");
            BufferedReader br = new BufferedReader(fr);
            String linea = "";
            int number = 0;
            
            while((linea = br.readLine()) != null)
            {
                conexion_data[number] = linea.substring(linea.indexOf("=") + 1, linea.length());
                number++;
                if(number > 3)
                    break;
            }
                
            con = new Conexion(conexion_data[0], conexion_data[1], conexion_data[2], conexion_data[3]);
            con.conectar();
            
            user = new Usuario();
            
            CLogin login = new CLogin();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException | FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        Kardex k = new Kardex();
    }
}
