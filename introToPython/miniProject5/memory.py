# implementation of card game - Memory
#===============================================================================
# Author: Saeed Alalwan
# Version: Beta 1
#===============================================================================


import pygame as pg
import random as rnd
import sys,os
FPS = 20
WIDTH = 600
HEIGHT = 400   
status=0
value=[0]
NUMBER_OF_SQUARES=24

class Square():
    def __init__(self, surf, x, y):
        self.value=rnd.randrange(1,5)
        self.Surf=surf
        self.container = pg.Rect(x, y, 80, 80)
        self.x=x
        self.y=y
        self.uncovered=0
        
    def returnValue(self):
        return self.value
    
    def setValue(self,i):
        self.value=i
    def returnCover(self):
        return self.uncovered
    
    def setCover(self,i):
        self.uncovered=i
        
    def returnPos(self):
        return (self.x,self.y)
    
    def drawSquare(self):
        self.uncovered=0
        pg.draw.rect(self.Surf,(255,255,255),self.container)
        pg.display.update(self.container)
    
    def flipSquare(self):
        self.uncovered=1
        font=pg.font.SysFont("Arial",36)
        text=font.render(str(self.value),1,(255,255,255))
        
        
        self.Surf.blit(text, (self.x, self.y))
        pg.display.update(self.container)
        
        
      
class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.mySquare=[]
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        self.newGame()
        self.newNum()
        self.Clock = pg.time.Clock()
        self.fps = FPS
        self.done = False
    
    def newGame(self):
        x=0
        y=0
        for i in range(NUMBER_OF_SQUARES/6):
            x=0
            for n in range(NUMBER_OF_SQUARES/4):
                self.mySquare.append(Square(self.screen,x,y))
                x+=100
            y+=100
            
    def newNum(self):
        temp=self.mySquare
        indcies=[n for n in range(NUMBER_OF_SQUARES)]
        x=0
        for i in indcies[:]:
           
            if (len(indcies)==2):
                t1=indcies.pop(0)
                t2=indcies.pop(0)
                self.mySquare[t2].setValue(self.mySquare[t1].returnValue())
                return
            t1=indcies.pop(rnd.randrange(len(indcies)))
            t2=indcies.pop(rnd.randrange(len(indcies)))
            self.mySquare[t2].setValue(self.mySquare[t1].returnValue())
            
    def event_loop(self):
        global status,value
        for event in pg.event.get():
            if event.type==pg.QUIT:
                pg.quit()
                sys.exit()
            
            elif event.type==pg.MOUSEBUTTONDOWN:
                mpos = pg.mouse.get_pos()
                
                for i in range(len(self.mySquare)):                 
                    if (self.mySquare[i].container.collidepoint(mpos[0],mpos[1]) and status<=2 and pg.mouse.get_pressed()[0]):
                        
                        if(self.mySquare[i].returnCover()==1 and pg.mouse.get_pressed()[0]):
                            return
                        self.mySquare[i].flipSquare()
                        
                        
                        if(value[0]==self.mySquare[i].returnValue()):
                            print"hit"
                            self.mySquare[i].setCover(3)
                            self.mySquare[value[1]].setCover(3)
                            status=0
                            value=[0]
                            pg.time.wait(1000)
                            continue
                            
                        else:
                            value=[self.mySquare[i].returnValue(),i]
                            
                        
                        status+=1  
                        
                    if (status==2):
                        pg.time.wait(1000)
                        for i in range(len(self.mySquare)):
                            if (self.mySquare[i].returnCover()==1):
                                value=[0]
                                status=0
                                self.mySquare[i].drawSquare()
                
    def main(self):
        for i in self.mySquare[:]:
                i.drawSquare()
                pg.display.update()
       
        while (True):
            self.event_loop()
            self.screen.fill(0)

if __name__ == "__main__":
    RunIt = Control()
    RunIt.main()
    pg.quit();sys.exit()

        
# # implementation of card game - Memory
# 
# import pygame
# import random
# 
# # helper function to initialize globals
# def new_game():
#     pass  
# 
#      
# # define event handlers
# def mouseclick(pos):
#     # add game state logic here
#     pass
#     
#                         
# # cards are logically 50x100 pixels in size    
# def draw(canvas):
#     pass
# 
# 
# # create frame and add a button and labels
# frame = simplegui.create_frame("Memory", 800, 100)
# frame.add_button("Reset", new_game)
# label = frame.add_label("Turns = 0")
# 
# # register event handlers
# frame.set_mouseclick_handler(mouseclick)
# frame.set_draw_handler(draw)
# 
# # get things rolling
# new_game()
# frame.start()
# 
# 
# # Always remember to review the grading rubric