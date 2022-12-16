
# Goal:
Build a java program mower's specification.
Mower can be throughout the whole surface.
Mower's position by coordinates (X, Y) and also a caracters indicate the orientation based on cardinal notation(N,E, W, S).
When a mower has finished, it give the final position and orientation

# Algorithme steps:
1. load file that contains instructions, position ...
2. parsing data to get lawn, mowers, position and instructions
3. Loop instructions and execute it one by one.
# How to test ?
. I have implemented a class test "MowerManagerTest" to execute mower instructions.
. load file.txt to get data
. Input example:
  5 5
  1 2 N
  GAGAGAGAA
  3 3 E
  AADAADADDA
. Execution example executeInstructionsMower1:
. Input         
   1 2 N     
   GAGAGAGAA
   Result: 1 3 N ==> displayed message "Position final Mower 1 : (X = 1, Y=3 ) Direction = N"

. Execution executeInstructionsMower2:

. Input:
  3 3 E
  AADAADADDA
  Result: 5 1 E ==> displayed message "Final Position Mower 2: (X = 5, Y=1 ) Direction = E"





