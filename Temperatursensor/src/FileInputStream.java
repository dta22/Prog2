public class FileInputStream {

	public static void main(String[] args) {
		InputStream f = new FileInputStream(dateiname);^
		
		byte[] buffer = new byte[(int) f.length()];
		InputStream in = new FileInputStream(f);
		in.read(buffer);
		in.close();
	}

}
