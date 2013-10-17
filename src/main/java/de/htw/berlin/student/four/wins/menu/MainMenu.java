package de.htw.berlin.student.four.wins.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import de.htw.berlin.student.four.wins.i18n.I18nResolver;
import de.htw.berlin.student.four.wins.listeners.MenuItemClickedListener;

/**
 * Implementation of the applications main menu.
 * 
 * @author Matthias Drummer
 */
public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = -6255856887632452352L;

	private MenuItemClickedListener itemListener;

	public MainMenu() {

		JMenu fileMenu = new JMenu(I18nResolver.getString("file"));
		JMenu helpMenu = new JMenu(I18nResolver.getString("help"));
		JMenu aboutMenu = new JMenu(I18nResolver.getString("about"));

		add(fileMenu);
		add(helpMenu);
		add(aboutMenu);

		configureFileMenu(fileMenu);
		confiureAboutMenu(aboutMenu);
	}

	private void configureFileMenu(JMenu fileMenu) {

		JMenuItem quitItem = new JMenuItem(I18nResolver.getString("quit"));

		quitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// close the program
				Runtime.getRuntime().exit(0);
			}
		});

		fileMenu.add(quitItem);
	}

	private void confiureAboutMenu(JMenu aboutMenu) {

		// aboutMenu.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("PEng");
		// itemListener.setMenuItemClicked(MenuItems.ABOUT);
		//
		// itemListener.actionPerformed(e);
		// }
		// });

		// TODO: change event listener.
		aboutMenu.addMenuListener(new MenuListener() {

			@Override
			public void menuSelected(MenuEvent menuEvent) {
				itemListener.setMenuItemClicked(MenuItems.ABOUT);
				itemListener.actionPerformed(new ActionEvent(menuEvent.getSource(), 0, null));
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// noop
			}

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// noop
			}
		});
	}

	/**
	 * Sets an actionListener which is fired when a menuItem was clicked.
	 * 
	 * @param listener
	 */
	public void setMenuItemClickedListener(MenuItemClickedListener listener) {
		this.itemListener = listener;
	}

}
