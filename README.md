# AreYouHungry

## Controller
Controller maintains restaurants, delivers and customers.

## Person
Person is an abstract class which maintains basic information about persons, such as id number, name, phone number, gender and email address.

### Deliver
Deliver is the person who delivers the food to customers.
Deliver class also maintains license number, rating and orders they are about to deliver.

Delivers can:
- accept orders to deliver
- reject orders
- **finish delivery to earn wage (wage is 80% of delivery fee)**

### Customer
Customers are users.

Customers can:
- add addresses to their accounts (a user can have multiple addresses and receivers might be different). The first address the customer built is the default receiving address.
- wirte reviews and rate restaurants and delivers
- put dishes to shopping carts
- make orders from shopping carts
- complete orders after payment
- cancel pending orders at anytime
- cancel completed orders if no deliver picked up within 5 minutes
- filter restaurants by category (open or not open)
- search restaurants open or not open (but must match part of restaurant name)
- maintain search history

## Restaurant
Restaurants can:
- add dishes to their menu

## Address
Address is an abstract class which maintains basic information about addresses.

## Restaurant address

## Person address
person addresses are customer receiving addresses.
The receiver is not necessarily the customer.

person address maintains:
- address id
- state name
- city name
- postal code
- suburb name
- address detail
- address created time
- last modified time
- receiver name
- label
- phone number

## Order
Order is an abstract class.

### Pending order
pending order is the order that yet to be payed.

### Completed order
After the customer has payed the order, pending orders turn to completed order.

Then the controller searches delivers to deliver the order.
The deliver can accept the offer or reject.
If the order is rejected the controller will assign another deliver.

## TODO
- add vouchers
- write more tests
- modify review and rating system
- customers can subscribe resturants and receive notifications (observer pattern)
