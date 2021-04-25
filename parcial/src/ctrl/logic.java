package ctrl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

import model.compAge;
import model.compBD;
import model.compName;
import model.compRace;
import model.pet;
import processing.core.PApplet;
import processing.core.PConstants;


public class logic {

	private PApplet app;
	private String[] l1;
	private String[] l2;
	private File f1;
	private File f2;
	private ArrayList<pet> p;

	public logic(PApplet app) {
		this.app = app;
		p = new ArrayList<pet>();
		l1 = new String[5];
		l2 = new String[5];
		f1 = new File("./data/InfoBase/F1.txt");
		f2 = new File("./data/InfoBase/F2.txt");
		read_1();
		read_2();
		Collections.sort(p);
	}

	public void read_1() {

		try {
			FileReader r = new FileReader(f1);
			BufferedReader fr = new BufferedReader(r);
			String l = "";
			int pl1 = 0;
			while ((l = fr.readLine()) != null) {
				l1[pl1] = l;
				pl1++;
			}

			fr.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
		}

		for (int i = 0; i < l1.length; i++) {
			String[] m = l1[i].split(" ");
			int ID = Integer.parseInt(m[0]);

			p.add(new pet(ID, m[1]));
		}
	}

	public void read_2() {

		try {
			FileReader r = new FileReader(f2);
			BufferedReader fr = new BufferedReader(r);
			String l = "";
			int pl2 = 0;
			while ((l = fr.readLine()) != null) {
				l2[pl2] = l;
				pl2++;
			}

			fr.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
		}

		for (int i = 0; i < l2.length; i++) {
			String[] mascota1 = l2[i].split(" ");
			int ID = Integer.parseInt(mascota1[0]);
			for (int j = 0; j < p.size(); j++) {
				if (ID == p.get(j).getID()) {
					p.get(j).setRace(mascota1[1]);
					p.get(j).setBirthDay(mascota1[2]);
					p.get(j).asigAge(j);
				}

			}

		}

	}
	
	public void carimag() {
		
	}

	public void pintarBotones() {
		app.rectMode(PConstants.CENTER);

		app.fill(0);
		app.rect(100, 530, 100, 60);
		app.rect(300, 530, 100, 60);
		app.rect(500, 530, 100, 60);
		app.rect(700, 530, 100, 60);
		app.rect(900, 530, 150, 60);

		app.fill(255);
		app.text("ID", 100, 540);
		app.text(" NAME", 300, 540);
		app.text("AGE", 500, 540);
		app.text("RACE", 700, 540);
		app.text("BIRTHDAY", 900, 540);

		System.out.println(app.mouseX + "/UwU/" + app.mouseY);

	}

	public void pintarInstrucciones() {

		app.fill(0);
		app.textSize(24);
		app.textAlign(PConstants.CENTER);
		app.text("para organiazarlo de diferente manera clickea sobre los botones", 500, 40);
		app.text("ID ---- NAME ---- AGE ---- RACE ---- BIRTHDAY", 500, 80);

	}

	public void lalista() {

		for (int i = 0; i < p.size(); i++) {
			app.fill(0);
			app.textSize(24);
			app.textAlign(PConstants.LEFT);
			app.text(p.get(i).getID() + "     " + p.get(i).getName() + "     " + p.get(i).getAge() + "     "
					+ p.get(i).getRace() + "     " + p.get(i).getBirthDay() + "     ", 100, 140 + (i * 80));
		}

	}

	public void porID() {

		if (app.mouseX > 50 && app.mouseX < 150 && app.mouseY > 500 && app.mouseY < 560) {
			Collections.sort(p);

			File IDS = new File("./data/newD/porID.txt");
			try {
				FileWriter f = new FileWriter(IDS);
				BufferedWriter fw = new BufferedWriter(f);

				for (int i = 0; i < p.size(); i++) {
					fw.write(p.get(i).getID() + "      " + p.get(i).getName() + "      " + p.get(i).getAge() + "      "
							+ p.get(i).getRace() + "      " + p.get(i).getBirthDay());
					fw.newLine();
				}

				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
			}

		}
	}

	public void porName() {

		if (app.mouseX > 250 && app.mouseX < 350 && app.mouseY > 500 && app.mouseY < 560) {
			Collections.sort(p, new compName());

			File NAMES = new File("./data/newD/porName.txt");
			try {
				FileWriter f = new FileWriter(NAMES);
				BufferedWriter fw = new BufferedWriter(f);

				for (int i = 0; i < p.size(); i++) {
					fw.write(p.get(i).getID() + "      " + p.get(i).getName() + "      " + p.get(i).getAge() + "      "
							+ p.get(i).getRace() + "      " + p.get(i).getBirthDay());
					fw.newLine();
				}

				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
			}

		}
	}

	public void porAge() {

		if (app.mouseX > 450 && app.mouseX < 550 && app.mouseY > 500 && app.mouseY < 560) {
			Collections.sort(p, new compAge());

			File AGE = new File("./data/newD/porAge.txt");
			try {
				FileWriter f = new FileWriter(AGE);
				BufferedWriter fw = new BufferedWriter(f);

				for (int i = 0; i < p.size(); i++) {
					fw.write(p.get(i).getID() + "      " + p.get(i).getName() + "      " + p.get(i).getAge() + "      "
							+ p.get(i).getRace() + "      " + p.get(i).getBirthDay());
					fw.newLine();
				}

				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
			}

		}
	}

	public void porRace() {

		if (app.mouseX > 650 && app.mouseX < 750 && app.mouseY > 500 && app.mouseY < 560) {
			Collections.sort(p, new compRace());

			File RACE = new File("./data/newD/porRace.txt");
			try {
				FileWriter f = new FileWriter(RACE);
				BufferedWriter fw = new BufferedWriter(f);

				for (int i = 0; i < p.size(); i++) {
					fw.write(p.get(i).getID() + "      " + p.get(i).getName() + "      " + p.get(i).getAge() + "      "
							+ p.get(i).getRace() + "      " + p.get(i).getBirthDay());
					fw.newLine();
				}

				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
			}

		}
	}

	public void porBD() {

		if (app.mouseX > 825 && app.mouseX < 975 && app.mouseY > 500 && app.mouseY < 560) {
			Collections.sort(p, new compBD());

			File BD = new File("./data/newD/porBD.txt");
			try {
				FileWriter f = new FileWriter(BD);
				BufferedWriter fw = new BufferedWriter(f);

				for (int i = 0; i < p.size(); i++) {
					fw.write(p.get(i).getID() + "      " + p.get(i).getName() + "      " + p.get(i).getAge() + "      "
							+ p.get(i).getRace() + "      " + p.get(i).getBirthDay());
					fw.newLine();
				}

				fw.close();

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
			}

		}
	}
}