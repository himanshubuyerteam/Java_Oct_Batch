package OOP3;

interface MusicSystem
{
    void playMusic();
    void pauseMusic();
}
class BoatMusicSystem implements MusicSystem
{
    public void playMusic()
    {
        System.out.println("Boat Music Play");
    }
    public void pauseMusic()
    {
        System.out.println("Boat Music Pause");
    }
}

class BoseMusicSystem implements MusicSystem
{
    public void playMusic()
    {
        System.out.println("Bose Music Play");
    }
    public void pauseMusic()
    {
        System.out.println("Bose Music Pause");
    }
}

class Car
{
    MusicSystem carms;
    Car(MusicSystem ms)
    {
        carms=ms;
    }
    void playMusic()
    {
        carms.playMusic();
    }
    void pauseMusic()
    {
        carms.pauseMusic();
    }
}

public class Intereface {
    public static void main(String[] args) {
        BoatMusicSystem bms=new BoatMusicSystem();
        BoseMusicSystem bms2=new BoseMusicSystem();
        Car c1=new Car(bms);
        Car c2=new Car(bms2);
        c1.playMusic();
        c2.playMusic();
    }
}
