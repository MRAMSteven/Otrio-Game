/*
 * Main.java
 * 
 * Copyright 2022 steve <steve@LAPTOP-AB2CG840>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.awt.*; 
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.BorderFactory;

public class Main extends JFrame implements ActionListener{
	Main()
	{
		
		super ("Otrio");

		setLayout(null);
		setSize (1200, 670) ; 
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		show() ;
		
		
	};
	
	static String Lieu= "Menu";
	static boolean Situation = true;
	static Main InterfaceP= new Main();	
	static boolean Mainmenu = false;
	static boolean Game = true;
	static JLayeredPane interfaceP = new JLayeredPane();
	static String SituationA = "Menu";
	static int centre = 1200/2;
	//~ static Joueurs[] joueurs;
	//~ static Joueurs[] Bsj = {new Joueur1(), new Joueur2(),new Joueur3(),new Joueur4()};
	static int modeChoisi = 0 ;
	static JLabel Background = new JLabel();
	static int Tour = 0 ;
	static boolean Waiting;

	public static void main (String arg[]) {
		InterfaceP.add(interfaceP);
		interfaceP.setVisible(true);
		interfaceP.setBounds(0,0,1200,670);
		interfaceP.setBackground(Color.black);
		initialisation();
		Intro();		
		menuPrincipale ();
		
		
		while (true){
			System.out.print("");
			if (!Lieu.equals("Menu") && Situation==false && SituationA=="Menu"){
				changer();
			}
			if (Lieu.equals("Menu") && Situation==false && Mainmenu==false){
				revenirA();
			}
			if (Lieu.equals("Menu") && Situation==false && Mainmenu==true){
				Menu.setLocation(0,0);
				Background.setVisible(true);
				Situation=true;
				Mainmenu=false;
				SituationA="Menu";
			} 
			if (Lieu.equals("Jeu") && Situation==false){
				selection.setLocation(1200,670);
				try {
				Thread.sleep(500);               
				} 
				catch(InterruptedException ex) {
				ex.printStackTrace();
				}
				Background.setVisible(true);
				interfaceP.add(EnJeu,6,6);
				EnJeu.add(loading,1,0);
				EnJeu.setOpaque(true);
				EnJeu.setBounds(0,0,1200,670);
				loading.setBounds(centre-1200/2,670/2-600/2,1600,900);
				System.out.println("ok");
				EnJeu.setBackground(Color.black);
				EnJeu.setOpaque(true);
				Situation=true;
			}
			if (Lieu.equals("Jeu") && Situation==true){	
			int i;
				try {
				Thread.sleep(4000);               
				} 
				catch(InterruptedException ex) {
				ex.printStackTrace();
				}
				loading.setLocation(1200,670);
				EnJeu.setBackground(new Color(0xFCD37E));
				EnJeu.remove(loading);
				EnJeu.setOpaque(false);
				MenuPri.setEnabled(true);
				preparation();
				lancer();
				Game=true;
				
				while (Game){
				Waiting= true;
				RestartG();
				jeu = true ;
				Tour = Tour%nbj1 ;
				while (jeu) {
				if (PlusdeCercle(Tour%nbj1) || PlusdePlace() || PasDeCercle())
				{
					jeu=false;
					MatchNul();
					break;
				}
				coup=jouer(Tour%nbj1);
				System.out.println(coup[0]+","+coup[1]+","+coup[2]);
				//~ System.out.println(Couleurs[Tour%nbj1][CouleurChoisi[Tour%nbj1]]);
				t1[coup[0]][coup[1]][coup[2]]=Couleurs[Tour%nbj1][CouleurChoisi[Tour%nbj1]];
				Coup(coup, Tour%nbj1);
				info(Tour%nbj1);	
				Show();
				//~ System.out.println(Tour + "||" + Tour%nbj1);
				if (testPrincipale()) {
					jeu = false; 
					Victoire[Tour%nbj1]++;
					Victoire(Tour%nbj1);
					break;
				}
				Tour++;
				}
				System.out.println(Waiting);
				while (Waiting){
					try {
				Thread.sleep(1);               
				} 
				catch(InterruptedException ex) {
				ex.printStackTrace();
				}
					if (Lieu.equals("Menu")){
						Game=false;
						break;
				}
			}
				enlever();
				RestartG();
				if (Game){

				
			try {
			Thread.sleep(2000);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
			}
			restart.setEnabled(true);
			MenuPri.setEnabled(true);
			}	
			}
			Situation=false;
			EnJeu.setBounds(0,0,0,0);
			Mainmenu=true;
			Tour=0;
			for (i=0 ; i<nbj1 ; i++){
				EnJeu.remove(ID[i]);
			}
			for (i=0 ; i<4 ; i++){
				ChoixCouleur[i].setVisible(false);
			}
			}
		}
		
		}
static boolean PasDeCercle(){
int i;
int i1,i2,i3;
boolean PC = false;
boolean PeutJouer = false;
int PPJ = 0;
for (i1=0 ; i1<3 ; i1++){
		for (i2=0 ; i2<3 ; i2++){
			for (i3=0 ; i3<3 ; i3++){

		if (t1[i3][i2][i1]==null){
			PeutJouer=true;
			break;
		}
	
	
	}
	
}
if (!PeutJouer || ((Pcouleurs) && (NombreDeCercle[Tour%nbj1][i1]== 0 && NombreDeCercle[Tour%nbj1+2][i1]==0)) || 
		(!Pcouleurs && NombreDeCercle[Tour%nbj1][i1] == 0)){
			PPJ++;		
	}
	PeutJouer=false;

}
if (PPJ==3){
	PC=true;
}
return PC;
	
}
static void RestartG(){

	int i,i2,i3;
	t1 = new String[3][3][3];
	Restart();
for (i=0 ; i<3 ; i++){
		for (i2=0 ; i2<3 ; i2++){
			for (i3=0 ; i3<3 ; i3++){
					Bts[i][i2][i3].setVisible(true);
					CCs[i][i2][i3].setIcon(new ImageIcon());
			}
		}
	}
	for (i=0 ; i<nbj1 ; i++){
		IDJ[i][3].setText("Victoire : "+ Victoire[i]);

		if (modeChoisi==2){
			IDJ[i][4].setText("Grand : "+NombreDeCercle[i][0] +", moyen :"+NombreDeCercle[i][1]+", petit :"+NombreDeCercle[i][2]);
			IDJ[i][5].setText("Grand : "+NombreDeCercle[i+2][0] +", moyen :"+NombreDeCercle[i+2][1]+", petit :"+NombreDeCercle[i+2][2]);
		}
		else{
			IDJ[i][4].setText("Grand : "+NombreDeCercle[i][0]+", moyen :"+NombreDeCercle[i][1]+", petit :"+NombreDeCercle[i][1]);
		}
	}

}
static void enlever(){
	int i;

	try{
		Thread.sleep(3000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	for (i=0 ; i<21; i++){
		AfterMatch.setVisible(false);
		FinDeMatch.setLocation(400,300+15*i);
		
		NomGa.setBounds(600-250,290,500-25*i,80);
		try{
		Thread.sleep(30);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	}
}
static void MatchNul(){
	int i;
	NomGa.setText("Draw !");
	NomGa.setForeground(Color.white);
	NomGa.setHorizontalAlignment(JLabel.CENTER);
	try{
		Thread.sleep(3000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
	}
	for (i=0 ; i<51; i++){
		NomGa.setBounds(600-250,290,10*i,80);
		try{
		Thread.sleep(10);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}			
	}
	try{
		Thread.sleep(3000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	for (i=0 ; i<21; i++){
		FinDeMatch.setVisible(true);
		FinDeMatch.setLocation(400,670-15*i);
		try{
		Thread.sleep(30);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	}
}
static void Coup(int[] c, int i){
	
	NombreDeCercle[Tour%nbj1+CouleurChoisi[Tour%nbj1]*2][coup[2]]--;
	IDJ[i][4+CouleurChoisi[i]].setText("Grand : "+NombreDeCercle[i][0] +", moyen :"+NombreDeCercle[i][1]+", petit :"+NombreDeCercle[i][2]);
	Bts[c[0]][c[1]][c[2]].setVisible(false);
	CCs[c[0]][c[1]][c[2]].setIcon(CercleCT[Tour%nbj1+2*CouleurChoisi[Tour%nbj1]][c[2]]);
	
}
static boolean PlusdePlace(){
int i, i2, i3;
boolean PP = true ;
	for (i=0 ; i<3 ; i++){
		for (i2=0 ; i2<3 ; i2++){
			for (i3=0 ; i3<3 ; i3++){
				if (t1[i][i2][i3]==null ){
					PP = false;
				}
			}
		}
	}
				
	return PP;
}
static boolean PlusdeCercle(int i){
	if (Pcouleurs){
		return ((NombreDeCercle[i+2][0]==0 &&
				NombreDeCercle[i+2][1]==0 &&
				NombreDeCercle[i+2][2]==0) && NombreDeCercle[i][0]==0 &&
				NombreDeCercle[i][1]==0 &&
				NombreDeCercle[i][2]==0);
	}
	else {
		return (NombreDeCercle[i][0]==0 &&
				NombreDeCercle[i][1]==0 &&
				NombreDeCercle[i][2]==0);
	}

}
static void Victoire(int a){
	int i;
	NomGa.setText(Noms[a]);
	NomGa.setForeground(Color.white);
	NomGa.setHorizontalAlignment(JLabel.CENTER);
	try{
		Thread.sleep(3000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
	}
	for (i=0 ; i<51; i++){
		AfterMatch.setBounds(0,100,24*i,200);
		AfterMatch.setVisible(true);
		NomGa.setBounds(600-250,290,10*i,80);
		try{
		Thread.sleep(10);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}			
	}
	try{
		Thread.sleep(3000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	for (i=0 ; i<21; i++){
		FinDeMatch.setVisible(true);
		FinDeMatch.setLocation(400,670-15*i);
		try{
		Thread.sleep(30);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	}
	
}
static void Intro(){
	interfaceP.add(introd,2,3);
	interfaceP.setBackground(Color.black);
	introd.setBounds(-40,-25,intro.getIconWidth(),intro.getIconHeight());
	try 
		{	
		Thread.sleep(5000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
	introd.setBounds(0,0,0,0);
	interfaceP.remove(introd);
}
	//~ initialisation des boutons et des données 
	static void initialisation(){
		//la matrice principale est initialisé
		t1=ALPHA0_1_2.Initialisation(t1);
		//bouton revenir en arrière 
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setOpaque(false);
		back.setBounds(25,25,30,30);
		back.addActionListener(InterfaceP);
		back.setContentAreaFilled(false);
		initialisationM();
		
		gameInitialisation();
		/*
		interfaceP.add(CreditL,4,6);
		CreditL.setBounds(centre-1200/2,670/2-720/2,1200,720);
		CreditL.setVisible(false);
		*/
		int i;
		/*
		for (i=0 ; i<boutons.length ; i++){
				Menu.add(boutons[i]);
				boutons[i].setBounds(50, 50+100*i, 200,70);
				boutons[i].setFocusable(false);
				boutons[i].setBorder(BorderFactory.createEtchedBorder());
				//~ boutons[i].setOpaque(false);
				boutons[i].setBackground(Color.gray);
				boutons[i].setForeground(Color.white);
				boutons[i].addActionListener(InterfaceP);
			}
		*/
		Background.setBounds(0,0,1200,670);
		Background.setOpaque(true);
		ImageIcon bg = new ImageIcon("image/couleurs.jpg");
		Image bg2=bg.getImage();
		Image bgn = bg2.getScaledInstance(1200, 700,  java.awt.Image.SCALE_SMOOTH);
		bg = new ImageIcon(bgn) ;
		Background.setIcon(bg); 
		interfaceP.add(Background, 0, 4);
	
	
		
	}

	static void revenirA(){ 
		if( SituationA.equals("Mode")){
			
		}
		SituationA="Menu";
	}
	static void tutoriel(){
	}
	static void credit(){
	}
	static void changer(){
		int i;

		if (Lieu.equals("Mode")){ 
			afficher();
			interfaceP.add(selection,2,1);
			interfaceP.add(back,2,1);			
		}
		//sortie animation 

		for (i=0 ; i<31 ; i++){
		try {
		Thread.sleep(10);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
		Menu.setLocation(-42*i,0);
		entree(i);
		}
				
		//~ System.out.println("ok");
		//~ interfaceP.remove(Menu);
		
		Situation= true;
		SituationA="Mode";
		System.out.println(Situation);
		
	}
	public static void menuPrincipale(){
		if (Lieu.equals("Menu") && Situation){

			//MODIFICATION BOUTONS PREMIERE PAGE
			
			jouer.setBounds(centre-300,200,600,200);
			jouer.setFont(new Font("Impact",Font.BOLD,100));
			jouer.setBackground(new Color(0x7F6767)); // ajouter couleur personnalisée au bouton
			jouer.setForeground(Color.yellow);
			jouer.setIcon(new ImageIcon("image/play.png"));
			jouer.setOpaque(false);
			jouer.setContentAreaFilled(true);
			jouer.setBorder(BorderFactory.createEmptyBorder()); // enlever borduer 
			jouer.setFocusable(false); // enlver encardrement texte quand tu cliques
			jouer.setBorderPainted(true);
			Menu.add(jouer); // modification neccessaire pour ajouter le bouton au carré "menu"
			jouer.addActionListener(InterfaceP);
			

			Tutorial.setIcon(new ImageIcon("image/tuto.png"));
			ImageIcon NexTut = new ImageIcon(new ImageIcon("image/tuto.png").getImage().getScaledInstance(200, 50,  java.awt.Image.SCALE_SMOOTH));
			Tutorial.setIcon(NexTut);
			Tutorial.setBounds(300,500,200,50);
			Tutorial.setBackground(Color.red);
			//~ Tutorial.setContentAreaFilled(false);
			Tutorial.setOpaque(false); //couluer visible ou pas
			Tutorial.setBorder(BorderFactory.createEmptyBorder());
			Tutorial.setFocusable(false); // enlver encardrement texte quand tu cliques
			Tutorial.setBorderPainted(false);
			Menu.add(Tutorial,0,0);
			Tutorial.addActionListener(InterfaceP);
			
			Credits.setIcon(new ImageIcon("image/credits.png"));
			ImageIcon NewCred = new ImageIcon(new ImageIcon("image/credits.png").getImage().getScaledInstance(200, 50,  java.awt.Image.SCALE_SMOOTH));
			Credits.setIcon(NewCred);
			
			Credits.setBounds(650,500,200,50);
			Credits.setBackground(Color.black);
			Credits.setBorderPainted(false);
			Tutorial.setContentAreaFilled(false);
			Credits.setOpaque(false);
			Credits.setFocusable(false);
			Credits.setBorder(BorderFactory.createEmptyBorder());
			
			Menu.add(Credits,0,0);
			Credits.addActionListener(InterfaceP);
			//~ Credits
			
			quitter.setText("quitter");
			Menu.add(quitter);
			interfaceP.add(Menu,1,2);
			Menu.setBackground(Color.green);
			Menu.setOpaque(false);
			
			Menu.setVisible(true);
			Menu.setBounds(0,0,1200,670); //bound= la place et taille de Menu
		}
		else {
	}
	
	
	}	
	
	@Override
	public void actionPerformed(ActionEvent action){
	int i,i2,i3;
		if (action.getSource()==jouer){
		Lieu="Mode";
		Situation= false;			
	}
	/*
	
	if (action.getSource()==Credits){
		CreditL.setVisible(true);
		try{
		Thread.sleep(15000);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		} 
		CreditL.setVisible(false);		
	}
	*/
	if (action.getSource()==MenuPri){
		Lieu="Menu";
		Waiting=false;
		MenuPri.setEnabled(false);
	}
	if (action.getSource()==MenuPri2){
	}
	if (action.getSource()==pause){
	}


		
	if ((action.getSource()==ChoixCouleur[0]) && JType[Tour%nbj1].equals("humain")){  
		ChoixCouleur[2].setEnabled(true);
		CouleurChoisi[0]=0;
		ChoixCouleur[0].setEnabled(false);

	}
		if ((action.getSource()==ChoixCouleur[2]) && JType[Tour%nbj1].equals("humain")){  
		ChoixCouleur[0].setEnabled(true);
		CouleurChoisi[0]=1;
		ChoixCouleur[2].setEnabled(false);

	}
			if ((action.getSource()==ChoixCouleur[1]) && JType[Tour%nbj1].equals("humain")){  
		ChoixCouleur[3].setEnabled(true);
		CouleurChoisi[1]=0;
		ChoixCouleur[1].setEnabled(false);

	}
		if ((action.getSource()==ChoixCouleur[3]) && JType[Tour%nbj1].equals("humain")){  
		ChoixCouleur[1].setEnabled(true);
		CouleurChoisi[1]=1;
		ChoixCouleur[3].setEnabled(false);

	}
	if (action.getSource()==restart){
		Waiting=false;
		restart.setEnabled(false);		
	}
		if (action.getSource()==quitter || action.getSource()==QUIT1 || action.getSource()==QUIT2){
		System.exit(0);
	}
		if (action.getSource()==back){
		Lieu="Menu";
		Situation= false;
	}
		if (action.getSource()==confirmer){
		Lieu="Jeu";
		jeu=true;
		Situation=false;
		
	}
	
	if (action.getSource()==Mod1){
		modeChoisi = 0;
		nbj1 = 4;
		description.setText(descp[modeChoisi]);
		mode1.setVisible(true);
		Mod1.setEnabled(false);
		Mod2.setEnabled(true);
		mode2.setVisible(false);
		Mod3.setEnabled(true);
		mode3.setVisible(false);
		for (i=0; i<2;i++){
		colors[i+2].setLocation(170,160+40*i);
		colors[i+2].setVisible(true);
		mode1.add(noms[i]);
		mode1.add(colors[i]);
		mode1.add(Types[i]);
		mode1.add(colors[i+2]);
		
	}
		
	}
	if (action.getSource()==Mod2){
		modeChoisi = 1;
		nbj1 = 2;
		description.setText(descp[modeChoisi]);
		mode2.setVisible(true);
		Mod2.setEnabled(false);
		Mod1.setEnabled(true);
		mode1.setVisible(false);
		Mod3.setEnabled(true);
		mode3.setVisible(false);
		for (i=0; i<2;i++){
		colors[i+2].setVisible(false);
		mode2.add(noms[i]);
		
		mode2.add(colors[i]);
		mode2.add(Types[i]);
		mode2.add(colors[i+2]);
		
	}
		
	
	}
	if (action.getSource()==Mod3){
		modeChoisi = 2;
		nbj1 = 2;
		description.setText(descp[modeChoisi]);
		mode3.setVisible(true);
		Mod3.setEnabled(false);
		mode1.setVisible(false);
		Mod1.setEnabled(true);		
		Mod2.setEnabled(true);
		mode2.setVisible(false);
		colors[2].setLocation(175+70,80);
		colors[3].setLocation(175+70,80+40);
		for (i=0; i<2;i++){
		mode3.add(noms[i]);
		mode3.add(colors[i]);
		mode3.add(Types[i]);mode1.add(colors[i+2]);
		mode3.add(colors[i+2]);
		
		//~ colors[i+2].setOpaque(true);
		colors[i+2].setVisible(true);
	}

	}

	for (i=0 ; i<3; i++){
		for (i2=0 ; i2<3; i2++){
			for (i3=0 ; i3<3; i3++){
				if (action.getSource()==Bts[i][i2][i3] && JType[Tour%nbj1].equals("humain") && NombreDeCercle[Tour%nbj1+2*CouleurChoisi[Tour%nbj1]][i3]>0){
					coup[0]= i ;
					coup[1]= i2 ;
					coup[2]= i3;
				}
			}
		}
		
	}	
}
static ImageIcon PlateauBG = new ImageIcon("image/Plateau.jpg");
static JLabel PlateauFond = new JLabel(new ImageIcon(PlateauBG.getImage().getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH)));
public static void gameInitialisation(){
	int i,i1,i2,i3;
	EnJeu.add(Plateau);
	EnJeu.setOpaque(false);
	Plateau.add(PlateauFond , 0,7);
	PlateauFond.setBounds(0,0,600,600);

		
	
	//~ Plateau.setIcon(new ImageIcon("Background.jpg"));
	//~ Plateau.setOpaque(false);
	Plateau.setBackground(new Color(0xFFED7B));
	Plateau.setOpaque(false);
	for (i1=0; i1<4 ; i1++){
		for (i2=0; i2<3 ; i2++){
		CercleCT[i1][i2]=new ImageIcon(CercleC[i1].getImage().getScaledInstance(160-40*i2, 160-40*i2,  java.awt.Image.SCALE_SMOOTH));
	}
	}
	for (i1=0; i1<3; i1++ ) { 
		for (i2=0; i2<3; i2++ ) {
			for (i3=0; i3<3; i3++ ) {
				Bts[i1][i2][i3] = new JButton();
				CCs[i1][i2][i3] = new JLabel();
				Plateau.add(Bts[i1][i2][i3],i3,i2);
				Plateau.add(CCs[i1][i2][i3],i3,i2);
				Bts[i1][i2][i3].setVisible(false);
				CCs[i1][i2][i3].setOpaque(false);
				
			}
		}
	}

	for (i1=0; i1<3; i1++ ) { 
		for (i2=0; i2<3; i2++ ) {
			for (i3=0; i3<3; i3++ ) {
				
				
				Bts[i1][i2][i3].setBounds(BoutonP[i1][i2][i3][0]-20,BoutonP[i1][i2][i3][1]-20,BoutonP[i1][i2][i3][2],BoutonP[i1][i2][i3][3]);
				CCs[i1][i2][i3].setBounds(BoutonP[i1][i2][i3][0]-20,BoutonP[i1][i2][i3][1]-20,BoutonP[i1][i2][i3][2],BoutonP[i1][i2][i3][3]);
				//~ Bts[i1][i2][i3].setForeground(new Color(0xA65F38));
				Bts[i1][i2][i3].setBorder(BorderFactory.createEmptyBorder());
				Bts[i1][i2][i3].setBackground(new Color(0xDAD5D2));
				Bts[i1][i2][i3].setOpaque(false);
			
				//~ System.out.println(Bts[i1][i2][i3].getBorder());
				
				Bts[i1][i2][i3].setContentAreaFilled(true);
				Bts[i1][i2][i3].setFocusable(false);
				//~ Bts[i1][i2][i3].setBorderPainted(false);
				Bts[i1][i2][i3].addActionListener(InterfaceP);
				JButton jButton1 = Bts[i1][i2][i3];
				
				
				//permet de gérer l'animation des boutons quand "hovered"
				jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				//~ jButton1.setOpaque(true);
				jButton1.setBorder(BorderFactory.createLineBorder(Colors[Tour%nbj1+2*CouleurChoisi[Tour%nbj1]],5));
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
				//~ jButton1.setOpaque(false);
				jButton1.setBorder(BorderFactory.createEmptyBorder());
				}
});
	

				

				
			}
		}
	}
	EnJeu.add(cadre,0,0);
	cadre.setVisible(false);
	cadre.setBounds(0,0,270,300);
	cadre.setBorder(BorderFactory.createLineBorder(Colors[Tour%nbj1],2));
	AfterMatch.setIcon(Victory);
	EnJeu.add(AfterMatch,5,5);
	NomGa=new JLabel();
	EnJeu.add(NomGa,6,5);
	NomGa.setFont(new Font("Impact", Font.ITALIC, 100));
	AfterMatch.setBackground(Color.black);
	//~ AfterMatch.setOpaque(true);
	EnJeu.add(FinDeMatch,8,3);
	FinDeMatch.add(restart);    //     MODIFICATION FIN DU JEU
	FinDeMatch.setSize(400,600);
	FinDeMatch.setLocation(400,670);
	FinDeMatch.setVisible(false);
	FinDeMatch.add(restart);
	
	restart.setBounds(10,30,480,50);
	restart.setBackground (new Color(0xCC8A25));
	restart.addActionListener(InterfaceP);
	restart.setFont(new Font("Impact", Font.PLAIN, 20));
	restart.setHorizontalAlignment(JButton.CENTER);
	FinDeMatch.add(QUIT1);
	QUIT1.setBounds(10,85,480,50);
	QUIT1.setBackground (new Color(0xCC8A25));
	QUIT1.addActionListener(InterfaceP);
	QUIT1.setFont(new Font("Impact", Font.BOLD, 20));
	QUIT1.setHorizontalAlignment(JButton.CENTER);
	FinDeMatch.add(MenuPri);
	QUIT1.setFocusable(false);
	MenuPri.setBounds(10,140,480,50);
	MenuPri.setBackground (new Color(0xCC8A25));
	MenuPri.addActionListener(InterfaceP);
	MenuPri.setFont(new Font("Impact", Font.BOLD, 20));
	MenuPri.setHorizontalAlignment(JButton.CENTER);
	MenuPri.setFocusable(false);
	
	
	
	EnJeu.add(Pause);
	for (i=0 ; i<4 ; i++){
		ChoixCouleur[i].setSize(180,70);
		ChoixCouleur[i].setVisible(false);
		EnJeu.add(ChoixCouleur[i],5,5);
		ChoixCouleur[i].setBackground(new Color(0x6B6B6B));
		ChoixCouleur[i].setFocusable(false);
		ChoixCouleur[i].setForeground(Colors[i]);
		ChoixCouleur[i].setFont(new Font("Impact", Font.PLAIN, 25));
		ChoixCouleur[i].setLocation(Coord[i][0],Coord[i][1]);
		ChoixCouleur[i].addActionListener(InterfaceP);
	}
}
static int[][] Coord = {{10, 350}, {960, 350}, {10, 450},{960, 450}};
public static void preparation(){
	int i;
	t1 = new String[3][3][3];
	//~ joueurs = new Joueurs[nbj1];
	ID= new JLabel[nbj1];
	IDJ=new JLabel[nbj1][7];
	Victoire = new int[nbj1];
	Noms= new String[nbj1];
	CouleurChoisi= new int[nbj1];
	Couleurs=new String[nbj1][2];
	NombreDeCercle= new int[4][3];
	Restart();
	JType=new String[nbj1];
	for (i=0 ; i<nbj1 ; i++){
		//~ joueurs [i]= Bsj[i];
		
		ID[i]=new JLabel();
		IDJ[i][0] = new JLabel(); //nom
		IDJ[i][0].setForeground(Color.white);
		IDJ[i][0].setBounds(175,5,90,45);
		IDJ[i][1] = new JLabel(); //couleur
		IDJ[i][1].setForeground(Color.white);
		IDJ[i][1].setBounds(175,105,100,45);
		IDJ[i][2] = new JLabel(); //type
		IDJ[i][2].setForeground(Color.white);
		IDJ[i][2].setBounds(175,55,90,45);
		IDJ[i][3] = new JLabel(); //Victoire
		IDJ[i][3].setForeground(Color.white);
		IDJ[i][3].setBounds(175,155,90,45);
		IDJ[i][4] = new JLabel(); //Nombre de cercle 1
		IDJ[i][4].setForeground(Color.white);
		IDJ[i][4].setBounds(10,205,170,45);
		IDJ[i][5] = new JLabel(); //Nombre de cercle 2
		IDJ[i][5].setForeground(Color.white);
		IDJ[i][5].setBounds(10,250,170,45);
		IDJ[i][5].setVisible(false);
	Nop = new ImageIcon(NopF);
		IDJ[i][6] = new JLabel(Nop); //Prof 
		IDJ[i][6].setBorder(BorderFactory.createBevelBorder(2));
		IDJ[i][6].setBounds(0,0,170,200);
		
		ID[i].add(IDJ[i][6]);
		
		ID[i].add(IDJ[i][4]);
		ID[i].add(IDJ[i][5]);

		ID[i].add(IDJ[i][0]);
		ID[i].add(IDJ[i][2]);
		ID[i].add(IDJ[i][1]);
		ID[i].add(IDJ[i][3]);
		ID[i].add(IDJ[i][4]);
		ID[i].add(IDJ[i][5]);
		
		Noms[i] = noms[i].getText();
		
		IDJ[i][0].setText("Nom : " + noms[i].getText());
		IDJ[i][3].setText("Victoire : "+ Victoire[i]);

		if (modeChoisi==2){
			Pcouleurs=true;
			
			Couleurs[i][0]=couleurR[i]; 
			IDJ[i][1].setText(couleurR[i] + " & " + couleurR[i+2]);
			IDJ[i][5].setVisible(true);
			IDJ[i][4].setText("Grand : "+NombreDeCercle[i][0] +", moyen :"+NombreDeCercle[i][1]+", petit :"+NombreDeCercle[i][2]);
			Couleurs[i][1]=couleurR[i+2];
			IDJ[i][5].setText("Grand : "+NombreDeCercle[i+2][0] +", moyen :"+NombreDeCercle[i+2][1]+", petit :"+NombreDeCercle[i+2][2]);
		}
		else{
			Pcouleurs=false;
			Couleurs[i][0]=couleurR[i];
			IDJ[i][1].setText("Couleur : "+ couleurR[i]);
			IDJ[i][4].setText("Grand : "+NombreDeCercle[i][0]+", moyen :"+NombreDeCercle[i][1]+", petit :"+NombreDeCercle[i][1]);
		}
		JType[i]=Types[i].getSelectedItem();
		IDJ[i][2].setText("type :" +JType[i]);
		info(i);
		ID[i].setBackground(Color.black);
		ID[i].setOpaque(true);


	}	

}
static void IPause(){
}

