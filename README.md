# JetSpace (Team 8)

## Team members

| Name          |  XP Core Value  |
| ------------- | --------------- |
| BingJiun Miu  |  Feedback       |
| Di Chen       |  Simplicity     |
| Jing Shu      |  Communication  |
| Yiyang Yin    |  Courage        |

## About the project
### Description 
- This project is built in Greenfoot IDE and the main language we used is Java. The goal of this project is that we want to build a game for users to play with their family or friends during the Covid pandemic.

- This game supports single player mode and dual players mode, each player have three hit points. You need to avoid obstacles and shot back to gain scores. As you destroy more obstacles, the game becomes more difficult. Try to survive in space and get a higher score!
### Feature Set
- Support both single player mode and dual players mode
- Support player-to-player rescue in dual players mode
- Automatic level upgrade 
- Automatic buff objects release
- Shot obstacles to gain scores 
- Get buff objects to speedup/ shorten cooldown after shooting
### How to run this project
- Option 1: Playing [online](https://www.greenfoot.org/scenarios/29540)
- Option 2:
  * Install [Greenfoot](https://www.greenfoot.org/download)
  * Clone this [repository](https://github.com/nguyensjsu/sp22-202-team-8)
  * Run `project.greenfoot` inside the src folder

## Links to project videos
* [User Story Video](https://youtu.be/2jGyKCIeLM8)
* [Project Demo Video](https://youtu.be/N-l3MLIJ5Io)
* [Stand-up meeting](https://youtu.be/Z2-zADDSuik)
* [Retrospective meeting](https://youtu.be/H5FF4OmhRXU)

## Project architecture
### UI Wireframes

![image](https://user-images.githubusercontent.com/98684620/168208179-f066e43e-90fe-498f-b1a6-5a1da8f1041a.png)

* Start Screen
  <img width="1101" alt="image" src="https://user-images.githubusercontent.com/90799662/166169722-7d798897-a194-4922-ae7c-b6aeb8873104.png">

* Game Screen - Two Players Mode
  <img width="1102" alt="image" src="https://user-images.githubusercontent.com/90799662/166169943-604959a9-48a6-45b2-8359-6fb50b59ebd6.png">

* Game Over Screen
  <img width="1101" alt="image" src="https://user-images.githubusercontent.com/90799662/166169680-c3ddc250-e7e0-40f3-920d-d47129e36a8e.png">

* LeaderBoard Screen
  <img width="1099" alt="04-LeaderBoardScreen" src="https://user-images.githubusercontent.com/90799662/168380940-b5a57cdb-7d8e-4033-8826-13c571f21eaa.png">

### High level diagrams
#### Architecture Diagram
![image](https://user-images.githubusercontent.com/98665601/168145807-af31c757-9954-4bcc-815f-bffdf4ffc793.png)

#### Component diagram
![image](https://user-images.githubusercontent.com/98665601/168164715-bfe0822b-ee1b-4dc8-8447-7ce198e6f16e.png)

#### State diagram
![image](https://user-images.githubusercontent.com/98684620/168186651-b8e33270-32fa-4bc7-81a7-9b1d61bdad5c.png)

## Key feature designs
### Abstract Factory Pattern
The factory method is used to create item objects (button, label) for different screens: Menu Screen, Game Over Screen and Leaderboard Screen.
* AbstractFactory(IGlyphFactory): declares an interface for operations that create products.
* ConcreteFactory(MenuScreenGlyphFactory, GameOverScreenGlyphFactory, and LeaderboardScreenGlyphFactory): implements the factory method to create the concrete products for specific screen. So, the clients (Screens) could just use these products and be independent of how its products are created, composed and represented.
* AbstractProduct (Button, Label): declares an interface for a type of product object.
* ConcreteProduct (eg: startButton, tryAgainButton, screenTitle): defines a product object to be created by the corresponding concrete factory.
* Client(MenuScreen,GameOverScreen and LeaderboardScreen): uses a set of related products created in ConcreteFactory and doesn’t need to know how these products are created.

![image](https://user-images.githubusercontent.com/98684620/168223386-c838ec39-905f-412a-a355-da62a9681560.png)

### Singleton Pattern
#### Factories as singletons
* An application typically needs only one instance of a ConcreteFactory per product family. So it’s usually best implemented as a singleton.
* In this project, MenuScreenGlyphFactory, GameOverScreenGlyphFactory, and LeaderboardScreenGlyphFactory are all implemented as singletons.

#### Settings as a singleton
* Users can select play mode in Menu Screen, which is stored in Settings Class.
* Settings must be exactly one instance of a class, and should be easily accessible to different Screens. 
* So it's perfectly implemented as a singleton
                                      
![image](https://user-images.githubusercontent.com/98684620/165899251-bd6243cf-52d1-429b-9af0-ec27061999df.png)
#### Subclasses of Buff as a singleton
* The user can get one buff object from the same class at a time, but there could be two buff objects from different classes.
* Introduced singleton pattern for subclasses of `Buff` to control the realse of buff object.

#### Scoreboard as a singleton
* There is only one scoreboard object realized in our game, in order to maintain an accurate representation of all the scores.
* All score data will be obtained through methods in this only object, so that we don't need to worry about score update sequence order.

### Composite Pattern
Different items should be displayed on Screens. Composite pattern is used to let client treat these objects uniformly. The key of the Composite pattern is the interface IDisplayComponent, which declares operations that all composite object share for accessing and managing its child components, and also defines operation (setLocation()) that is specific to graphical objects.

![image](https://user-images.githubusercontent.com/98684620/168221965-be368459-607a-483e-8017-8d81c6e4d46d.png)

### Observer Pattern
#### Observer for Stopping Game
* Once game is over, current screen should be set to GameOver screen and all moving object should be stopped.
* To make sure all related objects will be stopped at the same time, we introduced observer pattern.

![observer pattern-stop](https://user-images.githubusercontent.com/90799662/167265314-809a6526-02ab-44a5-89f5-69d586d57d3d.png)

#### Observer for Upgrading Level
* Once the user has gained a specific amount of scores, it will trigger the level upgrade system and change the level state.
* To avoid tight coupling of socres and updating level, we introduced observer pattern.

![observer pattern-level](https://user-images.githubusercontent.com/90799662/167265324-07ef0331-b330-468e-b97b-88c9c2452d9a.png)

### StateMachine Pattern
* Totally we designed three levels, each level will add more obstacles than the previous one.
* To allow later extension, we introduced state machine pattern.

![state machine pattern-level](https://user-images.githubusercontent.com/90799662/167265328-79207e11-2167-4b54-9bdb-7d9bec77a266.png)

### Strategy Pattern
* Use strategy pattern for counting score of different obstacles.
* It's easy to maintain and allow later extension of new obstacles and different counting methods.

![image](https://user-images.githubusercontent.com/98665601/167326537-2e6e6a08-1cb8-419e-aa81-64b79866b9df.png)

## Project backlog and chart
* [Sprint Task Sheet](https://docs.google.com/spreadsheets/d/1DDuHcrnP0oVV-RvFCs6CP5kt70owV9LetTp2wmWGdMA/edit?usp=sharing)
* Burn down chart

![00-Team 8 Burndown Chart](https://user-images.githubusercontent.com/90799662/168411875-b41634b7-12a3-4c87-b412-cfd79d46c47b.svg)

* Weekly Scrum Task Board
   * Week 1
![image](https://user-images.githubusercontent.com/98684620/163939113-03e051f9-5370-4ed9-a92e-e52039ae3223.png)

   * Week 2
![image](https://user-images.githubusercontent.com/98684620/165194777-f464028b-ddce-4831-a19e-d856caa20d46.png)

   * Week 3
![image](https://user-images.githubusercontent.com/98684620/166723448-c5ab79a9-fbee-4cc7-91bb-33557c332211.png)

   * Week 4
![image](https://user-images.githubusercontent.com/98684620/167542515-f5d2bd8b-f883-42e6-bb5e-e481e1516c1c.png)

## Individual Contributions and team journals
### Contributions

* BingJiun Miu
  - Game Development
    - Design and implementaion of Score counting function - Strategy pattern
    - Implementation of score display and automatically update
    - Implementation of level display and automatically update
    - Design and implementation of three hits points function for player
  - Code Maintenance
  - Documentation Maintenance
    - Architecture Diagram
    - Component Diagram
  - Depoly project to greenfoot 

* Di Chen
  - Game Development
    - Design and implementation of game logic - Observer pattern
    - Implementation of automatic level upgrade - Observer, StateMachine pattern
    - Implementation of automatic buff release - Singleton pattern
    - Implementation of player-to-player rescue
  - Code Maintenance
  - UI Beautification
  - Documentation Maintenance
    - Design notes and related calss diagrams
    - Burndown chart

* Jing Shu
  - Game Development
     - Implementation of Menu Screen(start screen ) - Composite pattern 
     - Implementation of MyWorld and transition of different screens - State Machine
     - Implementation of MusicController to enable music in the game - Singleton pattern 
     - Display items on different screens - Abstract Factory pattern, Singleton pattern, Composite pattern
  - UI Wireframes
  - 1-min User Story Video
  - Associated UML class diagrams and design notes
  - Setup Scrum meetings and maintain project materials

* Yiyang Yin
  - Game Development
    - Design and implementation of leaderboard logic - Singleton pattern
    - Implementation of Greenfoot UserInfo class integration
    - Implementation of Score updating logic, in support of score ranking in both local and online
    - Implementation of dual playing mode support and custom label storing in user profile
  - Documentation Maintenance and development for recording and presentation
  - UI design choice and architecture maintainance on Factory and Singleton patterns only
  - Deployment to Greenfoot Scenarios backend

### Journals
* [BingJiun Miu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/BingJiun%20Miu_Project_Journal.md)
* [Di Chen's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Di%20Chen_Project_Journal.md)
* [Jing Shu's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Jing%20Shu_Project_Journal.md)
* [Yiyang Yin's Journal](https://github.com/nguyensjsu/sp22-202-team-8/blob/main/journals/Yiyang%20Yin_Project_Journal.md)
