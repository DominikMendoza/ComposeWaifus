package com.zen.composewaifus.ui.screens.waifus

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.zen.composewaifus.data.model.Waifu
import com.zen.composewaifus.data.remote.ApiClient
import com.zen.composewaifus.data.remote.WaifuResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun WaifusScreen() {
    val waifus = remember { mutableStateOf(listOf<Waifu>()) }
    val waifusService = ApiClient.getWaifuService()
    val fetchWaifus = waifusService.fetchWaifus()


    fetchWaifus.enqueue(object : Callback<WaifuResponse> {
        override fun onResponse(
            call: Call<WaifuResponse>,
            response: Response<WaifuResponse>
        ) {
            if (response.isSuccessful) {
                waifus.value = response.body()!!.images
            }
            else {
                Log.e("Waifus", "Error fetching waifus: ${response.errorBody()}")
            }
        }

        override fun onFailure(call: Call<WaifuResponse>, t: Throwable) {
            Log.e("Waifus", "Error fetching waifus", t)
        }
    })

    //Text(text = waifus.value.toString())
   LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(waifus.value) {
            WaifuCard(it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaifuCard(
    waifu: Waifu,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(4.dp), onClick = {
        Log.d("WaifuCard", "Clicked on ${waifu.id}")
    }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            WaifuImage(waifu = waifu)
            WaifuItem(waifu = waifu)
        }
    }

}

@Composable
fun WaifuImage(waifu: Waifu, modifier: Modifier = Modifier) {
    AsyncImage(model = waifu.url, contentDescription = null)
}

@Composable
fun WaifuItem(waifu: Waifu, modifier: Modifier = Modifier) {
    Text(text = waifu.id, modifier = modifier)
}