package Model;
import java.util.Set;
import java.util.HashSet;
/*
 * Author Erick Vale
 * Modified by Maryam Najiarani
 */

public class Monster {
	//monster info
	
	private CharacterStat stats ;
	String ID;
	String name ;
	String description ;
	String tagLine ;
	
	public  Monster(String ID,String name, String description, String tagLine,CharacterStat stats)
	{
		setID(ID);
		setName(name);
		setDescription(description);
		setTagLine(tagLine);
		setStats(stats);
	}
	
	
	public CharacterStat getStats() {
		return stats;
	}

	public void setStats(CharacterStat stats) {
		this.stats = stats;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
}
