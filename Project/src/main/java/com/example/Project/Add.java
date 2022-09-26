package com.example.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Add {
	String id;
	String pw;
	String file_name;
	
	Add(String file_name) {
		try {
			this.file_name = file_name;
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			this.id = br.readLine();
			this.pw = br.readLine();
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void append(String id, String pw) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_name));
			bw.write(this.id + " " + id + "\n");
			bw.write(this.pw + " " + pw);
			bw.flush();
			bw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
