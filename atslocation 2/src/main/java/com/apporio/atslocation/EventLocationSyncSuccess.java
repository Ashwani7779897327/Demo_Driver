package com.apporio.atslocation;

public class EventLocationSyncSuccess {
    boolean sync;

    public EventLocationSyncSuccess(boolean sync){
        this.sync = sync ;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }


}
