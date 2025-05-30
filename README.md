# Sandwish - Java Sandwich Ordering System

Welcome to my SandWISH shop Java Application!


Sandwish is a Java-based console application designed to simulate a customizable sandwich ordering experience. Built with core Java principles and object-oriented design, this system allows users to create, modify, and manage sandwich orders with various toppings, sizes, and drinks, alongside generating detailed receipts.

##  Key Features


Selecting a new order brings the user to the Order Screen, while choosing exit ends the session with a thank-you message.
- **Custom Sandwich Builder:** Users can select sandwich size, bread type, toasted option, and add multiple toppings categorized by regular and premium types.
- **Drink and Chips Integration:** Optionally add drinks (various sizes and types) and chips to the order.
- **Order Management:** Add multiple sandwiches and drinks per order.
- **Receipt Generation:** Automatically creates timestamped text receipts summarizing the entire order with itemized prices.
- **Robust Console UI:** Interactive prompts guide users through the ordering process.
- **Use of Enums & OOP:** Clean design using enums for bread types, topping types, sizes, and drink types to make code look cleaner.

---

## Usage Instructions
Launch the application: The application will greet you.


![Screenshot 2025-05-30 012601](https://github.com/user-attachments/assets/2f40e3f5-1076-4c88-9a28-8763d351b350)



Create an order: Choose to add sandwiches, drinks, or chips.

Customize your sandwich:

Select sandwish size (4 inch, 8 inch, 12 inch).

Choose bread type (white, wheat, rye, wrap.).

Decide if toasted or not.

Add toppings from the available menu (regular and premium).

Add drinks and chips: Select from predefined drink sizes and chip types.

Review your order: View a summary of all items added.

Ability to go back, or cancel the order entirely.

Checkout: Confirm the order and receive a generated receipt saved in the /receipts folder.

---


## Home Screen Navigation
When the application starts, users are greeted with a simple home screen offering two choices:

Start a new order

Exit the application


![Screenshot 2025-05-30 012445](https://github.com/user-attachments/assets/e768ae46-1a6a-4838-92b5-ff812489f172)




----

## Order Screen
The order screen is the heart of the application. From here, users can:

Add a Sandwich – Launches a custom sandwich builder that walks users through choosing:

Sandwich size (4”, 8”, or 12”)

Bread type (White, Wheat, Rye, Wrap)

Toasting preference

Toppings (with options to mark toppings as “extra”)

Add a Drink – Users are prompted to choose a drink size (Small, Medium, Large) and select from available flavors using enums defined in DrinkType.

Add Chips – Displays a numbered list of chip options from the ChipType enum, allowing the user to pick one or cancel.

Checkout – Displays a summary of the current order (including price, sandwich, drink, chips). The user can confirm to complete the order and automatically generate a receipt.

Cancel Order – Clears the current order and returns to the home screen.

Order Finalization
If the user chooses to check out, a confirmation prompt appears. If confirmed, a receipt is generated using the Receipt class. The receipt contains a breakdown of the entire order and is saved to the receipts/ directory.



![Screenshot 2025-05-30 013136](https://github.com/user-attachments/assets/d195acc4-c16f-4212-b97d-75c2ea6f7491)


![Screenshot 2025-05-30 013230](https://github.com/user-attachments/assets/fa3b1690-a35e-4f99-b483-4a12c1c36e19)

![Screenshot 2025-05-30 013302](https://github.com/user-attachments/assets/3fa5bd85-9893-4c03-90d4-b3985e0bf1cc)


---


  ##  Use of Enums:
This project marks my first time incorporating enums in Java. The enum classes I've created were BreadType, ChipType, DrinkSize, DrinkType, SandwishSize, and ToppingType. After seeing classmates utilize them and receiving recommendations from online sources to include them in my design, I found enums to be very informative and convenient. They allowed me to efficiently organize fixed sets of constants—such as drink types, chip types, and sandwich options—which I could easily reference across my classes and display in the main application.

![Screenshot 2025-05-30 013419](https://github.com/user-attachments/assets/26776bf2-71d0-4513-b098-727ce8b0c41e)



![Screenshot 2025-05-30 013441](https://github.com/user-attachments/assets/043dab1b-e6fe-475d-ae5f-6b30de942da1)



![Screenshot 2025-05-30 013506](https://github.com/user-attachments/assets/344305e9-b937-4fad-88c0-8aad9c3cfdd0)





---

  ## Order and Sandwish Classes:
I created the Order and Sandwish classes because they’re essential for letting users customize and place their sandwich orders. The Order class handles the full order—it keeps track of the sandwiches, chips, drinks, and the total price. The Sandwish class focuses on the details of each sandwich, like the size, toppings, whether it's toasted, and the individual price.

----

 ##  Input Handling
To improve reliability, helper methods are included:

readIntInRange() – Ensures numeric input is within expected bounds.

readYesNo() – An option for the user to choose yes/no that prompts consistently.

createSandwich() – A dedicated method for guiding the user through the full sandwich customization process.


![Screenshot 2025-05-30 013605](https://github.com/user-attachments/assets/2112fc12-d480-4697-ab70-4c6588e0a0e1)

---

## Getters/ Setters and return statements

Getters/ setters and return statements are certainly needed because it worked together with my enum classes to display chiptype, drinktype, sizetype, etc.




![Screenshot 2025-05-30 013811](https://github.com/user-attachments/assets/0ceecce9-8b70-42f1-943d-b1ade9652df7)

---


What caught my attention in this project was creating the receipts. I implented the knowledge I have now, and with past projects that also used a receipts file/class, I created the Receipt class. In the Receipt class, I created the timestamp that was given to us as an example from the application requirements and created a String called "RECEIPT_FOLDER", so new receipts can be held there. I the, implemnted a Receipt.generate(order) so the receipt can be created when the user is checking out. I found this very interesting because this is my first time creating a receipt generator and I'm impressed of how convenient and accessible the receipts turn out.



![Screenshot 2025-05-30 014908](https://github.com/user-attachments/assets/c9dd153f-8b09-41aa-95b2-0a6c5531b620)


---

 ## GitBranch -

 

![Screenshot 2025-05-29 214606](https://github.com/user-attachments/assets/9f3f43b2-b41a-4bde-af14-426ea6af91dd)

---














