package com.lxn.platform.core.view

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.lxn.platform.core.resource.ResourceService
import com.lxn.platform.core.resource.sharepref.AppPreference
import com.lxn.platform.core.viewmodel.BaseViewModel
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import java.util.*
import javax.inject.Inject


/**
 * Created by @Author: Nam_Lx
 * Project : NoteAppKotlin
 * Create Time : 23:58 - 08/03/2022
 * For all issue contact me : namlxcntt@gmail.com
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(val bindingFactory: (LayoutInflater) -> VB) : AppCompatActivity(), BaseBehavior {

    lateinit var binding: VB

    abstract val viewModel: VM

    @Inject
    lateinit var resourceService: ResourceService

    @Inject
    lateinit var appPreference: AppPreference

    private var isUserCloseApp: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        addViewListener()
        onViewLoaded()
        addDataObserver()
    }

    override fun onViewLoaded() {

    }

    override fun onError() {
    }

    override fun onLoading() {

    }

    override fun addViewListener() {

    }

    override fun darkModeOff() {

    }

    override fun darkModeOn() {

    }

    /**
     * Variable with launch activity for result new
     * StartActivityForResult Deprecated()
     */
    private val launchSomeActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            onDataReceiverActivityForResult(result)
        }

    open fun onDataReceiverActivityForResult(activityResult: ActivityResult) {}

    /**
     * Open Activity for result
     */
    fun openActivityForResult(cla: Class<*>, vararg flags: Int) {
        val intent = Intent(this, cla)
        for (flag in flags) {
            intent.addFlags(flag)
        }
        launchSomeActivity.launch(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        launchSomeActivity.unregister()
    }

    @RequiresApi(Build.VERSION_CODES.FROYO)
    override fun onConfigurationChanged(configuration: Configuration) {
        when (configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.e("Namlxcntt", "UI_MODE_NIGHT_NO")
                darkModeOff()
            } // Night mode is not active, we're using the light theme
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.e("Namlxcntt", "UI_MODE_NIGHT_YES")
                darkModeOn()
            } // Night mode is active, we're using dark theme
        }
    }


    override fun addDataObserver() {
        viewModel.onDidBindViewModel()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase?.let { ViewPumpContextWrapper.wrap(it) })
    }

    /**
     * Open Activity
     */
    fun openActivity(cla: Class<*>, vararg flags: Int) {
        val intent = Intent(this, cla)
        for (flag in flags) {
            intent.addFlags(flag)
        }
        startActivity(intent)
    }

    /**
     * Exit app
     * Touch twice to exit app
     */
    fun existApp(textOut: String) {
        if (isUserCloseApp) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAndRemoveTask()
            }
        } else {
            Toast.makeText(
                this,
                textOut,
                Toast.LENGTH_LONG
            ).show()
            isUserCloseApp = true
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    isUserCloseApp = false
                }
            }, 3000)
        }
    }
}