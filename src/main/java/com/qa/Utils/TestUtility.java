package com.qa.Utils;

import java.io.IOException;

//import com.qa.Base.BaseClass;

public class TestUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Utilities obj = new Utilities();
		//BaseClass obj = new BaseClass();
		Object[][] data = Utilities.get_Data();
		for (int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[i].length;j++)
			{
				System.out.print(data[i][j]+" | ");
			}
			System.out.println();
		}
		

	}

}
