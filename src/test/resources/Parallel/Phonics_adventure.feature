Feature: Testing the word finder functionality of sommer learning

  Scenario Outline: Verity the Word Finder Functionality of Book 2
    When user navigate to the Sommer Learning baseurl
    Then Click on Phonics adventure
    Then Click on kindergarten
    Then choose all wordfinder of book 2
    When enter the wordfinder "<WordFinder>"
    Then Check the UI of books
    Then Click on the write book

    Examples: 
      | WordFinder |
      |          1 |
      |          2 |
      |          3 |
      |          4 |
      |          5 |
      |          6 |
      |          7 |
      |          8 |
      |          9 |
      |         10 |
      |         11 |
      |         12 |
      |         13 |
      |         14 |
      |         15 |
      |         16 |
      |         17 |
      |         18 |
      |         19 |
      |         20 |
      |         21 |
      |         22 |
      |         23 |
      |         24 |
      |         25 |
      |         26 |

  Scenario Outline: Verity the Word Finder Functionality of Book 3
    When user navigate to the Sommer Learning baseurl
    Then Click on Phonics adventure
    Then Click on kindergarten
    Then choose all wordfinder of book 3
    When enter the wordfinder "<WordFinder>"
    Then Check the UI of books
    Then Click on the write book

    Examples: 
      | WordFinder |
      |          1 |

  Scenario Outline: Verity the Word Finder Functionality of Book 7
    When user navigate to the Sommer Learning baseurl
    Then Click on Phonics adventure
    Then Click on kindergarten
    Then choose all wordfinder of book 7
    When enter the wordfinder "<WordFinder>"
    Then Check the UI of books
    Then Click on the write book

    Examples: 
      | WordFinder |
      |          1 |
