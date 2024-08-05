# Take Users name
player1 = input("Enter name of player1:")
player2 = input("Enter name of player2:")

# Ask for the players choice 
choicePlayer1 = input("Please select one from Rock,Paper,Scissor:").lower()
choicePlayer2 = input("Please select one from Rock,Paper,Scissor:").lower()

# Apply logical condition sto decide the winner
if choicePlayer1 == choicePlayer2:
    print("Its a tie between" + {player1} + "and " + {player2})

elif choicePlayer1 == "rock":
    if choicePlayer2 == "scissors":
        print("Player 1 wins")
    else:
        print("Player2 wins")

elif choicePlayer1 == "paper":
    if choicePlayer2 == "rock":
        print("Player1 wins")
    else:
        print("Player2 wins")    
elif choicePlayer1 == "scissors":
    if choicePlayer2 == "paper":
        print("Player1 wins")
    else:
        print("Player2 wins")