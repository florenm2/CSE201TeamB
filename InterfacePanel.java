import javax.swing.JPanel;
import java.awt.FlowLayout;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * This class creates the file chooses
 * @author lauren
 *
 */
public class InterfacePanel extends JPanel {

	/**
	 * Create the panel.
	 */

	File fileToOpen;
	
	/**
	 * make the interface for the file chooser
	 */
	public InterfacePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			fileToOpen = fileChooser.getSelectedFile();
			// try{
			// Desktop.getDesktop().open(fileToOpen);
			// }
			// catch(Exception e){
			// JOptionPane.showMessageDialog(null, "A Problem Occured");
			// }
		}
		add(fileChooser);
		fileChooser.setVisible(true);

		try {
			ImportCSV.csvFileIN(fileToOpen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {

		new InterfacePanel();

	}
}