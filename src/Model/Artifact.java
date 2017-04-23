package Model;
import View.ViewClass;

/*
 * Author Richard Williams
 * 
 * 
 */
public class Artifact
{
	
	ViewClass view = new ViewClass();
	private String artifactId;
	private String artifactName;
	private String Description;
	
	public Artifact()
	{
		setArtifactId("");
		setArtifactName("");
		setDescription("");
	}
	
	public void setArtifactId(String artifactId)
	{
		this.artifactId = artifactId;
	}
	
	public void setArtifactName(String artifactName)
	{
		this.artifactName = artifactName;
	}
	
	public void setDescription(String Description)
	{
		this.Description = Description;
	}
	
	public Artifact(String artifactId, String artifactName, String Description )
	{
		setArtifactId(artifactId);
		setArtifactName(artifactName);
		setDescription(Description);
	}
	
	public String getArtifactId()
	{
		return artifactId;
	}
	
	public String getArtifactName()
	{
		return artifactName;
	}
	
	public String getDescription()
	{
		return Description;
	}
	
	// Needs more code to become functional.
	public void viewItem()
	{
		//Needs code
		
		
		
		System.out.println("You just viewed" + " ");
	}
	
	public void getItem()
	{
		
		//Needs code
		
		
		
		System.out.println(" " + "has been aquired.");
	}
	
	public void dropItem()
	{
		
		
		
		
		
		System.out.println(" " + "has been dropped.");
	}
	
	public void useItem()
	{
		
		
		//needs code
		
		
		
		System.out.println("You used" + " ");
	}
	
	public void openChest()
	{
		
		//needs code
		
		
		
		
		System.out.println(" " + " has been opened");
	}
	
	public void drinkPotion()
	{
		
		//needs code
		
		
		
		
		System.out.println(" " + "has been drunk");
	}


}
