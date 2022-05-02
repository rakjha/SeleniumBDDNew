package test.com.anz.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.com.anz.core.BaseMethods;
import test.com.anz.page.methods.LoanCalculationMethods;

import java.util.List;


public class LoanCalculationSteps extends LoanCalculationMethods {

    @Given("User navigates to loan calculator page")
    public void user_navigates_to_loan_calculator_page() {
        BaseMethods.applicationURL();
    }

    @When("User selects application type")
    public void user_selects_application_type(io.cucumber.datatable.DataTable applicationType) throws InterruptedException {
        List<String> data = applicationType.asList();
        selectApplicationType(data.get(0));
    }

    @Then("User selects number of dependents")
    public void user_selects_number_of_dependents(io.cucumber.datatable.DataTable dependentsNumber) throws InterruptedException {
        List<String> data = dependentsNumber.asList();
        selectDependents(data.get(0));
    }

    @Then("User selects property type to buy")
    public void user_selects_property_type_to_buy(io.cucumber.datatable.DataTable propertyType) throws InterruptedException {
        List<String> data = propertyType.asList();
        selectPropertyType(data.get(0));
    }

    @When("User enters annual income")
    public void user_enters_annual_income(io.cucumber.datatable.DataTable annualIncome) throws InterruptedException {
        List<String> data = annualIncome.asList();
        enterAnnualIncome(data.get(0));
    }

    @Then("User enters other income")
    public void user_enters_other_income(io.cucumber.datatable.DataTable otherIncome) throws InterruptedException {
        List<String> data = otherIncome.asList();
        enterOtherIncome(data.get(0));
    }

    @When("User enters living expense details")
    public void user_enters_living_expense_details(io.cucumber.datatable.DataTable livingExpense) throws InterruptedException {
        List<String> data = livingExpense.asList();
        enterLivingExpense(data.get(0));
    }

    @Then("User enters current home loan repayments")
    public void user_enters_current_home_loan_repayments(io.cucumber.datatable.DataTable loanRepayments) throws InterruptedException {
        List<String> data = loanRepayments.asList();
        enterHomeLoanRepayments(data.get(0));
    }

    @Then("User enters other loan repayments")
    public void user_enters_other_loan_repayments(io.cucumber.datatable.DataTable otherLoanRepayments) throws InterruptedException {
        List<String> data = otherLoanRepayments.asList();
        enterOtherLoanRepayments(data.get(0));

    }

    @When("User enters other commitments")
    public void user_enters_other_commitments(io.cucumber.datatable.DataTable commitments) throws InterruptedException {
        List<String> data = commitments.asList();
        enterOtherCommitments(data.get(0));
    }

    @Then("User enters credit cards limit")
    public void user_enters_credit_cards_limit(io.cucumber.datatable.DataTable creditCardLimit) throws InterruptedException {

        List<String> data = creditCardLimit.asList();
        enterCreditCardLimit(data.get(0));
    }

    @Then("User validates borrowing estimate of following amount")
    public void user_validates_borrowing_estimate_of_following_amount(io.cucumber.datatable.DataTable expectedEstimatedAmount) throws InterruptedException {
        List<String> data = expectedEstimatedAmount.asList();
        validateExpectedEstimatedAmount(data.get(0));
    }

    @When("User enters {string} application type")
    public void user_enters_application_type(String applicationType) throws InterruptedException {
        selectApplicationType(applicationType);
    }

    @Then("User selects {string} as number of dependents")
    public void user_selects_as_number_of_dependents(String dependents) throws InterruptedException {
        selectDependents(dependents);
    }

    @Then("User selects {string} to buy")
    public void user_selects_to_buy(String propertyType) throws InterruptedException {
        selectPropertyType(propertyType);
    }

    @Then("User enters income details as {string} and {string}")
    public void user_enters_income_details_as_and(String annualIncome, String otherIncome) throws InterruptedException {
        enterAnnualIncome(annualIncome);
        enterOtherIncome(otherIncome);
    }

    @Then("User enters {string} expense details")
    public void user_enters_expense_details(String expense) throws InterruptedException {
        enterLivingExpense(expense);
    }

    @Then("User enters {string} and {string} repayments details")
    public void user_enters_and_repayments_details(String homeLoan, String otherLoan) throws InterruptedException {
        enterHomeLoanRepayments(homeLoan);
        enterOtherLoanRepayments(otherLoan);
    }

    @Then("User enters other {string} and {string} limits")
    public void user_enters_other_and_limits(String commitments, String creditCard) throws InterruptedException {
        enterOtherCommitments(commitments);
        enterCreditCardLimit(creditCard);

    }

    @Then("User validates calculated borrowing amount match {string}")
    public void user_validates_calculated_borrowing_amount_match(String expectedAmount) throws InterruptedException {
        validateExpectedEstimatedAmount(expectedAmount);
    }

    @Then("User clicks start over to reset the calculator")
    public void userClicksStartOverToResetTheCalculator() throws InterruptedException {
        resetBorrowingCalculator();
    }

    @Then("User validates error message")
    public void user_validates_error_message(io.cucumber.datatable.DataTable errorMessage) throws InterruptedException {
        List<String> data = errorMessage.asList();
        validateBorrowedErrorMessage(data.get(0));
    }

}
