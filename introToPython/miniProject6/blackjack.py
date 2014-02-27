# implementation of card game - Blackjack
#===============================================================================
# Author: Saeed Alalwan
# Version: Beta 1
#===============================================================================
import urllib2, cStringIO
from PIL import Image
import pygame as pg
import random as rnd
import sys,os,time
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

      
class Player(object):
    def __init__(self,surf,x,y):
        self.Surf=surf
        self.x=x
        self.y=y
        self.myCards=[]
        self.myCards.append(Card(self.Surf,self.x,self.y,rnd.randrange(len(listPos))))
        self.myCards.append(Card(self.Surf,self.x+100,self.y,rnd.randrange(len(listPos))))
    
    def addCard(self):
        self.myCards.append(Card(self.Surf,self.x+200,self.y,rnd.randrange(len(listPos))))
    
    def HandValue(self):
        value=0
        for i in self.myCards:
            value+=i[3]
        return value

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
        pg.display.update(self.container)
        
    def __str__(self):
        return self.pos[2]+" "+self.pos[3]
   
    def __getitem__(self,key):
        return VALUES[self.pos[key]]
    
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
        pg.display.update(self.container)
        
        
      
class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
      
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        
        self.dealer = Player(self.screen,150,50)
        self.player = Player(self.screen,150,250)
        self.hit=Button(self.screen,"hit",10,150)
        self.hit.drawButton()
        
        self.stand=Button(self.screen,"stand",10,200)
        self.stand.drawButton()
        
        self.deal=Button(self.screen,"deal",10,50)
        self.deal.drawButton()
        
        self.uncover=Button(self.screen,"uncover",10,100)
        self.uncover.drawButton()
        
    
        
       
        self.Clock = pg.time.Clock()
        self.fps = FPS
        pg.display.update()
            

            
    def event_loop(self):
        global status,value,i
 
        for event in pg.event.get():
            if event.type==pg.QUIT:
                pg.quit()
                sys.exit()
            
            elif event.type==pg.MOUSEBUTTONDOWN:
                mpos = pg.mouse.get_pos()
                if (self.deal.container.collidepoint(mpos[0],mpos[1])):
                    i=0
                    self.__init__()
                    
                elif (self.uncover.container.collidepoint(mpos[0],mpos[1])):
                   
                    self.player.myCards[i].drawSquare()
                    i+=1
                    if(i==2):
                        print "player: "+str(self.player.HandValue())
                        print "dealer: "+str(self.dealer.HandValue())
                        time.sleep(1)
                        self.dealer.myCards[0].drawSquare()
                        self.dealer.myCards[1].drawSquare()
                        
            
                    
                elif (self.hit.container.collidepoint(mpos[0],mpos[1])):
                    self.player.addCard()
                    if(self.player.HandValue()>21):
                        print "busted"
                    print "player: "+str(self.player.HandValue())
                    print "dealer: "+str(self.dealer.HandValue())
                    self.player.myCards[2].drawSquare()
                elif (self.stand.container.collidepoint(mpos[0],mpos[1])):
                    if(self.player.HandValue()<=self.dealer.HandValue()):
                        continue
                    elif(self.dealer.HandValue()<17):
                        self.dealer.addCard()
                        self.dealer.myCards[2].drawSquare()
            
    def main(self):
        while (True):
            self.event_loop()
            self.screen.fill(0)

if __name__ == "__main__":
    RunIt = Control()
    RunIt.main()
    pg.quit();sys.exit()










