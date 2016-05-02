/*
Definitive Guide to Swing for Java 2, Second Edition
By John Zukowski     
ISBN: 1-893115-78-X
Publisher: APress
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;


import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

/*public class choosePrereqs extends JPanel {

  private static final Insets EMPTY_INSETS = new Insets(0, 0, 0, 0);
  
  private JLabel sourceLabel;
  private JList sourceList;
  private SortedListModel sourceListModel;
  private JList destList;
  private SortedListModel destListModel;
  private JLabel destLabel;
  private JButton addButton;
  private JButton nextButton;
  private JButton removeButton;
  ArrayList<Course> allCourses = new ArrayList<Course>();
  ArrayList<Course> prereqsOnce = new ArrayList<Course>();
  ArrayList<Course> selectedCourses = new ArrayList<Course>();

  public choosePrereqs() {
    initScreen();
   
    JFrame f = new JFrame("Choose any prerequisites completed:");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(this, BorderLayout.CENTER);
    f.setSize(900, 900);
    f.setVisible(true);
    this.addSourceElements(setInputClasses());
  }
  
  public String[] setInputClasses(){
		try {
			allCourses = ImportCSV.csvFileIN();
			prereqsOnce = Controller.displayPrereqOptions(allCourses);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Course[] courseArray = prereqsOnce
				.toArray(new Course[prereqsOnce.size()]);
		String[] courseInfo = new String[courseArray.length];
		for(int i= 0; i < courseArray.length; i++){
			courseInfo[i] = "" + courseArray[i].getTitle()
					+ ", " + "CSE " + courseArray[i].getCourseNum() + ", "
					+ courseArray[i].getStartTime() + "-"
					+ courseArray[i].getStartTime();
		}
		
		return courseInfo;
  }

  public String getSourceChoicesTitle() {
    return sourceLabel.getText();
  }

  public void setSourceChoicesTitle(String newValue) {
    sourceLabel.setText(newValue);
  }

  public String getDestinationChoicesTitle() {
    return destLabel.getText();
  }

  public void setDestinationChoicesTitle(String newValue) {
    destLabel.setText(newValue);
  }

  public void clearSourceListModel() {
    sourceListModel.clear();
  }

  public void clearDestinationListModel() {
    destListModel.clear();
  }

  public void addSourceElements(ListModel newValue) {
    fillListModel(sourceListModel, newValue);
  }

  public void setSourceElements(ListModel newValue) {
    clearSourceListModel();
    addSourceElements(newValue);
  }

  public void addDestinationElements(ListModel newValue) {
    fillListModel(destListModel, newValue);
  }

  private void fillListModel(SortedListModel model, ListModel newValues) {
    int size = newValues.getSize();
    for (int i = 0; i < size; i++) {
      model.add(newValues.getElementAt(i));
    }
  }

  public void addSourceElements(Course newValue[]) {
    fillListModel(sourceListModel, newValue);
  }

  public void setSourceElements(Course newValue[]) {
    clearSourceListModel();
    addSourceElements(newValue);
  }

  public void addDestinationElements(Course newValue[]) {
    fillListModel(destListModel, newValue);
  }

  private void fillListModel(SortedListModel model, Course newValues[]) {
    model.addAll(newValues);
  }

  public Iterator sourceIterator() {
    return sourceListModel.iterator();
  }

  public Iterator destinationIterator() {
    return destListModel.iterator();
  }

  public void setSourceCellRenderer(ListCellRenderer newValue) {
    sourceList.setCellRenderer(newValue);
  }

  public ListCellRenderer getSourceCellRenderer() {
    return sourceList.getCellRenderer();
  }

  public void setDestinationCellRenderer(ListCellRenderer newValue) {
    destList.setCellRenderer(newValue);
  }

  public ListCellRenderer getDestinationCellRenderer() {
    return destList.getCellRenderer();
  }

  public void setVisibleRowCount(int newValue) {
    sourceList.setVisibleRowCount(newValue);
    destList.setVisibleRowCount(newValue);
  }


  public int getVisibleRowCount() {
    return sourceList.getVisibleRowCount();
  }

  public void setSelectionBackground(Color newValue) {
    sourceList.setSelectionBackground(newValue);
    destList.setSelectionBackground(newValue);
  }

  public Color getSelectionBackground() {
    return sourceList.getSelectionBackground();
  }

  public void setSelectionForeground(Color newValue) {
    sourceList.setSelectionForeground(newValue);
    destList.setSelectionForeground(newValue);
  }

  public Color getSelectionForeground() {
    return sourceList.getSelectionForeground();
  }

  private void clearSourceSelected() {
    Course selected[] = sourceList.getSelectedValues();
    for (int i = selected.length - 1; i >= 0; --i) {
      sourceListModel.removeElement(selected[i]);
    }
    sourceList.getSelectionModel().clearSelection();
  }

  private void clearDestinationSelected() {
    Course selected[] = destList.getSelectedValues();
    for (int i = selected.length - 1; i >= 0; --i) {
      destListModel.removeElement(selected[i]);
    }
    destList.getSelectionModel().clearSelection();
  }

  private void initScreen() {
    setBorder(BorderFactory.createEtchedBorder());
    setLayout(new GridBagLayout());
    sourceLabel = new JLabel("Available Classes");
    sourceListModel = new SortedListModel();
    sourceList = new JList(sourceListModel);
    add(sourceLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
        GridBagConstraints.CENTER, GridBagConstraints.NONE,
        EMPTY_INSETS, 0, 0));
    add(new JScrollPane(sourceList), new GridBagConstraints(0, 1, 1, 5, .5,
        1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        EMPTY_INSETS, 0, 0));

    addButton = new JButton("Add >>");
    add(addButton, new GridBagConstraints(1, 2, 1, 2, 0, .25,
        GridBagConstraints.CENTER, GridBagConstraints.NONE,
        EMPTY_INSETS, 0, 0));
    addButton.addActionListener(new AddListener());
    removeButton = new JButton("<< Remove");
    add(removeButton, new GridBagConstraints(1, 4, 1, 2, 0, .25,
        GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
            0, 5, 0, 5), 0, 0));
    removeButton.addActionListener(new RemoveListener());
    nextButton = new JButton("Done");
    add(nextButton, new GridBagConstraints(1, 4, 1, 2, 0, .25,
        GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
        new Insets(0, 5, 0, 5), 0, 0));
    nextButton.addActionListener(new NextListener());
    
    destLabel = new JLabel("Classes completed:");
    destListModel = new SortedListModel();
    destList = new JList(destListModel);
    add(destLabel, new GridBagConstraints(2, 0, 1, 1, 0, 0,
        GridBagConstraints.CENTER, GridBagConstraints.NONE,
        EMPTY_INSETS, 0, 0));
    add(new JScrollPane(destList), new GridBagConstraints(2, 1, 1, 5, .5,
        1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
        EMPTY_INSETS, 0, 0));
  }

  public static void main(String args[]) {
    
    choosePrereqs dual = new choosePrereqs();

  }

  private class AddListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Course selected[] = sourceList.getSelectedValues();
      addDestinationElements(selected);
      clearSourceSelected();
    }
  }

  private class RemoveListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Course selected[] = destList.getSelectedValues();
      addSourceElements(selected);
      clearDestinationSelected();
    }
  }
  
  private class NextListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	      Course selected[] = destList.getSelectedValues();
	      
	      Course selected1[] = new Course[selected.length];
	      
	      for(int i = 0; i< selected.length; i++){
	    	  selected1[i] = (Course)(selected[i]);
	      }
	      
	      //selectedCourses = (ArrayList<Course>) Arrays.asList(selected1);
	    }
  }
=======*/
import javax.swing.JTable;
import javax.swing.JToggleButton;

