package tes.POM;

import org.openqa.selenium.By;

public class POM {
	
	public static final By Username = By.xpath("//input[@name='username']");
	public static final By Password =By.xpath("//input[@name='pw']");
	public static final By Login = By.xpath("//input[@name='Login']");
	public static final By LeadObject = By.xpath("//a[@title='Leads']/parent::*");
	public static final By LeadNew = By.xpath("//div[text()='New']");
	public static final By Direct = By.xpath("//span[text()='Direct']/parent::div//parent::*//input");
	public static final By DirectNew = By.xpath("//span[text()='Next']");
	public static final By Advisor = By.xpath("//span[text()='Advisor']/ancestor::label//div[1]");

}
