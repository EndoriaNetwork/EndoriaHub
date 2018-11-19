package fr.hugob147.endorialobby.utils;

import java.io.File;
import java.io.IOException;

public class FileConfig
{
	public static void createFile(File dir, String fileName, String extention)
	{
		if(!dir.exists())
		{
			dir.mkdir();
		}

		File file = new File(dir, fileName + "." + extention);

		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static File getFile(File dir, String fileName, String extention)
	{
		return new File(dir, fileName + "." + extention);
	}
}
