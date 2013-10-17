package de.htw.berlin.student.four.wins.controler;

import javax.swing.JDialog;
import javax.swing.JFrame;

import de.htw.berlin.student.four.wins.i18n.I18nResolver;
import de.htw.berlin.student.four.wins.menu.MenuItems;
import de.htw.berlin.student.four.wins.view.AboutView;

/**
 * Controller to handle the content area.
 * 
 * @author Matthias Drummer
 */
public class ContentControler {

	private final JFrame rootFrame;

	public ContentControler(JFrame rootFrame) {
		this.rootFrame = rootFrame;
	}

	public void updateContent(MenuItems menuItemClicked) {

		switch (menuItemClicked) {
			case ABOUT:
				JDialog dialog = new JDialog(rootFrame, I18nResolver.getString("about"), true);
				dialog.setContentPane(new AboutView());
				dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				dialog.setLocationRelativeTo(rootFrame);
				dialog.pack();
				dialog.setVisible(true);
				break;
			case HELP:
				break;
			case NEW_GAME:
				break;
			default:
				throw new RuntimeException("No default operation supported.");
		}
	}
}
