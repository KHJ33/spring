package com.example.Project;

import java.io.*;

public class Make_file {

	Make_file(String file_name){
		File f = new File(file_name);
		if(f.isFile() == false)
			try {
				FileWriter fw = new FileWriter(f,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
