package steemer;
import java.util.*;
import java.io.*;

public class Parser {
	String[] myDocs;
	ArrayList<String> termList;
	// make sure that the list is sorted. This right now is not sorted 
	String[] stopList = {"a","is","in","so","of","at","the","to","an","and","it","as","be","are"};
	
	public Parser(String folderName){
		File folder = new File(folderName);
		File[] listOfFiles = folder.listFiles();
		myDocs = new String[listOfFiles.length];
		for(int i =0;i<listOfFiles.length;i++){
			System.out.println("File "+ listOfFiles[i].getName());
		}
		Arrays.sort(stopList);
		String[] tokens = parse(folderName + "/" +myDocs[4]);
		for(String token: tokens){
			if(searchStopword(token)==-1){
				System.out.println(token);
			}
		
		}
	}
	public String[] parse(String fileName){
		String[] tokens = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String allLines = new String();
			String line =null;
			while((line=reader.readLine())!=null){
				allLines += line.toLowerCase();//case folding
			}
			//this will make a string of words into tokens
			tokens = allLines.split("[ .,?!:;$%&*+()\\-\\^]+");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return tokens;
		
	}
	//binary search
	public int searchStopword(String key){
		//this is finding the range of the list
		int lo=0;
		int hi = stopList.length-1;
		while(lo<=hi){
			//key is in a [lo..hi] or not present
			int mid = lo +(hi-lo)/2;
			int result = key.compareTo(stopList[mid]);
			if(result<0) hi = mid-1;
			else if(result>0) lo=mid+1;
			else return mid;
		}
		//didn't find a match in the list
		return-1;
		
	}
	
	public static void main(String[]args){
		Parser p = new Parser(args[0]);
		//System.out.println(stopList);
		System.out.println("Stopwords: " + p.searchStopword("is"));
		Stemmer st = new Stemmer();
		st.add("replacement".toCharArray(),"replacement".length());
		st.stem();
		System.out.println("stemmed: " + st.toString());
	}
}
