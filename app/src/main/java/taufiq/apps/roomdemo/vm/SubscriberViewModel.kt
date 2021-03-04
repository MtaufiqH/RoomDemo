package taufiq.apps.roomdemo.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import taufiq.apps.roomdemo.db.SubscriberTable
import taufiq.apps.roomdemo.repos.SubscriberRepository

/**
 * Created By Taufiq on 3/4/2021.
 *
 */
class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subs = MutableLiveData<List<SubscriberTable>>()
    val _subs: LiveData<List<SubscriberTable>> = subs

    init {
        subs.value = repository.subscribers.value
    }

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun insertSubscriber(subscriber: SubscriberTable) {
        viewModelScope.launch(IO) {
            repository.insert(subscriber)
        }
    }

    fun deleteSubscriber(subscriber: SubscriberTable) {
        viewModelScope.launch(IO) {
            repository.delete(subscriber)
        }
    }

    fun updateSubscriber(subscriber: SubscriberTable) {
        viewModelScope.launch(IO) {
            repository.update(subscriber)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(IO) {
            repository.deleteAll()
        }
    }

}