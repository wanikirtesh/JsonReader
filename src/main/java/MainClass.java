/**
 * Created by idnkiw on 8/30/2016.
 */
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MainClass {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("jsonFile.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray suiteList = (JSONArray) jsonObject.get("test_suites");
            System.out.println("|        Suite Name       |  Total   |  Passed  |  Failed  |  Blocked |10 Seconds|" + "\n"
                              +"--------------------------"+((char)9532)+"----------+----------+----------+----------+-----------");
            for(Object suite:suiteList)
            {
                JSONObject jsonSuite = (JSONObject)suite;
                JSONArray resultsList = (JSONArray) jsonSuite.get("results");
                int totalTests = resultsList.size();
                int passedTests=0,failedTests=0,blockedTests=0,tenSecTests=0;

                for(Object result:resultsList){
                    JSONObject jsonResult = (JSONObject)result;
                    switch(jsonResult.get("status").toString().toLowerCase()){
                        case "pass":
                            passedTests++;
                            break;
                        case "fail":
                            failedTests++;
                            break;
                        case "blocked":
                            blockedTests++;
                            break;
                    }
                    try {
                        if(Double.parseDouble(jsonResult.get("time").toString())>=10){
                        tenSecTests++;
                    }}catch (Exception e){}
                }
                System.out.println(String.format("|%1$25s|%2$10s|%3$10s|%6$10s|%6$10s|%6$10s|", jsonSuite.get("suite_name"),totalTests,passedTests,failedTests,blockedTests,tenSecTests));
                //System.out.println("\t"+"\t"+failedTests+"\t"+blockedTests+"\t"+tenSecTests);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getFirsttSuiteName(){
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("jsonFile.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray suiteList = (JSONArray) jsonObject.get("test_suites");
            System.out.println("|        Suite Name       |  Total   |  Passed  |  Failed  |  Blocked |10 Seconds|" + "\n"
                    +"--------------------------"+((char)9532)+"----------+----------+----------+----------+-----------");
            for(Object suite:suiteList)
            {
                JSONObject jsonSuite = (JSONObject)suite;
                JSONArray resultsList = (JSONArray) jsonSuite.get("results");
                int totalTests = resultsList.size();
                int passedTests=0,failedTests=0,blockedTests=0,tenSecTests=0;

                for(Object result:resultsList){
                    JSONObject jsonResult = (JSONObject)result;
                    switch(jsonResult.get("status").toString().toLowerCase()){
                        case "pass":
                            passedTests++;
                            break;
                        case "fail":
                            failedTests++;
                            break;
                        case "blocked":
                            blockedTests++;
                            break;
                    }
                    try {
                        if(Double.parseDouble(jsonResult.get("time").toString())>=10){
                            tenSecTests++;
                        }}catch (Exception e){}
                }
                System.out.println(String.format("|%1$25s|%2$10s|%3$10s|%6$10s|%6$10s|%6$10s|", jsonSuite.get("suite_name"),totalTests,passedTests,failedTests,blockedTests,tenSecTests));
                //System.out.println("\t"+"\t"+failedTests+"\t"+blockedTests+"\t"+tenSecTests);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "suite";
    }
}
