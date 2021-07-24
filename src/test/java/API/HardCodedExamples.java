package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    /*
     * NOTES:
     *
     * Given - Preparing the request
     *
     * When - making the request/making the call/hitting the endpoint
     *
     * Then - verification/assertions
     *
     *
     */

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjY2MTc5NTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjY2MTE1MiwidXNlcklkIjoiMjkzNyJ9.ReQmRXaTS4ordojqV3jKwPQxtaLG-Y6g9cO6dzifnKI";
    static String employee_id;

    //@Test
    public void sampleTest() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", "2033677833");

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        /**
         * Printing response using aString() method to convert JSON object to a String
         * and printing using System.Out.Println()
         */

        System.out.println(response.asString());
    }
    @Test
    public  void aPostCreateEmployee(){

        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").body("{\n" +
                "  \"emp_firstname\": \"Sasha\",\n" +
                "  \"emp_lastname\": \"Bereza\",\n" +
                "  \"emp_middle_name\": \"Yos\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1980-07-10\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                "}");
        /**
         * log().all() will log and print all information being sent with the request
         */

        Response response = preparedRequest.when().post("/createEmployee.php");

        /**
         * prettyPrint() does the same as System.out.println(response.asString());
         */
        //response.prettyPrint();


        /**
         * jsonPath() allows us to retrieve specific data from a json object - just like
         * an xpath with selenium
         */
        employee_id = response.jsonPath().getString("Employee.employee_id");
        //System.out.println(employee_id);

        /**
         * Performing assertions
         */
        response.then().assertThat().statusCode(201);

        /**
         * Using Hamcrest Matchers class equalTo()
         */
        response.then().assertThat().body("Message", equalTo("Employee Created"));

        // Write an assertion that verifies that the response body has the name you used
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Sasha"));


        /**
         * Verifying server
         */
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }




@Test
    public void bGetCreatedEmployee(){
        RequestSpecification preparedRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id", employee_id );

        Response response = preparedRequest.when().get("/getOneEmployee.php");

       // response.prettyPrint();

    String empID = response.jsonPath().getString("employee.employee_id");

   boolean comparingEmpIDs =  empID.contentEquals(employee_id);
   Assert.assertTrue(comparingEmpIDs);
    System.out.println(comparingEmpIDs);


    // TASK retrieve the first name and assert that the first name is the same as the one you used
    //DO NOT USE HAMCREST MATCHES
    String firstName = response.jsonPath().getString("employee.emp_firstname");
    Assert.assertTrue(firstName.contentEquals("Sasha"));
    }

//@Test
    public void cGetAllEmployees(){

        RequestSpecification preparedRequest = given().header("Authorization",token).header("Content-Type", "application/json");
        Response response = preparedRequest.when().get("/getAllEmployees.php");
        String responseAsString = response.prettyPrint();

        JsonPath js = new JsonPath(responseAsString);
        int count = js.getInt("Employees.size()");
    System.out.println(count);

    //print all employee IDs from the response

    for(int i = 0; i < count; i++){
       String employeeIDs =  js.getString("Employees[" + i + "].employee_id");
       // System.out.println(employeeIDs);
        if(employeeIDs.contentEquals(employee_id)){
            System.out.println("Employee ID "+employee_id+" is present in response body");
            String firstName = js.getString("Employees[" + i + "].emp_firstname");
            System.out.println("Employee name is "+firstName);
            break;
        }
    }
    }

    @Test
    public void dPutUpdateCreatedEmployee(){

        RequestSpecification preparedRequest = given().header("Authorization",token).header("Content-Type", "application/json").body("{\n" +
                "  \"employee_id\": \"" + employee_id + "\",\n" +
                "  \"emp_firstname\": \"Ludmulaaa\",\n" +
                "  \"emp_lastname\": \"bnyt\",\n" +
                "  \"emp_middle_name\": \"ytythhgh\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1990-07-12\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"Tester\"\n" +
                "}");
        Response response = preparedRequest.when().put("/updateEmployee.php");
response.prettyPrint();
    }
}
