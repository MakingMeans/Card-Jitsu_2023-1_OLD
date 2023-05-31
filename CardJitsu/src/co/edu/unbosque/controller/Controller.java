package co.edu.unbosque.controller;
import co.edu.unbosque.model.Carta;
import co.edu.unbosque.model.FuncionesPrincipales;
import co.edu.unbosque.model.FuncionesSecundarias;
import co.edu.unbosque.model.GameplayLogic;
import co.edu.unbosque.model.Musica;
import co.edu.unbosque.view.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
	private InterfazInicial inicial;
	private UserLogin userCreate;
	private UserLogin userLogin;
	private MenuPrincipal mainMenu;
	private Saludo saludo;
	private GraphicGameplay gameplay;
	private GameplayLogic gameLogic;
	private Results resultsWin;
	private Results resultsLoss;
	private CambioCinturon levelUp;
	private CambioCinturon levelDown;
	private AreYouSure preventLostGame;
	private SeleccionMazo mazoView;
	private AreYouSure preventRandom;
	private Tutorial tutorialpg1;
	private Tutorial tutorialpg2;
	private Tutorial tutorialpg3;
	private Tutorial tutorialpg4;
	private Tutorial tutorialpg5;
	private Stats userStats;
	private AreYouSure userOptions;
	private AreYouSure preventSesion;
	private AreYouSure preventSalida;
	private FuncionesPrincipales funcionesPrimarias;
	private FuncionesSecundarias funcionesSecundarias;
	private Musica music;
	
	 private static void establecerIcono(JFrame ventana) {
		ImageIcon icon = new ImageIcon("src/co/edu/unbosque/assets/imagenesInterfaz/Icono.png");
		ventana.setIconImage(icon.getImage());
	}
	
	public Controller() {
		inicial=new InterfazInicial();
		userCreate=new UserLogin();
		userLogin=new UserLogin();
		mainMenu=new MenuPrincipal();
		saludo=new Saludo();
		gameplay=new GraphicGameplay();
		gameLogic=new GameplayLogic();
		resultsWin=new Results("Feliz");
		resultsLoss=new Results("Troste");
		levelUp=new CambioCinturon("LVup");
		levelDown=new CambioCinturon("LVdown");
		preventLostGame=new AreYouSure();
		mazoView=new SeleccionMazo();
		preventRandom=new AreYouSure();
		tutorialpg1=new Tutorial("Tut0");
		tutorialpg2=new Tutorial("Tut1");
		tutorialpg3=new Tutorial("Tut2");
		tutorialpg4=new Tutorial("Tut3");
		tutorialpg5=new Tutorial("Tut4");
		userStats=new Stats();
		userOptions=new AreYouSure();
		preventSesion=new AreYouSure();
		preventSalida=new AreYouSure();
		funcionesPrimarias=new FuncionesPrincipales();
		funcionesSecundarias=new FuncionesSecundarias();
		music=new Musica();
		agregarLectores();
		establecerIcono(inicial);
		establecerIcono(userCreate);
		establecerIcono(userLogin);
		establecerIcono(mainMenu);
		establecerIcono(saludo);
		establecerIcono(gameplay);
		establecerIcono(resultsWin);
		establecerIcono(resultsLoss);
		establecerIcono(levelUp);
		establecerIcono(levelDown);
		establecerIcono(preventLostGame);
		establecerIcono(mazoView);
		establecerIcono(preventRandom);
		establecerIcono(tutorialpg1);
		establecerIcono(tutorialpg2);
		establecerIcono(tutorialpg3);
		establecerIcono(tutorialpg4);
		establecerIcono(tutorialpg5);
		establecerIcono(userStats);
		establecerIcono(userOptions);
		establecerIcono(preventSesion);
		establecerIcono(preventSalida);
	}
	public void start(){
		inicial.setVisible(true);
		music.reproducirMusica("Welcome");
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
				
					gameplay.getBtnMus().addActionListener(this);
					gameplay.getBtnMus().setActionCommand("btnJugarMus");
					
					gameplay.getBtnSal().addActionListener(this);
					gameplay.getBtnSal().setActionCommand("btnJugarSal");
					
					gameplay.getBtnC1().addActionListener(this);
					gameplay.getBtnC1().setActionCommand("btnCard1");
					gameplay.getBtnC2().addActionListener(this);
					gameplay.getBtnC2().setActionCommand("btnCard2");
					gameplay.getBtnC3().addActionListener(this);
					gameplay.getBtnC3().setActionCommand("btnCard3");
					gameplay.getBtnC4().addActionListener(this);
					gameplay.getBtnC4().setActionCommand("btnCard4");
					gameplay.getBtnC5().addActionListener(this);
					gameplay.getBtnC5().setActionCommand("btnCard5");
				
						preventLostGame.getBtnConf().addActionListener(this);
						preventLostGame.getBtnConf().setActionCommand("btnConfirmSalPlay");
						
						preventLostGame.getBtnVol().addActionListener(this);
						preventLostGame.getBtnVol().setActionCommand("btnCancelSalPlay");
						
							resultsWin.getBtnMenu().addActionListener(this);
							resultsWin.getBtnMenu().setActionCommand("btnByeGameWon");
							
							resultsLoss.getBtnMenu().addActionListener(this);
							resultsLoss.getBtnMenu().setActionCommand("btnByeGameLose");
							
							levelUp.getBtnMenu().addActionListener(this);
							levelUp.getBtnMenu().setActionCommand("btnByeChangeUp");
							
							levelDown.getBtnMenu().addActionListener(this);
							levelDown.getBtnMenu().setActionCommand("btnByeChangeDown");
				
				mainMenu.getBtnMaz().addActionListener(this);
				mainMenu.getBtnMaz().setActionCommand("btnMazoMain");
				
					mazoView.getBtnCus().addActionListener(this);
					mazoView.getBtnCus().setActionCommand("btnCustomMaz");
					
					mazoView.getBtnRand().addActionListener(this);
					mazoView.getBtnRand().setActionCommand("btnRandomMaz");
					
						preventRandom.getBtnConf().addActionListener(this);
						preventRandom.getBtnConf().setActionCommand("btnConfirmRand");
						
						preventRandom.getBtnVol().addActionListener(this);
						preventRandom.getBtnVol().setActionCommand("btnCancelRand");
					
					mazoView.getBtnSal().addActionListener(this);
					mazoView.getBtnSal().setActionCommand("btnSalirMaz");
					
					mazoView.getBtnFuego().addActionListener(this);
					mazoView.getBtnFuego().setActionCommand("btnFuegoMaz");
					
					mazoView.getBtnAgua().addActionListener(this);
					mazoView.getBtnAgua().setActionCommand("btnAguaMaz");
					
					mazoView.getBtnNieve().addActionListener(this);
					mazoView.getBtnNieve().setActionCommand("btnNieveMaz");
					
					mazoView.getBtnAzul().addActionListener(this);
					mazoView.getBtnAzul().setActionCommand("btnAzulMaz");
					
					mazoView.getBtnAmarillo().addActionListener(this);
					mazoView.getBtnAmarillo().setActionCommand("btnAmarilloMaz");
					
					mazoView.getBtnRojo().addActionListener(this);
					mazoView.getBtnRojo().setActionCommand("btnRojoMaz");
					
					mazoView.getBtnVerde().addActionListener(this);
					mazoView.getBtnVerde().setActionCommand("btnVerdeMaz");
					
					mazoView.getBtnVioleta().addActionListener(this);
					mazoView.getBtnVioleta().setActionCommand("btnMoradoMaz");
					
					mazoView.getBtnNaranja().addActionListener(this);
					mazoView.getBtnNaranja().setActionCommand("btnNaranjaMaz");
				
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
		switch(e.getActionCommand()) {
			case "btnCrear":{
				userCreate.setYesTxt("SignUp", 35f,190,110);
				userCreate.setNoTxt("Volver", 35f,40,110);
				inicial.setVisible(false);
				userCreate.setVisible(true);
				break;
			}
			//opciones crear user
				case "btnConfirmCrear":{
					String name = userCreate.getDigD().getText();
					boolean error = funcionesPrimarias.crearUsuario(name);
					if(error) {
						JOptionPane.showMessageDialog(userCreate, "USUARIO REPETIDO O VACIO", "Error", 
								JOptionPane.ERROR_MESSAGE);
					}else if(!error){
						JOptionPane.showMessageDialog(userCreate, "Usuario creado con exito", "Validación",
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
				userLogin.setYesTxt("LogIn", 35f,200,110);
				userLogin.setNoTxt("Volver", 35f,40,110);
				inicial.setVisible(false);
				userLogin.setVisible(true);
				break;
			}
			//opciones login user
				case "btnConfirmLogin":{
					String name = userLogin.getDigD().getText();
					boolean error = funcionesPrimarias.ingresarUsuario(name);
					if(error) {
						JOptionPane.showMessageDialog(userLogin, "NO EXISTE TAL USUARIO", "Error", 
								JOptionPane.ERROR_MESSAGE);
					}else if(!error){
						JOptionPane.showMessageDialog(userCreate, "Inicio de sesión exitoso", "Validación",
								JOptionPane.INFORMATION_MESSAGE);	
						userLogin.setVisible(false);
						mainMenu.setVisible(true);
						if(name.equals("rickroll69")) {
							JOptionPane.showMessageDialog(userCreate, "Corre.", "Desesperación",
									JOptionPane.WARNING_MESSAGE);
							music.cambiarMusica("Roll");
						}else music.cambiarMusica("DojoMenu");
					}
					break;
				}
				//opciones main menu
					case "btnMusicaMain":{
						Musica mc = new Musica();
						if(mc.getPreMute()) {
							Musica.establecerVolumenInicial(0.7f);
							break;
						}else {
							Musica.establecerVolumenInicial(-1000f);
						}
						break;
					}
					case "btnJugarMain":{
						Runnable readyCallback = () -> {
							saludo.setVisible(false);
							gameplay.visualFinish(false, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							String name = funcionesPrimarias.currentUser().getName();
							int score = funcionesPrimarias.currentUser().getPuntaje();
							gameLogic.setCinco(gameLogic.cincoCartas(funcionesPrimarias.currentUser()));
							gameplay.setCartasCinco(gameLogic.getCinco());
							if(score<45) {
								if (name.equals("rickroll69")) music.cambiarMusica("PizzaTheme");
								else music.cambiarMusica("BattleTheme");
							}
							else if(score<60&&score>=45) music.cambiarMusica("MidWayTheme");
							else if(score<85&&score>=60) {
								if (name.equals("rickroll69")) music.cambiarMusica("PizzaTheme");
								else music.cambiarMusica("BattleTheme");
							}
							else if(score<100&&score>=85) music.cambiarMusica("FinaleTheme");
							else if(score>=100) music.cambiarMusica("PerfectRanking");
							
							gameplay.setUserStats(funcionesPrimarias.currentUser().getName(),
									funcionesPrimarias.currentUser().getCinturon(), funcionesPrimarias.currentUser().getPuntaje());
							gameplay.setVisible(true);
						};
						mainMenu.setVisible(false);
						music.shutUp();
						music.soundEffect("TimeIsUp");
						saludo.setVisible(true);
						saludo.getReady(readyCallback);
					    break;
					}
					//in-game
						case "btnCard1":{
							if(!gameplay.getProhibited()&&!gameLogic.getPerdedor()&&!gameLogic.getGanador()) {
								gameLogic.setSeleccion(1);
								gameLogic.setRivalSelection(gameLogic.importRivalSelection());
								Carta ogCard=gameLogic.getCinco()[0];
								gameLogic.partida(gameLogic.getCinco(),gameLogic.getRivalSelection());
								Carta[] cinco = gameLogic.cincoCartas(funcionesPrimarias.currentUser());
								Runnable timeCallback = () -> {
									Runnable animeCallback = () -> {
										gameplay.setCartasCinco(cinco);
							            gameLogic.setCinco(cinco);
							            gameplay.setProhibited(false);
							            if(gameLogic.getPerdedor()) {
							            	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							            	Runnable coolCallback = () -> {
							            		gameplay.nonvisibleSelect();
								            	gameplay.setVisible(false);
								            	music.shutUpSound();
								            	resultsLoss.setVisible(true);
								            	music.soundEffect("Defeat");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
							            	gameplay.coolDown(coolCallback); 
								        }else if(gameLogic.getGanador()) {
								        	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
								        	Runnable coolCallback = () -> {
								        		gameplay.nonvisibleSelect();
									        	gameplay.setVisible(false);
									        	music.shutUpSound();
									        	resultsWin.setVisible(true);
								        		music.soundEffect("Victory");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
								        	gameplay.coolDown(coolCallback); 
								        }
									};
									if(gameLogic.getWinRound()) {
										gameplay.miniCard(ogCard, true);
										music.soundEffect(ogCard.getElemento());
										gameplay.penguinAnime(ogCard, "Player", animeCallback);
									}
							        else if(gameLogic.getLoseRound()) {
							        	gameplay.miniCard(gameLogic.getRivalSelection(), false);
							        	music.soundEffect(gameLogic.getRivalSelection().getElemento());
							        	gameplay.penguinAnime(gameLogic.getRivalSelection(), "Rival", animeCallback);
							        }
						        };
						        gameplay.visibleSelect(gameLogic.getRivalSelection(), 0, timeCallback); 
							}
							break;
						}
						case "btnCard2":{
							if(!gameplay.getProhibited()&&!gameLogic.getPerdedor()&&!gameLogic.getGanador()) {
								gameLogic.setSeleccion(2);
								gameLogic.setRivalSelection(gameLogic.importRivalSelection());
								Carta ogCard=gameLogic.getCinco()[1];
								gameLogic.partida(gameLogic.getCinco(),gameLogic.getRivalSelection());
								Carta[] cinco = gameLogic.cincoCartas(funcionesPrimarias.currentUser());
								Runnable timeCallback = () -> {
									Runnable animeCallback = () -> {
										gameplay.setCartasCinco(cinco);
							            gameLogic.setCinco(cinco);
							            gameplay.setProhibited(false);
							            if(gameLogic.getPerdedor()) {
							            	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							            	Runnable coolCallback = () -> {
							            		gameplay.nonvisibleSelect();
								            	gameplay.setVisible(false);
								            	music.shutUpSound();
								            	resultsLoss.setVisible(true);
								            	music.soundEffect("Defeat");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
							            	gameplay.coolDown(coolCallback); 
								        }else if(gameLogic.getGanador()) {
								        	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
								        	Runnable coolCallback = () -> {
								        		gameplay.nonvisibleSelect();
									        	gameplay.setVisible(false);
									        	music.shutUpSound();
									        	resultsWin.setVisible(true);
								        		music.soundEffect("Victory");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
								        	gameplay.coolDown(coolCallback); 
								        }
									};
									if(gameLogic.getWinRound()) {
										gameplay.miniCard(ogCard, true);
										music.soundEffect(ogCard.getElemento());
										gameplay.penguinAnime(ogCard, "Player", animeCallback);
									}
							        else if(gameLogic.getLoseRound()) {
							        	gameplay.miniCard(gameLogic.getRivalSelection(), false);
							        	music.soundEffect(gameLogic.getRivalSelection().getElemento());
							        	gameplay.penguinAnime(gameLogic.getRivalSelection(), "Rival", animeCallback);
							        }
						        };
						        gameplay.visibleSelect(gameLogic.getRivalSelection(), 1, timeCallback); 
							}
							break;
						}
						case "btnCard3":{
							if(!gameplay.getProhibited()&&!gameLogic.getPerdedor()&&!gameLogic.getGanador()) {
								gameLogic.setSeleccion(3);
								gameLogic.setRivalSelection(gameLogic.importRivalSelection());
								Carta ogCard=gameLogic.getCinco()[2];
								gameLogic.partida(gameLogic.getCinco(),gameLogic.getRivalSelection());
								Carta[] cinco = gameLogic.cincoCartas(funcionesPrimarias.currentUser());
								Runnable timeCallback = () -> {
									Runnable animeCallback = () -> {
										gameplay.setCartasCinco(cinco);
							            gameLogic.setCinco(cinco);
							            gameplay.setProhibited(false);
							            if(gameLogic.getPerdedor()) {
							            	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							            	Runnable coolCallback = () -> {
							            		gameplay.nonvisibleSelect();
								            	gameplay.setVisible(false);
								            	music.shutUpSound();
								            	resultsLoss.setVisible(true);
								            	music.soundEffect("Defeat");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
							            	gameplay.coolDown(coolCallback); 
								        }else if(gameLogic.getGanador()) {
								        	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
								        	Runnable coolCallback = () -> {
								        		gameplay.nonvisibleSelect();
									        	gameplay.setVisible(false);
									        	music.shutUpSound();
									        	resultsWin.setVisible(true);
								        		music.soundEffect("Victory");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
								        	gameplay.coolDown(coolCallback); 
								        }
									};
									if(gameLogic.getWinRound()) {
										gameplay.miniCard(ogCard, true);
										music.soundEffect(ogCard.getElemento());
										gameplay.penguinAnime(ogCard, "Player", animeCallback);
									}
							        else if(gameLogic.getLoseRound()) {
							        	gameplay.miniCard(gameLogic.getRivalSelection(), false);
							        	music.soundEffect(gameLogic.getRivalSelection().getElemento());
							        	gameplay.penguinAnime(gameLogic.getRivalSelection(), "Rival", animeCallback);
							        }
						        };
						        gameplay.visibleSelect(gameLogic.getRivalSelection(), 2, timeCallback); 
							}
							break;
						}
						case "btnCard4":{
							if(!gameplay.getProhibited()&&!gameLogic.getPerdedor()&&!gameLogic.getGanador()) {
								gameLogic.setSeleccion(4);
								gameLogic.setRivalSelection(gameLogic.importRivalSelection());
								Carta ogCard=gameLogic.getCinco()[3];
								gameLogic.partida(gameLogic.getCinco(),gameLogic.getRivalSelection());
								Carta[] cinco = gameLogic.cincoCartas(funcionesPrimarias.currentUser());
								Runnable timeCallback = () -> {
									Runnable animeCallback = () -> {
										gameplay.setCartasCinco(cinco);
							            gameLogic.setCinco(cinco);
							            gameplay.setProhibited(false);
							            if(gameLogic.getPerdedor()) {
							            	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							            	Runnable coolCallback = () -> {
							            		gameplay.nonvisibleSelect();
								            	gameplay.setVisible(false);
								            	music.shutUpSound();
								            	resultsLoss.setVisible(true);
								            	music.soundEffect("Defeat");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
							            	gameplay.coolDown(coolCallback); 
								        }else if(gameLogic.getGanador()) {
								        	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
								        	Runnable coolCallback = () -> {
								        		gameplay.nonvisibleSelect();
									        	gameplay.setVisible(false);
									        	music.shutUpSound();
									        	resultsWin.setVisible(true);
								        		music.soundEffect("Victory");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
								        	gameplay.coolDown(coolCallback); 
								        }
									};
									if(gameLogic.getWinRound()) {
										gameplay.miniCard(ogCard, true);
										music.soundEffect(ogCard.getElemento());
										gameplay.penguinAnime(ogCard, "Player", animeCallback);
									}
							        else if(gameLogic.getLoseRound()) {
							        	gameplay.miniCard(gameLogic.getRivalSelection(), false);
							        	music.soundEffect(gameLogic.getRivalSelection().getElemento());
							        	gameplay.penguinAnime(gameLogic.getRivalSelection(), "Rival", animeCallback);
							        }
						        };
						        gameplay.visibleSelect(gameLogic.getRivalSelection(), 3, timeCallback); 
							}
							break;
						}
						case "btnCard5":{
							if(!gameplay.getProhibited()&&!gameLogic.getPerdedor()&&!gameLogic.getGanador()) {
								gameLogic.setSeleccion(5);
								gameLogic.setRivalSelection(gameLogic.importRivalSelection());
								Carta ogCard=gameLogic.getCinco()[4];
								gameLogic.partida(gameLogic.getCinco(),gameLogic.getRivalSelection());
								Carta[] cinco = gameLogic.cincoCartas(funcionesPrimarias.currentUser());
								Runnable timeCallback = () -> {
									Runnable animeCallback = () -> {
										gameplay.setCartasCinco(cinco);
							            gameLogic.setCinco(cinco);
							            gameplay.setProhibited(false);
							            if(gameLogic.getPerdedor()) {
							            	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
							            	Runnable coolCallback = () -> {
							            		gameplay.nonvisibleSelect();
								            	gameplay.setVisible(false);
								            	music.shutUpSound();
								            	resultsLoss.setVisible(true);
								            	music.soundEffect("Defeat");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
							            	gameplay.coolDown(coolCallback); 
								        }else if(gameLogic.getGanador()) {
								        	gameplay.visualFinish(true, gameLogic.getColorsWins(), gameLogic.getWayToWin());
								        	Runnable coolCallback = () -> {
								        		gameplay.nonvisibleSelect();
									        	gameplay.setVisible(false);
									        	music.shutUpSound();
									        	resultsWin.setVisible(true);
								        		music.soundEffect("Victory");
							            	};
							            	music.shutUp();
							            	if(funcionesPrimarias.currentUser().getName().equals("rickroll69")) music.soundEffect("Meme");
							            	else music.soundEffect("TimeIsUp");
								        	gameplay.coolDown(coolCallback); 
								        }
									};
									if(gameLogic.getWinRound()) {
										gameplay.miniCard(ogCard, true);
										music.soundEffect(ogCard.getElemento());
										gameplay.penguinAnime(ogCard, "Player", animeCallback);
									}
							        else if(gameLogic.getLoseRound()) {
							        	gameplay.miniCard(gameLogic.getRivalSelection(), false);
							        	music.soundEffect(gameLogic.getRivalSelection().getElemento());
							        	gameplay.penguinAnime(gameLogic.getRivalSelection(), "Rival", animeCallback);
							        }
						        };
						        gameplay.visibleSelect(gameLogic.getRivalSelection(), 4, timeCallback); 
							}
							break;
						}
						case "btnJugarMus":{
							Musica mc = new Musica();
							if(mc.getPreMute()) {
								Musica.establecerVolumenInicial(0.7f);
								break;
							}else {
								Musica.establecerVolumenInicial(-1000f);
							}
							break;
						}
						case "btnJugarSal":{
							preventLostGame.setUserName(funcionesPrimarias.currentUser().getName()+"?");
							preventLostGame.setVisible(true);
						    break;
						}
						case "btnConfirmSalPlay":{
							music.shutUpSound();
							music.cambiarMusica("DojoMenu");
							gameLogic.setRandomCards(null);
							gameplay.nonvisibleSelect();
							preventLostGame.setVisible(false);
							gameplay.setVisible(false);
							mainMenu.setVisible(true);
						    break;
						}
						case "btnCancelSalPlay":{
							preventLostGame.setVisible(false);
						    break;
						}
						case "btnByeGameWon":{
							music.shutUpSound();
							gameLogic.setGanador(false);
							boolean level=funcionesPrimarias.finishedGame(true);
							levelUp.setCint(funcionesPrimarias.currentUser().getCinturon());
							resultsWin.setVisible(false);
							if(!level) {
			            		mainMenu.setVisible(true);
								music.cambiarMusica("DojoMenu");
			            	}
			            	else {
			            		levelUp.setVisible(true);
				            	music.soundEffect("LvUp");
			            	}
							break;
						}
						case "btnByeGameLose":{
							music.shutUpSound();
							gameLogic.setPerdedor(false);
							boolean level=funcionesPrimarias.finishedGame(false);
							levelDown.setCint(funcionesPrimarias.currentUser().getCinturon());
							resultsLoss.setVisible(false);
			            	if(!level) {
			            		mainMenu.setVisible(true);
								music.cambiarMusica("DojoMenu");
			            	}
			            	else {
			            		levelDown.setVisible(true);
				            	music.soundEffect("LvDown");
			            	}
							break;
						}
						case "btnByeChangeUp":{
							music.shutUpSound();
							levelUp.setVisible(false);
							mainMenu.setVisible(true);
							music.cambiarMusica("DojoMenu");
							break;
						}
						case "btnByeChangeDown":{
							music.shutUpSound();
							levelDown.setVisible(false);
							mainMenu.setVisible(true);
							music.cambiarMusica("DojoMenu");
							break;
						}
					case "btnMazoMain":{
						mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());
						mainMenu.setVisible(false);
						mazoView.setVisible(true);
					    break;
					}
					//opciones mazo editable
						case "btnCustomMaz":{
							String name = funcionesPrimarias.currentUser().getName();
							String preNum = mazoView.getDigNUM().getText();
							String preId = mazoView.getDigID().getText();
							try {
								@SuppressWarnings("unused")
								byte test = Byte.parseByte(preId);
							}catch(NumberFormatException e2){
								JOptionPane.showMessageDialog(mazoView, "La Id debe ser numerica (entre 1 y 30)", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							try {
								@SuppressWarnings("unused")
								byte test = Byte.parseByte(preNum);
							}catch(NumberFormatException e2){
								JOptionPane.showMessageDialog(mazoView, "El número de la carta debe ser numerico (entre 2 y 15)", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							if(preId.isEmpty()) {
								JOptionPane.showMessageDialog(mazoView, "La Id de la carta esta vacia", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							if(preNum.isEmpty()) {
								JOptionPane.showMessageDialog(mazoView, "No se especifico número de la carta", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							mazoView.setId((byte)(Byte.parseByte(preId)-1));
							mazoView.setNum(Byte.parseByte(preNum));
							if(mazoView.getId()<0||mazoView.getId()>29) {
								JOptionPane.showMessageDialog(mazoView, "Las ids de las cartas van de 1 a 30", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							if(mazoView.getNum()<2||mazoView.getNum()>15) {
								JOptionPane.showMessageDialog(mazoView, "Los números de las cartas van de 2 a 15", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							if(mazoView.getElement()==null) {
								JOptionPane.showMessageDialog(mazoView, "No ha seleccionado algun elemento", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							if(mazoView.getColor()==null) {
								JOptionPane.showMessageDialog(mazoView, "No ha seleccionado algun color", "Error", 
										JOptionPane.ERROR_MESSAGE);
								break;
							}
							byte error2 = funcionesSecundarias.asignarMazoCustom(name, mazoView.getId(), mazoView.getNum(), mazoView.getElement(), mazoView.getColor());;
							if(error2!=0) {
								JOptionPane.showMessageDialog(mazoView, "No se puede crear la Carta#"+(mazoView.getId()+1)+"="+mazoView.getNum()+mazoView.getElement()+mazoView.getColor()+
										" porque ya esta en el mazo, no pueden haber cartas repetidas ---> Carta#"+error2+"="+mazoView.getNum()+mazoView.getElement()+mazoView.getColor(), "Error", 
										JOptionPane.ERROR_MESSAGE);
							}else {
								mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());;
								mazoView.setBigCard(String.valueOf(mazoView.getNum()),mazoView.getElement(),mazoView.getColor());
								JOptionPane.showMessageDialog(userCreate, "Se ha remplazado la Carta#"+(mazoView.getId()+1)+" por una Carta="
										+mazoView.getNum()+mazoView.getElement()+mazoView.getColor(), "Validación",JOptionPane.INFORMATION_MESSAGE);
							}
						    break;
						}
						case "btnRandomMaz":{
							preventRandom.setUserName(funcionesPrimarias.currentUser().getName()+"?");
							preventRandom.setPreguntaTxt("Randomizar el mazo de", 28f,25,10);;
							preventRandom.setVisible(true);
						    break;
						}
							case "btnConfirmRand":{
								preventRandom.setVisible(false);
								String name = funcionesPrimarias.currentUser().getName();
								funcionesSecundarias.asignarMazoAleatorio(name);
								mazoView.setCurrentMazo(funcionesPrimarias.currentUser().getMazo());
								mazoView.resetBigCard();
							    break;
							}
							case "btnCancelRand":{
								preventRandom.setVisible(false);
							    break;
							}
						case "btnSalirMaz":{
							mazoView.resetBigCard();
							mainMenu.setVisible(true);
							mazoView.setVisible(false);
						    break;
						}
						case "btnFuegoMaz":{
							mazoView.setElement("Fuego");
						    break;
						}
						case "btnAguaMaz":{
							mazoView.setElement("Agua");
						    break;
						}
						case "btnNieveMaz":{
							mazoView.setElement("Nieve");
						    break;
						}
						case "btnAzulMaz":{
							mazoView.setColor("Azul");
						    break;
						}
						case "btnAmarilloMaz":{
							mazoView.setColor("Amarillo");
						    break;
						}
						case "btnRojoMaz":{
							mazoView.setColor("Rojo");
						    break;
						}
						case "btnVerdeMaz":{
							mazoView.setColor("Verde");
						    break;
						}
						case "btnMoradoMaz":{
							mazoView.setColor("Morado");
						    break;
						}
						case "btnNaranjaMaz":{
							mazoView.setColor("Naranja");
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
						userOptions.setUserName(funcionesPrimarias.currentUser().getName());
						userOptions.setPreguntaTxt("Usuario:", 35f,40,10);
						userOptions.setYesTxt("Stats", 35f,205,110);
						userOptions.setNoTxt("LogOut", 35f,35,110);
						userOptions.setVisible(true);
					    break;
					}
					//opciones user logeado
						case "btnStats":{
							userStats.setUserStats(funcionesPrimarias.currentUser().getName(),funcionesPrimarias.currentUser().getId(),
									funcionesPrimarias.currentUser().getCinturon(), funcionesPrimarias.currentUser().getPuntaje(),
									funcionesPrimarias.currentUser().getNextLv());
							userOptions.setVisible(false);
							mainMenu.setVisible(false);
							userStats.setVisible(true);
						    break;
						}
						//salir de stats
							case "btnSalirStats":{
								userStats.setVisible(false);
							    mainMenu.setVisible(true);
								break;
							}
						case "btnCerrar":{
							preventSesion.setUserName(funcionesPrimarias.currentUser().getName()+"?");;
							preventSesion.setVisible(true);
							break;
						}
						//opciones logout
							case "btnConfirmSesion":{
								music.cambiarMusica("Welcome");
								preventSesion.setVisible(false);
								userOptions.setVisible(false);
								mainMenu.setVisible(false);
								inicial.setVisible(true);
								break;
							}
							case "btnVolverSesion":{
								preventSesion.setVisible(false);
								break;
							}
					case "btnSalirMain":{
						preventSalida.setUserName(funcionesPrimarias.currentUser().getName()+"?");
						preventSalida.setVisible(true);
					    break;
					}
					//opciones salir desde main menu
						case "btnConfirmSURE":{
							System.exit(0);
							break;
						}
						case "btnVolverSURE":{
							preventSalida.setVisible(false);
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
			}
		}
	}
}