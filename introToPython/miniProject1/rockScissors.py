import random

# Rock-paper-scissors-lizard-Spock template


# The key idea of this program is to equate the strings
# "rock", "paper", "scissors", "lizard", "Spock" to numbers
# as follows:
#
# 0 - rock
# 1 - Spock
# 2 - paper
# 3 - lizard
# 4 - scissors

# helper functions

def number_to_name(number):
    # fill in your code below
    
    # convert number to a name using if/elif/else
    # don't forget to return the result!
    name = None
    if (number==0):
        name = "rock"
    elif (number==1):
        name = "Spock"
    elif (number==2):
        name = "paper"
    elif (number==3):
        name = "lizard"
    elif (number==4):
        name = "scissors"
    return name
    
def name_to_number(name):
    # fill in your code below

    # convert name to number using if/elif/else
    # don't forget to return the result!
    number = None
    if (name=='rock'):
        number = 0
    elif (name=='Spock'):
        number = 1
    elif (name=='paper'):
        number = 2
    elif (name=='lizard'):
        number = 3
    elif (name=='scissors'):
        number = 4
    return number


def rpsls(name): 
    # fill in your code below
    

    # convert name to player_number using name_to_number
    pnumber = name_to_number(name)

    # compute random guess for comp_number using random.randrange()
    cn = random.randrange(0,5)
    
    # compute difference of player_number and comp_number modulo five
    score = (pnumber-cn)%5
 
    
    # use if/elif/else to determine winner


    if (score == 0):
        winner= "Player and computer tie!"
    elif (score == 1 or score == 2):
        winner = "Player wins!"
    else:
        winner = "Computer wins!"
    
        

    # convert comp_number to name using number_to_name
    cname = number_to_name(cn)
    # print results
    print "Player choose"    , name
    print "Computer choose"  , cname
    print winner
    print ""



    
# test your code
rpsls("rock")
rpsls("Spock")
rpsls("paper")
rpsls("lizard")
rpsls("scissors")

# always remember to check your completed program against the grading rubric


