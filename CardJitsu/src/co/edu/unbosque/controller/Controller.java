package co.edu.unbosque.controller;
import co.edu.unbosque.model.FuncionesPrincipales;
import co.edu.unbosque.model.FuncionesSecundarias;
import co.edu.unbosque.model.Musica;
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
	//private AreYouSure mazoOptions;
	private SeleccionMazo mazoView;
	private AreYouSure userOptions;
	private AreYouSure preventSalida;
	private AreYouSure preventSesion;
	private Stats userStats;
	private FuncionesPrincipales funcionesPrimarias;
	private FuncionesSecundarias funcionesSecundarias;
	private Musica music;
	private Tutorial tutorialpg1;
	private Tutorial tutorialpg2;
	private Tutorial tutorialpg3;
	private Tutorial tutorialpg4;
	private Tutorial tutorialpg5;
	boolean mute = false;
	public Controller() {
		inicial=new InterfazInicial();
		userCreate=new UserLogin();
		userLogin=new UserLogin();
		mainMenu=new MenuPrincipal();
		//mazoOptions=new AreYouSure();
		mazoView=new SeleccionMazo();
		userOptions=new AreYouSure();
		preventSesion=new AreYouSure();
		preventSalida=new AreYouSure();
		userStats=new Stats();
		tutorialpg1=new Tutorial("Tut0");
		tutorialpg2=new Tutorial("Tut1");
		tutorialpg3=new Tutorial("Tut2");
		tutorialpg4=new Tutorial("Tut3");
		tutorialpg5=new Tutorial("Tut4");
		funcionesPrimarias=new FuncionesPrincipales();
		funcionesSecundarias=new FuncionesSecundarias();
		music=new Musica();
		agregarLectores();
	}
	public void start(){
		inicial.setVisible(true);
		music.reproducirMusica();
	}
	public void agregarLectores(){
		inicial.getBtnNueU().addActionListener(this);
		inicial.getBtnNueU().setActionCommand("btnCrear");
		
			userCreate.getBtnConf().addActionListener(this);
			userCreate.getBtnConf().setActionCommand("btnConfirmCrear");
			
			userCreate.getBtnVol().addActionListener(this);
			userCreate.getBtnVol().setActionCommand("btnVolverCrear");
		
		inicial.getBtnIniS().addActionListener(this);
		inicial.getBtnIniS().setActionCommand("btnIngresar");
		
			userLogin.getBtnConf().addActionListener(this);
			userLogin.getBtnConf().setActionCommand("btnConfirmLogin");
			
				mainMenu.getBtnMus().addActionListener(this);
				mainMenu.getBtnMus().setActionCommand("btnMusicaMain");
				
				mainMenu.getBtnJug().addActionListener(this);
				mainMenu.getBtnJug().setActionCommand("btnJugarMain");
				
				mainMenu.getBtnMaz().addActionListener(this);
				mainMenu.getBtnMaz().setActionCommand("btnMazoMain");
				
					mazoView.getBtnCus().addActionListener(this);
					mazoView.getBtnCus().setActionCommand("btnCustomMaz");
					
					mazoView.getBtnRand().addActionListener(this);
					mazoView.getBtnRand().setActionCommand("btnRandomMaz");
					
					mazoView.getBtnSal().addActionListener(this);
					mazoView.getBtnSal().setActionCommand("btnSalirMaz");
				
				mainMenu.getBtnTut().addActionListener(this);
				mainMenu.getBtnTut().setActionCommand("btnTutorialMain");
				
					tutorialpg1.getBtnAde().addActionListener(this);
					tutorialpg1.getBtnAde().setActionCommand("btnAdelante1");
					
					tutorialpg1.getBtnMen().addActionListener(this);
					tutorialpg1.getBtnMen().setActionCommand("btnMenu1");
					
					tutorialpg2.getBtnAde().addActionListener(this);
					tutorialpg2.getBtnAde().setActionCommand("btnAdelante2");
					
					tutorialpg2.getBtnAtr().addActionListener(this);
					tutorialpg2.getBtnAtr().setActionCommand("btnAtras1");
					
					tutorialpg2.getBtnMen().addActionListener(this);
					tutorialpg2.getBtnMen().setActionCommand("btnMenu2");
					
					tutorialpg3.getBtnAde().addActionListener(this);
					tutorialpg3.getBtnAde().setActionCommand("btnAdelante3");
					
					tutorialpg3.getBtnAtr().addActionListener(this);
					tutorialpg3.getBtnAtr().setActionCommand("btnAtras2");
					
					tutorialpg3.getBtnMen().addActionListener(this);
					tutorialpg3.getBtnMen().setActionCommand("btnMenu3");
					
					tutorialpg4.getBtnAde().addActionListener(this);
					tutorialpg4.getBtnAde().setActionCommand("btnAdelante4");
					
					tutorialpg4.getBtnAtr().addActionListener(this);
					tutorialpg4.getBtnAtr().setActionCommand("btnAtras3");
					
					tutorialpg4.getBtnMen().addActionListener(this);
					tutorialpg4.getBtnMen().setActionCommand("btnMenu4");
					
					tutorialpg5.getBtnAde().addActionListener(this);
					tutorialpg5.getBtnAde().setActionCommand("btnAtras4");
				
					tutorialpg5.getBtnMen().addActionListener(this);
					tutorialpg5.getBtnMen().setActionCommand("btnMenu5");
				
				mainMenu.getBtnCue().addActionListener(this);
				mainMenu.getBtnCue().setActionCommand("btnCuentaMain");
				
					userOptions.getBtnConf().addActionListener(this);
					userOptions.getBtnConf().setActionCommand("btnStats");
					
						userStats.getBtnSal().addActionListener(this);
						userStats.getBtnSal().setActionCommand("btnSalirStats");
					
					userOptions.getBtnVol().addActionListener(this);
					userOptions.getBtnVol().setActionCommand("btnCerrar");
					
						preventSesion.getBtnConf().addActionListener(this);
						preventSesion.getBtnConf().setActionCommand("btnConfirmSesion");
						
						preventSesion.getBtnVol().addActionListener(this);
						preventSesion.getBtnVol().setActionCommand("btnVolverSesion");
				
				mainMenu.getBtnSal().addActionListener(this);
				mainMenu.getBtnSal().setActionCommand("btnSalirMain");
				
					preventSalida.getBtnConf().addActionListener(this);
					preventSalida.getBtnConf().setActionCommand("btnConfirmSURE");
					
					preventSalida.getBtnVol().addActionListener(this);
					preventSalida.getBtnVol().setActionCommand("btnVolverSURE");
			
			userLogin.getBtnVol().addActionListener(this);
			userLogin.getBtnVol().setActionCommand("btnVolverLogin");
		
		inicial.getBtnSal().addActionListener(this);
		inicial.getBtnSal().setActionCommand("btnSalir");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
		switch(e.getActionCommand()) {
			case "btnCrear":{
				userCreate.setYesTxt("SingUp", 30f,200,110);;
				userCreate.setNoTxt("Volver", 30f,40,110);;
				inicial.setVisible(false);
				userCreate.setVisible(true);
				break;
			}
			//opciones crear user
				case "btnConfirmCrear":{
					String name = userCreate.getDigD().getText();;
					boolean error = funcionesPrimarias.crearUsuario(name);
					System.out.println(error);
					if(error) {
						JOptionPane.showMessageDialog(userCreate, "USER REPETIDO O VACIO", "Error", 
								JOptionPane.ERROR_MESSAGE);
					}else if(!error){
						//JOptionPane.showMessageDialog(userCreate, "ES VALIDO", "Error", 
								//JOptionPane.ERROR_MESSAGE);
						JOptionPane.showMessageDialog(userCreate, "User creado con exito", "Validación",
								JOptionPane.INFORMATION_MESSAGE);
						if(name.equals("rickroll69")) {
							JOptionPane.showMessageDialog(userCreate, "No deberias...", "Perdición",
									JOptionPane.WARNING_MESSAGE);
						}
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
			case "btnIngresar":{
				userLogin.setYesTxt("LogIn", 30f,200,110);;
				userLogin.setNoTxt("Volver", 30f,40,110);;
				inicial.setVisible(false);
				userLogin.setVisible(true);
				break;
			}
			//opciones login user
				case "btnConfirmLogin":{
					String name = userLogin.getDigD().getText();;
					boolean error = funcionesPrimarias.ingresarUsuario(name);
					System.out.println(error);
					if(error) {
						JOptionPane.showMessageDialog(userLogin, "NO EXISTE TAL USER", "Error", 
								JOptionPane.ERROR_MESSAGE);
					}else if(!error){
						//JOptionPane.showMessageDialog(userLogin, "ES VALIDO", "Error", 
								//JOptionPane.ERROR_MESSAGE);
						JOptionPane.showMessageDialog(userCreate, "Inicio de sesión exitoso", "Validación",
								JOptionPane.INFORMATION_MESSAGE);
						//if(name.equals("rickroll69"))music.cambiarMusica("Roll");
						if(name.equals("rickroll69")) {
							JOptionPane.showMessageDialog(userCreate, "Run.", "Desesperación",
									JOptionPane.WARNING_MESSAGE);
							music.shutUp();
							music.soundEffect("Defeat");
							mainMenu.setEaster();
						}else mainMenu.hideEaster();
						userLogin.setVisible(false);
						mainMenu.setVisible(true);
					}
					break;
				}
				//opciones main menu
					case "btnMusicaMain":{
						Musica.bajarVolumenACero();
						if(mute) {
							Musica.restaurarVolumenOriginal();
							mute= false;
							break;
						}
						mute = true;
						break;
					}
					case "btnMazoMain":{
						/*mazoView.setUserName(funcionesPrimarias.currentUser().getName());;
						mazoView.setPreguntaTxt("Opciones Mazo:", 30f,40,10);;
						mazoView.setYesTxt("Randomizar", 27f,177,110);;
						mazoView.setNoTxt("Editar", 30f,45,110);;*/
						mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
						mainMenu.setVisible(false);
						mazoView.setVisible(true);
					    break;
					}
					//opciones mazo editable
						case "btnCustomMaz":{
							String name = funcionesPrimarias.currentUser().getName();;
							String num="2";
							String elemento="Fuego";
							String color="Amarillo";
							funcionesSecundarias.asignarMazoCustom(name);;
							//mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
							mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
							mazoView.setBigCard(num,elemento,color);
						    break;
						}
						case "btnRandomMaz":{
							String name = funcionesPrimarias.currentUser().getName();;
							funcionesSecundarias.asignarMazoAleatorio(name);;
							//mazoView.setVisible(false);
							mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
							mazoView.resetBigCard();
							//mazoView.setVisible(true);
						    break;
						}
						case "btnSalirMaz":{
							//mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
							mainMenu.setVisible(true);
							mazoView.setVisible(false);
						    break;
						}
					case "btnTutorialMain": {
						music.cambiarMusica("Tutorial");
						tutorialpg1.hideButton(true);
						mainMenu.setVisible(false);
						tutorialpg1.setVisible(true);
						break;
					}
					//botones pasar pagina tutorial
						case "btnAdelante1":{
							tutorialpg1.setVisible(false);
							tutorialpg2.setVisible(true);
							break;
						}
						case "btnAdelante2":{
							tutorialpg2.setVisible(false);
							tutorialpg3.setVisible(true);
							break;	
						}
						case "btnAdelante3":{
							tutorialpg3.setVisible(false);
							tutorialpg4.setVisible(true);
							break;	
						}
						case "btnAdelante4":{
							tutorialpg5.hideButton(true);
							tutorialpg4.setVisible(false);
							tutorialpg5.setVisible(true);
							break;	
						}
						case "btnAtras1":{
							tutorialpg1.hideButton(true);
							tutorialpg2.setVisible(false);
							tutorialpg1.setVisible(true);
							break;
						}
						case "btnAtras2":{
							tutorialpg3.setVisible(false);
							tutorialpg2.setVisible(true);
							break;	
						}
						case "btnAtras3":{
							tutorialpg4.setVisible(false);
							tutorialpg3.setVisible(true);
							break;	
						}
						case "btnAtras4":{
							tutorialpg5.setVisible(false);
							tutorialpg4.setVisible(true);
							break;	
						}
						case "btnMenu1":{
							music.cambiarMusica("DojoMenu");
							tutorialpg1.setVisible(false);
							mainMenu.setVisible(true);
							break;
						}
						case "btnMenu2":{
							music.cambiarMusica("DojoMenu");
							tutorialpg2.setVisible(false);
							mainMenu.setVisible(true);
							break;
						}
						case "btnMenu3":{
							music.cambiarMusica("DojoMenu");
							tutorialpg3.setVisible(false);
							mainMenu.setVisible(true);
							break;
						}
						case "btnMenu4":{
							music.cambiarMusica("DojoMenu");
							tutorialpg4.setVisible(false);
							mainMenu.setVisible(true);
							break;
						}
						case "btnMenu5":{
							music.cambiarMusica("DojoMenu");
							tutorialpg5.setVisible(false);
							mainMenu.setVisible(true);
							break;
						}
					case "btnCuentaMain":{
						userOptions.setUserName(funcionesPrimarias.currentUser().getName());;
						userOptions.setPreguntaTxt("Opciones Usuario:", 30f,40,10);;
						userOptions.setYesTxt("Stats", 30f,205,110);;
						userOptions.setNoTxt("LogOut", 30f,35,110);;
						userOptions.setVisible(true);
					    break;
					}
					//opciones user loged
						case "btnStats":{
							userStats.setUserName(funcionesPrimarias.currentUser().getName(),funcionesPrimarias.currentUser().getId(),
									funcionesPrimarias.currentUser().getCinturon(), funcionesPrimarias.currentUser().getPuntaje(),
									funcionesPrimarias.currentUser().getNextLv());;
							userOptions.setVisible(false);
							mainMenu.setVisible(false);
							userStats.setVisible(true);
						    //hacer visibles stats
						    break;
						}
						//boton dentro de stats
							case "btnSalirStats":{
								userStats.setVisible(false);
							    mainMenu.setVisible(true);
								break;
							}
						case "btnCerrar":{
							preventSesion.setUserName(funcionesPrimarias.currentUser().getName()+"?");;
							preventSesion.setVisible(true);
						    //mainMenu.setVisible(false);
							break;
						}
						//opciones logout
							case "btnConfirmSesion":{
								mazoView.resetBigCard();
								preventSesion.setVisible(false);
								userOptions.setVisible(false);
								mainMenu.setVisible(false);
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
					//opciones salir desde main menu
						case "btnConfirmSURE":{
							System.exit(0);
							break;
						}
						case "btnVolverSURE":{
							preventSalida.setVisible(false);
							//mainMenu.setVisible(true);
							break;
						}
				case "btnVolverLogin":{
					inicial.setVisible(true);
					userLogin.setVisible(false);
					break;
				}
			case "btnSalir":{
				System.exit(0);
				break;
				//para organizar ctr shift f
			}
		}
	}
}