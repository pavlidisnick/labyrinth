# Labyrinth

Labyrinth is a text-based adventure game written in Java. The player navigates through a labyrinth of rooms, searching for items to win the game. One of the items is a bomb, so choose wisely!

## Features

- Multiple rooms with unique descriptions and items
- Inventory management (pick up and destroy items)
- Save and load game progress
- Hard mode with move and time limits
- Player profile and stats display

## How to Play

1. **Clone the repository** and open it in your IDE.
2. **Build the project** using your preferred Java build tool or directly from the IDE.
3. **Run the main class:**  
   The entry point is [`Labyrinth.Model.Main`](src/Labyrinth/Model/Main.java).

   ```
   java Labyrinth.Model.Main
   ```

4. **Follow the prompts** in the terminal to start a new game or load a saved one.
5. **Available commands:**
   - `go <direction>`: Move to another room (`north`, `south`, `east`, `west`)
   - `pick <item>`: Pick up an item in the room
   - `destroy <item>`: Destroy an item in your inventory
   - `profile`: Show player stats
   - `save`: Save your current game
   - `load`: Load a previously saved game
   - `help`: Show all available commands
   - `quit`: Exit the game
