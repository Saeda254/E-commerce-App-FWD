@smoke

#SC3- User could reset his/her password successfully
Feature: Rest password | users can rest password
 #Test Scenario
  Scenario Outline: user  can rest password successfully
    Given user open login page
    And user clicks on forget password button
    And user type email "<email>" field
    And user clicks on recover button
    Then success message is displayed as Email with instructions has been sent to you
    Examples:
      | email                      |
      | saeda.mohamed254@gmail.com |