static int [][][][] BoutonP = { { {{40,40,160,160},{60,60,120,120},{80,80,80,80}},
						{{240,40,160,160},{260,60,120,120},{280,80,80,80}},
						{{440,40,160,160},{460,60,120,120},{480,80,80,80}} },
						{ {{40,240,160,160},{60,260,120,120},{80,280,80,80}},
						{{240,240,160,160},{260,260,120,120},{280,280,80,80}},
						{{440,240,160,160},{460,260,120,120},{480,280,80,80}} },
						{ {{40,440,160,160},{60,460,120,120},{80,480,80,80}},
						{{240,440,160,160},{260,460,120,120},{280,480,80,80}},
						{{440,440,160,160},{460,460,120,120},{480,480,80,80}} },}					
;
//~ les objets créés dans le menu  
//________________________________________________________
		static JLayeredPane Menu = new JLayeredPane();
		static JButton jouer = new JButton();
		static JButton Tutorial = new JButton();
		static JButton Credits = new JButton();
		static JButton quitter = new JButton();
		static JButton[] boutons= {jouer, Tutorial, Credits, quitter};
//________________________________________________________

//~ le boutons revenir
//________________________________________________________
		
		static ImageIcon a= new ImageIcon("image/back.png");
		static ImageIcon af= new ImageIcon(a.getImage().getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH));
		static JButton back = new JButton(af);
			
			
