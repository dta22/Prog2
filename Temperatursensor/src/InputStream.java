import java.io.FileNotFoundException;
import java.io.IOException;

//Scanner implementieren 

public class InputStream {

	public void inputStream() {
		InputStream is = null;
		try {
			is = new FileInputStream(filename);
		} catch (FileNotFoundException ex) {
			System.err.println("couldn’t open file - fatal");
			System.exit(0);
		}

		byte[] readBuffer = new byte[100];
		try {
			is.read(readBuffer);
		} catch (IOException ex) {
			System.err.println("couldn’t read data (fatal)");
			System.exit(0);
		}

		String readString = new String(readBuffer);
		System.out.println("read something: " + readString);

	}

}
