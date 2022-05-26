package view;

import java.io.IOException;

import controller.Leitor;

public class Principal {
	public static void main(String[] args) {
		String path = "C:\\TEMP\\";
		String file_name = "generic_food.csv";
		Leitor leitor = new Leitor();
		try {
			leitor.readFile(path, file_name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