//________________________________________________________
//~ les anciennes variables importantes
//________________________________________________________

static ImageIcon intro = new ImageIcon("image/Intro.gif");
static JLabel introd = new JLabel(intro);
static String [][][] t1 = new String [3][3][3] ;
	static int [][]MatTest = {{0,0,0},{1,1,1},{2,2,2},{0,1,2},{2,1,0}};
	static String MatriceSelection = "111213212223313233112233312213112131122232132333" ;
	static int [][][] Matselec = ALPHA0_1_2.Matriceinitialisation(MatriceSelection,8,3,2);;
	static String [] couleur = {"r","b","v","j"};              
	static String [] couleurR =  { "Rouge", "Bleu", "Vert", "Jaune"};
	static int [][] couleurgb = {{255,0,0},{0,0,255},{0,255,0},{255,255,0}};
	static Color[] Colors= {Color.red , Color.blue, Color.green, Color.yellow};
	static boolean jeu = true ;
	static int nb_joueurs,k=0,nb_couleurs1,mode,n;
	
//_______________________________________Redefinition des joueurs___________________________________
	
	static String[] Noms ;
	static String[][] Couleurs ;
	static String[] JType;
	static int[] CouleurChoisi ;
	static int[][] NombreDeCercle;
	static int[] Victoire;

