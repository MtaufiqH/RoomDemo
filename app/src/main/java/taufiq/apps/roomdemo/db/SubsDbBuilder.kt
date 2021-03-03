package taufiq.apps.roomdemo.db

import android.content.Context
import androidx.room.Room

/**
 * Created By Taufiq on 3/3/2021.
 *
 */
class SubsDbBuilder {

    companion object {
        private const val DATABASE_NAME = "Subscribers_database"

        @Volatile
        private var INSTANCE: SubscriberDatabase? = null

        fun getSubsDatabase(context: Context): SubscriberDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDb(context).also { INSTANCE = it }
            }
        }

        private fun buildDb(context: Context): SubscriberDatabase =
            Room.databaseBuilder(context, SubscriberDatabase::class.java, DATABASE_NAME).build()
    }
}