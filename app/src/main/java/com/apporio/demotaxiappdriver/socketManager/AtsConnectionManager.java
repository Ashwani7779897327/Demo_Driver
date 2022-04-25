package com.apporio.demotaxiappdriver.socketManager;

import android.content.Context;
import android.util.Log;

import com.apporio.demotaxiappdriver.BuildConfig;
import com.apporio.demotaxiappdriver.currentwork.IntentKeys;
import com.apporio.demotaxiappdriver.manager.SessionManager;
import com.apporio.demotaxiappdriver.others.EventSocketConnected;
import com.apporio.demotaxiappdriver.others.EventSocketConnectionState;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.greenrobot.eventbus.EventBus;

import java.net.URISyntaxException;

public class AtsConnectionManager {

    private static boolean connected = false;
    private static Socket mSocket = null;
    private static AtsConnectionManager atsConnectionManager;
    private SessionManager mSessionManager;
    private static String TAG = "AtsConnectionManager";

    private AtsConnectionManager() {
    }

    public static AtsConnectionManager getConnectionInstance() {

        Log.d(TAG, "ibn side getConnection Method ");
        if (atsConnectionManager != null) {
            Log.d(TAG, "returning older connection");
            return atsConnectionManager;
        } else {
            Log.d(TAG, "returning new instance ");
            return new AtsConnectionManager();
        }


    }


    public void makeConnection(final AtsConnectionListener atsConnectionListener) {

        Log.e("MakeConnection", "MakeConenction");
        try {
//            mSocket = IO.socket(BuildConfig.SOCKET_URL);
            if (!mSocket.connected()) {
                mSocket.connect();
            }

        } catch (Exception e) {

        }

        try {
            mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                    try {
                        EventBus.getDefault().post(new EventSocketConnected("Connected"));
                        Log.e("Connected", "Connected");
                        connected = true;
                        atsConnectionListener.onConnect(AtsEventManager.getInstance(atsConnectionManager));
                    } catch (Exception e) {

                    }
                }
            });

            mSocket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    try {
                        EventBus.getDefault().post(new EventSocketConnected("DisConnected"));
                        Log.e("DisConnected", "DisConnected");
//                        connected = false;
//                        atsConnectionListener.onDisconnect();

                        try {
                            EventBus.getDefault().post(new EventSocketConnected("Connected"));
                            Log.e("Connected", "Connected");
                            connected = true;
                            atsConnectionListener.onConnect(AtsEventManager.getInstance(atsConnectionManager));
                        } catch (Exception e) {

                        }

//                        mSocket = IO.socket(BuildConfig.SOCKET_URL);
//                        if (!mSocket.connected()) {
//                            mSocket.connect();
//                        }


                    } catch (Exception e) {

                    }
                }
            });

//            mSocket.emit(IntentKeys.DRIVER_CONNECTION, new Emitter.Listener() {
//                @Override
//                public void call(Object... args) {
//                    try {
//                        Log.i("***SocketConnected", "" + args);
//                    }catch (Exception e){
//
//                    }
//                }
//            });

//            mSocket.on(IntentKeys.DRIVER_CONNECTED, new Emitter.Listener() {
//                @Override
//                public void call(Object... args) {
//                    try{
//                        Log.i("***ListenSocketConnect", "" + args);
//                    }catch (Exception e){
//
//                    }
//                }
//            });
        } catch (Exception e) {

        }


    }

    static Socket getSocket() {
        return mSocket;
    }

    public static boolean isConnected() {
        return connected;
    }


    public interface AtsConnectionListener {
        void onConnect(AtsEventManager atsEventManager);

        void onDisconnect();
    }
}