//_______________________________________Durant le match____________________________________
	
	public static int[] coup = {4,4,4};
	public static void Restart(){
		int i;
		for (i=0 ; i<4; i++){	
		NombreDeCercle[i][0]=3;
		NombreDeCercle[i][1]=3;
		NombreDeCercle[i][2]=3;
	}
	}
	static ImageIcon Ipause = new ImageIcon("image/Pause.png");
	static ImageIcon Victory = new ImageIcon("image/Victory.gif");
	static JLabel Pause = new JLabel();
	static JButton pause = new JButton() ;
	static ImageIcon Credit = new ImageIcon("image/Credits.gif");
	static JLabel CreditL = new JLabel(Credit);
	

	static JButton restart = new JButton("Restart");
	static JButton MenuPri2 = new JButton("Menu Principal");
	static JButton QUIT1 = new JButton("Quitter");
	static JButton QUIT2 = new JButton("Quitter");
	static JLabel AfterMatch = new JLabel();
	static JLabel FinDeMatch = new JLabel();
	static JLabel gagnant = new JLabel();
	static JLabel NomGa;

	static JButton Stat = new JButton("statistique");
	static JButton MenuPri = new JButton ("Menu Principal");
	static JButton Retour = new JButton ("Retour");
	static int Partie = 1;
	
	
	public static void Reicoup(){
		coup[0]= 4;
	}
	
//_______________________________________   Mode ___________________________________
	static int nbj1=4;
	static int nboutons = 1+nbj1*2;
	static boolean Pcouleurs=false;	
	static JLayeredPane selection = new JLayeredPane();
	
	
	//~ les objets créés dans le mode  
//________________________________________________________
	

//________________________________________________________

	//~ les objets pour jouer
