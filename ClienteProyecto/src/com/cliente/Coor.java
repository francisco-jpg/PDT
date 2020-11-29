package com.cliente;

import java.util.ArrayList;
import java.util.List;

public class Coor {
	
	public List<double[]> Coordi_Maker(String a) {
		//Regresa las coordenadas en una lista con arrays de doubels siendo 0 Latitud y 1 Longitud
		//Cada array contiene grados en la pocicion 0 y minutos en la pocicion 1
		String lato= a.split(",")[0];
		String longo= a.split(",")[1].trim();
		Space(lato);
		Space(longo);
		double [] lat = {Double.valueOf(Space(lato)[0]),Double.valueOf(Space(lato)[1])};
		System.out.println("Los grados de la latitud son ="+lat[0]+" y los minutos son ="+lat[1]);
		double [] long_ = {Double.valueOf(Space(longo)[0]),Double.valueOf(Space(longo)[1])};
		System.out.println("Los grados de la longitud son ="+long_[0]+" y los minutos son ="+long_[1]);
		List<double[]> lista = new ArrayList<double[]>();
		//La lista tiene la latitud en el indice 0 y longitud en 1
		lista.add(lat);
		lista.add(long_);
		return lista;
	}
	
	public String[] Space(String a) {
		String[] sep = {a.split(" ")[0],a.split(" ")[1]};
		return sep;
		
	}
	
	public boolean Check(double[] coor_ns ,double[] coor_eo) {
		double[] max_lat = {35,0};
		double[] min_lat = {30,0};
		double[] max_long = {58,0};
		double[] min_long = {53,0};
		double[] coor_lat = coor_ns;
		double[] coor_long = coor_eo;
		boolean chek_coordi = false;
		for(int i = 0; i < 2;i++) {
			if(coor_lat[0] <= max_lat[0] && coor_lat[0] >= min_lat[0] ){
				if (coor_long[0] <= max_long[0] && coor_long[0] >= min_long[0] ){
					chek_coordi = true;
				}
				else{
					chek_coordi = false;
				}
			}
			else{
				chek_coordi = false;
			}
		}
		return chek_coordi;
	}

}
