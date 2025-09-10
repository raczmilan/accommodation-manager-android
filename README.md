Accommodation Manager (Android App)



An Android application for managing and displaying information about hotels. The app allows users to add new entries (hotel name, address with GPS coordinates, website, and phone number) and view them in a list.



&nbsp;	NewHotel Activity: form with input fields and validation for saving new accommodations into a local SQLite database. The address is 	stored as GPS coordinates so it can be embedded directly into a Google Maps URL.



&nbsp;	ListHotels Activity: displays saved entries in a ListView using a SimpleCursorAdapter, with buttons (icons) for:



&nbsp;		Open Map – launches Google Maps at the accommodation’s location



&nbsp;		Open Webpage – opens the accommodation’s website in a browser



&nbsp;		Phone Call – initiates a call to the accommodation’s phone number



After new entries are added a message is displayed and the list automatically refreshes.

