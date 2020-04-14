import java.io.IOException;

public class DataInputStream {

	public static void main(String[] args) {

		DataInputStream dis = new DataInputStream(is);
		try {
			int readIntValue = dis.readInt();
			System.out.println("read integer: " + readIntValue);
		} catch (IOException ex) {
			System.err.println("couldn’t read data (fatal)");
			System.exit(0);

		}

	}
}