//________________________________________________________

	static ImageIcon Nop = new ImageIcon("image/profil.png");
	static Image Nop2=Nop.getImage();
	static Image NopF = Nop2.getScaledInstance(170, 200,  java.awt.Image.SCALE_SMOOTH);
	
	static JLabel cadre = new JLabel();
	static ImageIcon GrillI = new ImageIcon("image/grille.png");
	static JLabel Grille = new JLabel(GrillI);

	static JLayeredPane EnJeu = new JLayeredPane();
	static ImageIcon loadingI = new ImageIcon("image/Loading5.gif");
	static JLabel loading = new JLabel(loadingI);
	
	static ImageIcon Red = new ImageIcon("image/0ROUGE.png");
	static ImageIcon Blue = new ImageIcon("image/0BLEU.png");
	static ImageIcon Green = new ImageIcon("image/0VERT.png");
	static ImageIcon Yellow = new ImageIcon("image/0JAUNE.png");
	
	static ImageIcon[] CercleC = {Red,Blue,Green,Yellow};
	static Image[][] IMcercle ;
	static ImageIcon[][] CercleCT = new ImageIcon[4][3];

	static JLayeredPane Plateau = new JLayeredPane();

	static JLabel[] ID;
	static JLabel[][] IDJ;
	static JButton[][][] Bts= new JButton[3][3][3];
	static JLabel[][][] CCs= new JLabel[3][3][3];
	
	static JButton ChoixC11 = new JButton("Rouge");
	static JButton ChoixC12 = new JButton("Bleu");
	static JButton ChoixC21 = new JButton("Vert");
	static JButton ChoixC22 = new JButton("Jaune");
	static JButton[] ChoixCouleur = {ChoixC11 , ChoixC12, ChoixC21, ChoixC22};
	
	
	
	//set de coordonnés 
	static int[][] coins = {{5,15},{915,15},{5,325},{915,325}};
	
	
//________________________________________________________
	public static void afficher(){
		selection.setLocation(600-400+1200,50);


		
	}
	public static void entree(int i){
		selection.setLocation(600-400+1200-42*i,50);
	}
	public static void lancer(){
	int i,i2,i1,i3;
	
		for (i=0; i<nbj1 ; i++){
			EnJeu.add(ID[i]);

			ID[i].setBounds(coins[i][0],-300,270,300);
		}
		Plateau.setBounds(300,-600,600,600);
		//~ placer les objets (animation):
		for (i2=0; i2<20 ; i2++){
			for (i=0; i<nbj1 ; i++){
			ID[i].setLocation(coins[i][0],-300+(coins[i][1]+300)/20*(i2+1));
		}
		
		Plateau.setLocation(300,-600+620/20*(i2+1));
		try 
		{	
		Thread.sleep(25);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
		}
		for (i=0;i<nbj1;i++){
			ID[i].setLocation(coins[i][0],coins[i][1]);
		}
		
		for (i2=0; i2<=5 ; i2++){
			Plateau.setLocation(300,20+i2*10);
			try 
		{	
		Thread.sleep(50);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
		}
		for (i2=0; i2<=5 ; i2++){
			Plateau.setLocation(300,20+10*5-i2*10);
			try 
		{	
		Thread.sleep(50);               
		} 
		catch(InterruptedException ex) {
		ex.printStackTrace();
		}
		}
	Plateau.add(Grille,0,0);
	Grille.setBounds(0,0,600,600);
	for (i1=0; i1<3; i1++ ) { 
		for (i2=0; i2<3; i2++ ) {
			for (i3=0; i3<3; i3++ ) {
				Bts[i1][i2][i3].setVisible(true);
				
			}
		}
	}
	for (i=0 ; i<4 ; i++){
		
	if (Pcouleurs){  
		ChoixCouleur[i].setVisible(true);
	}
	else{
		ChoixCouleur[i].setVisible(false);
	}
	}
}
public static void info(int i){
		System.out.println(Noms[i]);
		System.out.println(JType[i]);
		System.out.println(Victoire[i]);
		System.out.println(Couleurs[i][CouleurChoisi[i]]);
		System.out.println(Pcouleurs);
	}
public static boolean testPrincipale(){
		int i,i2,i3;
		boolean a = false ;
		for (i2=0; i2<couleurR.length ; i2++){
		for (i=0 ; i<Matselec.length ; i++){
			for (i3=0 ; i3<MatTest.length ; i3++){ 
			if (couleurR[i2].equals(t1[Matselec[i][0][0]][Matselec[i][0][1]][MatTest[i3][0]])
			&&	couleurR[i2].equals(t1[Matselec[i][1][0]][Matselec[i][1][1]][MatTest[i3][1]])
			&&  couleurR[i2].equals(t1[Matselec[i][2][0]][Matselec[i][2][1]][MatTest[i3][2]])){
/*				
			System.out.println( "l " + Matselec[i][0][0]+ " col " + Matselec[i][0][1] + " taille " +MatTest[i3][0] + "& n/"
									+ " l " + Matselec[i][1][0]+ " col " + Matselec[i][1][1] + " taille " +MatTest[i3][1] + "& n/" 
									+ " l " + Matselec[i][2][0]+ " col " + Matselec[i][2][1] + " taille " +MatTest[i3][2] );
*/  // il sert a afficher comment le joueur a gagné
				a = true ; 
				break ;					
			}
			}
			if (a==true) { 
				break ;
			}
			
			}
			if (a==true) { 
				break ;
			}
			if ((a== false) && ((Test1(couleurR[i2])))){
				a= true ; 
				break;
		}							
		
			}
		if (a== true){
	//~ System.out.println("c'est fini, la couleur " + couleurR [i2] + ",c'est à dire" + s + " a gagne!" );
}	
	
	return a;
}
public static boolean Test1(String c){
		boolean testeur = false ; 
		int i, i2, i3;
		for (i=0; i<t1.length ; i++){ 
		for (i2=0; i2<t1[i].length ; i2++){ 
			if (c.equals(t1[i][i2][0]) && c.equals(t1[i][i2][1]) && c.equals(t1[i][i2][2])) {
				testeur = true ; 
				System.out.println("true");
				break ;
			
		} 		
		}
		if (testeur == true) { 
			break ; 			                                      
		}			
		}
	return testeur ;
	}
	public static int[] jouer(int i){
		int [] jeu = new int[3];
		int i2,i3,i4,k1,k2,k3,k4;
		String c;
		Reicoup();
		if (JType[i].equals("humain")){
			while (coup[0]==4 && Lieu.equals("Jeu")) {
//___________________faire clignoter le cadre _________________________
				cadre.setVisible(true);
				cadre.setLocation(coins[i][0],coins[i][1]);
				cadre.setBorder(BorderFactory.createLineBorder(Colors[i],2));
			if (coup[0]!=4){
				cadre.setVisible(false);
				break;
			}
			try 
			{	
			Thread.sleep(100);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
			}
			cadre.setVisible(false);
			cadre.setLocation(coins[i][0],coins[i][1]);
				cadre.setBorder(BorderFactory.createLineBorder(Colors[i],2));
				try 
			{	
			Thread.sleep(100);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
			}
			if (coup[0]!=4){
				cadre.setVisible(false);
				break;
			}
//____________________________________________________________
			}

		}
			else if(JType[i].equals("IA")){
		int max1= 1;
		int min1= 0;

        int min = 0;
        int max = 2;
        k1 = (int)(Math.random()*(max-min+1)+min);
        k2 = (int)(Math.random()*(max-min+1)+min);
        k3 = (int)(Math.random()*(max-min+1)+min);
 
        while (t1[k1][k2][k3]!=null || NombreDeCercle[i+2*CouleurChoisi[i]][k3]==0){
		if (Pcouleurs) {CouleurChoisi[i] = (int)(Math.random()*(max1-min1+1)+min1);}
        k1 = (int)(Math.random()*(max-min+1)+min);
        k2 = (int)(Math.random()*(max-min+1)+min);
        k3 = (int)(Math.random()*(max-min+1)+min);
        
        //___________________faire clignoter le cadre _________________________
				cadre.setVisible(true);
				cadre.setLocation(coins[i][0],coins[i][1]);
				cadre.setBorder(BorderFactory.createLineBorder(Colors[i],2));
			try 
			{	
			Thread.sleep(100);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
			}
			cadre.setVisible(false);
			cadre.setLocation(coins[i][0],coins[i][1]);
				cadre.setBorder(BorderFactory.createLineBorder(Colors[i],2));
				try 
			{	
			Thread.sleep(100);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
			}
//____________________________________________________________
        }
        coup[0]= k1 ;
        coup[1]= k2 ;
        coup[2]= k3;
		
		try 
			{	
			Thread.sleep(500);               
			} 
			catch(InterruptedException ex) {
			ex.printStackTrace();
		}
        
        }
else if(JType[i].equals("IA (hard)")){
		
//L'IA teste si elle peut gagner la partie : elle joue le coup qui lui permet de gagner

boolean strategie = false;
	while (coup[0]==4){	
	int bin=0;

		if (Pcouleurs){ bin = 1;}
	for (CouleurChoisi[i]=0 ; CouleurChoisi[i]<bin+1; CouleurChoisi[i]++){
		System.out.println("marche " + CouleurChoisi[i]);
		for (i4=0 ; i4<Matselec.length ; i4++){
			for (i3=0 ; i3<MatTest.length ; i3++){ 
			
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])
			&&	Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])) &&
			(null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]))&& NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][2]]>0){
			coup[0] = Matselec[i4][2][0];
			coup[1] = Matselec[i4][2][1];
			coup[2] = MatTest[i3][2];
			strategie = true;
			break;
			}
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])
			&& Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])) &&
			(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]))&& NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][1]]>0){
			coup[0] = Matselec[i4][1][0];
			coup[1] = Matselec[i4][1][1];
			coup[2] = MatTest[i3][1];
			strategie = true;
			break;
			}
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])
			&& couleurR[i].equals(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])) &&
			(null==(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))&& NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][0]]>0){
			coup[0] = Matselec[i4][0][0];
			coup[1] = Matselec[i4][0][1];
			coup[2] = MatTest[i3][0];
			strategie = true;
			break;
			}
			}
			}
			if (strategie){
				break;
			}
		}
		if (coup[0]!=4){
			break;
		}	
	CouleurChoisi[i]=0;
	for (CouleurChoisi[i]=0; CouleurChoisi[i]<bin+1; CouleurChoisi[i]++){
			for (i4=0; i4<t1.length ; i4++){ 
			for (i2=0; i2<t1[i4].length ; i2++){ 
			c = Couleurs[i][CouleurChoisi[i]];
			if (((c.equals(t1[i4][i2][0]) && c.equals(t1[i4][i2][1])) && (null==(t1[i4][i2][2])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][2]>0)) {
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 2;
			strategie = true;
			break ;
			}
			if (((c.equals(t1[i4][i2][0]) && c.equals(t1[i4][i2][2])) && (null==(t1[i4][i2][1])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][1])>0){
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 1;
			strategie = true;
			break ;
			}
			if (((c.equals(t1[i4][i2][1]) && c.equals(t1[i4][i2][2])) && (null==(t1[i4][i2][0])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][0]>0)){
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 0;
			strategie = true;
			break ;
			
			}
			}
			if (strategie){
				break;
			}
			}
			if (strategie){
				break;
			}
		}

		if (coup[0]!=4){
			break;
		}
