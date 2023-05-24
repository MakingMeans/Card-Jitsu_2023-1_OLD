package co.edu.unbosque.controller;
import co.edu.unbosque.model.FuncionesPrincipales;
import co.edu.unbosque.view.*;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane; 

public class Controller implements ActionListener{
	private InterfazInicial inicial;
	private UserLogin userCreate;
	private UserLogin userLogin;
	private MenuPrincipal mainMenu;
	private AreYouSure userOptions;
	private AreYouSure preventSalida;
	private AreYouSure preventSesion;
	private Stats userStats;
	private FuncionesPrincipales funcionesPrimarias;
	boolean volume = false;
	public Controller() {
		inicial=new InterfazInicial();
		userCreate=new UserLogin();
		userLogin=new UserLogin();
		mainMenu=new MenuPrincipal();
		userOptions=new AreYouSure();
		preventSesion=new AreYouSure();
		preventSalida=new AreYouSure();
		userStats=new Stats();
		funcionesPrimarias=new FuncionesPrincipales();
		agregarLectores();
	}
	public void start(){
		inicial.setVisible(true);
		funcionesPrimarias.reproducirMusica();
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
		userCreate.getBtnConf().setActionCommand("btnConfirmCrear");
		
		userCreate.getBtnVol().addActionListener(this);
		userCreate.getBtnVol().setActionCommand("btnVolverCrear");
		
		userLogin.getBtnConf().addActionListener(this);
		userLogin.getBtnConf().setActionCommand("btnConfirmLogin");
		
		userLogin.getBtnVol().addActionListener(this);
		userLogin.getBtnVol().setActionCommand("btnVolverLogin");
		
		mainMenu.getBtnMus().addActionListener(this);
		mainMenu.getBtnMus().setActionCommand("btnMusicaMain");
		
		mainMenu.getBtnJug().addActionListener(this);
		mainMenu.getBtnJug().setActionCommand("btnJugarMain");
		
		mainMenu.getBtnMaz().addActionListener(this);
		mainMenu.getBtnMaz().setActionCommand("btnMazoMain");
		
		mainMenu.getBtnTut().addActionListener(this);
		mainMenu.getBtnTut().setActionCommand("btnTutorialMain");
		
		mainMenu.getBtnCue().addActionListener(this);
		mainMenu.getBtnCue().setActionCommand("btnCuentaMain");
		
		mainMenu.getBtnSal().addActionListener(this);
		mainMenu.getBtnSal().setActionCommand("btnSalirMain");
		
		userOptions.getBtnConf().addActionListener(this);
		userOptions.getBtnConf().setActionCommand("btnStats");
		
		userOptions.getBtnVol().addActionListener(this);
		userOptions.getBtnVol().setActionCommand("btnCerrar");
		
		userStats.getBtnSal().addActionListener(this);
		userStats.getBtnSal().setActionCommand("btnSalirStats");
		
		preventSesion.getBtnConf().addActionListener(this);
		preventSesion.getBtnConf().setActionCommand("btnConfirmSesion");
		
		preventSesion.getBtnVol().addActionListener(this);
		preventSesion.getBtnVol().setActionCommand("btnVolverSesion");
		
		preventSalida.getBtnConf().addActionListener(this);
		preventSalida.getBtnConf().setActionCommand("btnConfirmSURE");
		
		preventSalida.getBtnVol().addActionListener(this);
		preventSalida.getBtnVol().setActionCommand("btnVolverSURE");
		/*vi.getBtn2().addActionListener(this);
		vi.getBtn2().setActionCommand("btn2click");*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		switch(e.getActionCommand()) {
			case "btnCrear":{
				userCreate.setYesTxt("SingUp", 30f,200,110);;
				userCreate.setNoTxt("Volver", 30f,35,110);;
				inicial.setVisible(false);
				userCreate.setVisible(true);
				break;
			}
			case "btnIngresar":{
				userLogin.setYesTxt("LogIn", 30f,200,110);;
				userLogin.setNoTxt("Volver", 30f,35,110);;
				inicial.setVisible(false);
				userLogin.setVisible(true);
				break;
			}
			case "btnSalir":{
				System.exit(0);
				break;
			}
			case "btnConfirmCrear":{
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
			case "btnVolverCrear":{
				inicial.setVisible(true);
				userCreate.setVisible(false);
				break;
			}
			case "btnConfirmLogin":{
				String name = userLogin.getDigD().getText();;
				boolean error = funcionesPrimarias.ingresarUsuario(name);
				System.out.println(error);
				if(error) {
					JOptionPane.showMessageDialog(userLogin, "NO ES VALIDO", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}else if(!error){
					//JOptionPane.showMessageDialog(userLogin, "ES VALIDO", "Error", 
							//JOptionPane.ERROR_MESSAGE);
					mainMenu.setVisible(true);
					userLogin.setVisible(false);
					
				}
				break;
			}
			case "btnVolverLogin":{
				inicial.setVisible(true);
				userLogin.setVisible(false);
				break;
			}
			case "btnMusicaMain":{
				//funcionesPrimarias.reproducirMucica();
				FuncionesPrincipales.bajarVolumenACero();
				
				//System.out.println("XDDDDD");
				if(volume) {
					FuncionesPrincipales.restaurarVolumenOriginal();
					volume= false;
					//System.out.println("DDDDDDDX");
					break;
				}
				volume = true;
				break;
			}
			case "btnCuentaMain":{
				userOptions.setUserName(funcionesPrimarias.currentUser().getName());;
				userOptions.setPreguntaTxt("Opciones Usuario:", 30f,40,10);;
				userOptions.setYesTxt("Stats", 30f,200,110);;
				userOptions.setNoTxt("LogOut", 30f,35,110);;
				userOptions.setVisible(true);
			    mainMenu.setVisible(false);
			    break;
			}
			case "btnStats":{
				userStats.setUserName(funcionesPrimarias.currentUser().getName(),funcionesPrimarias.currentUser().getId(),
						funcionesPrimarias.currentUser().getCinturon(), funcionesPrimarias.currentUser().getPuntaje(),
						funcionesPrimarias.currentUser().getNextLv());;
				userOptions.setVisible(false);
				userStats.setVisible(true);
			    //hacer visibles stats
			    break;
			}
			case "btnCerrar":{
				preventSesion.setUserName(funcionesPrimarias.currentUser().getName()+"?");;
				preventSesion.setVisible(true);
			    //mainMenu.setVisible(false);
				break;
			}
			case "btnSalirStats":{
				userStats.setVisible(false);
			    mainMenu.setVisible(true);
				break;
			}
			case "btnConfirmSesion":{
				preventSesion.setVisible(false);
				userOptions.setVisible(false);
				inicial.setVisible(true);
				break;
			}
			case "btnVolverSesion":{
				preventSesion.setVisible(false);
				//mainMenu.setVisible(true);
				break;
			}
			case "btnSalirMain":{
				preventSalida.setUserName(funcionesPrimarias.currentUser().getName()+"?");;
				preventSalida.setVisible(true);
			    //mainMenu.setVisible(false);
			    break;
			}
			case "btnConfirmSURE":{
				System.exit(0);
				break;
			}
			case "btnVolverSURE":{
				preventSalida.setVisible(false);
				//mainMenu.setVisible(true);
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