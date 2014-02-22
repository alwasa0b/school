import pygame as pg
import sys,os,random,math
WIDTH = 600
HEIGHT = 400   
WHITE = (255,255,255)
START = (250,250)
SPEED_INTREVAL=-1.1
FPS = 100

class Circle():
    def __init__(self,x,y,size):
        self.angle = random.randrange(-45,45)
        self.size= size
        self.rect = pg.Rect((0,0),self.size)
        self.radial_speed = 2
        self.speed = [self.radial_speed*math.cos(math.radians(self.angle)),
                      self.radial_speed*math.sin(math.radians(self.angle))]
        self.move = [START[0],START[1]]
        
    def restart(self):
        self.angle = random.randrange(-45,45)
        self.rect = pg.Rect((0,0),self.size)
        self.radial_speed = 2
        self.speed = [self.radial_speed*math.cos(math.radians(self.angle)),
                      self.radial_speed*math.sin(math.radians(self.angle))]
        self.move = [START[0],START[1]]
        
    def ranAngle(self,angle):
        self.speed = [self.radial_speed*math.cos(math.radians(angle)),
                      self.radial_speed*math.sin(math.radians(angle))]
        
    def update(self,Surf,pad):
        self.movement()
        self.rect.topright = self.move
        self.boundaries(Surf.get_rect(),pad)
        pg.draw.ellipse(Surf,WHITE,self.rect,5)
        
    def movement(self):
        self.move[0] -= self.speed[0]
        self.move[1] += self.speed[1]
        
    def boundaries(self,bounding_rect,pad):
        if(pad.top[1]<=self.rect[1] and pad.down[1]>=self.rect[1] and self.rect[0]<=5):
            self.speed[0] *= SPEED_INTREVAL
            
        
        elif((pad.down[1]>=self.rect[1] or pad.top[1]<=self.rect[1]) and self.rect[0]<=5):
            self.restart()
            
            print "hit"
        
        elif not (0<self.rect[0] <= bounding_rect.size[0]):
           # self.speed[0] *= -1
           
          #  self.speed[1] *= -1
          self.ranAngle(random.randrange(-45,45))
        elif not (0<self.rect[1] <= bounding_rect.size[1]):
            self.speed[1] *= -1
         
       

class Pad():
 
    def __init__(self,Surf,top,down,w):
        self.top=top
        self.down=down
        self.w=w
        self.Surf=Surf
        self.rect = pg.draw.line(Surf,WHITE,self.top,self.down,self.w)
        self.speed = 3
      
        
    def update(self, Surf):
        pg.draw.line(Surf,WHITE,self.top,self.down,self.w)
        
    def moveUP(self):  
        if not (self.top[1]==0):
            self.top[1]-=2
            self.down[1]-=2
    
        
    def moveDOWN(self):
        if not (self.down[1]==HEIGHT):
            self.top[1]+=2
            self.down[1]+=2

class Control:
    def __init__(self):
        os.environ["SDL_VIDEO_CENTERED"] = '1'
        pg.init()
        self.screen = pg.display.set_mode((WIDTH,HEIGHT))
        self.myCirc = Circle(START[0],START[1],(10,15))
        self.myPad= Pad(self.screen,[0,250],[0,350],15)
        self.Clock = pg.time.Clock()
        self.fps = FPS
        self.done = False
    
    def event_loop(self,keys):
        if pg.event.get(pg.QUIT):
            pg.quit();sys.exit()
            
        elif keys[pg.K_UP]:
            self.myPad.moveUP()
        elif keys[pg.K_DOWN]:
            self.myPad.moveDOWN()
        
                
    def main(self):
        while (True):
            keys = pg.key.get_pressed()
            self.event_loop(keys)
            self.screen.fill(0)
            self.myPad.update(self.screen)
            self.myCirc.update(self.screen,self.myPad)
            pg.display.update()
            self.Clock.tick(self.fps)

if __name__ == "__main__":
    RunIt = Control()
    RunIt.main()
    pg.quit();sys.exit()








