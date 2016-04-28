
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrereqJTable {
		
		private static Course[] prereqs = new Course[11];
		private static String[] prereqNames = {"174","201","271","274",
			"278","283","289","383","385","386","448"};
		private ArrayList<String> prereqsFinished = new ArrayList();
		
		
		
		
		
		private static ArrayList<String> titel = new ArrayList();
		private static ArrayList<ArrayList<String>> table = new ArrayList();
    
	
		public PrereqJTable() {
			
			initializeComponents();
			
		}
		
		private void initializeComponents(){
			
			
			
		
		}
	
	    
	    public static void main(String[] args) {
	        
	        
	        Object[] tempTitel = titel.toArray();
	        String[][] tempTable = new String[table.size()][];
	        int i = 0;
	        for (List<String> next : table) {
	            tempTable[i++] = next.toArray(new String[next.size()]);
	        }
	        
	        JTable EndTable = new JTable(tempTable, tempTitel);
	        
	        JFrame frame = new JFrame("Demo");
	        frame.getContentPane().add(new JScrollPane(EndTable));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
}
