Feature: Checking Palindrome

  Scenario Outline: Check string for palindrome
    Given the user is on the landing page of the website
    When user types string in input box <word>
    Then user should see the result in output box <result>
    Examples:
      | word  | result |
      | mom   | true   |
      | dad   | true   |
      | son   | false  |
      | madam | true   |