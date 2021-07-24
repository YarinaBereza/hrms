package utils;

import org.json.JSONObject;

public class apiPayloadConstants {


    public  static  String createEmployeePayload(){
          String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Sasha\",\n" +
                "  \"emp_lastname\": \"Bereza\",\n" +
                "  \"emp_middle_name\": \"Yos\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1980-07-10\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                "}";
          return createEmployeePayload;
    }

    public static String createEmployeeBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Sasha");
        obj.put("emp_lastname", "Bereza");
        obj.put("emp_middle_name", "Yos");
        obj.put("emp_gender", "F");
        obj.put("emp_birthday", "1980-07-10");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "Cloud Consultant");

        return  obj.toString();
    }

    public  static  String createEmployeeMoreDynamic(String firstName, String lastName, String middleName,
                                                     String gender, String employeeBday, String employeeStatus, String employeeJobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", employeeBday);
        obj.put("emp_status", employeeStatus);
        obj.put("emp_job_title", employeeJobTitle);

        return  obj.toString();

    }
}
