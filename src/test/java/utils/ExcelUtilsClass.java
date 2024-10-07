package utils;

public class ExcelUtilsClass {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        //craete object for the class
        Excel_Utils_CallExcelFunctions excel = new Excel_Utils_CallExcelFunctions(projectPath+"/excel/data.xlsx","Sheet1");

        excel.getCellDataString(0,0);
        excel.getCellDataNumeric(1,1);
    }
}
