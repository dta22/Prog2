import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutputStream {

	public static void main(String[] args) {
		throw new FileNotFoundException();

		try {
			String filename = "testFile.txt";
			OutputStream os = new FileOutputStream(filename);
		} catch (FileNotFoundException ex) {
			System.err.println("couldn’t open file - fatal");
			System.exit(0); // brutal exception handling
		}

		String someText = "Hallo";
		byte[] textAsByte = someText.getBytes();
		try {
			os.write(textAsByte);
		} catch (IOException ex) {
			System.err.println("couldn’t write data (fatal)");
			System.exit(0);

		}

	}

}
