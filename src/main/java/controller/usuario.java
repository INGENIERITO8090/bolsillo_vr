package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import java.util.List;
import model.usuarioDao;
import model.usuarioVo;

 public class usuario  extends HttpServlet{ 

    usuarioVo r=new usuarioVo();
    usuarioDao rd=new usuarioDao();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 

        System.out.println("Entró al Doget");
        String a=req.getParameter("accion");
         switch (a){
        case"listar":
        listar(req, resp);
        break;
         }
     

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch ( a) {
           case"registrar": 
          System.out.println("registrar");
            add(req, resp);


    }
} 
private void add(HttpServletRequest req, HttpServletResponse resp) { 
        
        System.out.println("registrando");

        if(req.getParameter("N_documento")!=null){
            r.setN_documento( Integer.parseInt(req.getParameter("N_documento")));
        }
        if(req.getParameter("NombreUsuario")!=null){
            r.setNombreUsuario(req.getParameter("NombreUsuario"));
        }
        if(req.getParameter("ContrasenaUsuario")!=null){
            r.setConstrasenaUsuario(req.getParameter("ContrasenaUsuario"));
        }
        if(req.getParameter("NumeroCelularUsuario")!=null){
            r.setNumeroCelularUsuario( Integer.parseInt(req.getParameter("NumeroCelularUsuario")));
        } 

        if(req.getParameter("chkestado")!=null){
            r.setEstadoUsuario(Boolean.parseBoolean(req.getParameter("EstadoUsuario")));
        }


        else{
            r.setEstadoUsuario(false);
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
   
      }



    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario = rd.listar();
            req.setAttribute("usuarios",usuario);
            req.getRequestDispatcher("views/usuario.jsp").forward(req, resp); 
            System.out.println(usuario);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }}
