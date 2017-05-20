package uI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class UiFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiFrame frame = new UiFrame();
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
	public UiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 411);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenuItem mntmAbmc = new JMenuItem("ABMC");
		mntmAbmc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			showABMCVehiculos();
			
			}
		});
		mnVehiculos.add(mntmAbmc);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 494, 330);
		contentPane.add(desktopPane);
	}
	protected void showABMCVehiculos() {
		
		 UiABMVehiculos frmPer=new UiABMVehiculos();
		desktopPane.add(frmPer);
		frmPer.setVisible(true);
		
		
		
	}
}
