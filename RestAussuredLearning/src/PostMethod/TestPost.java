package PostMethod;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

//import com.sun.tools.javac.util.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TestPost {
@Test
	public void RegistrationSuccessful()
	{ 
	 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
	 RequestSpecification request = RestAssured.given();
	 
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("FirstName", "Surabhi"); // Cast
	 requestParams.put("LastName", "Sahu");
	 requestParams.put("UserName", "Surabhisahu");
	 requestParams.put("Password", "password1");
	 requestParams.put("Email",  "SampleTest@gmail.com");
	 
	 request.body(requestParams.toJSONString());
	 Response response = request.post("/register");
	 
	 int statusCode = response.getStatusCode();
	 System.out.println("The status code recieved: " + statusCode);
	 
	 System.out.println("Response body: " + response.body().asString());
	}

}
