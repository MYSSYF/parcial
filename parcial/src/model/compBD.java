package model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;

public class compBD implements Comparator<pet> {

	@Override
	public int compare(pet p0, pet p1) {
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date p1d = null;
		Date p2d = null;
		try {
			p1d = d.parse(p0.getBirthDay());
			p2d = d.parse(p1.getBirthDay());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error, pero al leer" + e);
		}
		return p1d.compareTo(p2d);
	}

}
