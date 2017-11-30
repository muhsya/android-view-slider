package com.syarifme.viewslider.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by syarifme on 24/11/17.
 */
class ConnectionChecker {
    companion object {
        fun getInstance() : ConnectionChecker = ConnectionChecker()
    }

    fun isConnectionAlailabe(context: Context) : Boolean {
        val manager : ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info : NetworkInfo = manager.activeNetworkInfo
        val status : Boolean = info != null && info.isAvailable && info.isConnected
        return status
    }
}