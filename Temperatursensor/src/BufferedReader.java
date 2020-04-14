import java.io.IOException;

public class BufferedReader {

	public static void main(String[] args) {

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			readString = br.readLine();
			System.out.println("read: " + readString);
		} catch (IOException ex) {
			System.err.println("couldn’t read data (fatal)");
			System.exit(0);
		}

	}

}
