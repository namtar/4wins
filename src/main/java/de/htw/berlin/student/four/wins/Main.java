package de.htw.berlin.student.four.wins;

import javax.swing.SwingUtilities;

/**
 * Main class for the 4wins swing project.
 * 
 * @author Matthias Drummer
 */
public class Main {

	public static void main(String[] args) {

		Runnable runner = new Runnable() {

			@Override
			public void run() {
				FourWins fourWins = new FourWins();
				fourWins.run();
			}
		};

		SwingUtilities.invokeLater(runner);

	}		

}
