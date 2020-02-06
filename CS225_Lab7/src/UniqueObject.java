import java.text.DecimalFormat;

public class UniqueObject {
	
	/////////////////////////////////////////////////////
	//Fields
	private static long nextUniqueId = 0;
	private long uniqueId;
	
	/////////////////////////////////////////////////////
	//Constructor
	public UniqueObject()
	{
		uniqueId = nextUniqueId++;
	}
	
	/////////////////////////////////////////////////////
	// Getters
	protected long getUniqueId()
	{
		return uniqueId;
	}
	protected String getUniqueIdString()
	{
		DecimalFormat df = new DecimalFormat("0000");
		return df.format(uniqueId);
	}
}