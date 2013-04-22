package hashmapping;

import java.util.LinkedList;

public class MyHashmap
{
	private LinkedList<MyNode>[] myMap;
	private int mapSize;
	
	@SuppressWarnings("unchecked")
	public MyHashmap(int mapSize)
	{
		this.mapSize = mapSize;
		myMap = new LinkedList[mapSize];
		
		for(int i = 0; i < mapSize; i++)
		{
			myMap[i] = new LinkedList<MyNode>();
		}
		
		System.out.println("size: " + mapSize);
	}
	
	public void callDictionary(String word)
	{
		// first gather its ASCII value
		
		int wordLength = word.length();
		int wordScore = 0;
		
		for(int i = 0; i < wordLength; i++)
		{
			int asciiValue = word.charAt(i);
			wordScore += asciiValue;
		}
		
		// this is its index in the array
		wordScore = wordScore%mapSize;
		

		if(myMap[wordScore].size() == 0)
		{
			MyNode newNode = new MyNode(1, word);	
			myMap[wordScore].add(newNode);
		}
		else
		{
			int pos = -1;
			
			for(int count = 0; count < myMap[wordScore].size(); count++)
			{
				// first check to see if the word is in the dictionary already
				if(myMap[wordScore].get(count).getWord().equals(word))
				{
					pos = count;
				}
			}
			
			if(pos != -1)
			{
				
				int newScore = myMap[wordScore].get(pos).getWordCount() + 1;

				myMap[wordScore].get(pos).setWordCount(newScore);
			}
			else
			{
				MyNode newNode = new MyNode(1, word);	
				myMap[wordScore].add(newNode);
			}
		}
		
		
	}
	
	public String printDictionary()
	{
		String theDictionary = "";
		
		for(int i = 0; i < mapSize; i++)
		{
			for(int x = 0; x < myMap[i].size(); x++)
			{
				theDictionary += "Index: " + i + " --> Word: " + myMap[i].get(x).getWord() + " --> Count: " +
						myMap[i].get(x).getWordCount() + "\n";

			}
		}
		
		
		return theDictionary;
	}
	

}
