import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    int cuenta = 0;
    //velocidad a la que aparecen los enemigos.
    int spawner = 50;
    int randSpawn;
    public Jugador MJugador = new Jugador();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1);
        addObject(MJugador, getWidth()/2, getHeight()/2);
    }
    public void act(){
        cuenta++;
        spawnFallen();
    }
    public void spawnFallen(){
        if(cuenta % spawner == 0){
            randSpawn = Greenfoot.getRandomNumber(8);
            switch(randSpawn){
                case 0 : addObject(new TheFallen(MJugador), 0, 0); break;
                case 1 : addObject(new TheFallen(MJugador), getWidth()/2, 0); break;
                case 2 : addObject(new TheFallen(MJugador), getWidth(), 0); break;
                case 3 : addObject(new TheFallen(MJugador), 0, getHeight()/2); break;
                case 4 : addObject(new TheFallen(MJugador), getWidth(), getHeight()/2); break;
                case 5 : addObject(new TheFallen(MJugador), 0, getHeight()); break;
                case 6 : addObject(new TheFallen(MJugador), getWidth()/2, getHeight()); break;
                case 7 : addObject(new TheFallen(MJugador), getWidth(), getHeight()); break;
            }
        }
    }
}
