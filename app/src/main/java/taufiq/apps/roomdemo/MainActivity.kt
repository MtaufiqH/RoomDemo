package taufiq.apps.roomdemo

import android.os.Bundle
import android.util.Log
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import taufiq.apps.roomdemo.databinding.ActivityMainBinding
import taufiq.apps.roomdemo.db.SubsDbBuilder
import taufiq.apps.roomdemo.db.SubscriberTable
import taufiq.apps.roomdemo.repos.SubscriberRepository
import taufiq.apps.roomdemo.vm.SubscriberViewModel
import taufiq.apps.roomdemo.vm.SubscriberViewmodelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val daos = SubsDbBuilder.getSubsDatabase(this)
        val repos = SubscriberRepository(daos.subsDao())
        val vmv = SubscriberViewmodelFactory(repos)
        val vm = ViewModelProvider(this, vmv).get(SubscriberViewModel::class.java)


        binding.btnSave.setOnClickListener {
            val name = binding.etName.text
            val email = binding.etEmail.text
            vm.insertSubscriber(SubscriberTable(0, name.toString(), email.toString()))
        }

        binding.btnClearAll.setOnClickListener {
            vm.deleteAll()
        }

        vm.subs.observe(this){
            it?.let { data ->
                Log.i("MY_TAG", data.toString())
            }
        }
    }
}