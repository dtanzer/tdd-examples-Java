Feature: Amount too small?

  Scenario: Amount on wednesday is too small.
    Given today is wednesday
    And the amount of buns is 41
    When somebody orders a hot dog
    Then the application has to order buns