package  com.example.androiddevchallenge.catdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppyDetailActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context, brand: String) {
            val intent = Intent(context, PuppyDetailActivity::class.java)
            intent.putExtra(PUPPY_NAME_KEY, brand)
            context.startActivity(intent)
        }

        private const val PUPPY_NAME_KEY = "PuppyDetailActivity:puppyNameKey"
    }

    private lateinit var puppyDetailViewModel: PuppyDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbarTitle()
        instantiateViewModel()
        showCarBrandModels()
    }

    private fun instantiateViewModel() {
        puppyDetailViewModel = ViewModelProvider(this).get(PuppyDetailViewModel::class.java)
    }

    private fun ComponentActivity.showCarBrandModels() {
        setContent {
            val carBrandModels by puppyDetailViewModel.getPuppyByName(getPuppyName())
                .observeAsState()
            carBrandModels?.let {
                MyTheme {
                    Surface(color = MaterialTheme.colors.background) { PuppyDetail(it) }
                }
            } ?: finish()
        }
    }

    private fun setToolbarTitle() {
        supportActionBar?.title = getPuppyName()
    }

    private fun getPuppyName() = intent.extras?.getString(PUPPY_NAME_KEY)
}