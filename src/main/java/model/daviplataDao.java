package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daviplataDao { 
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int dp; //cantidad de filas que devuelve una sentencia

    public int recargar (daviplataVo dVo) throws SQLException{
 
        sql="INSERT INTO rol(descripcionRol,estadoRol) values(?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, rol.getDescripcionRol());
            ps.setBoolean(2, rol.getEstadoRol());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el rol correctamente");

        }
        catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            
            con.close();//cerrando conexión
        }
        return r;

     
    }  

    public List<daviplataVo> consultarsaldo(daviplataVo dVo) throws SQLException{ 
        List<daviplataVo> saldo=new ArrayList<>();
        sql="select  IdCuenta,saldo from  daviplata "; 
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
            daviplataVo  dp=new daviplataVo();
                //Escribir  en el setter cada valor encontrado
                dp.setIdCuenta(rs.getInt("IdCuenta"));
                dp.setSaldo(rs.getInt("saldo"));
                saldo.add(dp);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return saldo;
    } 






    
}
