package co.edu.unbosque.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Data {
	private ArrayList<User> usuarios = new ArrayList<User>();

	public void saveData(ArrayList<User> usuarios) {
		try {
			this.usuarios = usuarios;
			FileOutputStream fileOut = new FileOutputStream("usersData.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this.usuarios);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<User> loadData() {
		try {
			FileInputStream fileIn = new FileInputStream("usersData.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this.usuarios = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return this.usuarios;
	}
}