package com.mahadiks.mysideeffectapp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeScreen(modifier: Modifier = Modifier) {


    //rememberCoroutineScope will give me the scope to execute the coroutine,
    // suspend function or other execution which is not in context of composable.
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            //use of scope is here..!
            scope.launch {
                repeat(5) {
                    delay(1000)
                    Log.d("TAG", "RememberCoroutineScopeScreen: $it")
                }
            }
        }) {
            Text("Click Me")
        }
    }


}