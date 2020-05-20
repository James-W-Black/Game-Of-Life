# Game-Of-Life
Based off John Conways game of life.

This is a automatic evolution game, the cells in the game are initially randomized and will change based off these rules:

1: if the cell is alive and there are either 2 or 3 alive cells touching it, it will remain alive.
2: if an alive cell has < 2 alive cells touching it, it will die.
3: if an alive cell has > 3 cells touching it, it will die.
4: if a dead cell has exactly 3 alive cells touching it, it will come back to life.

In this version of the game, to move through evolutions you must n on the keyboard, to move to the next generation. This is modelled after snake and other games which allow the player to leave one side of the screen and come out on the opposite side, meaning for example, cells at [0][0] and [0][size-1] are neighbouring cells and can affect each other despite being on seperate sides of the grid. 
