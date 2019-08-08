Feature: Sanity pack

  @ECOM-8773 @ECOM-9136 @Major @issue=ECOM-6659 @Sanity
  Scenario: Authorized Payment Methods - ECOM-8773 Sanity - Payment Methods - Add CC Payment Method by Admin
    Given Open Shop DS site
    And DS Portal - Accept cookies
    When Global Navigation - Login as "SANITY_ADMIN"
    Then Global Navigation - Login button changed to greeting text for "SANITY_ADMIN"
    And Open page "My Profile"
    And DS Portal - Left Navigation - Expand PRACTICE_MANAGEMENT section
    When DS Portal - Left Navigation - PRACTICE_MANAGEMENT - Click "Authorized Payment Methods" link
    Then Page "Authorized Payment Methods" is opened
    When DS Portal - Authorized Payment Methods - Save payment methods amount
    And DS Portal - Authorized Payment Methods - Click add a payment method
    Then DS Portal - Add a Payment Method - BILLING_ADDRESS section contains fields:
      | First Name *      |
      | Last Name *       |
      | Address *         |
      | City *            |
      | Country           |
      | State/Province *  |
      | Zip/Postal Code * |
      | Phone Number      |
      | Email *           |
    And DS Portal - Add a Payment Method - PAYMENT_DETAILS section contains fields:
      | Card Type *       |
      | Card Number *     |
      | Expiration Date * |
      | CVN *             |
    When DS Portal - Add a Payment Method - Submit mandatory fields with valid values
    Then Page "Authorized Payment Methods" is opened
  # todo : And DS Portal - Confirmation message is DISPLAYED - blocked by https://jiraeu.epam.com/browse/DENTECOM-6659
    And DS Portal - Authorized Payment Methods - Methods amount INCREASED
    And DS Portal - Authorized Payment Methods - Practice's billing location is DISPLAYED in Billing Address field
    When DS Portal - Authorized Payment Methods - Remove last added payment method

  @ECOM-8738 @Critical @Sanity @issue=ECOM-23343
  Scenario: Checkout - ECOM-8738 - Sanity Checkout Ordering via One time payment method by Admin
    Given Open Shop DS site as "SANITY_ADMIN"

    And Clear basket for logged in user via REST API
    And DS Portal - Shopping Cart - Open Shopping Cart and check it is empty
    And DS Portal - Accept cookies
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-AX270", quantity "1"
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-AX057", quantity "1"
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-M3US", quantity "1"

    When Open page "Checkout"
    Then Page "Checkout" is opened
    And DS Portal - Checkout Page - Remember added products
    When DS Portal - Checkout Page - Specify payment method "One-Time"
    And DS Portal - Checkout Page - Continue to payment
    Then Page "Checkout Step One" is opened
    When DS Portal - Checkout Step One Page - Fill in Billing Address form
    And DS Portal - Checkout Step One Page - Fill in payment details form
    And DS Portal - Checkout Step One Page - Click Pay button

    Then DS Portal - Order Placed Page - Order is placed
    And Page "Thank You" is opened
    And DS Portal - Order Placed Page - Shipping To section shown
    And DS Portal - Order Placed Page - Selected Delivery Options shown
    And DS Portal - Order Placed Page - Products Ordered shown
    And DS Portal - Order Placed Page - Ordered products are correct
    And DS Portal - Order Placed Page - Total price shown

    When Open page "Orders"
    Then Page "Orders" is opened
    And DS Portal - Orders Page - Orders table is shown
    And DS Portal - Orders Page - Placed order is present in orders table
    And DS Portal - Orders Page - Placed order has status "Received"

   # TODO: And SMB - Check xml files are created for ERPs "AX270,AX057,M3US" in "dt-outbound" folder
   # TODO: check XML file at RDP (steps 9,10) when required folder is shared (need to change "dt-outbound" test data to point at correct path)

    And DS Portal - Orders Page - Check order placed email for "SANITY_ADMIN"

  @ECOM-8749 @ECOM-7225 @Blocker @Sanity
  Scenario Outline: Checkout - ECOM-8749 and ECOM-7225 - Sanity Checkout Ordering via invoice payment method by Member and Admin
    Given Open Shop DS site as "<userRole>"

    And Clear basket for logged in user via REST API
    And DS Portal - Shopping Cart - Open Shopping Cart and check it is empty
    And DS Portal - Accept cookies
    And Add product using REST API: "<userRole>", sku "path-to-shop-ds-product-AX270", quantity "1"
    And Add product using REST API: "<userRole>", sku "path-to-shop-ds-product-AX057", quantity "1"
    And Add product using REST API: "<userRole>", sku "path-to-shop-ds-product-M3US", quantity "1"

    When Open page "Checkout Page"
    Then Page "Checkout Page" is opened
    And DS Portal - Checkout Page - Remember added products
    When DS Portal - Checkout Page - Specify payment method "Terms"
    Then DS Portal - Checkout Page - 'Confirm Payment Details' button is shown

    When DS Portal - Checkout Page - Click 'Confirm Payment Details' button
    Then DS Portal - Order Placed Page - Order is placed
    And Page "Thank You" is opened
    And DS Portal - Order Placed Page - Products Ordered shown
    And DS Portal - Order Placed Page - Ordered products are correct

    When Open page "Orders Page"
    Then Page "Orders Page" is opened
    And DS Portal - Orders Page - Orders table is shown
    And DS Portal - Orders Page - Placed order is present in orders table
    And DS Portal - Orders Page - Placed order has status "Received"
    And Global Navigation - Logout
    # TODO: When SMB - Check xml files are created for ERPs "AX270,AX057,M3US" in "dt-outbound" folder for invoice payment

    And DS Portal - Orders Page - Check order placed email for "<userRole>"

    Examples:
      | userRole      |
      | SANITY_ADMIN  |
      | SANITY_MEMBER |


  @ECOM-8766 @Critical @Sanity
  Scenario: Checkout - ECOM-8766 - Sanity Checkout Ordering via CC payment method by Admin
    Given Open Shop DS site as "SANITY_ADMIN"

    And Clear basket for logged in user via REST API
    And DS Portal - Shopping Cart - Open Shopping Cart and check it is empty
    And DS Portal - Accept cookies
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-AX270", quantity "1"
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-AX057", quantity "1"
    And Add product using REST API: "SANITY_ADMIN", sku "path-to-shop-ds-product-M3US", quantity "1"

    When Open page "Checkout Page"
    Then Page "Checkout" is opened
    And DS Portal - Checkout Page - Remember added products

    When DS Portal - Checkout Page - Specify payment method "CC"
    Then DS Portal - Checkout Page - 'Confirm Payment Details' button is shown

    When DS Portal - Checkout Page - Click 'Confirm Payment Details' button
    Then Page "Checkout Step One" is opened
    And DS Portal - Checkout Step One Page - 'Billing address' section is shown
    And DS Portal - Checkout Step One Page - 'Payment Details' section is shown
    And DS Portal - Checkout Step One Page - 'Your Order' section is shown

    When DS Portal - Checkout Step One Page - Click Pay button
    Then DS Portal - Order Placed Page - Order is placed
    And Page "Thank You" is opened
    And DS Portal - Order Placed Page - Shipping To section shown
    And DS Portal - Order Placed Page - Selected Delivery Options shown
    And DS Portal - Order Placed Page - Products Ordered shown
    And DS Portal - Order Placed Page - Ordered products are correct
    And DS Portal - Order Placed Page - Total price shown

    When Open page "Orders Page"
    Then Page "Orders" is opened
    And DS Portal - Orders Page - Orders table is shown
    And DS Portal - Orders Page - Placed order is present in orders table
    And DS Portal - Orders Page - Placed order has status "Received"

    # TODO: And SMB - Check xml files are created for ERPs "AX270,AX057,M3US" in "dt-outbound" folder

    And DS Portal - Orders Page - Check order placed email for "SANITY_ADMIN"

  @ECOM-8771 @ECOM-14551 @ECOM-9599 @Major @Sanity @PracticeAccount
  Scenario: ECOM-9599 ECOM-8771 - Add Practice Account Member
    Given Open Shop DS site
    And Global Navigation - Login as user "member_temporary_account"
    And DS Portal - Accept cookies
    And Open page "My Profile"
    Then Page "My Profile" is opened
    And DS Portal - Left Navigation - user role is "MEMBER"
    When DS Portal - My Account - Click Manage or Register for Practice accounts
    Then Page "Register For A Practice Account" is opened
    When DS portal - Register Account - Add NPI Number
    And DS portal - Register Account - Add Primary License Number
    And DS portal - Register Account - Add name and practice billing location
    And DS portal - Register Account - Set shipping address same as billing
    And DS portal - Register Account - Add another shipping address
    And DS portal - Register Account - Submit changes
    Then DS Portal - My Account - Check created Account on Manage Practice Account page
    Then DS Portal - Left Navigation - user role is "MEMBER"

  @ECOM-8771 @ECOM-9615 @Major @Sanity @PracticeAccount @issue=ECOM-23640
  Scenario: ECOM-8771 ECOM-9615 - Add Practice Account [Contact]
    Given Open backoffice as authorized user "hybris_admin"
    And Select "ADMIN" role
    And Backoffice menu: navigate to User, Customers
    And Administration - Search by "contact_temporary_account" user
    And Select the first search result in Administration View
    And Customer Details - Click ADMINISTRATION tab
    And Customer Details - Administration - Remove Customer Account Info
    And Customer Details - Administration - Remove Default B2B Unit
    And Customer Details - Click GENERAL tab
    And Customer Details - General - Remove all linked accounts

    When Open Shop DS site
    And Global Navigation - Login as user "contact_temporary_account"
    And DS Portal - Accept cookies
    And Open page "My Profile"
    Then Page "My Profile" is opened
    And DS Portal - Left Navigation - user role is "CONTACT"

    When DS Portal - My Account - Click on "ADD_A_PRACTICE_ACCOUNT"
    Then Page "Register For A Practice Account" is opened

    When DS portal - Register Account - Add NPI Number
    And DS portal - Register Account - Add Primary License Number
    And DS portal - Register Account - Add name and practice billing location
    And DS portal - Register Account - Set shipping address same as billing
    And DS portal - Register Account - Add another shipping address
    And DS portal - Register Account - Submit changes
    Then DS Portal - My Account - Check created Account on Manage Practice Account page
    And Open page "My Profile"
    Then DS Portal - Left Navigation - user role is "ADMIN"
    And DS Portal - Left Navigation - practice name equals to stored practice

  @ECOM-8767 @ECOM-10270 @issue=ECOM-16493 @Minor @Sanity
  Scenario: ECOM-8767 - User Access Management - Edit Practice Account by Account Admin AND ASSOCIATED PRACTICE ACCOUNT > Edit Account for [ADMIN]
    Given Open Shop DS site as "SANITY_ADMIN"
    And DS Portal - Accept cookies
    And Open page "My Profile"
    Then Page "My Profile" is opened
    When DS Portal - Left Navigation - Expand PRACTICE_MANAGEMENT section
    And DS Portal - Left Navigation - PRACTICE_MANAGEMENT - Click "Manage Practice Accounts" link
    Then Page "Manage Practice Accounts" is opened
    When DS Portal - Manage Practice Account - Click on Edit Practice button for 1 practice
    Then Page "Edit A Practice Account" is opened
    When DS Portal - Edit Account - Edit billing location
    And DS Portal - Edit Account - Save billing location changes
    Then DS Portal - Edit Account - Check billing location has changed
    When DS Portal - Edit Account - Add new default shipping location
    Then DS Portal - Edit Account - New or edited location exists in locations list
    And DS Portal - Edit Account - Remove 1 shipping location

    #     The product with all sections is not configured on dev3 yet
    #     TODO: create "path-to-shop-ds-product-that-has-all-sections" dev3 product
  @ECOM-8755 @Major @Sanity
  Scenario: ECOM-8755 - Product Details Page - Sanity PDP Product Detail Page look & feel
    Given Open Shop DS site as "SANITY_ADMIN"
    And  DS Portal - Accept cookies
    And DS Portal - Open a product with path "path-to-shop-ds-product-that-has-all-sections"
    Then Page "Product" is opened
    And DS Portal - Product Page - Page is configured for DESKTOP view

  @ECOM-8761 @Sanity @Major @LookAndFeel
  Scenario Outline: ECOM-8761 Sanity Search Product Result for Procedure and Category look and feel
    Given Open Shop DS site as "<userRole>"
    And DS Portal - Accept cookies
    Then "Shop DS" site is opened

    When Mega menu - <tabName> - click View all
    And DS Portal - Shop by <tabName> - Open PLP by path "<path>"
    Then DS Portal - Search product results page - Search Product Results Component is DISPLAYED
    And DS Portal - Search product results page - Search Product Result is correct for "<userRole>"

    When DS Portal - Search product results page - Click "0" product image
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product name
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product purchase options
    Then Page "Product" is opened

    When Global Navigation - Logout

    Examples:
      | userRole      | tabName   | path               |
      | GUEST         | PROCEDURE | procedure-plp-path |
      | GUEST         | CATEGORY  | category-plp-path  |
      | SANITY_ADMIN  | PROCEDURE | procedure-plp-path |
      | SANITY_ADMIN  | CATEGORY  | category-plp-path  |
      | SANITY_MEMBER | PROCEDURE | procedure-plp-path |
      | SANITY_MEMBER | CATEGORY  | category-plp-path  |
      | CONTACT       | PROCEDURE | procedure-plp-path |
      | CONTACT       | CATEGORY  | category-plp-path  |


  @ECOM-8761 @Sanity @Major @LookAndFeel
  Scenario Outline: ECOM-8761 Sanity Search Product Result for Search and Brand look and feel
    Given Open Shop DS site as "<userRole>"
    Then "Shop DS" site is opened
    And DS Portal - Accept cookies

    When DS Portal - Top Navigation - Type "dent" into Search field and press "Enter"
    Then Page "Search Product Result" is opened
    And DS Portal - Search product results page - Search Product Results Component is DISPLAYED
    And DS Portal - Search product results page - Search Product Result is correct for "<userRole>"

    When DS Portal - Search product results page - Click "0" product image
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product name
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product purchase options
    Then Page "Product" is opened

    When Mega menu - hover BRAND tab
    And Mega menu - BRAND - click tile by number "1"
    Then DS Portal - Search product results page - Search Product Results Component is DISPLAYED
    And DS Portal - Search product results page - Search Product Result is correct for "<userRole>"

    When DS Portal - Search product results page - Click "0" product image
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product name
    Then Page "Product" is opened

    When Return back
    And DS Portal - Search product results page - Click "0" product purchase options
    Then Page "Product" is opened

    When Global Navigation - Logout

    Examples:
      | userRole      |
      | GUEST         |
      | CONTACT       |
      | SANITY_ADMIN  |
      | SANITY_MEMBER |

  @ECOM-12066 @Blocker @Sanity @issue=ECOM-21078
  Scenario: ECOM-12066 Checkout page for DSAcademy - Positive.
    Given Open Academy DS site as "SANITY_MEMBER"
    And DS Academy - Unenroll user "SANITY_MEMBER" from course "valid_livecourse04" using REST API
    And DS Academy - Open livecourse with params "valid_livecourse04"
    And DS Academy - Course Details - Enroll on course

    When DS Portal - Checkout Page - Remember Order total price
    When DS Portal - Checkout Page - Specify payment method "CC"
    And DS Portal - Checkout Page - Continue to payment
    And DS Portal - Checkout Step One Page - Cybersource form shown for CC payment
    And DS Portal - Checkout Step One Page - 'Your Order' section is shown for CC payment with correct Total amount
    When DS Portal - Checkout Step One Page - Click Pay button
    Then DS Portal - Order Placed Page - Order is placed
    And Page "Academy Thank You" is opened

  @ECOM-13308 @Blocker @Sanity @issue=ECOM-21078
  Scenario: ECOM-13308 Enroll button look & feel for Guest (Internal Course)
    Given Open Academy DS site as "GUEST"
    And DS Academy - Open livecourse with params "valid_livecourse05"
    Then DS Academy - Course Details - Enroll button is displayed
    And DS Academy - Course Details - Enroll on course
    Then "SSO login" site is opened

    When DS Academy - Open livecourse with params "livecourse_without_seats"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, seats are full" is shown

    When DS Academy - Open livecourse with params "livecourse_with_ended_registration"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, Registration has ended" is shown

    When DS Academy - Open livecourse with params "livecourse_with_failed_integration"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, registration has ended" is shown

    When DS Academy - Open webinar with params "webinar_without_seats"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open webinar with params "webinar_with_ended_registration"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open webinar with params "webinar_with_failed_integration"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open livecourse with params "external_course"
    Then DS Academy - Course Details - Enroll button is displayed
    And DS Academy - Course Details - Enroll on course
    Then Page is opened in same tab


  @ECOM-13312 @Blocker @Sanity @issue=ECOM-21078
  Scenario Outline: ECOM-13312 Enroll button look & feel for Contact/Member/Admin
    Given Open Academy DS site as "<role>"
    And DS Academy - Open livecourse with params "valid_livecourse06"
    Then DS Academy - Course Details - Enroll button is displayed
    And DS Academy - Course Details - Enroll on course
    Then Page "Academy Checkout" is opened

    When DS Academy - Open livecourse with params "livecourse_without_seats"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, seats are full" is shown

    When DS Academy - Open livecourse with params "livecourse_with_ended_registration"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, registration has ended" is shown

    When DS Academy - Open livecourse with params "livecourse_with_failed_integration"
    Then DS Academy - Course Details - Enroll button is disabled
    And DS Academy - Course Details - Warning message "Sorry, registration has ended" is shown

    When DS Academy - Open webinar with params "webinar_without_seats"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open webinar with params "webinar_with_ended_registration"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open webinar with params "webinar_with_failed_integration"
    Then DS Academy - Course Details - Enroll button is displayed

    When DS Academy - Open livecourse with params "external_course"
    Then DS Academy - Course Details - Enroll button is displayed
    And DS Academy - Course Details - Enroll on course
    Then Page is opened in same tab

    Examples:
      | role          |
      | SANITY_ADMIN  |
      | SANITY_MEMBER |
      | CONTACT       |





