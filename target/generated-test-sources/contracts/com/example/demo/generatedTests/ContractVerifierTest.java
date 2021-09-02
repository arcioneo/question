package com.example.demo.generatedTests;

import com.example.demo.BaseClassForIntegrationTests;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.RestAssured.*;

@SuppressWarnings("rawtypes")
public class ContractVerifierTest extends BaseClassForIntegrationTests {

	@Test
	public void validate_shouldSayHello() throws Exception {
		// given:
			RequestSpecification request = given()
					.header("Content-Type", "application/json");

		// when:
			Response response = given().spec(request)
					.get("/sayhello/Eduardo");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['msg']").isEqualTo("hello Eduardo");
	}

}
