Feature: Start Game

  Scenario: Start Game
    Given I have players registered
    When  I try to click the start button
    Then  It must start the game
