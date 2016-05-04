import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/*
 * Displays a window that allows the use to select whether their major
 * is Computer Science or Software Engineering.
 */

public class chooseMajor extends javax.swing.JFrame {

	Boolean isCS;
	// if false CS, if true SE
	boolean CSSE = false;

//	private void makeFrameFullSize(JFrame chooseMajor)
//	{
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		aFrame.setSize(screenSize.width, screenSize.height);
//	}

	/*
	 * chooseMajor constructor
	 * No parameters
	 */
	public chooseMajor() {
		initComponents();
		
		setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/*
	 * Method used to display the chooseMajor window of an existing object
	 * Used in the back button of choosePrereqs
	 */
	public void displayChooseMajor(){
		initComponents();
		setLocationRelativeTo(null);
		this.setVisible(true);
	}


	@SuppressWarnings({ "deprecation" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	public void initComponents() {

		topMessage = new javax.swing.JLabel();
		nextButton = new javax.swing.JToggleButton();
		CSButton = new javax.swing.JToggleButton();
		SEButton = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		topMessage.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		topMessage.setText("Welcome! Please select your major: ");

		nextButton.setLabel("Next");
		nextButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				nextButtonActionPerformed(evt, CSSE);

			}
		});

		CSButton.setLabel("Computer Science");
		CSButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CSSE = false;
				CSButtonActionPerformed(evt);
			}
		});

		SEButton.setLabel("Software Engineering");
		SEButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CSSE = true;
				SEButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(69, 69, 69)
								.addComponent(topMessage,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										480,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		nextButton)
																.addContainerGap())
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		CSButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(156,
																		156,
																		156))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		SEButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		189,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addComponent(topMessage)
								.addGap(27, 27, 27)
								.addComponent(CSButton,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(SEButton,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)
								.addComponent(nextButton)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}

	public void nextButtonActionPerformed(java.awt.event.ActionEvent evt,
			boolean CSSE) {
		if (!CSSE)
			isCS = true;
		else
			isCS = false;

		choosePrereqs cp = new choosePrereqs(this);
		this.dispose();

	}

	public void CSButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void SEButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		
		
	}

	// Variables declaration - do not modify
	public static javax.swing.JLabel topMessage;
	public static javax.swing.JToggleButton nextButton;
	public static javax.swing.JToggleButton CSButton;
	public static javax.swing.JToggleButton SEButton;
	// End of variables declaration

}
