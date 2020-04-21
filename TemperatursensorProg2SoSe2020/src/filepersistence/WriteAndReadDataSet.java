package filepersistence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

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
		// für filname Script schreiben
		String filename = "testfile.txt";
		// FileOutputStream erzeugen
		OutputStream fileOutputStream = new FileOutputStream(filename);

		// DataoutputStream erzeugen und fileOutputstream hineinstopfen
		DataOutputStream dos = new DataOutputStream(fileOutputStream);

		// wie ober dargestellt wissen wir vorab wieviele DS geschrieben werden > 3
		// also erste Info die im File dann stehen wird ist die Anzahl der Datensätze
		// diesen Schritt unten auch beim Lesen implementieren
		dos.writeInt(3);

		// nun in DataOutputStream die Daten hineinschreiben >> also Datensatz schreiben
		// dafür hier noch main benutzen >> ab nächste Woche nutzen wir
		// Softwaremaschinen
		// dafür brauchen wir a) Sensorname b) Timestamp c) Werte

		// das ganz von a) bis c) mit Schleife, da wir wissen das es 3 valueSets gibt
		for (int number = 0; number < 3; number++) {
			// sensorname
			dos.writeUTF(sensorName);

			// timestamp (ist ein long Wert)
			// zunächste ersten Datensatz nehmen
			dos.writeLong(timeStamps[number]);

			// werte >> Frage wie variable Datenmenge speichern, um sie später wieder
			// auszulesen
			// zunächst Anzahl reinschreiben, wieviele Daten wir denken reinzuschreiben
			// (also mit int)
			// values[0] >> values an der posit
			dos.writeInt(values[number].length);
			for (int i = 0; i < values[number].length; i++) {
				// nun Daten rausschreiben
				dos.writeFloat(values[number][i]);

			}
		}
		// TODO: your job use DataInputStream / FileInputStream
		InputStream is = new FileInputStream(filename);
		// nun etwas herauslesen >> dafür brauchen wir DataoutputStream und darin
		// InputStream is reinstopfen
		DataInputStream dis = new DataInputStream(is);

		// siehe oben >> erste Info im File sind die Anzahl der Datensätze
		// also diese Zahl aus dem File herauslsen
		int numberSets = dis.readInt();

		// als letzter Schritt (Challenge 2) wird an dieser Stelle eine Ausgabe
		// produziert
		System.out.println("number of data sets " + numberSets);

		// numberSets nun für eine Schleife nutzen
		while (numberSets > 0) {
			numberSets--;

			// was herausgelesen wird in welcher Reihenfolge s.o >> sensor>timestamp>value
			// wie obern > nur statt write ein read machen ülus sensorname hinten löschen da
			// nix eingegebn wird sondern
			// etwas rauskommt
			// a) sensorname
			String sensorNameReceived = dis.readUTF();
			System.out.println("name sensor " + sensorNameReceived);

			// b) timestamp
			long timeStampReceived = dis.readLong();
			System.out.println("timestamp " + timeStampReceived);

			// c) values >> wichtig zu wissen wieviele Werte angelegt wurden >> dafür ein
			// array anlegen vom typ float
			int numberReceived = dis.readInt();
			float[] valuesReceived = new float[numberReceived];

			for (int i = 0; i < numberReceived; i++) {
				// float Wert den man herausbekommt muss gespeichert werden >> und zwar in dem
				// array valuesReceived
				valuesReceived[i] = dis.readFloat();
				System.out.print("value [" + i + "]" + valuesReceived[i]);
			}
			System.out.println();
		}

		// folgende Code Zeilen hatten zu Beginn der Übung gedient
		/*
		 * DataOutputStream dos = new DataOutputStream(os); try { dos.writeInt(42); }
		 * catch (IOException ex) { System.err.println("couldn’t write data (fatal)");
		 * System.exit(0); }
		 * 
		 * try { String filename = "testFile.txt"; OutputStream os = new
		 * FileOutputStream(filename); } catch (FileNotFoundException ex) {
		 * System.err.println("couldn’t open file - fatal"); System.exit(0); // brutal
		 * exception handling }
		 * 
		 * String someText = "Hallo"; byte[] textAsByte = someText.getBytes(); try {
		 * os.write(textAsByte); } catch (IOException ex) {
		 * System.err.println("couldn’t write data (fatal)"); System.exit(0);
		 * 
		 * }
		 * 
		 * // read data from file and print to System.out // TODO: your job use
		 * DataInputStream / FileInputStream DataInputStream dis = new
		 * DataInputStream(is); try { int readIntValue = dis.readInt();
		 * System.out.println("read integer: " + readIntValue); } catch (IOException ex)
		 * { System.err.println("couldn’t read data (fatal)"); System.exit(0);
		 * 
		 * }
		 */
	}
}
