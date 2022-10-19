@smoke
  Feature: Login | users could use login functionality to use their accounts
  Scenario:  user could login with valid email and password
  Given           user go to login page
  When            user login with "valid" "SAEDA@FWD.com" and "123456789"
  And             user press on login button
  Then            user login to the system successfully

  Scenario:   user could login with invalid email and password
  Given           user go to login page
  When            user login with "invalid" "saedaXX@mail.com" and "P@ssXXw0rd"
  And             user press on login button
  Then            user could not login to the system

