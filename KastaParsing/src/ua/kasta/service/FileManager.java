package ua.kasta.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import ua.kasta.model.Item;

public class FileManager {
	
	private static final String DIR_PATH = getDirPath();
	
	
public static void writeDataPageServiceToFile(Item item, boolean append) throws IOException{
		
		try (FileWriter wr = new FileWriter(DIR_PATH + "data.csv", append)) {
			
			try {
				wr.write(item.toString() + ";\n");
				wr.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	private static String getDirPath() {

		String dir = System.getProperty("user.dir"); 
		String separator = System.getProperty("file.separator");
		
		String destinationDir = dir + separator + "files";
		File file = new File(destinationDir);
		
		if (Files.notExists(file.toPath())) {
			file.mkdir();
		}
		
		return destinationDir + separator;
		
	}

}
