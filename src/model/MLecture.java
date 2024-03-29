package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EDataFileName;
import valueObject.VMLecture;

public class MLecture {
private Vector<VMLecture> vMLectures;
	
	public MLecture() {
		this.vMLectures = new Vector<VMLecture>();
	}

	public Vector<VMLecture> getData(String fileName) throws FileNotFoundException {

			this.vMLectures.clear();
			File file = new File(EDataFileName.path.getString() + fileName);
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				VMLecture vMLecture = new VMLecture();
				vMLecture.readFromFile(scanner);
				this.vMLectures.add(vMLecture);
			}
			scanner.close();
			return this.vMLectures;
			

	}

	public void setdata(String fileName, Vector<VMLecture> vMLectures) throws IOException {
		File file = new File(EDataFileName.path.getString() + fileName);
		FileWriter FileWriter = new FileWriter(file);
		for(VMLecture vMLecture : vMLectures) {
			vMLecture.writeToFile(FileWriter);
		}
	}
}
