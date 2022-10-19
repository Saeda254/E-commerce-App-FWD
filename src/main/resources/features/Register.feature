@smoke

Feature: Register | users can register with new accounts
  Scenario: NEW user can register with valid data successfully
    Given     user open register page
    When      user select gender type
    And       user type first name "saeed05a44" and last name "mohamed"
    And       user set date of birth
    And       user type email "saeed0a44@mail.com" field
    And       user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And       user clicks on register button
    Then      success message is displayed