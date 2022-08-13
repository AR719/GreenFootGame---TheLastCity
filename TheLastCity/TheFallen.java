import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheFallen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheFallen extends Actor
{
    /**
     * Act - do whatever the TheFallen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int vida = 3;
    Jugador jugador;
    public TheFallen(Jugador MJugador){
        jugador = MJugador;
        setImage(new GreenfootImage(30,30));
        getImage().setColor(Color.YELLOW);
        getImage().fillOval(0, 0, 30, 30); 
    }
    public void act()
    {
        movimiento();
        recibirDaño();
    }
    public void movimiento(){
        move(1);
        turnTowards(jugador.getX(), jugador.getY());  
    }
    public void recibirDaño(){
        Actor bullet = getOneIntersectingObject(CodeBullet.class);
        if(bullet != null){
            vida--;
            getWorld().removeObject(bullet); 
        }
        if(vida ==0){
            getWorld().removeObject(this);
        }
    }
}
