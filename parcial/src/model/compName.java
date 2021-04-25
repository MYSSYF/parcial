package model;

import java.util.Comparator;

public class compName implements Comparator<pet>{

	@Override
	public int compare(pet p0, pet p1) {

		return p0.getName().compareTo(p1.getName());
	}

}
