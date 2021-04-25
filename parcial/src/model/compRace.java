package model;

import java.util.Comparator;

public class compRace implements Comparator<pet>{

	@Override
	public int compare(pet p0, pet p1) {

		return p0.getRace().compareTo(p1.getRace());
	}

}
