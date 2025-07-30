package Tests;

import classHolder.MusicPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MusicPlayerTest {

    String a;
    MusicPlayer mp = new MusicPlayer(a);
    @Test
    void getMusicPlay() {
        Assertions.assertTrue(mp.GetMusicPlay(a));
    }
}