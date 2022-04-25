package com.apporio.atslocation;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Ack;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class SocketListeners {

    private final static String TAG = "SocketListeners";
    public static final String CONNECT_DEVICE = "connect_device" ;
    public static final String DEVICE_LOCATION = "device_location" ;
    public static final String CASHED_LOCATION = "cashed_location" ;
    public static final String TRIAL_LISTENER = "trial_listener" ;
    public static final String ADD_DEVICE_IN_LIST= "add_device_in_list" ;
    public static final String REMOVE_DEVICE_FROM_LIST= "remove_device_from_list" ;



    public static Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.d(TAG , "DATA  incoming ");
        }
    };



    public static Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.d(TAG , "Connected to socket server and emitting device info ");
            ATSApplication.getSocket().emit(CONNECT_DEVICE, OnConnectionInfoManager.getDeviceAndApplicationInfo(), new Ack() {
                @Override
                public void call(Object... args) {
                    Log.i(TAG, " - - "+ args[0]);
                }
            });

        }
    };



    public static Emitter.Listener onDisconnected = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Log.d(TAG , "Disconnected to socket server");
        }
    };


    ////// Listeners

    public static Emitter.Listener onTrialEvent = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Ack ack = (Ack)args[args.length -1];
            ack.call();
            Log.d(TAG , "Add Device To List");
        }
    };


    public static Emitter.Listener onAddDeviceInList = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Ack ack = (Ack)args[args.length -1];
            ack.call();
            Log.d(TAG , "RECEIVED Connected Devices");
        }
    };


    public static Emitter.Listener onRemoveDeviceFromList= new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            Ack ack = (Ack)args[args.length -1];
            ack.call();
            Log.d(TAG , "Remove some device from list");
        }
    };





    public static void emitLocation(JSONObject location){
        ATSApplication.getSocket().emit(DEVICE_LOCATION, location, new Ack() {
            @Override
            public void call(Object... args) {
                Log.i(TAG, " - - "+ args[0]);

            }
        });
    }


    public static void emitCashedLocation ( JSONObject cashed_location){

        ATSApplication.getSocket().emit(CASHED_LOCATION, cashed_location, new Ack() {
            @Override
            public void call(Object... args) {
                Log.i(TAG, " - - "+ args[0]);
                EventBus.getDefault().post(new EventLocationSyncSuccess(true));
            }
        });
    }









}
