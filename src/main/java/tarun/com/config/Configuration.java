package tarun.com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class Configuration {
	private final Properties prop;
	private InputStream  input;
	private int noOfQueuePassanger;
	private String arrangements;
	
	public Configuration() {
		prop = new Properties();
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			arrangements = prop.getProperty("ARRANGEMENT");
			noOfQueuePassanger = Integer.parseInt(prop.getProperty("PASSANGERS"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	

	public int getNoOfQueuePassanger() {
		return noOfQueuePassanger;
	}

	public int[][] getArrangements() {
		int N = arrangements.length();
		
		arrangements = arrangements.substring(1, N - 1).trim();
		String []strArng = arrangements.split(", ");
		int [][] arang = new int[strArng.length][2];
		for (int i = 0; i < strArng.length; ++i) {
			strArng[i] = strArng[i].replace('[', ' ').trim();
			strArng[i] = strArng[i].replace(']', ' ').trim();
			
			String []nums = strArng[i].split(",");
			arang[i][0] = Integer.parseInt(nums[0]);
			arang[i][1] = Integer.parseInt(nums[1]);
			if (arang[i][0] == 0 || arang[i][1] == 0) {
				throw new IllegalArgumentException("Value can,t be zero");
			}
		}
		
		return arang;
	}
	
/**
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		System.out.println(conf.getNoOfQueuePassanger());

	}
**/
}
