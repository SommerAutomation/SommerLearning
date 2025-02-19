Feature: Verify all links
  Scenario: Verify all links on the homepage
    When the user navigates to the Sommer Learning base URL
    Then the store button should work correctly
    And the media library button should work correctly
    