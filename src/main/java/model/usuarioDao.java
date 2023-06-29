package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDao {
    
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int registrar(usuarioVo usuario) throws SQLException{
        sql="INSERT INTO usuario(N_documento,Nombreusuario,ConstrasenaUsuario,NumeroCelularUsuario,EstadoUsuario) values(?,?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, usuario.getN_documento());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getConstrasenaUsuario());
            ps.setInt(4, usuario.getNumeroCelularUsuario());
            ps.setBoolean(5, usuario.getEstadoUsuario());;
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el rol correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public List<usuarioVo> listar() throws SQLException{
        sql="SELECT *from usuario";
        List<usuarioVo> usuario=new ArrayList<>();
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                 usuarioVo r =new usuarioVo();  
                 /*   r.setIdRol(rs.getInt("idRolUsuario"));
                r.setDescripcionRol(rs.getString("descripcionRolUsuario"));
                r.setEstadoRol(rs.getBoolean("estadoRolUsuario")); */

                //Escribir  en el setter cada valor encontrado
                    r.setIdUsuario(rs.getInt("IdUsuario")); 
                    
                    r.setN_documento(rs.getInt("N_documento"));
                
                    r.setNombreUsuario(rs.getString("NombreUsuario"));
                
                    r.setConstrasenaUsuario(rs.getString("ConstrasenaUsuario")); 
                 
                    r.setNumeroCelularUsuario(rs.getInt("NumeroCelularUsuario")); 
           
                    r.setEstadoUsuario(rs.getBoolean("EstadoUsuario")); 
                     usuario.add(r);
            
            } 
             /* for(usuarioVo lis:usuario ){
                     System.out.println("datos lista"+lis.getNombreUsuario()+lis.getConstrasenaUsuario()+lis.getIdUsuario());
                    } 
           
                           
             System.out.println();
                    System.out.println(r); 
                    System.out.println("tamaño lista"+usuario.size());
                    System.out.println(usuario.get(0).getIdUsuario());*/ 
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usuario;
    }


}

