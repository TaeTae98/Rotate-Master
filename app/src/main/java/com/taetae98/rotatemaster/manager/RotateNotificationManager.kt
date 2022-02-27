package com.taetae98.rotatemaster.manager

import android.content.Context
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.taetae98.rotatemaster.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RotateNotificationManager @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    private val manager = NotificationManagerCompat.from(context)

    init {
        createNotificationChannel()
    }

    fun sendMessage() {
        manager.notify(
            context.resources.getInteger(R.integer.rotate_notification_id),
            NotificationCompat.Builder(context, context.getString(R.string.rotate_notification_channel_id))
                .setSmallIcon(R.drawable.ic_round_screen_rotation_24)
                .setContentTitle("Hello")
                .build()
        )
    }

    fun cancelMessage() {
        manager.cancel(context.resources.getInteger(R.integer.rotate_notification_id))
    }

    private fun createNotificationChannel() {
        manager.createNotificationChannel(
            NotificationChannelCompat.Builder(
                context.getString(R.string.rotate_notification_channel_id),
                NotificationManagerCompat.IMPORTANCE_MAX
            ).apply {
                setName(context.getString(R.string.rotate_notification_channel_id))
            }.build()
        )
    }
}