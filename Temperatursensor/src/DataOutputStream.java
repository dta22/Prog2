import java.io.IOException;

public class DataOutputStream {

	public void dataOutputStream() {

		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeInt(42);
		} catch (IOException ex) {
			System.err.println("couldn’t write data (fatal)");
			System.exit(0);
		}

	}
}
