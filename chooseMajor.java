/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class chooseMajor extends javax.swing.JFrame {

	String major = "";
	// if false CS, if true SE
	boolean CSSE = false;
	public int stage;

	/**
	 * Creates new form frontend.
	 */
	public chooseMajor() {
		initComponents();
		major = getMajor();
		stage = getStage();
		this.setVisible(true);
	}

	public String getMajor() {
		return major;
	}
	
	public int getStage() {
		return stage;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jToggleButton1 = new javax.swing.JToggleButton();
		jToggleButton2 = new javax.swing.JToggleButton();
		jToggleButton3 = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jLabel1.setText("Welcome! Please select your major(s): ");

		jToggleButton1.setLabel("Next");
		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton1ActionPerformed(evt, CSSE);

			}
		});

		jToggleButton2.setLabel("Computer Science");
		jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CSSE = false;
				jToggleButton2ActionPerformed(evt);
			}
		});

		jToggleButton3.setLabel("Software Engineering");
		jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CSSE = true;
				jToggleButton3ActionPerformed(evt);
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
								.addComponent(jLabel1,
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
																		jToggleButton1)
																.addContainerGap())
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jToggleButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		191,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(156,
																		156,
																		156))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jToggleButton3,
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
								.addComponent(jLabel1)
								.addGap(27, 27, 27)
								.addComponent(jToggleButton2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jToggleButton3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										76,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(38, 38, 38)
								.addComponent(jToggleButton1)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt,
			boolean CSSE) {
		if (CSSE)
			major = "Computer Science";
		else
			major = "Software Engineering";
		stage = 1;

	}

	private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		
		
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JToggleButton jToggleButton1;
	private javax.swing.JToggleButton jToggleButton2;
	private javax.swing.JToggleButton jToggleButton3;
	// End of variables declaration

}
