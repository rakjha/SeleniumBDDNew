package test.com.anz.page.methods;


import main.com.anz.core.BaseMethods;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.com.anz.page.elements.LoanCalculationElements;

public class LoanCalculationMethods extends LoanCalculationElements {

    public LoanCalculationMethods() {
        PageFactory.initElements(BaseMethods.WEB_DRIVER_THREAD_LOCAL.get(), this);
    }

    protected void selectApplicationType(String applicationType) throws InterruptedException {

        if (applicationType.trim().equalsIgnoreCase("joint")) {
            scrollAndHighlightElement(jointBtn);
            clickElement(jointBtn);
        } else {
            scrollAndHighlightElement(singleBtn);
            clickElement(singleBtn);
        }
    }

    protected void selectDependents(String dependents) throws InterruptedException {
        scrollAndHighlightElement(dependentsDropDown);
        selectByValue(dependentsDropDown, dependents);

    }

    protected void selectPropertyType(String propertyType) throws InterruptedException {
        if (propertyType.trim().equalsIgnoreCase("Residential investment")) {
            scrollAndHighlightElement(residentialInvestment);
            clickElement(residentialInvestment);
        } else {
            scrollAndHighlightElement(homePropertyType);
            clickElement(homePropertyType);
        }
    }

    protected void enterAnnualIncome(String annualIncome) throws InterruptedException {
        scrollAndHighlightElement(annualIncomeTextBox);
        typeInTextField(annualIncomeTextBox, annualIncome);
    }

    protected void enterOtherIncome(String otherIncome) throws InterruptedException {
        scrollAndHighlightElement(annualIncomeTextBox);
        typeInTextField(otherIncomeTextBox, otherIncome);
    }

    protected void enterLivingExpense(String livingExpense) throws InterruptedException {
        scrollAndHighlightElement(livingExpensesTextBox);
        typeInTextField(livingExpensesTextBox, livingExpense);
    }

    protected void enterHomeLoanRepayments(String homeLoan) throws InterruptedException {
        scrollAndHighlightElement(homeLoansTextBox);
        typeInTextField(homeLoansTextBox, homeLoan);
    }

    protected void enterOtherLoanRepayments(String otherLoan) throws InterruptedException {
        scrollAndHighlightElement(otherLoansTextBox);
        typeInTextField(otherLoansTextBox, otherLoan);

    }

    protected void enterOtherCommitments(String commitments) throws InterruptedException {
        scrollAndHighlightElement(commitmentsTextBox);
        typeInTextField(commitmentsTextBox, commitments);
    }

    protected void enterCreditCardLimit(String creditLimit) throws InterruptedException {
        scrollAndHighlightElement(creditCardLimitsTextBox);
        typeInTextField(creditCardLimitsTextBox, creditLimit);
    }

    protected void validateExpectedEstimatedAmount(String expectedAmount) throws InterruptedException {
        jsPageScrollDown();
        scrollAndHighlightElement(borrowCalculatorBtn);
        borrowCalculatorBtn.click();
        waitForAjaxLoad();
        scrollAndHighlightElement(borrowResultTextAmount);
        Assert.assertEquals(expectedAmount.trim(), borrowResultTextAmount.getText().trim(), "Calculated borrowed amount is not matching the expected amount");
    }

    protected void resetBorrowingCalculator() throws InterruptedException {
        scrollAndHighlightElement(startOverBtn);
        clickElement(startOverBtn);
        waitForAjaxLoad();
        scrollAndHighlightElement(annualIncomeTextBox);
        Assert.assertEquals(annualIncomeTextBox.getAttribute("value").trim(), "0", "Annual income is not reset");
        Assert.assertEquals(livingExpensesTextBox.getAttribute("value").trim(), "0", "Annual income is not reset");
    }

    protected void validateBorrowedErrorMessage(String errorMessage) throws InterruptedException {
        scrollAndHighlightElement(borrowCalculatorBtn);
        borrowCalculatorBtn.click();
        scrollAndHighlightElement(borrowErrorText);
        Assert.assertTrue(borrowErrorText.getText().trim().equalsIgnoreCase(errorMessage), "Error message is not matching with expected one");

    }
}
