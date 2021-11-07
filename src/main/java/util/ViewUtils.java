package util;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ViewUtils {
	public static void textArea(String message,int rows,int columns) {
		 JTextArea textArea = new JTextArea(message, rows,  columns);
		 JScrollPane sp = new JScrollPane(textArea);
	     sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	     JOptionPane.showMessageDialog(null, sp);
	}
}