CouleurChoisi[i]=0;
//L'IA ne peut pas gagner la partie, elle vérifie si l'adversaire peut gagner la partie au prochain coup et le contre :
// elle joue le coup qui empêche son adversaire de gagner

for (CouleurChoisi[i]=0 ; CouleurChoisi[i]<bin+1; CouleurChoisi[i]++){
	System.out.println("essaie de contrer");
		for (i2=0; i2<nbj1+2*bin ; i2++){
		for (i4=0; i4<t1.length ; i4++){ 
			for (i3=0; i3<t1[i4].length ; i3++){ 
			c = couleurR[i2];
			if (((c.equals(t1[i4][i3][0]) && c.equals(t1[i4][i3][1])) && (null==(t1[i4][i3][2])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][2]>0) ) {
			coup[0] = i4;
			coup[1] = i3;
			coup[2] = 2;
			strategie = true;
			break ;
			}
			if (((c.equals(t1[i4][i3][0]) && c.equals(t1[i4][i3][2])) && (null==(t1[i4][i3][1])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][1]>0)){
			coup[0] = i4;
			coup[1] = i3;
			coup[2] = 1;
			strategie = true;
			break ;
			}
			if (((c.equals(t1[i4][i3][1]) && c.equals(t1[i4][i3][2])) && (null==(t1[i4][i3][0])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][0]>0)){
			coup[0] = i4;
			coup[1] = i3;
			coup[2] = 0;
			strategie = true;
			break ;
			}
			}
		if (strategie){
				break;
			}
			}
		if (coup[0]!=4){
			break;
		}
		for (i4=0 ; i4<Matselec.length ; i4++){
			for (i3=0 ; i3<MatTest.length ; i3++){ 
				
			if ((couleurR[i2].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])
			&&	couleurR[i2].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])) &&
			(null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][2]]>0)){
			coup[0] = Matselec[i4][2][0];
			coup[1] = Matselec[i4][2][1];
			coup[2] = MatTest[i3][2];
			strategie = true;
			break;
			}
			if ((couleurR[i2].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])
			&& couleurR[i2].equals(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])) &&
			(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][1]]>0)){
			coup[0] = Matselec[i4][1][0];
			coup[1] = Matselec[i4][1][1];
			coup[2] = MatTest[i3][1];
			strategie = true;
			break;
			}
			if ((couleurR[i2].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])
			&& couleurR[i2].equals(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])) &&
			(null==(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][0]]>0)){
			coup[0] = Matselec[i4][0][0];
			coup[1] = Matselec[i4][0][1];
			coup[2] = MatTest[i3][0];
			strategie = true;
			break;
			}
			}
			if (strategie){
				break;
			}
			}
			if (strategie){
				break;
			}	
		}
		if (strategie){
				break;
			}
	}
System.out.println(coup[0]+ ":" + coup[1] +":" + coup[2] + strategie);

	if (CouleurChoisi[i]==0 && Pcouleurs && (ContreStrategique((CouleurChoisi[i]+1)%2 , coup[0], coup[1],coup[2],i)) ){
		CouleurChoisi[i]=(CouleurChoisi[i]+1)%2;

	}
	else{
	CouleurChoisi[i]=0;
	}
	if (coup[0]!=4){
			break;
	}


//L'IA ne peut pas gagner la partie, n'a pas à contrer l'adversaire, elle cherche donc à se rapprocher de la victoire : 
//elle joue un coup qui pourrait la mettre en position de gagner au prochain tour

int[] random = {0,2,2,0,7,1,0,6,0,0,3,4,3,5,2,0,0,1,4,3,2,1,5,4,2,0};
int[] randomI ={0,1,2,0,1,2,2,1,0,0,1,2,1,2,1,2,3,2,1,0,0,1,0,3,4,5};
int min1 = 0;
int max1 = 25;
int var = (int)(Math.random()*(max1-min1+1)+min1);
for (CouleurChoisi[i]=0 ; CouleurChoisi[i]<bin+1 ; CouleurChoisi[i]++){

		for (i4=random[var] ; i4<Matselec.length ; i4++){
			for (i3=0 ; i3<MatTest.length ; i3++){ 
				
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))
			&&	(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]) &&
			(null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][2]]>0)){
			coup[0] = Matselec[i4][2][0];
			coup[1] = Matselec[i4][2][1];
			coup[2] = MatTest[i3][2];
			strategie = true;
			break;
			}
			
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))
			&& (null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]) &&
			(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][1]]>0)){
			coup[0] = Matselec[i4][1][0];
			coup[1] = Matselec[i4][1][1];
			coup[2] = MatTest[i3][1];
			strategie = true;
			break;
			}
			if ((Couleurs[i][CouleurChoisi[i]].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]))
			&& (null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]) &&
			(null==(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][0]]>0)){
			coup[0] = Matselec[i4][0][0];
			coup[1] = Matselec[i4][0][1];
			coup[2] = MatTest[i3][0];
			strategie = true;
			break;
			}
			}
			if (strategie){
				break;
			}
			}
var = (int)(Math.random()*(max1-min1+1)+min1);
			for (i4=randomI[var]; i4<t1.length ; i4++){ 
			for (i2=0; i2<t1[i4].length ; i2++){ 
			c = Couleurs[i][CouleurChoisi[i]];
			if ((c.equals(t1[i4][i2][0])) && (null==(t1[i4][i2][1]) && (null==(t1[i4][i2][2])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][2]>0)) {
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 2;
			strategie = true;
			break ;
			}
			if ((c.equals(t1[i4][i2][0])) && (null==(t1[i4][i2][2]) && (null==(t1[i4][i2][1])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][1]>0)){
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 1;
			strategie = true;
			break ;
			}
			if ((c.equals(t1[i4][i2][1])) && (null==(t1[i4][i2][2]) && (null==(t1[i4][i2][0])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][0]>0)){
			coup[0] = i4;
			coup[1] = i2;
			coup[2] = 0;
			strategie = true;
			break ;
			
			}
			}
			if (strategie){
				break;
			}
			}
		if (strategie){
			break;
		}
}

