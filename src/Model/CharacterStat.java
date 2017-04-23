package Model;
/*
 * Author Maryam Najiarani
 * Contains the information related to the Characters states of attack,HP, Defense, dodge
 * 
 * 
 */
public class CharacterStat {

	private int HP;
	private int ATK ;
	private int DEF ;
	private int Dodge ;
	
	public CharacterStat( )
	{
		
	}
	public CharacterStat( int HP, int ATK, int DEF, int Dodge) 
	{
		setHP(HP);
		setATK(ATK);
		setDEF(DEF);
		setDodge(Dodge);
		
	}
	
	public void Update( int dHP, int dATK, int dDEF, int dDodge)
	{
		setHP( getHP() + dHP) ;
		setATK( getATK() + dATK) ;
		setDEF( getDEF() + dDEF) ;
		setDodge( getDodge() + dDodge) ;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getATK() {
		return ATK;
	}
	public void setATK(int aTK) {
		ATK = aTK;
	}
	public int getDEF() {
		return DEF;
	}
	public void setDEF(int dEF) {
		DEF = dEF;
	}
	public int getDodge() {
		return Dodge;
	}
	public void setDodge(int dodge) {
		Dodge = dodge;
	}
	
	
}
