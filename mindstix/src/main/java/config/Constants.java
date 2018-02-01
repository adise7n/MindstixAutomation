package config;

public class Constants {

	//Change the below Path:-------------------------------------------
	public static final String Path_TestData = "src\\main\\java\\dataEngine\\DataEngine.xlsx";
	
	//Change the below Path:-------------------------------------------
	//public static final String Path_OR = "C:\\Users\\Aditya\\workspace\\Aditya_Automation\\src\\config\\OR.txt";
	public static final String Path_OR = "src\\main\\java\\config\\OR.txt";

	//public static final String File_TestData = "/home/kumar/Desktop/project/aditya/src/main/java/dataEngine/DataEngine.xlsx";
	
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1;
	public static final int Col_PageName =3;
	public static final int Col_PageObject =4;
	public static final int Col_ActionKeyword =5;
	public static final int Col_RunMode =2;
	public static final int Col_Result =3;
	public static final int Col_DataSet =6;
	public static final int Col_TestStepResult =7;
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";

	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "Test Steps";
	public static final String Sheet_TestCases = "Test Cases";

	
}