//L'IA n'a pas de possibilité de gagner, de contrer, ou de jouer stratégiquement, elle joue au hasard un coup qui peut le faire gagner 
if (coup[0]!=4){
			break;
		}
CouleurChoisi[i]=0;
int i7;

var = (int)(Math.random()*(max1-min1+1)+min1);
System.out.println(var);
int MaxChoix=1;
int MinChoix=0;
if (Pcouleurs){CouleurChoisi[i] = (int)(Math.random()*(MaxChoix-MinChoix+1)+MinChoix);}
		for (i4=randomI[var] ; i4<Matselec.length ; i4++){
			for (i3=0 ; i3<MatTest[i3].length ; i3++){ 
			int p1 = Matselec[i4][0][0];
			int p2 = Matselec[i4][0][1]; 
			int p3 = MatTest[i3][0];
			int p4 = Matselec[i4][1][0];
			int p5 = Matselec[i4][1][1];
			int p6 = MatTest[i3][1];
			int p7 = Matselec[i4][2][0];
			int p8 = Matselec[i4][2][1];
			int p9 = MatTest[i3][2];
			
			if (null==(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])
			&&	(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])) &&
			(null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][2]]>0)
			&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][1]]>0)&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][0]])>0){
			int min = 0;
			int max = 2;
			int choix_pos = (int)(Math.random()*(max-min+1)+min);
			if (choix_pos==0){
			
			coup[0] = p1;
			coup[1] = p2;
			coup[2] = p3;
			}
			else if (choix_pos==1){
			coup[0] = p4;
			coup[1] = p5;
			coup[2] = p6;
			}
			else if (choix_pos==2){
			coup[0] = p7;
			coup[1] = p8;
			coup[2] = p9;
			}
			strategie = true;
			break;
			}
			}
			if (strategie){
				break;
			}
			}
if (coup[0]!=4){
			break;
}
CouleurChoisi[i] = 0;
System.out.println("essaie ici");
if (Pcouleurs){CouleurChoisi[i] = (int)(Math.random()*(MaxChoix-MinChoix+1)+MinChoix);}
			for (i4=0; i4<t1.length ; i4++){ 
			for (i2=0; i2<t1[i4].length ; i2++){ 

			c = Couleurs[i][CouleurChoisi[i]];
			int p1 = i4;
			int p2 = i2;
			int p3 = 0;
			int p4 = 1;
			int p5 = 2;
			if ((null==(t1[i4][i2][0])) && (null==(t1[i4][i2][1])) && (null==(t1[i4][i2][2]))&&(NombreDeCercle[i+2*CouleurChoisi[i]][0]>0)
			&& (NombreDeCercle[i+2*CouleurChoisi[i]][1]>0)&& (NombreDeCercle[i+2*CouleurChoisi[i]][2])>0) {
			int min = 0;
			int max = 2;
			int choix_pos = (int)(Math.random()*(max-min+1)+min);
			if (choix_pos==0){
			coup[0] = p1;
			coup[1] = p2;
			coup[2] = p3;
			}
			else if (choix_pos==1){
			coup[0] = p1;
			coup[1] = p2;
			coup[2] = p4;
			}
			else if (choix_pos==2){
			coup[0] = p1;
			coup[1] = p2;
			coup[2] = p5;
			}
			strategie = true;
			break ;
			}
			}
			if (strategie){
				break;
			}
			}
if (coup[0]!=4){
			break;
		}
CouleurChoisi[i] = 0;
//L'IA n'a plus de solution
System.out.println("trouve pas de solution");			
			int min = 0;
			int max = 2;
			k1 = (int)(Math.random()*(max-min+1)+min);
			k2 = (int)(Math.random()*(max-min+1)+min);
			k3 = (int)(Math.random()*(max-min+1)+min);
			
			while (t1[k1][k2][k3]!=null || NombreDeCercle[i+2*CouleurChoisi[i]][k3]==0 ){
			if (Pcouleurs){  CouleurChoisi[i] = (int)(Math.random()*(MaxChoix-MinChoix+1)+MinChoix);}
			k1 = (int)(Math.random()*(max-min+1)+min);
			k2 = (int)(Math.random()*(max-min+1)+min);
			k3 = (int)(Math.random()*(max-min+1)+min);
			coup[0]= k1 ;
			coup[1]= k2 ;
			coup[2]= k3;
			System.out.println("En train de réfléchir");
			
		}
	
	}
}
        
		jeu = coup;
		System.out.println("marche " + CouleurChoisi[i]);
		return jeu;
	}
public static void Show() { 

		int i, i2, i3;
		for (i=0; i<t1.length ; i++){ 
		System.out.println("\n");
		for (i2=0; i2<t1[i].length ; i2++){ 
			System.out.print("|  ");
			for (i3=0; i3<t1[i][i2].length ; i3++){ 
				System.out.print("["+t1[i][i2][i3]+"]");
			} 
			System.out.print("  |");
		}
	System.out.println("	" + i);	                                          
	}
	
	System.out.println();	
}
	public static void initialisationM(){
		
//________________________________________________
	int i;
		selection.setBackground(Color.green); //carré vert deuxieme page (faire toute page)
		selection.setOpaque(false);
		selection.setVisible(true);
		selection.setBounds(0,0,1200,670);
		
		confirmer.addActionListener(InterfaceP);
		confirmer.setBackground(Color.black);
		confirmer.setIcon(new ImageIcon(new ImageIcon("image/play.png").getImage().getScaledInstance(150,55,  java.awt.Image.SCALE_SMOOTH)));
		confirmer.setOpaque(false);
		//confirmer.setText("JOUER");
		confirmer.setFocusable(false);
           //MODOFIIER ICI BOUTON JOUER 
		confirmer.setBounds(350,500,120,50);
		selection.add(confirmer,4,4);
		confirmer.setBorder(BorderFactory.createEmptyBorder());	
		selection.add(Modes);
		Modes.add(Mod1);
		Modes.add(Mod2);
		Modes.add(Mod3);
		
		Mod1.setBounds(25,15,150,60);
		Mod1.setFocusable(false);
		Mod1.setBackground(new Color(0xEBE16B)); 
		             //couleurs boutons MODE
		Mod1.setBorder(new RoundBtn(15));
		Mod1.addActionListener(InterfaceP);
		
		
		Mod2.setBounds(225,15,150,60);
		Mod2.setFocusable(false);
		Mod2.setBackground(new Color(0xEBE16B));
		Mod2.setBorder(new RoundBtn(15));
		Mod2.addActionListener(InterfaceP);		
		
		Mod3.setBounds(425,15,150,60);
		Mod3.setFocusable(false);
		Mod3.setBackground(new Color(0xEBE16B));
		Mod3.setBorder(new RoundBtn(15));
		Mod3.addActionListener(InterfaceP);
		
		Mod1.setText("4 players");		
		Mod2.setText("1V1");		
		Mod3.setText("1V1 HARD");
		Mod1.setFont(new Font("Impact",Font.ITALIC,15));
		Mod2.setFont(new Font("Impact",Font.ITALIC,15));
		Mod3.setFont(new Font("Impact",Font.ITALIC,15));
		Mod1.setForeground(Color.black); 
		

		
		// carré rouge autour choix modes
		Modes.setBounds(100,20,600,100);
		Modes.setBackground(Color.red);
		Modes.setOpaque(false);
		Mod1.setEnabled(false);
		
		
		selection.add(mode1);
		selection.add(mode2);
		selection.add(mode3);
		
		//carré gris
		mode1.setVisible(true);
		mode1.setOpaque(false);
		mode1.setBackground(new Color(0x606060));
		mode1.setBounds(50,125,700,325);
		
		for (i=0;i<4;i++){
			mode1.add(colors[i]);
			mode1.add(noms[i]);
			noms[i].setText(names[i]);
			noms[i].setBounds(10,80+i*40,60,30);

			mode1.add(Types[i]);
			Types[i].setLocation(90,85+i*40);
			//  nom.setLocation(,)
			//  nom.setSize(,)
			colors[i].setForeground(new Color(couleurgb[i][0],couleurgb[i][1],couleurgb[i][2]));
			colors[i].setFont(new Font("Impact",Font.ITALIC,20));
			colors[i].setBounds(170,80+i*40,60,30);
			colors[i].setVisible(true);
			
			if (i<3){
			Type1.add(IA[i]); //selection humain IA
			Type2.add(IA[i]);
			Type3.add(IA[i]);
			Type4.add(IA[i]);
			}

		}



		
		mode2.setVisible(false);
		mode2.setOpaque(false);
		mode2.setBackground(new Color(0x665EE3));
		mode2.setBounds(50,125,700,325);
		
		mode3.setVisible(false);
		mode3.setOpaque(false);
		mode3.setBackground(new Color(0x5B5B5B));
		mode3.setBounds(50,125,700,325);
		
		selection.add(description,0,0);
		description.setText(descp[0]);
		description.setBounds(75,125,650,70);

		description.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(2,new Color(0x8E4709),new Color(0x463102))," Regles "));
