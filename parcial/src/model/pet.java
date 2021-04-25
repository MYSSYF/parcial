package model;

import processing.core.PImage;

public class pet implements Comparable<pet> {
	private int ID;
	private String Name;
	private String Race;
	private String BirthDay;
	private int Age;
	PImage mm;

	public pet(int ID, String Name) {
		this.ID = ID;
		this.Name = Name;
		Age = 0;
		Race = " ";
		BirthDay = " ";
	

	}

	public void asigAge(int y) {
		if (y==0) {	
			Age=2;
		}
		if (y==1) {
			Age=10;
		}
		if (y==2) {	
			Age=2;
		}
		if (y==3) {	
			Age=0;
		}
		if (y==4) {	
			Age=4;
		}
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int compareTo(pet H) {

		return (int) (ID - H.ID);
	}

}
