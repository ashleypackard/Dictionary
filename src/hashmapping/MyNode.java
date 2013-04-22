package hashmapping;

public class MyNode 
{
	private int wordCount;
	private String word;
	
	public MyNode()
	{
		wordCount = 0;
		word = "";
	}
	
	public MyNode(int wordCount, String word)
	{
		this.wordCount = wordCount;
		this.word = word;
	}
	
	public void setWordCount(int wordCount)
	{
		this.wordCount = wordCount;
	}
	
	public int getWordCount()
	{
		return wordCount;
	}
	
	public void setWord(String word)
	{
		this.word = word;
	}
	
	public String getWord()
	{
		return word;
	}

}
