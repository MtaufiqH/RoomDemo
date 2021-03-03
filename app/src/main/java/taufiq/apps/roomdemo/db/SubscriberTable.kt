package taufiq.apps.roomdemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created By Taufiq on 3/3/2021.
 *
 */
@Entity(tableName = "subscribers_table")
data class SubscriberTable constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "subscriber_id")
    val subIid: Int,
    @ColumnInfo(name = "subscriber_name")
    val subName: String,
    @ColumnInfo(name = "subscriber_email")
    val subEmail: String,
)
