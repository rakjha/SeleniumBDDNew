@LoanTest
Feature: Loan Borrowing Calculator

  Background:
    Given User navigates to loan calculator page

  @SampleTest1
  Scenario: TC001 Validate loan borrowing capacity for "single" with following details
    When User selects application type
      | single |
    Then User selects number of dependents
      | 0 |
    And User selects property type to buy
      | Home to live in |
    When User enters annual income
      | 80000 |
    Then User enters other income
      | 10000 |
    When User enters living expense details
      | 500 |
    Then User enters current home loan repayments
      | 0 |
    And User enters other loan repayments
      | 100 |
    When User enters other commitments
      | 0 |
    Then User enters credit cards limit
      | 10000 |
    And User validates borrowing estimate of following amount
      | $542,000 |

  @SampleTest1
  Scenario: TC002 Validate loan borrowing capacity for "joint" with following details
    When User selects application type
      | joint |
    Then User selects number of dependents
      | 0 |
    And User selects property type to buy
      | Home to live in |
    When User enters annual income
      | 80000 |
    Then User enters other income
      | 10000 |
    When User enters living expense details
      | 500 |
    Then User enters current home loan repayments
      | 0 |
    And User enters other loan repayments
      | 100 |
    When User enters other commitments
      | 0 |
    Then User enters credit cards limit
      | 10000 |
    And User validates borrowing estimate of following amount
      | $479,000 |

  @SampleTest1
  Scenario: TC003 Validate click on start over button will reset the borrowing calculator
    When User selects application type
      | single |
    Then User selects number of dependents
      | 0 |
    And User selects property type to buy
      | Home to live in |
    When User enters annual income
      | 80000 |
    Then User enters other income
      | 10000 |
    When User enters living expense details
      | 500 |
    Then User enters current home loan repayments
      | 0 |
    And User enters other loan repayments
      | 100 |
    When User enters other commitments
      | 0 |
    Then User enters credit cards limit
      | 10000 |
    And User validates borrowing estimate of following amount
      | $542,000 |
    Then User clicks start over to reset the calculator

  @SampleTest1
  Scenario: TC004 Validate error message when all other fields are set to zero except living expense
    When User selects application type
      | single |
    Then User selects number of dependents
      | 0 |
    And User selects property type to buy
      | Home to live in |
    When User enters annual income
      | 0 |
    Then User enters other income
      | 0 |
    When User enters living expense details
      | 1 |
    Then User enters current home loan repayments
      | 0 |
    And User enters other loan repayments
      | 0 |
    When User enters other commitments
      | 0 |
    Then User enters credit cards limit
      | 0 |
    And User validates error message
      | Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500. |

  @SampleTest2
  Scenario Outline: TC005 Calculate loan borrowing capacity for with following details
    When User enters "<applicationType>" application type
    Then User selects "<dependents>" as number of dependents
    And  User selects "<propertyType>" to buy
    Then User enters income details as "<annualIncome>" and "<otherIncome>"
    And  User enters "<living>" expense details
    Then User enters "<homeLoan>" and "<otherLoan>" repayments details
    And  User enters other "<commitments>" and "<creditCard>" limits
    Then User validates calculated borrowing amount match "<expectedAmount>"

    Examples:
      | applicationType | dependents | propertyType           | annualIncome | otherIncome | living | homeLoan | otherLoan | commitments | creditCard | expectedAmount |
      | single          | 0          | Home to live in        | 80000        | 10000       | 500    | 0        | 100       | 0           | 10000      | $542,000       |
      | joint           | 1          | Home to live in        | 80000        | 10000       | 500    | 0        | 100       | 0           | 10000      | $542,000       |
      | single          | 0          | Residential investment | 80000        | 10000       | 500    | 0        | 100       | 0           | 10000      | $542,000       |
      | single          | 2          | Home to live in        | 80000        | 10000       | 500    | 0        | 100       | 0           | 10000      | $542,000       |
