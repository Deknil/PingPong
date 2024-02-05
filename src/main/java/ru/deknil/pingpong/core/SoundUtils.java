package ru.deknil.pingpong.core;

import ru.deknil.pingpong.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;

/**
 * @Author Deknil
 * @GitHub <a href=https://github.com/Deknil>https://github.com/Deknil</a>
 * @Date 05.02.2024
 * @Description A set of tools for managing audio files
 * <p></p>
 * PingPong © 2024. All rights reserved.
 */
public class SoundUtils {
    /**
     * Playing a file by its name
     * @param soundFile file name
     */
    public static void playSound(String soundFile) {
        try {
            File f = new File("src/main/resources/sounds/" + soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing media file: " + soundFile + " | " + " Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
