package argusAssignment

import argusAssignment.OrdersEndpointTests

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



OrdersEndpointTests tests = new OrdersEndpointTests()



	//@Test
	/* 1. A group of 4 people orders 4 starters, 4 mains and 4 drinks.
	 *	  When the order is sent to the endpoint the total is calculated correctly
	 */
	tests.UserStory1and3_4people_4starters_4mains_4drinks()


	//@Test
	/* 2. A group of 2 people order 1 starter and 2 mains. The endpoint can be called and return the correct total.
	 *	They are then joined by 2 more people who order 2 mains, when the updated order is sent to the endpoint the total is calculated correctly.
	 */
	tests.UserStory2_2people_1starter_2mains()
	
	
