package com.syarifme.viewslider.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by syarifme on 15/11/17.
 */

public class InternetConnection {
    private static Context context;

    private static InternetConnection instance = new InternetConnection();

    public static InternetConnection getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }


    public boolean isConnectionAvailable() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        boolean connected = info != null && info.isConnected() && info.isAvailable();
        return connected;
    }
}
