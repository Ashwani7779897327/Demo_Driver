package com.apporio.demotaxiappdriver.socketManager;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Ack;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

public class AtsEventManager {


    private static AtsEventManager atsEventManagerInstance=null;
    private static AtsConnectionManager mAtsConnectionManager=null;


    private AtsEventManager(){
    }

    public static AtsEventManager getInstance(AtsConnectionManager atsConnectionManager){

        if(atsConnectionManager!=null){
            mAtsConnectionManager = atsConnectionManager;
            if (atsEventManagerInstance == null){

                atsEventManagerInstance = new AtsEventManager();
            }
            return atsEventManagerInstance;
        }
        return null;

    }

    public static void emitLocation(String event,Object location, final AtsEmitterListener atsEmitterListener){

        if(!AtsConnectionManager.isConnected()){
            atsEmitterListener.onError("Connection Not Established");

        }else {
            AtsConnectionManager.getSocket().emit(event, location, (Ack) args -> {

                try {
                    JSONArray jsonElements = new JSONArray(new Gson().toJson(args));
                    // Log.d("***Elements",((JSONObject)jsonElements.get(0)).getString("nameValuePairs"));

                    Log.e("AcknowledgeArg",""+jsonElements);
                    if(jsonElements.length()>0){
                        atsEmitterListener.onAcknowledge(jsonElements.get(0));

                    }else{
                        atsEmitterListener.onAcknowledge(new Gson().toJson(args));

                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                    atsEmitterListener.onError(e.getLocalizedMessage());
                }

            });
        }
    }

    public static void removeListener(String event){
        AtsConnectionManager.getSocket().off(event);
    }

    public static void listen(String eventName, final AtsEventListener atsEventListener){


        if(!AtsConnectionManager.isConnected()){
            atsEventListener.onError("Connection Not Established");
        }else {
            AtsConnectionManager.getSocket().on(eventName, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    try {
                        JSONArray jsonElements = new JSONArray(new Gson().toJson(args));
                        // Log.d("***Elements",((JSONObject)jsonElements.get(0)).getString("nameValuePairs"));

                        if(jsonElements.length()>0){
                            atsEventListener.onListen(((JSONObject)jsonElements.get(0)).getString("nameValuePairs"));

                        }else{
                            atsEventListener.onListen(new Gson().toJson(args));

                        }
                    } catch (Exception e) {
                        //e.printStackTrace();
                        atsEventListener.onError(e.getLocalizedMessage());
                    }

                }
            });
        }

    }

    public interface AtsEmitterListener{
        void onAcknowledge(Object location);
        void onError(String error);
    }

    public interface AtsEventListener{

        void onListen(String data);
        void onError(String error);
    }
}
