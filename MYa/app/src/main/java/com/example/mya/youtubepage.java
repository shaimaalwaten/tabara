package com.example.mya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtubepage extends YouTubeBaseActivity {

    private static final String TAG = "youtubepage";
    YouTubePlayerView myoutubrplayerview ;
    Button btnplayer ;
    YouTubePlayer.OnInitializedListener mOnInit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtubepage);
        Log.d(TAG, "onCreate: Starting.");
        btnplayer= findViewById(R.id.btnplayer);
        myoutubrplayerview = findViewById(R.id.youtubeplayer);

        mOnInit = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done");

                youTubePlayer.loadVideo("F_HgkoMWes4");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed");

            }
        };
        btnplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Intializing youtube player");
                myoutubrplayerview.initialize(youtubeConf.getApiKey(),mOnInit);
            }
        });
    }
}