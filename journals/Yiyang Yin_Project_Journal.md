# Yiyang Yin's Project Journal

## Week 1 Scrum Report
1. What tasks did I work on / complete?
I was in charge with the leaderboard element in this game. To make this game a 
more competitive playing experience, we discussed and decided on a easy to show 
leaderboard on both the setting screen and the game ending screen.

2. What am I planning to work on next?
First of all, we need to decide what to put on the backlog task sheet. 
After team discussion, I decided to further work on the tasks regarding the design,
implementation, and documentation of the game’s ending page.

3. What tasks are blocked waiting on another team member?
We are having difficulties with Scrum practices. For example, although we have put on some backlog items based on our program functionality on our task sheet, we don’t know how to define the tasks for each backlog item so that we can work rather independently without relying on heavy communication. Right now we divide each backlog item into 4 tasks, but that does not look like a good Scrum practice. We need to ask Prof. Nguyen.
I already consulted Prof. Nguyen and have this problem sorted out. For now, I will be in charge of the courage element of
our team, and keep on developing the game screen.


## Week 2 Scrum Report
1. What tasks did I work on / complete?
I finished implementation of the leaderboard class along with the leaderboard screen. the scoreboard now is able to rank scores locally following the given logic. The leaderboard class utilizes the singleton pattern to ensure that only one object is in charge of the score update and extraction functions. In this way, we keep the consistency of our score records.
2. What am I planning to work on next?
We discussed about the possibility that we could integrate our leaderboard with the Greenfoot server backend, so that all players online could share the same leaderboard. This will be the new feature I work on.
3. What tasks are blocked waiting on another team member?
We decided to make some change to the counter and levels logic in our game, so I need to wait until those are finished first to have a working counter.

## Week 3 Scrum Report
1. What tasks did I work on / complete?
I finished the integration of Greenfoot UserInfo class with our leaderboard. Now that the board is fully functional even online.
2. What am I planning to work on next?
We decided to have two leaderboards in parallel so to stimulate player's interest in getting a high score. The two leaderboards will serve different functionalities, either showing off scores from people in similar geolocations or comparing scores in the two game modes we have.
I am particular trying to be creative in giving prototype ideas on our two players mode. In this way, I want to promote the courage element in our team so that everyone can feel free to speak out about their ideas and reach out the present the various different implementations they tried.
3. What tasks are blocked waiting on another team member?
I need to have the final player saving logic finished in the two players mode so that I know how to properly count score for that game mode. Fortunetly that would be a easy implementation and testing that I could finish on Tuesday.

## Week 4 Scrum Report
1. What tasks did I work on / complete?
The final version of the singleton parallel scoreboards are set. Although the two scoreboards are side to side, they belong to one singleton LocalScoreBoard class that initialize only once for the game program. It is able to record different annotations for different game modes as well. 
2. What am I planning to work on next?
I need to finish documentation for my code and work on drawing diagrams for the project. I also need to work on the presentation slides.
3. What tasks are blocked waiting on another team member?
No blocker for this week since we just need to get ready for presentation and demo.
