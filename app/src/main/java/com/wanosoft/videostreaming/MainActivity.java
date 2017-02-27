package com.wanosoft.videostreaming;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    VideoView visor;
    String url="rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visor=(VideoView) findViewById(R.id.videoView);
        visor.setVideoPath(url);
        visor.requestFocus(); //foco del visor
        MediaController mediaController=new MediaController(this); //Crear el controlador de video
        mediaController.setAnchorView(visor); //linkeando al media controler
        visor.setMediaController(mediaController); //
        visor.start(); //empiece

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.tostada,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}