package com.example.soundpoolbuilder;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1, iv2;
    AudioAttributes audioAttributes;
    SoundPool mySounds;
    int bugleSound, fluteSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.imageView);
        iv2 = findViewById(R.id.imageView2);
        audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();
        mySounds = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();
        bugleSound = mySounds.load(this, R.raw.reveille,1);
        fluteSound = mySounds.load(this, R.raw.rhapsody, 1);
    }

    public void play(View v) {
        if (v.equals(iv1)) {
            mySounds.play(bugleSound, 0.1f, 0.9f,1, 0,1  );
        } else {
            mySounds.play(fluteSound, 0.9f, 0.1f,1, 0,1  );
        }
    }

}
