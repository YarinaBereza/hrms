Feature:  Adding employees

  Background:
    And  user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button option
    Then employee added successfully

  @smoke
  Scenario: Adding employee from add employee page via feature file
    And user enters firstname "Yarina123" middlename "MS" and lastname "Yarina456"
    And user clicks on save button option
    Then employee added successfully

  @example
  Scenario Outline: Adding employee from add employee page via feature file
    And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
    And user clicks on save button option
    Then employee added successfully

  Examples:
  |FirstName|MiddleName|LastName|
  |Test123456|MS       |Test9876|
  |Test228   |MS       |Test7849|
  |Test12345 |MS       |Test3476|
  |Test785   |MS       |Test7669|

  #FLOW
#    1 - hooks
#    2 - background
#    3- scenario 1
#    4 - hooks
#    5 - background
#    6 - scenario 2

  @datatablewithheader
  Scenario: Adding multiple employees in a single execution
    When add multiple employees and verify they are added successfully
      |FirstName|MiddleName|LastName|
      |Jon0404  |MS        |US      |
      |Jack0404 |MS        |US      |
      |MS0909   |MS        |US      |

    @excel
    Scenario: Adding the employee from excel file
When user adds multiple employees from excel file from "Sheet2" sheet and verify they are added





