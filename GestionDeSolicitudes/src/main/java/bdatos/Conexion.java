/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatos;

import com.mysql.jdbc.Driver;
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Conexion
{
	/* Variables */
	
	long tiempo_inicio = -1;
  	long tiempo_total = 0;
  	
  	private final static String url ="jdbc:mysql://localhost:3310/gestionsolicitud"+"?useUnicode=true&use"
                +"JDBCCompilantTimezoneShift=true&useLegacyDatetimecode=false&"
                +"serverTimezone=UTC"; //local
  	//private final static String url ="jdbc:mysql://174.121.232.85:3306/biarmonias"; // produccion
	private String usuario="root";	
	private String password="";
	private final static String driver = "com.mysql.cj.jdbc.Driver";			
	private String error;
	// logs halcon
	//public String ruta_logs="/usr/local/apache-tomcat-6.0.2/webapps/consultas_rh/administracion/logs.html";
	
	// ruta jboss local
	//public String ruta_logs="/var/www/vhosts/clubbioarmonias.com/httpdocs/logs.html";
	//public String ruta_logs="/clubbioarmonias/logs.html";
	//public String ruta_logs="/usr/share/tomcat5/webapps/clubbioarmonias.war/administracion/logs.html"; // ruta hosting
	
	// pc casa
	//public String ruta_logs="E:/workspace/clubbioarmonias/WebContent/administracion/logs.html";
	
	// portatil
	public String ruta_logs="/jbdevstudio/jboss-eap/jboss-as/server/default/deploy/clubbioarmonias/administracion/logs.html";
	
	//public String ruta_logs="/var/www/vhosts/sotraexsa.com/httpdocs/ecolsi/clubbioarmonias/logs/logs.html";

	// logs dodo
	//public String ruta_logs="/home/users/tomcat/jakarta-tomcat-5.0.28/webapps/encardi/administracion/logs.html";
	
	private Connection con;
	private CallableStatement cs;
	private PreparedStatement ps;	
	private ResultSet rst;
        
	
	public Conexion()
	{		
		super();
	}
	
	public Conexion(String usuario,String clave) throws java.sql.SQLException
	{		
		super();
		setusuario(usuario);
		setclave(clave);		
	}		
	
	public void setusuario(String usuario)
	{
		this.usuario=usuario;		
	}

	public void setclave(String clave)
	{
		this.password=clave;		
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	// Obtener conexion. 
	public Connection conectar(String pagina) throws java.sql.SQLException
	{						
		try
		{
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,usuario,password);
			this.escribirLogsCon(pagina);
                        System.out.println("se conecto");
		}
		catch(Exception e)
		{
			this.escribirLogs("Conexion","conectar()",e.toString());
                        System.out.println("no se conecto");
		}
		return this.con;
	}
	
	// Asignar conexion.
	public void setConnection (Connection conex)
	{
		this.con= conex;	
	}
	
	// Cerrar la conexión
	public void cerrarConexion()
	{
		
		try
		{		
			if (this.rst!=null) this.rst.close();
			if (this.ps!=null) this.ps.close();
			if (this.cs!=null) this.cs.close();
						
			this.rst= null;
			this.ps= null;
			this.cs=null;
			
			this.con.close();
			this.con=null;
		}
		catch(Exception e)
		{
			this.escribirLogs("Conexion", "cerrarConexion()",e.toString());
		}
		
	}  		
	
	// Método para logs de conexiones de los usuarios.
	public void escribirLogsCon(String nombre_pagina)
	{
		try
		{
			java.util.Date tiempo=new java.util.Date();
			SimpleDateFormat formato_fecha=new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formato_hora=new SimpleDateFormat("h:mm a");
			FileWriter fw = new FileWriter(this.ruta_logs,true);
			fw.write(formato_fecha.format(tiempo)+" "+formato_hora.format(tiempo)+" >> Conexion del usuario: "+ this.usuario+" pagina: "+nombre_pagina+"<br><br>");
			fw.close();
		}
		catch(Exception e)
		{
			this.escribirLogs("Conexion", "escribirLogsCon()",e.toString());
		}
	}
		
	/* Método que registra los errores presentados en el sistema */
	public void escribirLogs(String nombre_clase, String nombre_pagina,String mensaje_error)
	{
		try
		{
			java.util.Date tiempo=new java.util.Date();
			SimpleDateFormat formato_fecha=new SimpleDateFormat("dd MMMM yyyy");
			SimpleDateFormat formato_hora=new SimpleDateFormat("h:mm a");
			FileWriter fw = new FileWriter(this.ruta_logs,true);
			fw.write(formato_fecha.format(tiempo)+" "+formato_hora.format(tiempo)+" >> Error en la clase: "+nombre_clase+" de: "+nombre_pagina+ ": " +mensaje_error+"<br><br>");
			fw.close();
			
			this.error = mensaje_error;
		}
		catch(Exception e)
		{
			System.err.println("Error en el método escribirLogs: "+e.toString());
		}
	}
	
	/* Método que permite iniciar el cronometro */
	public void iniciarCronometro()
	{
		tiempo_inicio = System.currentTimeMillis();
		tiempo_total=0;
	}

	/* Método que permite detener el cronometro */
	public void detenerCronometro()
	{
		tiempo_total = System.currentTimeMillis() - tiempo_inicio;
	}

	/* Método que permite calcular el tiempo total de ejecución para un proceso */
	public long getTiempoTotal()
	{
		return tiempo_total;
	}
	
	public Connection getConnection()
	{
		return this.con;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Conexion))
			return false;
		final Conexion other = (Conexion) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}