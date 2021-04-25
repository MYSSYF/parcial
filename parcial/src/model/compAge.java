package model;

import java.util.Comparator;

public class compAge implements Comparator<pet> {

	@Override
	public int compare(pet p0, pet p1) {

		return p0.getAge() - p1.getAge();
	}

}
