import java.io.File;
import java.io.IOException;


public class Controller {

	public static void main(String[] args) {
		try {
			ImportCSV.csvFileIN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
