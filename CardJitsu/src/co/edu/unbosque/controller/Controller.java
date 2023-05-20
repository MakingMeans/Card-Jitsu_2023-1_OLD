package co.edu.unbosque.controller;
import co.edu.unbosque.model.FuncionesPrincipales;
import co.edu.unbosque.view.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane; 

public class Controller implements ActionListener{
	private InterfazInicial inicial;
	private UserCreate userCreate;
	private UserLogin userLogin;
	private MenuPrincipal mainMenu;
	private FuncionesPrincipales funcionesPrimarias;
	public Controller() {
		inicial=new InterfazInicial();
		userCreate=new UserCreate();
		userLogin=new UserLogin();
		mainMenu=new MenuPrincipal();
		funcionesPrimarias=new FuncionesPrincipales();
		agregarLectores();
	}
	public void start(){
		inicial.setVisible(true);
		/*VentanaPrincipal v1 = new VentanaPrincipal();
		v1.ejecutarPrincipal();*/
	}
	public void agregarLectores(){
		inicial.getBtnNueU().addActionListener(this);
		inicial.getBtnNueU().setActionCommand("btnCrear");
		
		inicial.getBtnIniS().addActionListener(this);
		inicial.getBtnIniS().setActionCommand("btnIngresar");
		
		inicial.getBtnSal().addActionListener(this);
		inicial.getBtnSal().setActionCommand("btnSalir");
		
		userCreate.getBtnConf().addActionListener(this);
		userCreate.getBtnConf().setActionCommand("btnConfirm1");
		
		userCreate.getBtnVol().addActionListener(this);
		userCreate.getBtnVol().setActionCommand("btnVolver1");
		
		userLogin.getBtnConf().addActionListener(this);
		userLogin.getBtnConf().setActionCommand("btnConfirm2");
		
		userLogin.getBtnVol().addActionListener(this);
		userLogin.getBtnVol().setActionCommand("btnVolver2");
		
		/*vi.getBtn2().addActionListener(this);
		vi.getBtn2().setActionCommand("btn2click");*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		switch(e.getActionCommand()) {
			case "btnCrear":{
				inicial.setVisible(false);
				userCreate.setVisible(true);
				break;
			}
			case "btnIngresar":{
				inicial.setVisible(false);
				userLogin.setVisible(true);
				break;
			}
			case "btnSalir":{
				System.exit(0);
				break;
			}
			case "btnConfirm1":{
				String name = userCreate.getDigD().getText();;
				boolean error = funcionesPrimarias.crearUsuario(name);
				System.out.println(error);
				if(error) {
					JOptionPane.showMessageDialog(userCreate, "NO ES VALIDO", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}else if(!error){
					JOptionPane.showMessageDialog(userCreate, "ES VALIDO", "Error", 
							JOptionPane.ERROR_MESSAGE);
					inicial.setVisible(true);
					userCreate.setVisible(false);
				}
				break;
			}
			case "btnVolver1":{
				inicial.setVisible(true);
				userCreate.setVisible(false);
				break;
			}
			case "btnConfirm2":{
				String name = userLogin.getDigD().getText();;
				boolean error = funcionesPrimarias.ingresarUsuario(name);
				System.out.println(error);
				if(error) {
					JOptionPane.showMessageDialog(userLogin, "NO ES VALIDO", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}else if(!error){
					JOptionPane.showMessageDialog(userLogin, "ES VALIDO", "Error", 
							JOptionPane.ERROR_MESSAGE);
					mainMenu.setVisible(true);
					userLogin.setVisible(false);
				}
				break;
			}
			case "btnVolver2":{
				inicial.setVisible(true);
				userLogin.setVisible(false);
				break;
			}
		/*case "btn2click":{
			try {
				double numero= Double.parseDouble(funcionesPrimarias.getEntrada().getText());
				numero=Math.pow(numero, 2);
				funcionesPrimarias.getTitulos()[1].setText("POW: "+numero);
			}catch(NumberFormatException e2){
				JOptionPane.showMessageDialog(vp, "NO ES VALIDO", "error", 
						JOptionPane.ERROR_MESSAGE);
			}
			break;
			//JOptionPane.showMessageDialog(vp, "SI ES EL BOTON");
		}
		//default:*/
		}
	}
}