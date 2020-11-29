package com.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.entities.*;
import com.exception.ServiciosException;
import com.servicios.*;




@SuppressWarnings("unused")
public class ClienteProyecto{


	public static void main(String[] args) throws NamingException {
		
	}
	
	//Funciones
	
	//Usuario
	public void UAdd(String nombre,String apellido,String email,String usuario,String pass,int per) throws ServiciosException{
		try {
			User().AltaUsuario(nombre, apellido, pass, email, per, usuario);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void UDel(int id) throws ServiciosException {
		try {
			User().BorrarUsuario(id);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void Umod(int ID,String nombre,String apellido,String email,String usuario,String pass,int per) throws ServiciosException {
		try {
			User().ModificarUsuario(ID, nombre, apellido, pass, email, per, usuario);
		} catch (NamingException e) {
			
		}
	}
	
	public void Umod(int ID,int per) throws ServiciosException {
		try {
			User().ModificarUsuario(ID, per);
		} catch (NamingException e) {
			
		}
	}
	
	
	public List<Usuario> Uget() throws ServiciosException{
		 try {
			return User().GetALL();
		} catch (NamingException e) {
			return null;
		}
	}
	
	
	public Usuario Log(String usuario, String contraseña) throws ServiciosException{
		
		try {
			Usuario usr = User().Login(usuario, contraseña);
			return usr;
		} catch (NamingException e) {
			
			return null;
		}
		
	}
	
	public void ModMyUsr(long id,String pass) throws ServiciosException{
		try {
			User().ModificarUsuario(id, pass);
		} catch (NamingException e) {
			System.out.println("Error al modificar la contraseña :"+e.getMessage());
		}
		
	}
	
	
	//Caracteristicas
	
	
	//Departamento
	
	public List<Departamento> DeptoGet() throws ServiciosException{
		try {
			return Departamento().GetALL();
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
			return null;
		}
		
	}
	
	public static void DeptoAdd(String nombre,long id_zona) throws ServiciosException{
		try {
			Departamento().AltaDepartamento( nombre, id_zona);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void DeptoDel(long ID) throws ServiciosException{
		try {
			Departamento().BorrarDepartamento(ID);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void DeptoMod(long ID,String nombre) throws ServiciosException{
		try {
			Departamento().Modificardepartamento(ID, nombre);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	//Detalle
	
	//Fenomeno
	public List<Fenomeno> FGet() throws ServiciosException{
		try {
			return Fen().GetALL();
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
			return null;
		}
		
	}
	
	public static void FAdd(String nombre,String descripcion,int tel) throws ServiciosException{
		try {
			Fen().AltaFenomeno( nombre, descripcion, tel);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void FDel(int ID) throws ServiciosException{
		try {
			Fen().BorrarFenomeno(ID);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void FMod(int ID,String nombre,String descripcion,int tel) throws ServiciosException{
		try {
			Fen().ModificarFenomeno(ID, nombre, descripcion, tel);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	//Imagenes
	public void AddImg(byte[]img,String formato) throws ServiciosException{
		try {
			Img().AltaImagen(1, img, 1,formato);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	//Localidad
	public List<Localidad> Getloc() throws ServiciosException{
		try {
			return Loc().GetALL();
		} catch (NamingException e) {
			return null;
		}
		
	}
	
	
	public static void LocAdd( String nombre, String geo, long id_dep) throws ServiciosException{
		try {
			Loc().AltaLocalidad( nombre, geo, id_dep);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void LocDel(long ID) throws ServiciosException{
		try {
			Loc().BorrarLocalidad(ID);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	public  void LocMod(long ID,String nombre,String geo) throws ServiciosException{
		try {
			Loc().ModificarLocalidad(ID, nombre, geo);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error :/r/n" + e.getMessage());
		}
	}
	
	//Observacion
	public void AddObs(int estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user)throws ServiciosException {
		try {
			Obs().AltaObservacion(estado, desc, fecha, geo, id_fen, id_loc, id_user);;
		} catch (NamingException e) {
			System.out.println("A ocurrido un error : /n"+e.getMessage());
		}
	}
	
	public void ModObs(long id,long estado,String desc, Date fecha,String geo,long id_fen, long id_loc,long id_user)throws ServiciosException {
		try {
			Obs().ModificarObservacion(id, estado, desc, fecha, geo, id_fen, id_loc, id_user);;
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void DelObs(int id)throws ServiciosException {
		try {
			Obs().BorrarObservacion(id);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Observacion> GetObs()throws ServiciosException {
		try {
			return Obs().GetALL();
		} catch (NamingException e) {
			return null;
		}
	}
	
	public List<Observacion> GetObs(int id)throws ServiciosException {
		try {
			return Obs().GetALL(id);
		} catch (NamingException e) {
			return null;
		}
	}
	
	public List<Observacion> Getfilt(int id)throws ServiciosException, NamingException {
		return Obs().ObsFilt(id);
	}
	
	//Revisa
	
	//Zona
	
	public void AddZona(String nombre)throws ServiciosException {
		try {
			Zone().AltaZona( nombre);
		} catch (NamingException e) {
			System.out.println("A ocurrido un error : /n"+e.getMessage());
		}
	}
	
	public void ModZona(int id,String nombre)throws ServiciosException {
		try {
			Zone().ModificarZona(id, nombre);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void DelZona(long id)throws ServiciosException {
		try {
			Zone().BorrarZona(id);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Zona> GetZonas()throws ServiciosException {
		try {
			return Zone().GetALL();
		} catch (NamingException e) {
			return null;
		}
	}
	
	/*public List<Observacion> GetZona(int id)throws ServiciosException {
		try {
			return Zone().Get(id);
		} catch (NamingException e) {
			return null;
		}
	}*/
	
	
	
	//Fin Funciones
	

	
	
	//BEANS
	public static UsuarioBeanRemote User() throws NamingException {
		UsuarioBeanRemote UB=(UsuarioBeanRemote)
				InitialContext.doLookup("ProyectoEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");
		return UB;
	}
	public static CaracteristicaBeanRemote Car() throws NamingException {
		CaracteristicaBeanRemote UB=(CaracteristicaBeanRemote)
				InitialContext.doLookup("ProyectoEJB/CaracteristicaBean!com.servicios.CaracteristicaBeanRemote");
		return UB;
	}
	public static DepartamentoBeanRemote Dep() throws NamingException {
		DepartamentoBeanRemote UB=(DepartamentoBeanRemote)
				InitialContext.doLookup("ProyectoEJB/DepartamentoBean!com.servicios.DepartamentoBeanRemote");
		return UB;
	}
	public static DetalleBeanRemote Det() throws NamingException {
		DetalleBeanRemote UB=(DetalleBeanRemote)
				InitialContext.doLookup("ProyectoEJB/DetalleBean!com.servicios.DetalleBeanRemote");
		return UB;
	}
	public static FenomenoBeanRemote Fen() throws NamingException {
		FenomenoBeanRemote FB=(FenomenoBeanRemote)
				InitialContext.doLookup("ProyectoEJB/FenomenoBean!com.servicios.FenomenoBeanRemote");
		if(FB!=null)System.out.println("FB Lokup encontrado!");
		else System.out.println("FB Lokup fallo!");
		return FB;
	}
	
	public static ImagenesBeanRemote Img() throws NamingException {
		ImagenesBeanRemote UB=(ImagenesBeanRemote)
				InitialContext.doLookup("ProyectoEJB/ImagenesBean!com.servicios.ImagenesBeanRemote");
		return UB;
	}
	public static LocalidadBeanRemote Loc() throws NamingException {
		LocalidadBeanRemote UB=(LocalidadBeanRemote)
				InitialContext.doLookup("ProyectoEJB/LocalidadBean!com.servicios.LocalidadBeanRemote");
		return UB;
	}
	public static ObservacionBeanRemote Obs() throws NamingException {
		ObservacionBeanRemote UB=(ObservacionBeanRemote)
				InitialContext.doLookup("ProyectoEJB/ObservacionBean!com.servicios.ObservacionBeanRemote");
		return UB;
	}
	public static RevisaBeanRemote Rev() throws NamingException {
		RevisaBeanRemote UB=(RevisaBeanRemote)
				InitialContext.doLookup("ProyectoEJB/RevisaBean!com.servicios.RevisaBeanRemote");
		return UB;
	}
	public static ZonaBeanRemote Zone() throws NamingException {
		ZonaBeanRemote UB=(ZonaBeanRemote)
				InitialContext.doLookup("ProyectoEJB/ZonaBean!com.servicios.ZonaBeanRemote");
		return UB;
	}
	//DEPARTAMENTO
	public static DepartamentoBeanRemote Departamento() throws NamingException {
		DepartamentoBeanRemote UB=(DepartamentoBeanRemote)
				InitialContext.doLookup("ProyectoEJB/DepartamentoBean!com.servicios.DepartamentoBeanRemote");
		return UB;
	}
	
	//BEANS
}
	

