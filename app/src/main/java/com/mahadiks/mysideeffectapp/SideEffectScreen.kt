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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import javax.security.auth.Destroyable

@Composable
fun SideEffectScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    SideEffect {
        Toast.makeText(context, "Side Effect Triggered every time composable is recomposed", Toast.LENGTH_SHORT).show()
    }

    var counter by remember {
        mutableStateOf(0)
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