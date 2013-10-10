package de.htw.berlin.student.four.wins;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.htw.berlin.student.four.wins.i18n.I18nResolver;

/**
 * Base class for the 4wins game.
 * 
 * @author Matthias Drummer
 */
public class FourWins extends JFrame {

	private static final long serialVersionUID = -7750850088846818136L;

	private static final Logger LOGGER = Logger.getLogger(FourWins.class.getName());

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
		JMenuBar menueBar = new JMenuBar();

		JMenu fileMenu = new JMenu(I18nResolver.getString("file"));
		JMenu helpMenu = new JMenu(I18nResolver.getString("help"));
		JMenu aboutMenu = new JMenu(I18nResolver.getString("about"));

		menueBar.add(fileMenu);
		menueBar.add(helpMenu);
		menueBar.add(aboutMenu);
		
		configureFileMenu(fileMenu);

		this.setJMenuBar(menueBar);
	}

	private void configureFileMenu(JMenu fileMenu) {

		JMenuItem quitItem = new JMenuItem(I18nResolver.getString("quit"));

		quitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// close the program
				System.exit(NORMAL);
			}
		});

		fileMenu.add(quitItem);
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
