package com.example.sample_2_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SurfaceHolder.Callback {
//    MySurfaceView mView;
//    private Animation mAnimation;
//    private ImageView mImageView;
//    private TextView mTextView;
//    private Button mButton1;
//    private Button mButton2;
//    private Button mButton3;
//    private Button mButton4;
//    private MediaPlayer mMediaPlayer;
//    private SoundPool mSoundPool;
//    HashMap<Integer,Integer> mSoundPoolMap;

    private String path = "/sdcard/bbb.3gp";
    private Button playButton;
    private Button pauseButton;
    private boolean isPause = false;
    private SurfaceHolder mSurfaceHolder;
    private MediaPlayer mMediaPlayer;
    private SurfaceView mSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mView = new MySurfaceView(this);
//        setContentView(mView);
//        initSounds();
        setContentView(R.layout.activity_main);
        requestPermission();

//        mAnimation = AnimationUtils.loadAnimation(this,R.anim.myanim);
//        mImageView = findViewById(R.id.myImageView);
//        mImageView.startAnimation(mAnimation);

//        mTextView = findViewById(R.id.textView);
//        mButton1 = findViewById(R.id.button1);
//        mButton2 = findViewById(R.id.button2);
//        mButton3 = findViewById(R.id.button3);
//        mButton4 = findViewById(R.id.button4);
//        mButton1.setOnClickListener(this::onClick);
//        mButton2.setOnClickListener(this::onClick);
//        mButton3.setOnClickListener(this::onClick);
//        mButton4.setOnClickListener(this::onClick);
        playButton = findViewById(R.id.play_Button);
        pauseButton = findViewById(R.id.pause_Button);
        playButton.setOnClickListener(this::onClick);
        pauseButton.setOnClickListener(this::onClick);
        mSurfaceView = findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);
        mMediaPlayer = new MediaPlayer();

    }
    private void requestPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

            }else{
                Toast.makeText(this, "存储权限获取失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //
//    private void initSounds(){
//        mMediaPlayer = MediaPlayer.create(this,R.raw.backsound);
//        mSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC,100);
//        mSoundPoolMap = new HashMap<>();
//        mSoundPoolMap.put(1,mSoundPool.load(this,R.raw.dingdong,1));
//    }

//    private void playSound(int sound,int loop){
//        AudioManager mgr = ((AudioManager) getSystemService(Context.AUDIO_SERVICE));
//        float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);
//        float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        float volume = streamVolumeCurrent / streamVolumeMax;
//        mSoundPool.play(mSoundPoolMap.get(sound),volume,volume,1,loop,1f);
//    }

    @Override
    public void onClick(View v) {
//        if(v == mButton1){
//            mTextView.setText("使用MediaPlayer播放声音");
//            if(!mMediaPlayer.isPlaying()){
//                mMediaPlayer.start();
//            }
//        }
//        else if(v == mButton2){
//            mTextView.setText("暂停MediaPlayer播放声音");
//            if(mMediaPlayer.isPlaying()){
//                mMediaPlayer.pause();
//            }
//        }
//        else if(v == mButton3){
//            mTextView.setText("使用SoundPool播放声音");
//            playSound(1,0);
//        }
//        else if(v == mButton4){
//            mTextView.setText("暂停了SoundPool播放的声音");
//            mSoundPool.pause(1);
//        }
        if(v == playButton){
            isPause = false;
            playVideo(path);
        }
    }
    private void playVideo(String path){
        if(mMediaPlayer.isPlaying() == true){
            mMediaPlayer.reset();
        }
        mMediaPlayer.setDisplay(mSurfaceHolder);
        try{
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
        mMediaPlayer.start();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}