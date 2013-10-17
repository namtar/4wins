package de.htw.berlin.student.four.wins.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htw.berlin.student.four.wins.menu.MenuItems;

/**
 * An implementation to determine which menu item was clicked.
 * 
 * @author Matthias Drummer
 */
public class MenuItemClickedListener implements ActionListener {

	private MenuItems menuItemClicked;

	public MenuItemClickedListener() {
	}

	/**
	 * Override this method to implement custom behaviour when the action is fired.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// noop
	}

	/**
	 * Sets a {@link MenuItems} enum to identify the clicked menu item.
	 * 
	 * @param menuItemClicked a {@link MenuItems}
	 */
	public void setMenuItemClicked(MenuItems menuItemClicked) {
		this.menuItemClicked = menuItemClicked;
	}

	/**
	 * returns the identifier which menu item was clicked.
	 * 
	 * @return a {@link MenuItems}
	 */
	public MenuItems getMenuItemClicked() {
		return menuItemClicked;
	}

}
