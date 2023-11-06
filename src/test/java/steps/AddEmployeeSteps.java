package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.time.Duration;

public class AddEmployeeSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {

        openBrowserAndLaunchApplication();

    }
    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {
        WebElement usernameTextField= driver.findElement(By.xpath("//*[@id='txtUsername']"));
    
        sendText(usernameTextField, ConfigReader.getPropertyValue("username"));
        
        WebElement passwordTextField= driver.findElement(By.cssSelector("input#txtPassword"));
        sendText(passwordTextField,ConfigReader.getPropertyValue("password"));

    


    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        WebElement loginButton=driver.findElement(By.xpath("//*[value='LOGIN'}"));
        click(loginButton);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("My test passed");
    }

    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton=driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
        click(addEmployeeButton);

    }

    @When("user enters firstName middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        WebElement firstNameField=driver.findElement(By.id("firstName"));
        WebElement middleNameField=driver.findElement(By.id("middleName"));
        WebElement lastNameField=driver.findElement(By.id("lastName"));


    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveBtn= driver.findElement(By.id("btnSave"));
        click(saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @Then("user closes the browser")
    public void user_closes_the_browser() {
        closeBrowser();

    }
}
