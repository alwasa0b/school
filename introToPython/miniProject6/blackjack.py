# implementation of card game - Blackjack
#===============================================================================
# Author: Saeed Alalwan
# Version: Beta 1
#===============================================================================
import urllib2, cStringIO
from PIL import Image
import pygame as pg
import random as rnd
import sys,os
FPS = 20
WIDTH = 949
HEIGHT = 392   
status=0
value=[0]
NUMBER_OF_SQUARES=24


# load card sprite - 949x392 - source: jfitz.com
CARD_SIZE = (73, 98)
CARD_CENTER = (36.5, 49)

# card_images = cStringIO.StringIO(urllib2.urlopen(URL1).read())
# 
# 
# CARD_BACK_SIZE = (71, 96)
# CARD_BACK_CENTER = (35.5, 48)
# URL2 = "http://commondatastorage.googleapis.com/codeskulptor-assets/card_back.png"   
# card_back  = cStringIO.StringIO(urllib2.urlopen(URL1).read())


# initialize some useful global variables
in_play = False
outcome = ""
score = 0


# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}

xpos=[x for x in range(0,WIDTH,CARD_SIZE[0])]
ypos=[x for x in range(0,HEIGHT,CARD_SIZE[1])]
listPos=list()

for y in ypos:
    for x in xpos:
        listPos.append((x,y)) 
        



class Card():
    def __init__(self,surf, cardx, cardy, pos):
        self.Surf=surf
        self.rectContainer = pg.Rect(pos[0], pos[1], CARD_SIZE[0], CARD_SIZE[1])
        self.imageSurface = pg.image.load(os.path.join('/home/missoula/cards.jfitz.png'))
        self.cardx=cardx
        self.cardy=cardy
        
    def drawSquare(self):
        card=pg.Surface((CARD_SIZE[0], CARD_SIZE[1]))
        card.blit(self.imageSurface,(0,0),self.rectContainer)
        self.Surf.blit(card, (self.cardx,self.cardy,80,80))
     
        
#         self.uncovered=0
#         #self.asurf
#         #pg.draw.rect(self.imageSurface,(255,255,255),self.rectContainer)
#         
#         print card.blit(self.imageSurface,(255,255),self.rectContainer)
#         
#         #pg.draw.rect(self.Surf,(255,255,255),self.rectContainer)
#         
#         #print pg.transform.chop(self.imageSurface,self.rectContainer)
#         ##pg.draw.rect(self.Surf,(255,255,255),self.container)

#         #pg.display.update(self.rectContainer)
        
        
      
class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.myCards=[]
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        Card(self.screen,250,250,listPos[51]).drawSquare()
        Card(self.screen,350,250,listPos[50]).drawSquare()
        pg.display.update()
        self.Clock = pg.time.Clock()
        self.fps = FPS
        self.done = False
            

            
    def event_loop(self):
        global status,value
        for event in pg.event.get():
            if event.type==pg.QUIT:
                pg.quit()
                sys.exit()
            
            elif event.type==pg.MOUSEBUTTONDOWN:
                mpos = pg.mouse.get_pos()
                
    def main(self):
#         for i in self.mySquare[:]:
#                 i.drawSquare()
#                 pg.display.update()
       
        while (True):
            self.event_loop()
            self.screen.fill(0)

if __name__ == "__main__":
    RunIt = Control()
    RunIt.main()
    pg.quit();sys.exit()


































# 
# # load card sprite - 949x392 - source: jfitz.com
# CARD_SIZE = (73, 98)
# CARD_CENTER = (36.5, 49)
# card_images = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/cards.jfitz.png")
# 
# CARD_BACK_SIZE = (71, 96)
# CARD_BACK_CENTER = (35.5, 48)
# card_back = simplegui.load_image("http://commondatastorage.googleapis.com/codeskulptor-assets/card_back.png")    
# 
# # initialize some useful global variables
# in_play = False
# outcome = ""
# score = 0
# 
# # define globals for cards
# SUITS = ('C', 'S', 'H', 'D')
# RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
# VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}
# 
# 
# # define card class
# class Card:
#     def __init__(self, suit, rank):
#         if (suit in SUITS) and (rank in RANKS):
#             self.suit = suit
#             self.rank = rank
#         else:
#             self.suit = None
#             self.rank = None
#             print "Invalid card: ", suit, rank
# 
#     def __str__(self):
#         return self.suit + self.rank
# 
#     def get_suit(self):
#         return self.suit
# 
#     def get_rank(self):
#         return self.rank
# 
#     def draw(self, canvas, pos):
#         card_loc = (CARD_CENTER[0] + CARD_SIZE[0] * RANKS.index(self.rank), 
#                     CARD_CENTER[1] + CARD_SIZE[1] * SUITS.index(self.suit))
#         canvas.draw_image(card_images, card_loc, CARD_SIZE, [pos[0] + CARD_CENTER[0], pos[1] + CARD_CENTER[1]], CARD_SIZE)
#         
# # define hand class
# class Hand:
#     def __init__(self):
#         pass    # create Hand object
# 
#     def __str__(self):
#         pass    # return a string representation of a hand
# 
#     def add_card(self, card):
#         pass    # add a card object to a hand
# 
#     def get_value(self):
#         # count aces as 1, if the hand has an ace, then add 10 to hand value if it doesn't bust
#         pass    # compute the value of the hand, see Blackjack video
#    
#     def draw(self, canvas, pos):
#         pass    # draw a hand on the canvas, use the draw method for cards
#  
#         
# # define deck class 
# class Deck:
#     def __init__(self):
#         pass    # create a Deck object
# 
#     def shuffle(self):
#         # shuffle the deck 
#         pass    # use random.shuffle()
# 
#     def deal_card(self):
#         pass    # deal a card object from the deck
#     
#     def __str__(self):
#         pass    # return a string representing the deck
# 
# 
# 
# #define event handlers for buttons
# def deal():
#     global outcome, in_play
# 
#     # your code goes here
#     
#     in_play = True
# 
# def hit():
#     pass    # replace with your code below
#  
#     # if the hand is in play, hit the player
#    
#     # if busted, assign a message to outcome, update in_play and score
#        
# def stand():
#     pass    # replace with your code below
#    
#     # if hand is in play, repeatedly hit dealer until his hand has value 17 or more
# 
#     # assign a message to outcome, update in_play and score
# 
# # draw handler    
# def draw(canvas):
#     # test to make sure that card.draw works, replace with your code below
#     
#     card = Card("S", "A")
#     card.draw(canvas, [300, 300])
# 
# 
# # initialization frame
# frame = simplegui.create_frame("Blackjack", 600, 600)
# frame.set_canvas_background("Green")
# 
# #create buttons and canvas callback
# frame.add_button("Deal", deal, 200)
# frame.add_button("Hit",  hit, 200)
# frame.add_button("Stand", stand, 200)
# frame.set_draw_handler(draw)
# 
# 
# # get things rolling
# deal()
# frame.start()
# 
# 
# # remember to review the gradic rubric