# # # Implementation of classic arcade game Pong
# # 
# import pygame, sys
# import random
# from pygame.locals import *
# # 
# # # initialize globals - pos and vel encode vertical info for paddles
# pygame.init()
# WIDTH = 600
# HEIGHT = 400       
# BALL_RADIUS = 20
# PAD_WIDTH = 8
# PAD_HEIGHT = 80
# HALF_PAD_WIDTH = PAD_WIDTH / 2
# HALF_PAD_HEIGHT = PAD_HEIGHT / 2
# LEFT = False
# RIGHT = True
# posX=(50,50)
# posY=(50,50)
# keyUP=0
# keyDOWN=1
# newPos=250
# screen = pygame.display.set_mode((640, 480))
# WHITE=(255,255,255)
# BLACK=(0,0,0)
# 
# rectCircle=pygame.Rect(0,0,0,0)
# 
# balXpos=[250,250]
# balYpos=(0,0)
# def drawBall():
#     global balXpos
#     
#     balXpos[0]= balXpos[0]+1
#     
#     rectCircle.move(balXpos)
#     
#     pygame.draw.circle(screen,WHITE,balXpos,2,2)
#     
# def drawPaddle(upOrDown):
#     global posX, posY, newPos,keyUP,keyDOWN
#     
#     pygame.draw.line(screen, (0,0,0), posX, posY, PAD_WIDTH)
#    
#     if upOrDown==keyDOWN and posX[1]==0:
#         newPos+=1
#         posX=(50,50+newPos) 
#         posY=(50,posX[1]+PAD_HEIGHT)
#       
#     if upOrDown==keyUP and posX[1]==400:
#         newPos-=1
#         posX=(50,50+newPos) 
#         posY=(50,posX[1]+PAD_HEIGHT)
#           
#     elif upOrDown==keyDOWN and not (posX[1]==0 or posX[1]==HEIGHT):
#         newPos+=1
#         posX=(50,50+newPos) 
#         posY=(50,posX[1]+PAD_HEIGHT)
#            
#     elif upOrDown==keyUP and not (posX[1]==0 or posX[1]==HEIGHT):
#         newPos-=1
#         posX=(50,50+newPos) 
#         posY=(50,posX[1]+PAD_HEIGHT)
#     
#     
#     
#     print posX 
#     print posY
#     
#     pygame.draw.line(screen, (255,255,255), posX, posY, PAD_WIDTH)
#     
#     pygame.display.update()
#     
#     # draw mid line and gutters
# #     c.draw_line([WIDTH / 2, 0],[WIDTH / 2, HEIGHT], 1, "White")
# #     c.draw_line([PAD_WIDTH, 0],[PAD_WIDTH, HEIGHT], 1, "White")
# #     c.draw_line([WIDTH - PAD_WIDTH, 0],[WIDTH - PAD_WIDTH, HEIGHT], 1, "White")
#          
#     # update ball
#              
#     # draw ball
#      
#     # update paddle's vertical position, keep paddle on the screen
#      
#     # draw paddles
#      
#     # draw scores        
# 
# 
# 
# i=50
# clock= pygame.time.Clock()
# 
# while(True):    
#         if pygame.event.get(pygame.QUIT):
#             sys.exit()
#         drawBall()     
#         keys = pygame.key.get_pressed()
#         if keys[pygame.K_UP]:
#             i=i-1
#             drawPaddle(0)
#             clock.tick(60)
#         elif keys[pygame.K_DOWN]:
#             i=i+1
#             drawPaddle(1)
#             clock.tick(60)       
#                 
#                      
# 
# 
# 
# 
#     
# # 
# # # initialize ball_pos and ball_vel for new bal in middle of table
# # # if direction is RIGHT, the ball's velocity is upper right, else upper left
# # def spawn_ball(direction):
# #     global ball_pos, ball_vel # these are vectors stored as lists
# # 
# # 
# # # define event handlers
# # def new_game():
# #     global paddle1_pos, paddle2_pos, paddle1_vel, paddle2_vel  # these are numbers
# #     global score1, score2  # these are ints
# # 
# #         
# # def keydown(key):
# #     global paddle1_vel, paddle2_vel
# #    
# # def keyup(key):
# #     global paddle1_vel, paddle2_vel
# # 
# # 
# # # create frame
# # frame = simplegui.create_frame("Pong", WIDTH, HEIGHT)
# # frame.set_draw_handler(draw)
# # frame.set_keydown_handler(keydown)
# # frame.set_keyup_handler(keyup)
# # 
# # 
# # # start frame
# # new_game()
# # frame.start()
