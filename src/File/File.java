package File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

	public static void write(String value, String file) {

		try {
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(value);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static String read(String f) throws IOException {

		Path filePath = Paths.get(f);
		
		return Files.readAllLines(filePath).toString();
	}

}
