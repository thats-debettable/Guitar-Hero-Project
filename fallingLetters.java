import java.util.*;
import java.io.*;

public class fallingLetters {
	
	private double x;
	private double y;
	private String note;
	
	public fallingLetters(String n, double pos)
	{
		x = pos;
		y = .9;
		note = n;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String n)
	{
		note = n;
	}
	
	public boolean fall() throws InterruptedException
	{
		StdDraw.text(x, y, note);
		y -= .05;
		Thread.sleep(30);
		return(y <= .025);
	}
		
}
