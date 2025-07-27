package com.mahadiks.mysideeffectapp

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun LaunchedEffectScreen(modifier: Modifier = Modifier) {

    // in this below example we can trigger the LaunchEffect when the counter value is 5 or -5
    //and by default LaunchedEffect will be trigger when composable is launch first time.

    val context = LocalContext.current
    var counter by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = counter == 5, key2 = counter == -5) {
        Toast.makeText(context, "launch effect triggered", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end=10.dp)
        ) {
            Button(modifier = modifier.weight(1f), onClick = {
                counter++
            }) {
                Text("Add")
            }
            Spacer(modifier = modifier.weight(0.5f))
            Button(modifier = modifier.weight(1f), onClick = {
                counter--
            }) {
                Text("Minus")
            }
        }

        Text("$counter")
    }


}