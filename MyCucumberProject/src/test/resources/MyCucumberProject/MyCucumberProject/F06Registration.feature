Feature: Validate Registration Process

  Background: 
    Given Launch Registration page

  Scenario: To validate registration process
    When I Enter following data
      | Devendra | Vasta | devendra@gmail.com | 9897985878 | Mandsaur  |
      | Nagraj   | Naik  | nagraj@gmail.com   | 7897897890 | Honnavara |
    Then Registration process should success

  Scenario: To validate registration process with title
    When Enter the data as follows
      | FirstName | LastName | EmailID             | MobileNo   | City     |
      | Swathi    | Acharya  | swati@gmail.com     | 9879879879 | Mysore   |
      | Sangeetha | K        | sangeetha@gmail.com | 8948948945 | Banglore |
    Then Registration Success
