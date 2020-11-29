package com.cliente;

import java.util.HashMap;
import java.util.Map;

public class Utils {
	
	 private static final Map<Integer, String> estados = new HashMap(){
	        {
	        	put(0, "-- Seleccionar --");
	        	put(1, "Verificado");
	            put(2, "Sin verificar");
	            put(3,"Rechazada");
	        }
	    };

	    private static final Map<String, Integer> estadosIn = new HashMap(){
	        {
	        	put( "-- Seleccionar --",0);
	        	put("Verificado",1);
	            put("Sin verificar",2);
	            put("Rechazada",3);
	        }
	    };
	    
	    
	    
	    private static final Map<Integer,String > dtptos = new HashMap(){
	        {
	        	put(0, "-- Seleccionar --");
	        	put(1, "ARTIGAS");
	        	put(2, "CANELONES");
	        	put(3, "CERRO LARGO");
	        	put(4, "COLONIA");
	        	put(5, "DURAZNO");
	        	put(6, "FLORES");
	        	put(7, "FLORIDA");
	        	put(8, "LAVALLEJA");
	        	put(9,"LIMITE CONTESTADO");
	        	put(10, "MALDONADO");
	        	put(11, "MONTEVIDEO");
	        	put(12, "PAYSANDU");
	        	put(13, "RIO NEGRO");
	        	put(14, "RIVERA");
	        	put(15, "ROCHA");
	        	put(16, "SALTO");
	        	put(17, "SAN JOSE");
	        	put(18, "SORIANO");
	        	put(19, "TACUAREMBO");
	        	put(20, "TREINTA Y TRES");
	        }
	    };
	    
	    private static final Map<String,String > dtptosIn = new HashMap(){
	        {
	        	put("-- Seleccionar --","0");
	        	put("MONTEVIDEO","1");
	        	put("ARTIGAS","2");
	        	put("CANELONES","3");
	        	put("CERRO LARGO","4");
	        	put("COLONIA","5");
	        	put("DURAZNO","6");
	        	put("FLORES","7");
	        	put("FLORIDA","8");
	        	put("LAVALLEJA","9");
	        	put("MALDONADO","10");
	        	put("PAYSANDU","11");
	        	put("RIO NEGRO","12");
	        	put("RIVERA","13");
	        	put("ROCHA","14");
	        	put("SALTO","15");
	        	put("SAN JOSE","16");
	        	put("SORIANO","17");
	        	put("TACUAREMBO","18");
	        	put("TREINTA Y TRES","19");
	        }
	    };
	    
	public static Map<Integer, String> getDtptos() {
			return dtptos;
		}
	public static Map<Integer, String> getEstados() {
		return estados;
	}
	public static Map<String, Integer> getEstadosin() {
		return estadosIn;
	}
	public static Map<String, String> getDtptosin() {
		return dtptosIn;
	}
	
	
	    
	    
	    

}
