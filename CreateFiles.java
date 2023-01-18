package FileCreation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class CreateFiles {

	public static void main(String[] args) throws IOException {
		
		try {
			
			int[] lenArray = {50, 1000, 2000, 5000, 10000};
			String[] fileNames = {"random_50.txt", "random_1000.txt", "random_2000.txt", "random_5000.txt", "random_10000.txt", 
										"reverse_50.txt", "reverse_1000.txt", "reverse_2000.txt", "reverse_5000.txt", "reverse_10000.txt", 
										"ascending_50.txt", "ascending_1000.txt", "ascending_2000.txt", "ascending_5000.txt", "ascending_10000.txt", };
			
			// used to increment through the fileNames array
			int nameCounter = 0;
			
			// generate randomly ordered files
			for (int i = 0; i < lenArray.length; i++) {
				
				List<Integer> shuffArray = new ArrayList<Integer>();
		      for (int j = 1; j <= lenArray[i]; j++) {
		      	shuffArray.add(j);
		      }
		      
		      Collections.shuffle(shuffArray);
		      
		      int[] array = new int[shuffArray.size()];
		      
		      for (int j = 0; j < shuffArray.size(); j++) {
		      	array[j] = shuffArray.get(j);
		      }
		      
	      	Writer wr = new FileWriter(fileNames[nameCounter]);
	      	
	      	for (int j = 0; j < array.length; j++) {
	      		wr.write(array[j] + "" + "\n");
	      		
	      	}
	      	wr.close();
				
				
				nameCounter++;
			}
			
			
			// generate reverse ordered files
			for (int i = 0; i < lenArray.length; i++) {
				
				int[] array = new int[lenArray[i]];
				
				int index = 0;
		      for (int j = lenArray[i]; j >= 1; j--) {
		      	
		      	array[index] = j;
		      	index++;
		      	
		      }

	      	Writer wr = new FileWriter(fileNames[nameCounter]);
	      	
	      	for (int j = 0; j < array.length; j++) {
	      		wr.write(array[j] + "" + "\n");
	      		
	      	}
	      	wr.close();
				
				
				nameCounter++;
			}

			
			// generate ascending ordered files
			for (int i = 0; i < lenArray.length; i++) {
				
				int[] array = new int[lenArray[i]];
				

		      for (int j = 1; j <= lenArray[i]; j++) {
		      	
		      	array[j - 1] = j;
		      	
		      }

	      	Writer wr = new FileWriter(fileNames[nameCounter]);
	      	
	      	for (int j = 0; j < array.length; j++) {
	      		wr.write(array[j] + "" + "\n");
	      		
	      	}
	      	wr.close();
				
				
				nameCounter++;
			}
			
      	
      }
      catch(IOException e) {
      	System.out.println("file not found");
      }


	}

}
