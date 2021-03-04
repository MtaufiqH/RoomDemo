package taufiq.apps.roomdemo

import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import taufiq.apps.roomdemo.databinding.ActivityMainBinding
import taufiq.apps.roomdemo.db.SubsDbBuilder
import taufiq.apps.roomdemo.repos.SubscriberRepository
import taufiq.apps.roomdemo.vm.SubscriberViewModel
import taufiq.apps.roomdemo.vm.SubscriberViewmodelFactory

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()
    private val daos = SubsDbBuilder.getSubsDatabase(this)
    private val repos = SubscriberRepository(daos.subsDao())
    private val factory = SubscriberViewmodelFactory(repos)
    private val viewmodel by viewModels<SubscriberViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        binding.btnSave.setOnClickListener {
            viewmodel.insertSubUi(name,email)
        }

        binding.btnClearAll.setOnClickListener {
            viewmodel.deleteAll()
        }
    }
}