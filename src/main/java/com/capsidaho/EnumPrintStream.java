package com.capsidaho;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Creates a file. A base filename is used which is appended
 * with an integer number. In this way a series of files can
 * be produced with the same filename but an increasing integer
 * number. This allows a large input file to be broken up into
 * several smaller output files, all sharing the same base
 * filename.
 * 
 * @author r_martin
 *
 */
public final class EnumPrintStream {
	
	private int currentNumber=0;
	private String baseFileName="";
	private String extension="";
	private PrintStream currentFile;

	/**
	 * Creates the initial printStream.
	 * 
	 * @param fdIn basename of file
	 * @param startIn starting index of file
	 * @param ext file extension
	 */
	public EnumPrintStream (String fdIn, int startIn, String ext) {
		currentNumber=startIn;
		baseFileName=fdIn;
		extension=ext;
		createFile();
	}
	
	/**
	 * Create the file with the filename from the instance variables.
	 */
	private void createFile() {
		try {
			currentFile=new PrintStream(baseFileName+currentNumber+"."+extension);
		} catch (FileNotFoundException e) {
			System.err.println("Error - cannot create file.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Close the current file, increment the index number to append to the
	 * filename and open the new file.
	 */
	public void incFile() {
		currentFile.close();
		currentNumber++;
		createFile();
	}

	/**
	 * Writes an integer number to the file.
	 * 
	 * @param intIn Integer to write.
	 */
	public void print(int intIn) {
		currentFile.print(intIn);	
	}

	/**
	 * Writes a String to the file.
	 * 
	 * @param sIn String to write.
	 */
	public void print(String sIn) {
		currentFile.print(sIn);	
	}

	/**
	 * Closes the current file.
	 */
	public void close() {
		currentFile.close();		
	}
	
}
