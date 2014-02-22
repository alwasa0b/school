import pygame as pg
import random as rnd
import sys,os,math
FPS = 100
WIDTH = 600
HEIGHT = 400   

class Square():
    def __init__(self, surf, x, y):
        self.value=rnd.randrange(1,10)
        self.Surf=surf
        self.container = pg.Rect(x, y, 80, 80)
    def returnValue(self):
        return self.value
    
    def drawSquare(self):
        
        pg.draw.rect(self.Surf,(255,255,255),self.container)
    
    def flipSquare(self):
        font=pg.font.Font(None,36)
        text=font.render(str(self.value),1,(255,255,255))
        textpos = self.container
        background = pg.Surface(self.container.size)
        background = background.convert()
        background.blit(text, textpos)
        self.Surf.blit(background, (0, 0))
        pg.display.flip()
        
      
class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        self.mySquare = [Square(self.screen,0,0),Square(self.screen,0,100),Square(self.screen,0,200),Square(self.screen,0,300),
                         Square(self.screen,100,0),Square(self.screen,100,100),Square(self.screen,100,200),Square(self.screen,100,300),
                         Square(self.screen,200,0),Square(self.screen,200,100),Square(self.screen,200,200),Square(self.screen,200,300),
                         Square(self.screen,300,0),Square(self.screen,300,100),Square(self.screen,300,200),Square(self.screen,300,300),
                         Square(self.screen,400,0),Square(self.screen,400,100),Square(self.screen,400,200),Square(self.screen,400,300),
                         Square(self.screen,500,0),Square(self.screen,500,100),Square(self.screen,500,200),Square(self.screen,500,300)]
        
        self.Clock = pg.time.Clock()
        self.fps = FPS
        self.done = False
    
    def event_loop(self,keys):
        if pg.event.get(pg.QUIT):
            pg.quit();sys.exit()
        elif keys[0]:
            mpos = pg.mouse.get_pos()
            self.mySquare[0].flipSquare()
        elif keys[0]:
            self.myPad.moveDOWN()
        
                
    def main(self):
        for i in self.mySquare[:]:
                i.drawSquare()
                pg.display.update()
                
        while (True):
            keys = pg.mouse.get_pressed()
            self.event_loop(keys)
            self.screen.fill(0)
            self.Clock.tick(self.fps)

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