package uI;

import entities.*;
import controlers.*;
import java.util.Scanner;




public class ConsoleABMVehiculos {
	private ControladorABMCVehiculo ctrl=new ControladorABMCVehiculo();
	private Scanner s;
	
		public void start() {
			s=new Scanner(System.in);
			
			int op= 1;
			
			while(op!=0) {
				
System.out.println("Ingrese una opcion:");
System.out.println("\n 1-Alta Vehiculo");
System.out.println("\n 2-Baja Vehiculo");
System.out.println("\n 3-ConsultaVehiculo");
System.out.println("\n 4-ModificarVehiculo");
System.out.println("\n 0-Salir");
				
		op=Integer.parseInt(s.nextLine());
		clearScreen();
		handle(op);
		
		
			} 
			s.close();
			
		}
		
		public void handle(int op) {
			switch (op) {
			case 1: {
				altaVehiculo();
				break;
				}
			
			case 2: {
				bajaVehiculo();
				break;
				
			}
			
			case 3: {
				consultaVehiculo();
				break;
				
			}
			
			case 4: {
				modificarVehiculo();
				break;
				
				
			}
			
			default : {}
			
			}
			
			
			
			
			
			
			
		}
	
	
	
		private void clearScreen(){
			for (int i = 0; i < 50; ++i) System.out.println();
		}
		
		private void altaVehiculo() {
			Vehiculo ve;
			ve= new Vehiculo();
			System.out.println("\n Ingrese patente del vehiculo");
			ve.setPatente(s.nextLine());
			if (!ctrl.existeVehiculo(ve)) {
				
				System.out.println("\n Ingrese titular del vehiculo");
				ve.setTitular(s.nextLine());
				System.out.println("\n Ingrese anio del vehiculo");
				ve.setAnio(s.nextLine());
				System.out.println("\n Ingrese modelo del vehiculo");
				ve.setModelo(s.nextLine());
				
						ctrl.agregarVehiculo(ve);
						
						System.out.println("Alta exitosa  - Presione Enter para continuar");
						s.nextLine();
						clearScreen();
					
			}
			else {
			System.out.println("Ya existe un vehiculo con esa patente");
			}
			
			
		
			
			
		}
		
		private void bajaVehiculo() {
			Vehiculo newVehiculo = new Vehiculo();
			
			System.out.println("Ingrese Patente:");
			newVehiculo.setPatente(s.nextLine());
			if (validarVehiculo(newVehiculo)){
				newVehiculo = ctrl.devolverVehiculo(newVehiculo);
				System.out.println("¿Esta seguro que quiere dar de baja la persona con los siguientes datos? [1=Si, 0=No]");
				mostrarDatosVehiculo(newVehiculo);
				
				if (s.nextLine().equals("1")){
					ctrl.borrarVehiculo(newVehiculo);
					
					System.out.println("Baja exitosa - Presione Enter para continuar");
				}
				else{
					System.out.println("Baja cancelada, se ha arrepentido a tiempo - Presione Enter para continuar");
				}
				s.nextLine();
				clearScreen();
			}
		
			
			
			
			}
		public void consultaVehiculo() {
			Vehiculo v= new Vehiculo();
			System.out.println("Ingrese patente del vehiculo a consultar: \n");
			v.setPatente(s.nextLine());
			if (ctrl.existeVehiculo(v)) {
				v=ctrl.devolverVehiculo(v);
				mostrarDatosVehiculo(v);
					}	
			
			else {
				System.out.println("No existe un vehiculo con esa patente");
				
				
			}
			
		
		
		
		}
		
		public void modificarVehiculo() {
			Vehiculo v= new Vehiculo();
			System.out.println("\n Ingrese patente del vehiculo a modificar: ");
			v.setPatente(s.nextLine());
			if (ctrl.existeVehiculo(v)) {
				
				v=ctrl.devolverVehiculo(v);
				mostrarDatosVehiculo(v);
				System.out.println(" \n Ingrese Titular vehiculo :");
				v.setTitular(s.nextLine());
				System.out.println("\n Ingrese modelo del vehiculo :");
				v.setModelo(s.nextLine());
				System.out.println("\n Ingrese año del vehiculo :");
				v.setAnio(s.nextLine());
				
				ctrl.modificarVehiculo(v);
				
				
			}
			
			else {System.out.println("No existe un vehiculo con esa patente");}
			
			
		}
		
		
		
		
		public void mostrarDatosVehiculo(Vehiculo ve) {
			System.out.println("\n Patente:"+ ve.getPatente());
			System.out.println("\n Titular:"+ ve.getTitular());
			System.out.println("\n Anio:"+ ve.getAnio());
			System.out.println("\n Modelo:"+ ve.getModelo()+"\n\n");
			
			
		
		}
		
		private boolean validarVehiculo(Vehiculo v){		
			if (ctrl.existeVehiculo(v)){
				return true;
			}
			else{
				System.out.println("No existe un vehiculo con esa patente");
				return false;
			}
		}
		
}
