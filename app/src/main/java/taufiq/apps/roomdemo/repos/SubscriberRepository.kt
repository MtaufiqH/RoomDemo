package taufiq.apps.roomdemo.repos

import taufiq.apps.roomdemo.db.SubscriberTable
import taufiq.apps.roomdemo.db.SubscribersDao

/**
 * Created By Taufiq on 3/4/2021.
 *
 */
class SubscriberRepository constructor(private val subscribersDao: SubscribersDao) {
    val subscribers = subscribersDao.getAllSubscriber()

    suspend fun insert(subscriber : SubscriberTable){
        subscribersDao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber : SubscriberTable){
        subscribersDao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber : SubscriberTable){
        subscribersDao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        subscribersDao.deleteAllSubs()
    }


}