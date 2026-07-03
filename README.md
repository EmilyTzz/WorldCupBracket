# World Cup Bracket Generator

This is a Java-application that generates the FIFA World Cup 2026 Knockout bracket with 48 teams, using a custom logic for generating the Round of 32 Matchups.

## Features

- Generates a full FIFA World Cup 2026 knockout bracket
- Allows user to rank teams in the Group Stage, and predict which team will win in each matchup in the Knockout Rounds
- Automatically generates the Round of 32 matchups based on the Group Stage results
- Has a full tournament progression: Group Stage, Round of 32, Round of 16, Quarterfinals, Semifinals, Third-Place Playoff, and Final
- Dynamically links matches so winners can advance automatically in each knockout stage
- Match prediction system that shows the win probability of each team in each matchup based on the FIFA June 11, 2026, rankings 

## How It Works

1. Teams are assigned to groups from a dataset (Format: Group Team)
2. User gets to rank the top 3 teams from each group
3. User then gets to pick the top 8 top 3 teams to advance with all the top 1s and 2s to the Round of 32
4. The program would then generate the Round of 32 matchups using the custom logic built in
5. User then gets to choose which team will win in each matchup to advance until a champion is determined

## Key Concepts Used

- Object-Oriented Programming (OOP)
- File Handling
- ArrayLists
- Sorting
- Loops
- Tree-style Tournament Logic

## Future Improvements

- Interactive bracket visualization (Creating a GUI with SceneBuilder)
- User input for generating the teams instead of a dataset

## Author
Emily Trinh
    
