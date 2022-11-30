# Di Chen's Project Journal
XP Core Value: Simplicity
## Week 1 Scrum Report (Apr 11th ~ Apr 15th)
1. What tasks did I work on / complete?
- Completed the class design for major game actor classes
- Designed and implemented the basic game logic
- Introduced `Observer` pattern to stop objects when game is over
- Merged Game world into `Screen` frame
- Added support for 2 players 
2. What am I planning to work on next?
- Level control system
3. What tasks are blocked waiting on another team member?
- Need score system to support automatic level upgrade
4. XP Core Value
- After deciding what type of game we wanted to create, we broke down the project into several simple user stories and implemented them using the simplest methods.

## Week 2 Scrum Report
1. What tasks did I work on / complete?
- Designed and implemented the level system by using `StateMachine` pattern
- Added new obstacle for new level
- Fixed the logic problem of resetting the score
2. What am I planning to work on next?
- Add buff/ debuff logic
3. What tasks are blocked waiting on another team member?
- Wait for user input from setting screen to control player number
4. XP Core Value
- To reuse the code, we used subclasses inheritance to create new obstacles and introduced design patterns to realized level control. 

## Week 3 Scrum Report
1. What tasks did I work on / complete?
- Designed and implemented the buff logic
- Add two Buff classes
  - SpeedUp: make the rocket move faster, buff last for 5 seconds
  - FasterShot: shorten the cooldown of the rocket after shooting, buff last for 5 seconds
- Introduced `Singleton` pattern to control the number of `Buff` objects
- Fixed the game over control issue in two players mode
2. What am I planning to work on next?
- Restrict the area in which buff objects can exist
- Allow rescues between two players
3. What tasks are blocked waiting on another team member?
- N/A
4. XP Core Value
- Merge classes with similar functionalities into one

## Week 4 Scrum Report
1. What tasks did I work on / complete?
- Designed and implemented rescue logic between players
- Adjusted game balance
- Finished documentation 
  - Plot burndown chart
  - Add class diagrams for design patterns
2. What am I planning to work on next?
- N/A
3. What tasks are blocked waiting on another team member?
- N/A
4. XP Core Value
- This week we finished final code clean up to keep the code as simple as possible.
