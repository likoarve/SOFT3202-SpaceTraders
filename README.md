# SpaceTraders GUI
This project provides a Graphical User Interface (GUI) for [SpaceTraders API](https://spacetraders.io/). This project is created as part of University of Sydney's SOFT3202 Task 2.

## Getting Started
### Built With
This application is developed using Java 17 and [JavaFX 17.0.1](https://openjfx.io/).

### Requirements
- Java JDK 17 or higher.
- Gradle 7.0 or higher.

## How to Run the Application
To start, either download the repository or clone the repository using the command below.
```
git clone https://github.com/likoarve/SOFT3202-SpaceTraders.git
```
The application can be runned in two different modes. <br>

#### Offline Mode
The offline mode is the dummy version of the application, 
meaning that there are no logic behind the application and all
information displayed is statically generated. User inputs does not
anything to do application. This mode is intended to demonstrate 
the GUI of the application. <br><br>
To run the offline version, use the command below.
``` 
gradle run --args="offline"
```

#### Online Mode
This is the actual version of the application. This mode
uses the logics of the SpaceTraders API.<br><br>
To run the offline version, either put the argument 'online' 
or use no arguments.
``` 
gradle run --args="online"
```
``` 
gradle run
```

## Acknowledgement
This project is fully inspired by SpaceTraders API. The full API documentation can be accessed from the links below.
- https://github.com/SpaceTradersAPI
- https://api.spacetraders.io/

---

## Functionalities
The functionalities implemented in this application are the ones specified in [SpaceTraders API's Getting Started Guide](https://spacetraders.io/docs/guide). Below are the functionalities of this application and how to
access them. Note that these functionalities only apply to
the 'online' mode of the application.

### General Functionalities
In almost all pages, there is a 'Back' button in the top-left of
the screen. Use this button to go to the page you previously
visited. In most cases, this button is used to go back to the
main menu.

In pages that displays long information, utilise the scrollbar to
navigate through the contents.

### Check Server Status
To check the server status, simply look at the bottom left of
the very first page. If the text is green, the server is online.
If it is red, the server is offline.

### Creating an Account and Storing Credentials
Follow the steps below:
1. Run the application.
2. Press 'Sign In'.
3. Enter a username.
4. If the username is valid, the account will be created 
successfully. You will now be brought to the main menu.
5. Go to 'Account'
6. Press 'Copy token to Clipboard' to save your token.

### Logging in to an Existing Account
Follow the steps below:
1. Run the application.
2. Press 'Login'.
3. Enter your username and token.
4. If the combination is valid, you will now be brought 
to the main menu.

### Logging in to an Existing Account
Follow the steps below:
1. Run the application.
2. Press 'Login'.
3. Enter your username and token.
4. If the combination is valid, you will now be brought
   to the main menu.

```
Note: All functionalities below this message will assume that you
are logged in and is currently at the main menu.
```
### Viewing Account Information
Simply press the 'Account' button in the bottom of the Main Menu.

### List Available Loans and Details
Simply press the 'Available Loans' button.

### Obtain a Loan
Follow the steps below:
1. Go to 'Available Loans'
2. Press 'Take Loan'

### List Active Loans
Simply press the 'Active Loans' button.

### List and Purchase Ships
Follow the steps below:
1. Go to 'Purchase Ships'
2. You can see the list of ships here.
3. To buy a ship:
   1. Select the ship to buy in the dropbox.
   2. Press buy.

### List Your Ships
Simply go to 'Your Ships', where information of your ships such
as its cargo, location, and other information are listed.

### Purchasing Fuel
Follow the steps below:
1. Make sure you have sufficient funds.
2. Go to 'Marketplace - Buy Items'
3. Select the marketplace location. The locations listed are 
places where you have a ship docked.
4. Press 'Search'. This will display all the goods available
in that location.
5. Select 'FUEL' and select the ship it's for.
6. Enter the quantity.
7. Press 'Buy'

### Viewing Marketplace
This can be done in two ways:
1. Press 'Marketplace - Buy Items'
2. Press 'Marketplace - Sell Items'

Then, select a marketplace location. The location listed are
places where you have a ship docked. Press 'Search', then the 
location's marketplace's details will be displayed.

### Purchase Goods
Follow the steps below:
1. Press 'Marketplace - Buy Items'
2. Follow the steps in the 'Viewing Marketplace' section. 
3. Choose the items to purchase from the list.
4. There are two dropdowns:
   1. Goods: This displays the items that can be bought from
   the selected marketplace. Choose the item you want to purchase.
   2. Ship: This displays all of your ships that are docked in
   that location. Choose which ship that will store the cargo
   bought.
5. Enter the quantity and press 'Buy'

### Selling Goods
Follow the steps below:
1. Go to 'Your Ships' to view your cargo and decide which item to sell.
2. Press the back button.
3. Press 'Marketplace - Sell Items'.
4. Follow the steps in the 'Viewing Marketplace' section.
5. There are two dropdowns:
   1. Goods: This displays the items that can be sold to
      the selected marketplace. Choose the item you want to sell.
   2. Ship: This displays all of your ships that are docked in
      that location. Choose the ship that contains the item 
      you want to sell.
6. Enter the quantity and press 'Buy'

### List Nearby Locations
Simply press 'Nearby Locations' in the main menu.

### Create a Flight Plan
Follow the steps below:
1. Press 'Plan Travel'
2. Choose the available destinations.
3. Choose which ship to use.
4. Press 'Travel'

### View Current Flight Plans
Simply press 'Current Travels' in the main menu.

---

## Contact
Email: liko.arve@gmail.com