//________________________________________________
		
	}
	//_____création des boutons choix_____//
	static JButton confirmer = new JButton();
	static String[] descp = {"4 joueurs s'affrontent! ces joueurs sont de types humain ou ordinateurs!",
							"1 vs 1, une couleur au choix, ces joueurs sont de types humain ou ordinateurs!",
							"1 vs 1, deux couleurs attribue! ces joueurs sont de types humain ou ordinateurs!"};
	static JLabel description = new JLabel();
	static JLabel Modes = new JLabel();
	static JButton Mod1 = new JButton();
	static JButton Mod2 = new JButton();
	static JButton Mod3 = new JButton(); 
	

	
	static Choice Type1 = new Choice();
	static Choice Type2 = new Choice();
	static Choice Type3 = new Choice();
	static Choice Type4 = new Choice(); 
	static Choice[] Types = {Type1 , Type2, Type3, Type4};
	static String[] IA = {"humain","IA","IA (hard)"};
	
	static JLabel Color1 = new JLabel("Rouge");
	static JLabel Color2 = new JLabel("Bleu");
	static JLabel Color3 = new JLabel("Vert");
	static JLabel Color4 = new JLabel("Jaune");
	static JLabel[] colors = {Color1,Color2,Color3,Color4};
	static Choice choix1 = new Choice();
	static Choice choix2 = new Choice();
	static String[] names = {"Joueur 1", "Joueur 2", "Joueur 3", "Joueur 4"};
	
	static JTextField Joueur1 = new JTextField();
	static JTextField Joueur2 = new JTextField();
	static JTextField Joueur3 = new JTextField();
	static JTextField Joueur4 = new JTextField();
	static JTextField[] noms = {Joueur1 , Joueur2, Joueur3, Joueur4};
	
	//mode 1  
	
	static JLabel mode1 = new JLabel();
			
	//mode 2
	static JLabel mode2 = new JLabel();	
	
	//mode 3
	static JLabel mode3 = new JLabel();	
static boolean ContreStrategique(int v,int a,int b, int c2, int i){
int[] coupFictif =	{4,4,4};
boolean strategie = false;
int i4,i3,i2;
CouleurChoisi[i]=v;
		for (i4=0 ; i4<Matselec.length ; i4++){
			for (i3=0 ; i3<MatTest.length ; i3++){ 
				
			if ((couleurR[(i+1)%2].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))
			&&	(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]) &&
			(null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][2]]>0)){
			coupFictif[0] = Matselec[i4][2][0];
			coupFictif[1] = Matselec[i4][2][1];
			coupFictif[2] = MatTest[i3][2];
			
			if (coupFictif[0]==a && coupFictif[1]==b && coupFictif[2]==c2){
			strategie = true;
			break;
			}
			if (Matselec[i4][1][0]==a && Matselec[i4][1][1]==b && MatTest[i3][1]==c2){
			strategie = true;
			break;
			}
			}
		
			
			if ((couleurR[i].equals(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]]))
			&& (null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]) &&
			(null==(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][1]]>0)){
			coupFictif[0] = Matselec[i4][1][0];
			coupFictif[1] = Matselec[i4][1][1];
			coupFictif[2] = MatTest[i3][1];
			strategie = true;
			if (coupFictif[0]==a && coupFictif[1]==b && coupFictif[2]==c2){
			strategie = true;
			break;
			}
			if (Matselec[i4][2][0]==a && Matselec[i4][2][1]==b && MatTest[i3][2]==c2){
			strategie = true;
			break;
			}
			break;
			}
			if ((couleurR[i].equals(t1[Matselec[i4][1][0]][Matselec[i4][1][1]][MatTest[i3][1]]))
			&& (null==(t1[Matselec[i4][2][0]][Matselec[i4][2][1]][MatTest[i3][2]]) &&
			(null==(t1[Matselec[i4][0][0]][Matselec[i4][0][1]][MatTest[i3][0]])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][MatTest[i3][0]]>0)){
			coupFictif[0] = Matselec[i4][0][0];
			coupFictif[1] = Matselec[i4][0][1];
			coupFictif[2] = MatTest[i3][0];
			strategie = true;
			if (coupFictif[0]==a && coupFictif[1]==b && coupFictif[2]==c2){
			strategie = true;
			break;
			}
			if (Matselec[i4][2][0]==a && Matselec[i4][2][1]==b && MatTest[i3][2]==c2){
			strategie = true;
			break;
			}
			break;
			}
			}
			if (strategie){
				break;
			}
			}

			for (i4=0; i4<t1.length ; i4++){ 
			for (i2=0; i2<t1[i4].length ; i2++){ 
			String c = Couleurs[i][CouleurChoisi[i]];
			if ((c.equals(t1[i4][i2][0])) && (null==(t1[i4][i2][1]) && (null==(t1[i4][i2][2])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][2]>0)) {
			coupFictif[0] = i4;
			coupFictif[1] = i2;
			coupFictif[2] = 2;
			strategie = true;
			if (coupFictif[0]==a && coupFictif[1]==b && coupFictif[2]==c2){
			strategie = true;
			break;
			}
			if ((coupFictif[0]==a && coupFictif[1]==b && 1==c2)){
			strategie = true;
			break;
			}
			break ;
			}
			if ((c.equals(t1[i4][i2][0])) && (null==(t1[i4][i2][2]) && (null==(t1[i4][i2][1])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][1]>0)){
			coupFictif[0] = i4;
			coupFictif[1] = i2;
			coupFictif[2] = 1;
			strategie = true;
			break ;
			}
			if ((c.equals(t1[i4][i2][1])) && (null==(t1[i4][i2][2]) && (null==(t1[i4][i2][0])))&& (NombreDeCercle[i+2*CouleurChoisi[i]][0]>0)){
			coupFictif[0] = i4;
			coupFictif[1] = i2;
			coupFictif[2] = 0;
			strategie = true;
			
			if (coupFictif[0]==a && coupFictif[1]==b && coupFictif[2]==c2){
			strategie = true;
			break;
			}
			if ((coupFictif[0]==a && coupFictif[1]==b && 1==c2)){
			strategie = true;
			break;
			}
			break ;
			}
			}
			if (strategie){
				break;
			}
			}
CouleurChoisi[i]=(CouleurChoisi[i]+1)%2;
	if (strategie ==true) {
		return true ;
	}
	else {
		return false ;	
}
}
}
// classe importé d'extérieur

/*
 Algorithme Jeu 
 Variables
 t1 : tableau de Chaines de Caractères [3][3][3]
 (Les différentes variables ...)
	Fonction TestPrincipale (var int[][][] t1):boolean 
		Variables 
		i, i1, i2 : entiers 
		a :booléen
		Debut
		a = true; 
		Pour i de 0 à couleurR.length faire
		Pour i2 de 0 à Matselec.length faire
			Pour i3 de 0 MatTest.length faire 
			Si (couleurR[i]==t1[Matselec[i2,0,0]][Matselec[i2,0,1]][MatTest[i3,0]]
			et	couleurR[i]==t1[Matselec[i2,1,0]][Matselec[i2,1,1]][MatTest[i3,1]])
			et  couleurR[i]==t1[Matselec[i2,2,0]][Matselec[i2,2,1]][MatTest[i3,2]]))Alors 
			  a= false
			  break
			fin Si
			fin Pour
			si !a alors
			 break 
			fin SI
		fin Pour
			si !a alors
			break
			fin Si
			Si TestSecondaire(CouleurR[i]) Alors
			a=true
			Fin Si
		fin Pour	
			Si TestSecondaire
		TestPrincipale <-- a
		Fin
			 
 Debut 
 Initialisation des matrices() 
	Tant que true faire 
		Si !TestPrincipale faire
			break;
		Fin si
		(question joueurs et jeu du joueur)
	Fin Tant que
		annonce du vainqueur()
	Fin
 
	
	
 */


