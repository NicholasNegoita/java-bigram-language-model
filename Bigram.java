import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Bigram {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
	
	public static String promptUser(HashMap<String, HashMap<String, Long>> map) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String prompt;
		do {
		System.out.println("Enter a word: ");
		prompt = scan.nextLine();
		
		if(!map.containsKey(prompt))
			System.out.println(ANSI_GREEN + "Word doesn't exist in database" + ANSI_RESET);
		}while(!map.containsKey(prompt));
		return prompt;
	}
	
	public static String mapNewWord(String word, HashMap<String, Long> map) {
		int x = (int)(Math.random()*(map.size()));
		List<String> list = new ArrayList<>(map.keySet());
		return(list.get(x));
	}
	
	public static void main(String[] args) {
		HashMap<String, HashMap<String, Long>> outerMap = new HashMap<>();
		HashMap<String, Long> innerMap = new HashMap<>();
		
		try {
		BufferedReader reader = new BufferedReader(new FileReader(/*COPY AND PASTE THE FILE PATH HERE*/);
		String line;
		while((line = reader.readLine()) != null) {
			String[]arr = line.split(" ");
			
			for(int i=0; i<arr.length-1; i++) {
				String firstWord = arr[i];
				String secondWord = arr[i+1];
				
				//long count = Long.parseLong(arr[2]);
				
				if(!outerMap.containsKey(firstWord)) {
					innerMap = new HashMap<>();
					outerMap.put(firstWord, innerMap);
				}
				else {//if the outer map already contains the firstword as a key
					innerMap = outerMap.get(firstWord);
				}
				
				if(!innerMap.containsKey(secondWord)) {//if inner map does not already contain the second word as a key
					innerMap.put(secondWord, (long) 1);
				}
			}
		}
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		for(int a=0; a<a+1; a++) {
			String prompt = promptUser(outerMap);
			String output = "";
			int outputLength = (int)(Math.random()*10)+1;
		for(int i=0; i<outputLength; i++) {
			HashMap<String, Long> map = outerMap.get(prompt);
			prompt = mapNewWord(prompt, map);
			output+= ANSI_YELLOW + prompt + " " + ANSI_RESET;
			if(!outerMap.containsKey(prompt))
				break;
		}
		System.out.println(output);
		}
		
	}
	
}
