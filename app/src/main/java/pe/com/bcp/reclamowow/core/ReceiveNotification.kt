package pe.com.bcp.reclamowow.core

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class ReceiveNotification : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.i("PUSHPUSH", " onMessageReceived - message: " + p0.toString());
    }
}