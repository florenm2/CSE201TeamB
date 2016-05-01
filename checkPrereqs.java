import javax.swing.JOptionPane;

public class checkPrereqs {

	public static void main(String[] args) {
		int selectedOption = JOptionPane.showConfirmDialog(null,
				"Did you complete this prerequisite?", "Choose",
				JOptionPane.YES_NO_OPTION);
		if (selectedOption == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

}
