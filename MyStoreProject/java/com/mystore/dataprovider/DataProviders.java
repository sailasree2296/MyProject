/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

/**
 * @author Saila Sree T
 *
 */
public class DataProviders
{
NewExcelLibrary obj=new NewExcelLibrary();

@DataProvider(name="credentials")
public Object[][] getCredentials()
{
	int rows=obj.getRowCount("credentials");
	int column=obj.getColumnCount("credentials");
	int actRows=rows-1;
	
	Object[][] data=new Object[actRows][column];
	for(int i=0;i<actRows;i++) 
	{
		for(int j=0;j<column;j++)
		{
			data[i][j]=obj.getCellData("credentials", j, i+2);
		}
	}
	return data;
}
	
}
