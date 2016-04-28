
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class jTable {
    
    private static ArrayList<String> string = new ArrayList();
    private static ArrayList<String> titel = new ArrayList();
    private static ArrayList<ArrayList<String>> table = new ArrayList();
    
    public static void main(String[] args) {
        
        try {
            ArrayList<Course> courseList = ImportCSV.csvFileIN();
            
            titel.add("CourseName");
            for (Course c : courseList) {
                string.add(c.getTitle());
                table.add(string);
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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
