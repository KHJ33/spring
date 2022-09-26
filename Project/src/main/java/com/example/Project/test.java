package com.example.Project;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		String data[] = null;
		
//		while(true) {
//			System.out.println("1.사용자 , 2.관리자 3.out");
//			Scanner scan = new Scanner(System.in);
//			String num = scan.nextLine();
//		
//			if(num.equals("1")) {
//				System.out.println("1");
//			}
//			else if(num.equals("2")) {
//				System.out.println("2");
//			}
//			else if(num.equals("3"))
//				break;
//			else
//				System.out.println("잘못입력하셨습니다.");
//			
//		}

//		String a = "wuwqd sdam suxux wdgqw sxal sxoia sixai";
//		String data[] = a.split(" ");
//		
//		for(int i=0 ; i<data.length ; i++)
//			System.out.println(data[i]);
		
		
//		File f = new File("test");
//		System.out.println(f.isFile());
//		try {
//			FileWriter fw = new FileWriter(f,true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("test"));
//			String s = br.readLine();
//			
//			BufferedWriter bw = new BufferedWriter(new FileWriter("test"));
//			
//			//bw.write(s+" 안녕\n ckck");
//			bw.write("id aaa\n");
//			bw.write("pw 111");
//			bw.flush();
//			bw.close();
//			
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("test"));
//			
//			String s = br.readLine();
//			String s2 = br.readLine();
//			
//			
//			if(s==null) {
//				System.out.println("비어있습니다.");
//				s = "aaa";
//				s2 = "111";
//			}
//			else {
//				data = s.split(" ");
//			}
//			
//			for(int i=0 ; i<data.length ; i++)
//				System.out.println(data[i]);
//			
//			System.out.println(s);
//			System.out.println(s2);
//			
//			BufferedWriter bw = new BufferedWriter(new FileWriter("test"));
//			bw.write(s+" 555\n");
//			bw.write(s2+" bbb");
//			bw.flush();
//			bw.close();
//			
//			br.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String c = "qwe ewq 111 333";
		String b[] = null;
		
		b = c.split(" ");
		System.out.println(b.length);
		System.out.println(b[0]);
		b[0] = "";
		System.out.println(b[0]);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("test"));
			String s;
			ArrayList<String> ab = new ArrayList<String>();
			String a[] = null;
			int i= 0;
			
			while((s=br.readLine()) != null) {
				System.out.println(s);
				ab.add(s);
				
			}
			System.out.println("------");
			//Arrays.sort(a);
			
			System.out.println(ab);
			System.out.println(ab.size());
			ab.sort(null);
			System.out.println(ab);
			System.out.println(ab.get(0).getClass());
			
			a = ab.get(0).split(" ");
			System.out.println(a[0]+"////"+a[1]);
			ab.set(0, ab.get(0)+" aaa");
//			ab.remove(2);
//			System.out.println(ab);
//			System.out.print(ab.get(0));
//			System.out.print(ab.get(1));
//			System.out.print(ab.get(2));
			
			
			s="";
			for(i=0 ; i<ab.size(); i++)
				s = s + ab.get(i) + "\n";
			System.out.print(s);
			
			
			
//			BufferedWriter bw = new BufferedWriter(new FileWriter("test"));
//			bw.write(s);
//			
//			bw.flush();
//			bw.close();
//			
//			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
