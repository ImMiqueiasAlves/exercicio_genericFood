package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor {
	public void readDir(String path) throws IOException{
		File dir = new File(path);
		if(!dir.exists() || !dir.isDirectory()) 
			 throw new IOException("Diretório inexistente");
		File[] files = dir.listFiles();
		if(files.length < 1) {
			System.out.println("Diretório vazio!");
			return;
		}
			
		for(File f : files)
			System.out.println(f.getName());
	}
	
	public void readFile(String path, String file_name) throws IOException {
		File file = new File(path, file_name);
		if(!file.exists() || !file.isFile())
			throw new IOException("Arquivo não encontrado!");
		
		FileInputStream stream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		
		String line = buffer.readLine();
		String[] header = line.split(",");
		System.out.println(header[0] + " | \t" + header[1] + " | \t" + header[3]);
		while(line != null) {
			String[] array = line.split(",");
			if(array[2].contains("Fruits"))
				System.out.println(array[0] + "\t" + array[1] + "\t" + array[3]);
			line = buffer.readLine();
		}
		buffer.close();
		reader.close();
		stream.close();
	}
}
