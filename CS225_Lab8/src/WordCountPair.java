//////////////////////////////////////////////////////////////////////////////////
// This class acts as a simple pair class which connects a String and int together
// in a single class/object, which makes sorting easier in our particular problem.
//////////////////////////////////////////////////////////////////////////////////
public class WordCountPair
{
	// Instance variables
	private String word = "";
	private int count = 0;
	
	// Overloaded constructor
	WordCountPair(String wordStr, int wordCount)
	{
		word = wordStr;
		count = wordCount;
	}
	
	// Getters
	public String getWord() { return word; }
	public int getCount() { return count; }
	
	// Setters
	public void setWord(String wordStr) { word = wordStr; }
	public void setCount(int wordCount) { count = wordCount; }
}