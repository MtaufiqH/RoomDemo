package taufiq.apps.roomdemo.db

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created By Taufiq on 3/3/2021.
 *
 */
@Database(entities = [SubscriberTable::class], version = 1)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract fun subsDao(): SubscribersDao
}