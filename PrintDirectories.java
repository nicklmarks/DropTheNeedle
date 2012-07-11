import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 Not recursive yet.
 needs to filter out MP3's from other files.
 **/
public class PrintDirectories {
	
	public static void main (String[] args) {
		//Get input from user. should be polymorphed to also use the gui.
		System.out.print("Enter filepath and press Enter: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pathname = null;
		try {
			pathname = br.readLine();
		} catch (IOException e) {
			System.out.println("Error!");
			System.exit(1);
		}
		
		File dir = new File(pathname);
		String[] children = dir.list();
		
		//open child directories
		for (int i=0; i<children.length; i++) {
			// check if its a folder
			File currentFile = new File(children[i]);
			if (currentFile.isDirectory() == true) {
					//code to start again
		
			}
		}
		
		// It is also possible to filter the list of returned files.
		// This example does not return any files that start with `.'.
		//**change this filter to only accept mp3's instead of excluding files that start with "."
		//** possible first start is to only include ".class" or ".java" or ".pages" to see how the sorting works.
/**
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
//				return name.endsWith(".java");
				return name.endsWith(".mp3");	// correct code 
			}
		};
		children = dir.list(filter);		
 **/

		
//		File dir = new File(pathname);
		// Print the contents.
		//*add filtering(above) and recursive(in this call make it call for each subdirectoy.
//		String[] children = dir.list();
		if (children == null) {
			// Either dir does not exist or is not a directory
		} 
		else {
			for (int i=0; i<children.length; i++) {
				// Get filename of file or directory
				String filename = children[i];
				System.out.println(filename);
			}
		}
	}
		
}
