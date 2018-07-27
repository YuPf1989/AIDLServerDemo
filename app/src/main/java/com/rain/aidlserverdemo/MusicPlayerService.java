package com.rain.aidlserverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:rain
 * Date:2018/7/26 17:14
 * Description:
 */
public class MusicPlayerService extends Service {
    private static final String TAG  = "MusicPlayerService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: " );
        return super.onStartCommand(intent, flags, startId);

    }

    IMusicService.Stub mBinder = new IMusicService.Stub() {

        ArrayList<Music> list = new ArrayList<>();

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int caculate(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public List<Music> getMusicList() throws RemoteException {
            return list;
        }

        @Override
        public void addMusic(Music m) throws RemoteException {
            list.add(m);
        }
    };
}
