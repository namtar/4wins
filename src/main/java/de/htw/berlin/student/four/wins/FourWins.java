package de.htw.berlin.student.four.wins;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.htw.berlin.student.four.wins.controler.ContentControler;
import de.htw.berlin.student.four.wins.listeners.MenuItemClickedListener;
import de.htw.berlin.student.four.wins.menu.MainMenu;

/**
 * Base class for the 4wins game.
 * 
 * @author Matthias Drummer
 */
public class FourWins extends JFrame {

	private static final long serialVersionUID = -7750850088846818136L;

	private static final Logger LOGGER = Logger.getLogger(FourWins.class.getName());
	private final ContentControler contentControler;

	/**
	 * DefaultConstructor.
	 */
	public FourWins() {

		this.contentControler = new ContentControler(this);
	}

	private void configure() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setResizable(false);

		setLookAndFeed();

		this.pack();
		this.setVisible(true);
	}

	/**
	 * Runs the game.
	 */
	public void run() {
		configure();
		setUpUiComponents();
	}

	private void setUpUiComponents() {

		MainMenu mainMenu = new MainMenu();
		mainMenu.setMenuItemClickedListener(new MenuItemClickedListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// super.actionPerformed(e);
				contentControler.updateContent(getMenuItemClicked());
			}
		});

		this.setJMenuBar(mainMenu);
	}

	private void setLookAndFeed() {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (InstantiationException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (IllegalAccessException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		} catch (UnsupportedLookAndFeelException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}
}