/**
 * 
 * @author miamistudent
 */
public class choosePrereqs extends javax.swing.JFrame {

	public ArrayList<String> prereqsComplete = new ArrayList();
	static ArrayList<String> listChecked = new ArrayList<String>();
	public int stage;

	/**
	 * Creates new form prereqs
	 */
	public choosePrereqs() {
		initComponents();
		prereqsComplete = getPrereqsComplete();
		stage = getStage();
		this.setVisible(true);
	}

	public ArrayList<String> getPrereqsComplete() {
		return prereqsComplete;
	}

	public int getStage(){
		return stage;
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "serial", "deprecation" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		javax.swing.JTextArea jTextArea1 = new javax.swing.JTextArea();
		jTable2 = new javax.swing.JTable();
		JToggleButton nextButton = new javax.swing.JToggleButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jTextArea1
				.setText("Please select which of the following courses you have completed:");
		jTextArea1.setToolTipText("");
		jTextArea1.setWrapStyleWord(true);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { new Boolean(false), "CSE 174" },
						{ new Boolean(false), "CSE 201" },
						{ new Boolean(false), "CSE 271" },
						{ new Boolean(false), "CSE 274" },
						{ new Boolean(false), "CSE 278" },
						{ new Boolean(false), "CSE 283" },
						{ new Boolean(false), "CSE 289" },
						{ new Boolean(false), "CSE 383" },
						{ new Boolean(false), "CSE 385" },
						{ new Boolean(false), "CSE 386" },
						{ new Boolean(false), "CSE 448" } }, new String[] { "",
						"Course" }) {
			Class[] types = new Class[] { java.lang.Boolean.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}

		});


		nextButton.setLabel("Next");
		nextButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				for (int i = 1; i < 11; i++)
					if ((Boolean) jTable2.getValueAt(i, 0)) {
						listChecked.add((String) jTable2.getValueAt(i, 1));
					}
				jToggleButton1ActionPerformed(evt, listChecked);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(71, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jTextArea1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														396,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jTable2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		342,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		nextButton)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(20, 20, 20)
								.addComponent(jTextArea1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										108,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTable2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(nextButton))
								.addContainerGap()));

		pack();
	}// </editor-fold>

	private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt,
			ArrayList<String> PC) {
		this.prereqsComplete = PC;
	}


	public static void main(String args[]) {

		choosePrereqs p = new choosePrereqs();

		ArrayList<String> completed = p.prereqsComplete;

	}

	// Variables declaration - do not modify
	private javax.swing.JButton nextButton;
	private javax.swing.JTable jTable2;
	// End of variables declaration
}


