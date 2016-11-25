Feature: View Players

  Scenario: View players
    Given I have players available
    When  I try to view all players
    Then  I must see all players
