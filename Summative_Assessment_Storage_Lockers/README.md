As I created this program I tried my best to give each class only one main function.
* Main would handle the menu
* LockerService the locker functionality and locker data validation.
* Locker would hold locker data.
* IO would handle IO functions. However, it also handled PIN creation and validation.
* ResultStr / ResultInt would hold result data used in the other classes.

I start by first building the data classes (Locker / ResultStr / ResultInt) before starting on
the IO class creating basic functions to operate on Result data. I then began by creating a simple menu and basic LockerService functions
for renting / accessing / releasing. I then began to add on to these function by adding validation. I tried to apply DRY as best I could, especially in the menu
logic by separating large chunk of validation functions into their own separate methods.

The hardest challenge I faced in this project would most likely be either creating the menu logic or the implementation 
of the dynamically shown rent locker option. I tried my best to distill the menu logic into its simplest form, delegating any more complicated
things to other helper functions in the Main class. The dynamic showing of the rent locker option was difficult as it required a lot of thinking to implement in a way that was both easy to read and code efficient.
I originally was going to create two menus, but I felt that would be a waste of a lot of code, so I instead mapped the input to different values, to correct for the menu options shifting over when the
rent locker option would disappear.
