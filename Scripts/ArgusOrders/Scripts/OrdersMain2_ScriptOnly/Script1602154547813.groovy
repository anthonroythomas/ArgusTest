//package argusAssignment

import com.kms.katalon.core.annotation.Keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.webservice.verification.WSResponseManager as WSResponseManager
//groovy
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
//Groovy
import static org.assertj.core.api.Assertions.*
//import MobileBuiltInKeywords as Mobile
//Selenium
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
//Java imports
import java.util.List as List

import org.junit.Assert
import org.junit.Assume
import java.lang.AssertionError
import java.lang.Error
import java.lang.Object.*;
import java.nio.charset.Charset
import java.util.Random.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Math

//open browser
WebUI.openBrowser('')

WebUI.maximizeWindow()


	def response
	def starter = 4.00
	def main = 7.00
	def drink = 2.50
	def orderValueS
	float orderValueF
	float orderCalculated


	String request = "https://19f5ad92-e73b-4c7b-90f1-79bf6fbb242b.mock.pstmn.io/v1/argus/orders"
	
			KeywordLogger log = new KeywordLogger();
			JsonSlurper slurper = new JsonSlurper();
	
			response = WS.sendRequest(findTestObject("API/APIOrder2"))
	
	
			//parsing the response object into a usable String
			Map parsedJson = slurper.parseText(response.getResponseText());
	
			//This catch block ensures the JSON contains the correct keys
			try {
				assert parsedJson.containsKey("starters")
				assert parsedJson.containsKey("mains")
				assert parsedJson.containsKey("drinks")
				assert parsedJson.containsKey("total")
				assert parsedJson.containsKey("service")
			}
			catch (def stepFailedException){
			}
			
			//This parses the order total value from the Map into a String to compare against
			orderValueS = parsedJson.get('total')
			System.out.println(orderValueS)
			
			//Parse the String into an float
			orderValueF = Float.parseFloat(orderValueS);
	
	
			//Calculates the Starters and mains separately from the drinks and service
			orderCalculated = orderCalculated.valueOf((starter * 1) + (main * 2));
			
			//Calculates the 10% Service charge on ONLY the food
			orderCalculated = (orderCalculated * 1.10) + (drink *0.00)
	
			//Logs the result of both floats for debugging purpose
			System.out.println(orderValueF);
			System.out.println(orderCalculated);
	
			
			//This compares the values from the JSON to our own calculation to ensure the test passes
			assert orderValueF.equals(orderCalculated)
			
			
//@Test
/* 2a. 1 person from the group cancels their order
*	  When the order is sent to the endpoint the total is recalculated correctly
*/
			response = WS.sendRequest(findTestObject("API/APIOrder2a"))
			
			//parsing the response object into a usable String
			parsedJson = slurper.parseText(response.getResponseText());
			
			//This parses the order total value from the Map into a String to compare against
			orderValueS = parsedJson.get('total')
			System.out.println(orderValueS)
			
			//Parse the String into an float
			orderValueF = Float.parseFloat(orderValueS);
	
	
			//Calculates the Starters and mains separately from the drinks and service
			orderCalculated = orderCalculated.valueOf((starter * 1) + (main * 4));
			
			//Calculates the 10% Service charge on ONLY the food
			orderCalculated = (orderCalculated * 1.10) + (drink *0.00)
	
			//Logs the result of both floats for debugging purpose
			System.out.println(orderValueF);
			System.out.println(orderCalculated);
	
			
			//This compares the values from the JSON to our own calculation to ensure the test passes
			assert orderValueF.equals(orderCalculated)