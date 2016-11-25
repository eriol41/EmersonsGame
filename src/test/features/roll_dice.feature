Feature: Roll Dice

  Scenario: Roll Dice
    Given I have a player in turn
    When  I try to click roll dice button
    Then  I must have a random number
