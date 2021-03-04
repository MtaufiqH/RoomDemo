package taufiq.apps.roomdemo.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import taufiq.apps.roomdemo.repos.SubscriberRepository

/**
 * Created By Taufiq on 3/4/2021.
 *
 */
class SubscriberViewmodelFactory(private val repository: SubscriberRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SubscriberViewModel(repository) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}