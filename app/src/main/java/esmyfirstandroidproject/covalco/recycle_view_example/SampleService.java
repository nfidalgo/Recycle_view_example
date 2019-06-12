package esmyfirstandroidproject.covalco.recycle_view_example;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class SampleService extends Service {
    private MediaPlayer player;

    public SampleService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
        // TODO: Return the communication channel to the service.
    }
    @Override
    public void onCreate() {
        Toast.makeText(this,"service was created", Toast.LENGTH_LONG).show();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        Toast.makeText(this,"Service Starter", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        player.stop();
        Toast.makeText(this,"Service Stopped", Toast.LENGTH_LONG).show();
    }
}
