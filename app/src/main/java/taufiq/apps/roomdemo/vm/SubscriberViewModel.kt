package taufiq.apps.roomdemo.vm

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import taufiq.apps.roomdemo.db.SubscriberTable
import taufiq.apps.roomdemo.repos.SubscriberRepository

/**
 * Created By Taufiq on 3/4/2021.
 *
 */
class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = liveData {
        emitSource(repository.subscribers)
    }

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun insertSubUi(nameUi: String, emailUi: String) {
        _name.value = nameUi
        _email.value = emailUi
        insertSubscriber(SubscriberTable(0,_name.value.toString(),_email.value.toString()))

    }

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