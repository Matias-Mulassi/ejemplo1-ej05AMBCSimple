package uI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JTextField;

import entities.*;
import controlers.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UiABMVehiculos extends JInternalFrame {
	private ControladorABMCVehiculo ctrl= new ControladorABMCVehiculo();
	private JTextField txtPatente;
	private JTextField txtTitular;
	private JTextField txtAnio;
	private JTextField txtModelo;
	private JCheckBox chckbxPagado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiABMVehiculos frame = new UiABMVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UiABMVehiculos() {
		setClosable(true);
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(null);
		
		txtPatente = new JTextField();
		txtPatente.setBounds(96, 32, 86, 20);
		getContentPane().add(txtPatente);
		txtPatente.setColumns(10);
		
		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setBounds(22, 35, 46, 14);
		getContentPane().add(lblPatente);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setBounds(22, 77, 46, 14);
		getContentPane().add(lblTitular);
		
		txtTitular = new JTextField();
		txtTitular.setBounds(96, 74, 86, 20);
		getContentPane().add(txtTitular);
		txtTitular.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(22, 129, 46, 14);
		getContentPane().add(lblAo);
		
		txtAnio= new JTextField();
		txtAnio.setBounds(96, 126, 86, 20);
		getContentPane().add(txtAnio);
		txtAnio.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(22, 176, 46, 14);
		getContentPane().add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(96, 173, 86, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		chckbxPagado = new JCheckBox("Pagado");
		chckbxPagado.setBounds(22, 215, 97, 23);
		getContentPane().add(chckbxPagado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			agregarClick();
			
			
			
			}
		});
		btnAgregar.setBounds(216, 31, 89, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			borrarClick();
			
			}
		});
		btnBorrar.setBounds(216, 172, 89, 23);
		getContentPane().add(btnBorrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			consultarClick();
			
			}
		});
		btnConsultar.setBounds(335, 31, 89, 23);
		getContentPane().add(btnConsultar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			modificarClick();
			
			}
		});
		btnModificar.setBounds(335, 172, 89, 23);
		getContentPane().add(btnModificar);
		setBounds(100, 100, 450, 300);

	}

protected void agregarClick() {
	Vehiculo v = new Vehiculo();
	v.setPatente(this.txtPatente.getText());
	if (ctrl.existeVehiculo(v)){
		JOptionPane.showMessageDialog(null,"Ya existe un Vehiculo con esa Patente");
	return;
	
		}
	
	ctrl.agregarVehiculo(this.mapearDeForm());
	JOptionPane.showMessageDialog(null,"Vehiculo agregado Exitosamente");
	
	
	
}
	
protected void borrarClick() {
	
	Vehiculo v= new Vehiculo();
	v.setPatente(this.txtPatente.getText());
	v= ctrl.devolverVehiculo(v);
	mostrarBorrado(v);
	
			
	
	}
	
protected void modificarClick(){
	Vehiculo v = new Vehiculo();
	v = mapearDeForm();
	mostrarModificado(v);
			


}
	

protected void consultarClick() {
	Vehiculo v= new Vehiculo();
	v.setPatente(this.txtPatente.getText()); //Aqui pasamos el control grafico//
	v= ctrl.devolverVehiculo(v);
	if (v==null) 
		patenteNoExiste();
	
	else {
		if (v.isPagado()){
		JOptionPane.showMessageDialog(null, "Titular: "+ v.getTitular() + "\n Modelo: "+ v.getModelo() + "\n Año:" + v.getAnio() + "\n Pagado: Si " );
		}
		else {JOptionPane.showMessageDialog(null, "Titular: "+ v.getTitular() + "\n Modelo: "+ v.getModelo() + "\n Año:" + v.getAnio() + "\n Pagado: No " );}
		
		mapearAForm(v);}

}
	
private void patenteNoExiste() {
	
	JOptionPane.showMessageDialog(null,"No existe un Vehiculo con esa Patente");
	
}

	
	
	
	

private void mapearAForm(Vehiculo v) {   //Este metodo pone los datos en el formulario//
		
		this.txtPatente.setText(v.getPatente());
		this.txtTitular.setText(v.getTitular());
		this.txtAnio.setText(v.getAnio());
		this.chckbxPagado.setSelected(v.isPagado());
		
		
		
		
	}

	private Vehiculo mapearDeForm()
	{
		Vehiculo v= new Vehiculo();
		
		v.setPatente(this.txtPatente.getText());
		v.setTitular(this.txtTitular.getText());
		v.setAnio(this.txtAnio.getText());
		v.setModelo(this.txtModelo.getText());
		v.setPagado(this.chckbxPagado.isSelected());
	
		return v;
		
		
		
		
		
		
		
	}	

private void mostrarBorrado(Vehiculo v) {
		
		if (v==null) {
			patenteNoExiste();}
				
		else {	
			ctrl.borrarVehiculo(v);
			if(v.isPagado()){
			JOptionPane.showMessageDialog(null, " Vehiculo Borrado : " +"\n" + "Titular: "+ v.getTitular() + "\n" + "Modelo: " + v.getModelo() +"\n" + "Pagado : Si"  );
			}
		
			else {
				JOptionPane.showMessageDialog(null, " Vehiculo Borrado : " +"\n" + "Titular: "+ v.getTitular() + "\n" + "Modelo: " + v.getModelo() +"\n" + "Pagado : No"  );			}
				}
		
	}

private void mostrarModificado(Vehiculo v) {
	
	if (!ctrl.existeVehiculo(v)){
		patenteNoExiste();
		return;	
	}
	ctrl.modificarVehiculo(v);
	mapearAForm(v);
	if (v.isPagado()){
	JOptionPane.showMessageDialog(null,"Vehiculo Modificado Con exito" +"\n"+ "Titular: "+ v.getTitular() + "\n" + "Modelo: " + v.getModelo() +"\n" + "Pagado : Si"  );
	return;
	}
	
	JOptionPane.showMessageDialog(null,"Persona Modificado Con exito" +"\n"+ "Titular: "+ v.getTitular() + "\n" + "Modelo: " + v.getModelo() +"\n" + "Pagado : No" );
}	


}
