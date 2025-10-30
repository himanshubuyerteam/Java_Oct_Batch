package OOP3;

interface MusicSystem
{
    void playMusic();
    void pauseMusic();
    void stopMusic();
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
class SonyMS
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
    // MusicSystem carms;
    // BoseMusicSystem bms;
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
        SonyMS sms1=new SonyMS();
        Car c1=new Car(bms);
        Car c2=new Car(bms2);
        // Car c3=new Car(sms)
        c1.playMusic();
        c2.playMusic();
    }
}
