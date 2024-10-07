package config;

import test.TestNG_GoogleSearch_RelatedtoPropertiesfile;

import java.io.*;
import java.util.Properties;

//Create a config.properties file inside the same package
public class PropertiesFile {

    public static void main(String[] args) {

        getProperties();
        setProperties();
        getProperties();
    }

    //Get data from properties file
    public static void getProperties(){

        try {
            //Step 1 : Create an object of class properties file
                Properties prop = new Properties();

            //Step 2 : Create an object for class input stream
                //get location of current project
                    String projectPath=System.getProperty("user.dir");
                    InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");

            //Step 3: Load properties file
                prop.load(input);

            //Step 4: Read properties file (within brackets, give the property names which is declared in properties file)
                String browsername = prop.getProperty("browser");
                System.out.println(browsername);


                //This was done because I needed to use my testNG file in properties. (browserName is the variable decalred in testNG file)
            TestNG_GoogleSearch_RelatedtoPropertiesfile.browserName=browsername;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Set data to properties file
    public static void setProperties(){
        try {
            //Step 1 : Create an  of class properties file
                Properties prop = new Properties();

            //Step 2 : Create an object for class output stream
                //get location of current project
                    String projPath = System.getProperty("user.dir");
                    OutputStream output = new FileOutputStream(projPath + "/src/test/java/config/config.properties");

            //Step 3: Set property (property name and then the value to be set)
                 prop.setProperty("browser","chrome");

            /*
            This was done because I needed to use my testNG file in properties. (browserName is the variable decalred in testNG file)
                                 prop.setProperty("result","pass");

             */


            //Step 4: Store values in properties file(variable used for output stream, comments are optional)
                prop.store(output,null);


        }
        catch (Exception exp){

        }
    }

}
