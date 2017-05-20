package controlers;

import java.util.ArrayList;
import entities.*;



public class ControladorABMCVehiculo {
	
	private ArrayList<Vehiculo> vehis;
	public ControladorABMCVehiculo () {
	vehis= new ArrayList<Vehiculo>();
	vehis.add(new Vehiculo("HZF 510",true,"Peugeot 307","2009","Jesus Mulassi"));
	
	}
	
	public void agregarVehiculo(Vehiculo v) {
		vehis.add(v);
		
	} 

	public void borrarVehiculo(Vehiculo v) {
		int index= vehis.indexOf(v);
		vehis.remove(index);
			
		}
		
	public Vehiculo devolverVehiculo(Vehiculo v) {
		for(Vehiculo ve :vehis) {
			if (ve.equals(v)) {
				return ve;
				
				}
			
			
		}
		
		return null;
		
		
	}
	
	public boolean existeVehiculo(Vehiculo v) {
		return vehis.contains(v);
		}
		
	
		public void modificarVehiculo(Vehiculo v) {
				borrarVehiculo(devolverVehiculo(v));
				agregarVehiculo(v);
			
			
			
			
		}
		
		
	
	
	
		
		
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

