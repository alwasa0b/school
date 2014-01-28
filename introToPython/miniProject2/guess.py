# template for "Guess the number" mini-project
# input will come from buttons and an input field
# all output for the game will be printed in the console



import random
from Tkinter import *



# initialize global variables used in your code
low=0
high=100
daNumber=random.randrange(low,high)


# helper function to start and restart the game
def new_game():
    global daNumber
    daNumber=random.randrange(low,high)   
    t.delete(1.0, END)
    


# define event handlers for control panel
def range100():
    global high
    high=100

    

def range1000():
    global high
    high=1000
    
def input_guess(guess):
    # main game logic goes here    
    
    if(guess>daNumber):
        return "Lower"
    if(guess<daNumber):
        return "Higher"
    if (guess==daNumber):
        return "Correct"
    # remove this when you add your code

    
# create frame


# register event handlers for control elements



# call new_game and start frame



# always remember to check your completed program against the grading rubric


master = Tk()
t= Text(master,height=15,width=15)
t.pack()
e = Entry(master)
e.pack()

e.focus_set()

def callback():
   
    a = input_guess(int(e.get()))
    t.insert(END,a+"\n")

b = Button(master, text="guess", width=10, command=callback)
r = Button(master, text="reset", width=10, command=new_game)
b.pack()
r.pack()

mainloop()


# var = raw_input("Enter something: ")
# while not (int(var)==daNumber):
#     var = raw_input("Enter something: ")
#     input_guess(int(var))
