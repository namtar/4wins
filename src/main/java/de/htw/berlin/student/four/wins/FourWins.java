package de.htw.berlin.student.four.wins;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Base class for the 4wins game.
 * 
 * @author Matthias Drummer
 */
public class FourWins extends JFrame {

	private static final long serialVersionUID = -7750850088846818136L;

	/**
	 * DefaultConstructor.
	 */
	public FourWins() {
	}

	private void configure() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setResizable(false);
		
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Runs the game.
	 */
	public void run() {

		configure();
	}
}
