# CS 5010 Semester Project

This repo represents the coursework for CS 5010, the Fall 2022 Edition!

**Name:** Abhishek Kumar, Valay Gundecha

**Email:** kumar.abhis@northeastern.edu , gundecha.v@northeastern.edu

**Preferred Name:** Abhishek, Valay



### About/Overview

	Design a board game where there would be multiple components of the game called spaces. The dimension of the board game would be given and each spaces inside board game will have its own coordinates. The spaces do not overlap with each other and can have items in it. Each items would have a certain weightage which can be used to play the game. The spaces sharing the common wall is referred to as neighbours. There wold be an objective target which has its own health and would have a predetermined path to move across the spaces. A player can be added anywhere in the game and can perform certain operations. Operations like Look Around, PickItema and Move  Relocate Pet and Kill Target, counts as turns.

	My program creates a 2-D array called the world which contains rooms. It allows the functionality to create rooms inside the world and add rooms without overlapping. Also it allows functionalities to add items to room and show the neighbouring rooms. The target starts from the 0 index of its pre determined path and moves across the world. We can Display a space or a player, add human or computer player, plot Graph, look around, move, pick items, move pet and attempt to kill the target. The person who kills the target wins the game.

	It is the game where the player has an objective to kill the target using poke or items, if the target and the player are in the same room and not being seen by any other player.



### List of Features

	1. Create world.
	2. Add rooms to the world.
	3. Check for the overlapping rooms.
	4. Get neighbors of the room.
	5. Add item to the room.
	6. Move target across the world in the rooms.
	7. Display details of the room.
	8. Display details about item.
	9. Check if target is present in the room.
	10. Get all items from any room.
	11. Get all rooms.
	12. Add Computer Player
	13. Add Human Player
	14. Move player to neighbouring space
	15. Look For the neighbouring rooms.
	16. Pick Item from the room.
	17. Display a Space
	18. Display a Player
	19. Add Item to player list
	20. Remove item form player
	21. Remove item from room.
	22. Relocate the pet to a specific room.
	23. Attempt to Kill Target
	24. If there is no item then there is an option to poke the target in the eye.
	25. The pet moves across the spaces in the world in the Depth First Search traversal.



### How to Run

	java -jar milestone4.jar input.txt 15

	We have to run the above command from the location where the jar is present i.e the res folder. Afer that the name of the text file has to be given as the command line argument following that, maximum number of turn has to be given.



### How to Use the Program

	After running the file, it will show the option to choose either the existing map or use a new map. After clicking on the play button, it will ask you to enter the player details. After that the game will start. The hint is given in the screen and also there there is the option to add player in between the game.



### Example Runs

	This submission doesn't have command line example run.



### Design/Model Changes

	View 
		1. Removed unnecessary fields in AddPlayerPanel
		2. Added few getters and setters(in case of clear) in the AddPlayer Panel
		3. Added JMenuItem in WelcomePanel
		4. Added listeners to Menu in WelcomePanel
		5. Removed all the classes for PopUp in BoardPanel
		6. Added methods for PopUp in BoardPanel.

	Controller
		1. Added the Feature interface
		2. Added private method for adding functionalities to the KeyListener Map and ActionListener map
		3. Added Method to check GameOver.
		4. Added Helper method to do common operations.

	Model
		1. Added methods to get itemNames
		2. Added getCurrentPlayerInformation method
		3. Added getWinner method
		4. Added getWorldMatrix method
		5. Added getPlayerItemNames method


### Assumptions

	1. Players cannot have the same name.
	2. Player can be added anytime.
	3. Player will specify while adding player that player is human or not.
	4. The pet will do DFS even after the player reallocates it.
	5. Player won't be able from different room to the current room if pet is present.



### Limitations

	1. Player will specify while adding player that player is human or not.
	2. The inputs are case sensitive.
	3. Players cannot have the same name.
	4. Will have to follow the exact instruction for Keyboard listeners as it is case sensitive.




### Citations

	1. https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html
	2. https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
	3. https://docs.oracle.com/javase/tutorial/uiswing/events/index.html



