/*
* Author: Mateusz Krawiec
* e-mail: mateusz.krawiec.e@gmail.com
* 14 gru 2018
*
*/

package pl.mk.mybag.back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class InputOutput {

	String fileName = "data";

	public ArrayList<Element> fileReader() {

		String line = null;
		String data = "";
		ArrayList<Element> list = new ArrayList<Element>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				data = line;
			}
			reader.close();
		} catch (FileNotFoundException fileEx) {
			System.out.println("File not found");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		String[] lineFromFile = data.split(";");
		String[] textContain;

		for (int i = 0; i < lineFromFile.length; i++) {
			textContain = lineFromFile[i].split(",");

			Element element = new Element();
			element.setName(textContain[0]);
			element.setWeight(Double.parseDouble(textContain[1]));
			// tutaj jeszcze wykrywanie czy pojemnik
			list.add(element);
		}

		return list;
	}

	public void fileWriter(Element element) {
		fileWriter(element, "data");
	}

	public void fileWriter(Element element, String filename) {

		StringBuilder string = new StringBuilder();
		string.append(element.getName());
		string.append(",");
		string.append(element.getWeight());
		string.append(",");
		string.append("false");
		string.append(";");
		String stringOut = string.toString();

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));

			out.print(stringOut);
			out.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
