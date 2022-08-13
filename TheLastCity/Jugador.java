import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 3;
    int TSobrevivido = 0;
    public Jugador(){
        setImage(new GreenfootImage(70,50));
        getImage().setColor(Color.RED);
        getImage().fillOval(0, 0, 50, 50);
        getImage().setColor(Color.BLACK);
        getImage().fillRect(50, 20, 60, 10); 
    }
    public void act()
    {
        TSobrevivido++;
        Girar();
        Movimiento();
        Disparo();
        daño();
    }
    public void Girar(){
        if(Greenfoot.getMouseInfo() !=null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void Movimiento(){
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX() - speed,getY());
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX() + speed,getY()); 
    }
    public void Disparo(){
        if(Greenfoot.mousePressed(null)){
            CodeBullet bullet = new CodeBullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
        }
    }
    public void daño(){
        if(isTouching(TheFallen.class)){
            getWorld().showText("Has Muerto... - Sobreviviste por: " + (TSobrevivido/60) + " segundos!" , getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
