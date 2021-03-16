This is some code to simulate a phase 10 game.

The code is not currently fully functional for an entire game of phase 10.

The src/main/java/com/barnett/phase10/main/Phase10.java class has a main method
which can be used to run a test of the whichPhases method. This will create a deck
of phase 10 cards shuffle them and then check to see which phases a set of 10 cards delt
will finish if any. This loops 100 times. 

When running the main method you will see a printout in the console of the cards in the current
hand and then any phases that can be completed for example:

    These are your cards: 
    [Green_four, Blue_two, Green_eight, Red_two, Yellow_six, Blue_seven, Yellow_four, Blue_twelve, Red_two, Yellow_eight]
    You can complete these phases: None
    
    These are your cards:
    [Red_ten, Green_six, Red_five, Green_twelve, Yellow_three, Green_seven, Red_eleven, Blue_eight, Yellow_four, Red_nine]
    You can complete these phases: Phase 4, Phase 5, Phase 6, 

TODO: 
- implement the use of Wild cards
- simplify and refactor code for readability and efficiency.
- finish game class to be able to play game
- create GUI for users to play game

