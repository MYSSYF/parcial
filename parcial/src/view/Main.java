package view;

import ctrl.logic;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

	@Override
	public void settings() {
		size(1000, 600);

	}

	private logic l;

	public void setup() {
		l = new logic(this);

	}

	public void draw() {
		background(100);
		l.pintarInstrucciones();
		l.pintarBotones();
		l.lalista();

	}

	public void mousePressed() {
		l.porID();
		l.porName();
		l.porAge();
		l.porRace();
		l.porBD();
	}


}
