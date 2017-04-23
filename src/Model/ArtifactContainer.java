package Model;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * Author Richard Williams 
 * Modified by Maryam Najiarani
 * 
 * 
 */

public class ArtifactContainer 
{
	ArrayList<Artifact> artifactList = null;
	public ArtifactContainer()
	{
		artifactList = new ArrayList<Artifact>();
	}
	
	public boolean LoadArtifacts(String fileName)
	{
		try
		{
			
			File artifactFile = new File(fileName);
			Scanner fileReader = new Scanner(artifactFile);
			
			String str = fileReader.nextLine();
			int itemCount = Integer.parseInt(str);
			
			for( int i = 0; i < itemCount; i++)
			{
				String artifactId = fileReader.nextLine();
				String artifactName = fileReader.nextLine();
				String Description = fileReader.nextLine();
				
				Artifact artifact = new Artifact(artifactId, artifactName, Description);
				artifactList.add(artifact);
			}
			
			fileReader.close();
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	
	public ArrayList<Artifact> getArtifactList()
	{
		return artifactList;
	}
	public int getArtifactCount()
	{
		return artifactList.size();
	}
	
	
	public Artifact getArtifact(int i)
	{
		return artifactList.get(i);
	}
	
	public Artifact getArtifact(String artifactID)
	{
		for ( int i=0; i< artifactList.size() ; i++)
		{
			if( artifactList.get(i).getArtifactId().equalsIgnoreCase(artifactID))
				return artifactList.get(i) ;
		}
		return null;
		
	}
	
}
