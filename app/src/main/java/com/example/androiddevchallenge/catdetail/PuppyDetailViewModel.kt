package  com.example.androiddevchallenge.catdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.PuppyData.puppies

class PuppyDetailViewModel : ViewModel() {
    fun getPuppyByName(name: String?) = MutableLiveData<Puppy>(getPuppy(name))
    private fun getPuppy(name: String?) =
        puppies.find { it.name == name }
}