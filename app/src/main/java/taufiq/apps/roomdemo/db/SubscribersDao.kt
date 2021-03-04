package taufiq.apps.roomdemo.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created By Taufiq on 3/3/2021.
 *
 */
@Dao
interface SubscribersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubscriber(subscriber: SubscriberTable)

    @Update
    suspend fun updateSubscriber(subscriber: SubscriberTable)

    @Delete
    suspend fun deleteSubscriber(subscriber: SubscriberTable)

    @Query("DELETE FROM subscribers_table")
    suspend fun deleteAllSubs()

    @Query("SELECT * FROM subscribers_table")
    fun getAllSubscriber(): LiveData<List<SubscriberTable>>
}