class CourseComp implements Comparator<Course>{
	 
    public int compare(Course c1, Course c2) {
    	return c1.getCourseNum().compareTo(c2.getCourseNum());
    }
}  

class SortedListModel extends AbstractListModel {

  SortedSet<Course> model;

  public SortedListModel() {
    model = new TreeSet<Course>(new CourseComp());
  }

  public int getSize() {
    return model.size();
  }

  public Course getElementAt(int index) {
    return (Course) model.toArray()[index];
  }

  public void add(Course element) {
    if (model.add(element)) {
      fireContentsChanged(this, 0, getSize());
    }
  }

  public void addAll(Course elements[]) {
    Collection c = Arrays.asList(elements);
    model.addAll(c);
    fireContentsChanged(this, 0, getSize());
  }

  public void clear() {
    model.clear();
    fireContentsChanged(this, 0, getSize());
  }

  public boolean contains(Course element) {
    return model.contains(element);
  }

  public Course firstElement() {
    return model.first();
  }

  public Iterator iterator() {
    return model.iterator();
  }

  public Course lastElement() {
    return model.last();
  }

  public boolean removeElement(Course element) {
    boolean removed = model.remove(element);
    if (removed) {
      fireContentsChanged(this, 0, getSize());
    }
    return removed;
  }
}