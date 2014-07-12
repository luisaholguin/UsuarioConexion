/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestiones;

import CapaDatos.Conexionbd;
import ClasesPojo.Usuario;
import java.sql.SQLException;

/**
 *
 * @authora: Luisa Holguin
 */
public class GestionUsuario implements IGestion {
    
        private Usuario usuario;

    public GestionUsuario() {        
        usuario=new Usuario(0,"","","");
        Conexionbd.setUsuario("root");
        Conexionbd.setClave("");
        Conexionbd.setCadenaConexion("jdbc:mysql://localhost/usuariodb");
    }
    /**
     * Get the value of usuario
     *
     * @return the value of usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Set the value of usuario
     *
     * @param usuario new value of usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void Nuevo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insertar() throws SQLException {   
        try
        {
         Conexionbd.getInstancia().conectar();
         Conexionbd.getInstancia().ejecutar("insert into usuario (Id,Nombre,Apellido,Cedula) values ("+usuario.getId()+",'"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getCedula()+"')");
        }
        catch(SQLException ex)
        {
            throw ex;
        }
        finally 
        {
            Conexionbd.getInstancia().desconectar();
        }
        
    }

    @Override
    public void Consultar() throws SQLException {
        try
        {
            Conexionbd.getInstancia().conectar();
            Conexionbd.getInstancia().ejecutar("SELECT `id`, `nombre`, `apellido`, `cedula` FROM `usuario` WHERE Id="+usuario.getId());
        }
        catch(SQLException ex)
        {
            
        }
        finally{Conexionbd.getInstancia().desconectar();}
    }

    @Override
    public void Modificar() throws SQLException {
 try
        {
            Conexionbd.getInstancia().conectar();
            Conexionbd.getInstancia().ejecutar("UPDATE `usuario` SET "
                    + "`nombre`='"+usuario.getNombre()+"',`apellido`='"+usuario.getApellido()+"',"
                    + "`cedula`='"+usuario.getCedula()+"' WHERE Id="+usuario.getId());
        }
        catch(SQLException ex)
        {
            //throw ex;
        }
        finally{Conexionbd.getInstancia().desconectar();}
    }

    @Override
    public void Eliminar() throws SQLException {
    try
        {
            Conexionbd.getInstancia().conectar();
            Conexionbd.getInstancia().ejecutar("DELETE FROM `usuario` WHERE id="+usuario.getId());
        }
        catch(SQLException ex)
        {
            //throw ex;
        }
        finally{Conexionbd.getInstancia().desconectar();} 
    }   
}
