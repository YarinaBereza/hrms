package utils;

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
}
