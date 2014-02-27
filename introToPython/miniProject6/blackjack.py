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
# load card sprite - 949x392 - source: jfitz.com
CARD_SIZE = (73, 98)
CARD_CENTER = (36.5, 49)

# initialize some useful global variables
in_play = False
outcome = ""
score = 0
i=0

# define globals for cards
SUITS = ('C', 'S', 'H', 'D')
RANKS = ('A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K')
VALUES = {'A':1, '2':2, '3':3, '4':4, '5':5, '6':6, '7':7, '8':8, '9':9, 'T':10, 'J':10, 'Q':10, 'K':10}

#creating a list of x,y postions to draw the cards 
xpos=[x for x in range(0,WIDTH,CARD_SIZE[0])]
ypos=[x for x in range(0,HEIGHT,CARD_SIZE[1])]

listPos=list()


counterx=0
countery=0

for y in ypos:
    counterx=0
    for x in xpos:
        listPos.append((x,y,SUITS[countery],RANKS[counterx])) 
        counterx+=1
    countery+=1  
    


class Button(object):
    def __init__(self, surf, caption ,x, y):
        self.value=rnd.randrange(1,5)
        self.Surf=surf
        self.container = pg.Rect(x, y, 80, 20)
        self.x=x
        self.y=y
        self.caption=caption
        self.uncovered=0
        self.drawButton()
    
    def drawButton(self):
        self.uncovered=0
        font=pg.font.SysFont("Arial",20)
        text=font.render(self.caption,1,(0,0,0))
        pg.draw.rect(self.Surf,(255,255,255),self.container)
        self.Surf.blit(text, (self.x, self.y))
        pg.display.update(self.container)

class Dealer(object):
    def __init__(self,surf):
        self.Surf=surf
        self.dealCards=[]
        self.dealCards.append(Card(self.Surf,250,50,rnd.randrange(len(listPos))))
        self.dealCards.append(Card(self.Surf,350,50,rnd.randrange(len(listPos))))
        self.dealCards.append(Card(self.Surf,450,50,rnd.randrange(len(listPos))))

class Card():
    def __init__(self,surf, cardx, cardy, p):
        self.pos=listPos[p][0],listPos[p][1],listPos[p][2],listPos[p][3]
        self.Surf=surf
        self.imageContainer = pg.Rect(self.pos[0], self.pos[1], CARD_SIZE[0], CARD_SIZE[1])
        self.container = pg.Rect(cardx, cardy, CARD_SIZE[0], CARD_SIZE[1])
        self.imageSurface = pg.image.load(os.path.join('/home/missoula/cards.jfitz.png'))
        self.coverSurface = pg.image.load(os.path.join('/home/missoula/card_back.png'))
        self.cardx=cardx
        self.cardy=cardy
        self.cover()
        pg.display.update()
        
    def __str__(self):
        return self.pos[2]+" "+self.pos[3] +" "+ str(VALUES[self.pos[3]])
    
    def getValue(self):
        return VALUES[self.pos[3]] 
    
    def drawSquare(self):
        card=pg.Surface((CARD_SIZE[0], CARD_SIZE[1]))
        
        card.blit(self.imageSurface,(0,0),self.imageContainer)
      
        self.Surf.blit(card, self.container)
        pg.display.update(self.container)
        
     
    def cover(self): 
        card=pg.Surface((CARD_SIZE[0], CARD_SIZE[1]))
        card.blit(self.coverSurface,(0,0))
        self.Surf.blit(card, (self.cardx,self.cardy))
        pg.display.update()
        
        
      
class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.myCards=[]
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        Dealer(self.screen)
        self.hit=Button(self.screen,"hit",10,50)
        self.hit.drawButton()
        self.stand=Button(self.screen,"stand",10,100)
        self.stand.drawButton()
        
        self.myCards.append(Card(self.screen,250,250,rnd.randrange(len(listPos))))
        self.myCards.append(Card(self.screen,350,250,rnd.randrange(len(listPos))))
        self.myCards.append(Card(self.screen,450,250,rnd.randrange(len(listPos))))
        
       
        self.Clock = pg.time.Clock()
        self.fps = FPS
        self.done = False
            

            
    def event_loop(self):
        global status,value,i
        
        for event in pg.event.get():
            if event.type==pg.QUIT:
                pg.quit()
                sys.exit()
            
            elif event.type==pg.MOUSEBUTTONDOWN:
                mpos = pg.mouse.get_pos()
                if (self.hit.container.collidepoint(mpos[0],mpos[1])):
                    print self.myCards[i]
                    self.myCards[i].drawSquare()
                 
                    
                    i+=1
                elif (self.stand.container.collidepoint(mpos[0],mpos[1])):
                    print "stand"
            
            
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