package test.com.anz.page.elements;

import main.com.anz.core.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoanCalculationElements extends CommonMethods {

    @FindBy(id = "application_type_single")
    protected WebElement singleBtn;

    @FindBy(id = "application_type_joint")
    protected WebElement jointBtn;

    @FindBy(css = ".borrow__question__answer--select select")
    protected WebElement dependentsDropDown;

    @FindBy(id = "borrow_type_home")
    protected WebElement homePropertyType;

    @FindBy(id = "borrow_type_investment")
    protected WebElement residentialInvestment;

    @FindBy(xpath = "//input[@aria-labelledby='q2q1']")
    protected WebElement annualIncomeTextBox;

    @FindBy(xpath = "//input[@aria-labelledby='q2q2']")
    protected WebElement otherIncomeTextBox;

    @FindBy(id = "expenses")
    protected WebElement livingExpensesTextBox;

    @FindBy(id = "homeloans")
    protected WebElement homeLoansTextBox;

    @FindBy(id = "otherloans")
    protected WebElement otherLoansTextBox;

    @FindBy(xpath = "//input[@aria-labelledby='q3q4']")
    protected WebElement commitmentsTextBox;

    @FindBy(id = "credit")
    protected WebElement creditCardLimitsTextBox;

    @FindBy(id = "btnBorrowCalculater")
    protected WebElement borrowCalculatorBtn;

    @FindBy(css = ".borrow__result__text__amount")
    protected WebElement borrowResultTextAmount;

    @FindBy(xpath = "//div[@class='borrow__result__action']//button[@class='start-over']")
    protected WebElement startOverBtn;

    @FindBy(css = ".borrow__error__text")
    protected WebElement borrowErrorText;

}
