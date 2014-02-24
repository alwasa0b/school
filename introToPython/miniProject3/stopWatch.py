# Basic StopWatch
#===============================================================================
# Author: Saeed Alalwan
# Version: Beta 1
#===============================================================================
import pygame as pg
import random as rnd
import sys,os
from time import gmtime, strftime
FPS = 20
WIDTH = 600
HEIGHT = 400  

class Watch(object):
        def __init__(self, surf, caption ,x, y):
            self.value=rnd.randrange(1,5)
            self.Surf=surf
            self.container = pg.Rect(x, y, 80, 20)
            self.x=x
            self.y=y
            self.caption=caption
            self.uncovered=0
            self.drawTime()
            
        def drawTime(self):
            self.uncovered=0
            font=pg.font.SysFont("Arial",20)
            text=font.render(self.caption,1,(0,0,0))
            pg.draw.rect(self.Surf,(255,255,255),self.container)
            self.Surf.blit(text, (self.x, self.y))
            pg.display.update(self.container)

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

class Frame(object):
    def __init__(self,Surf):
        self.value=rnd.randrange(1,5)
        self.container = pg.Rect(250,50, 250, 250)
        self.Surf=Surf
        self.uncovered=0
        self.drawSquare()
    
    def drawSquare(self):       
        pg.draw.rect(self.Surf,(255,255,255),self.container)
        Watch(self.Surf,strftime("%H:%M:%S", gmtime()), self.container.centerx-50,self.container.centery)
        pg.display.update(self.container)
        
class Control(object):
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.mySquare=[]
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        self.start=Button(self.screen,"start",10,50)
        self.stop=Button(self.screen,"stop",10,100)
        self.reset=Button(self.screen,"rest",10,150)
        Frame(self.screen)
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
                if (self.start.container.collidepoint(mpos[0],mpos[1])):
                    print "start"
                elif (self.stop.container.collidepoint(mpos[0],mpos[1])):
                    print "stop"
                elif (self.reset.container.collidepoint(mpos[0],mpos[1])):
                    print "reset"
            

    def main(self):
       
        while (True):
            self.event_loop()
            self.screen.fill(0)

if __name__ == "__main__":
    RunIt = Control()
    RunIt.main()
    pg.quit();sys.exit()


# # template for "Stopwatch: The Game"
# 
# # define global variables
# 
# 
# # define helper function format that converts time
# # in tenths of seconds into formatted string A:BC.D
# def format(t):
#     pass
#     
# # define event handlers for buttons; "Start", "Stop", "Reset"
# 
# 
# 
# # define event handler for timer with 0.1 sec interval
# 
# 
# # define draw handler
# 
#     
# # create frame
# 
# 
# # register event handlers
# 
# 
# # start frame
# 
# 
# # Please remember to review the grading rubric
