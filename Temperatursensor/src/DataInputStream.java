import java.io.IOException;

public class DataInputStream {

	public void dataInputStream() {

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
