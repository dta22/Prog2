package filepersistence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteAndReadDataSet {
	public static void main(String[] args) {
		// three example data sets
		String sensorName = "MyGoodOldSensor"; // does not change

		long timeStamps[] = new long[3];
		timeStamps[0] = System.currentTimeMillis();
		timeStamps[1] = timeStamps[0] + 1; // milli sec later
		timeStamps[2] = timeStamps[1] + 1000; // second later

		float[][] values = new float[3][];
		// 1st measure .. just one value
		float[] valueSet = new float[1];
		values[0] = valueSet;
		valueSet[0] = (float) 1.5; // example value 1.5 degrees

		// 2nd measure .. just three values
		valueSet = new float[3];
		values[1] = valueSet;
		valueSet[0] = (float) 0.7;
		valueSet[1] = (float) 1.2;
		valueSet[2] = (float) 2.1;

		// 3rd measure .. two values
		valueSet = new float[2];
		values[2] = valueSet;
		valueSet[0] = (float) 0.7;
		valueSet[1] = (float) 1.2;

		// write three data set into a file
		// TODO: your job. use DataOutputStream / FileOutputStream
		DataOutputStream dos = new DataOutputStream(os);
		try {
			dos.writeInt(42);
		} catch (IOException ex) {
			System.err.println("couldn’t write data (fatal)");
			System.exit(0);
		}

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

		// read data from file and print to System.out
		// TODO: your job use DataInputStream / FileInputStream
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
