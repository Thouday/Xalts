Manually Tested and Automated Cases:

When user is new to the platform - Positive Flow
Scenario 1 : User launches the URL and clicks on "Sign In" btn and enters credentials with email, pswd, confirm pswd 
             and clicks sign in btn, will redirect to get started page and clicks on sign out btn.

Scenario 2 : User launches the URL and clicks on "Get Started" btn and enters credentials with email, pswd, confirm pswd 
             and clicks sign in btn, will redirect to get started page and clicks on sign out btn.

When user is old to the platform - Positive Flow
Scenario 1 : User launches the URL and clicks on "SignIn" btn and clicks on "Already have an account? Click here to sign in." 
             and enters credentials with email and pswd and clicks on "Sign In" btn will redirect to get started page.

Scenario 2 : User launches the URL and clicks on "Get Started" btn and clicks on "Already have an account? Click here to sign in." 
             and enters credentials with email and pswd and clicks on "Sign In" btn will redirect to get started page.

When user is old to the platform - Negative Flow
Scenario 1 : User launches the URL and clicks on "SignIn" and enters credentials with email and pswd, confrim pswd, 
             then get the pop-up like "Provided E-Mail is already in use" and again clicks on "Already have an account? Click here to sign in." 
             and enters credentials with email and pswd and clicks on "Sign In" btn will redirect to get started page.

Scenario 2 : User launches the URL and clicks on "Get Started" and enters credentials with email and pswd, confrim pswd, 
             then get the pop-up like "Provided E-Mail is already in use" and again clicks on "Already have an account? Click here to sign in." 
             and enters credentials with email and pswd and clicks on "Sign In" btn will redirect to get started page.

Created the Automation framework by using TestNG and POM Design:

When user Logged In and continues the Submit Request To Onboard Nodes to Existing Blockchain:
1. Entered the details of the node (node ID and public IP) and clicked "ADD NODE" to add node to make a list of nodes.
2. Repeated the process by using looping condition to the wish list.
3. Added to the Wallet which all are added to the Wallet and clicked on the NEXT and submitted the Request.

When user Logged In and continues the Submit Request To Create New Private Blockchain:
1. Automated the network Name and wallet address.
2. Entered the Node IP and Public IP and added to the Nodes as a list and submitted the request.
