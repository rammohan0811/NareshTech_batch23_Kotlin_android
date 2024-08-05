package com.nareshit.jetpackuicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var count by remember {
                mutableStateOf(0)
            }
            Column(modifier = Modifier.background(Color.Yellow)) {
                Button(onClick = {
                    count++
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true)) {
                    Text(text = "+")
                }
                Box(modifier = Modifier.weight(8f,true),
                    contentAlignment = Alignment.Center){
                    Text(text = count.toString(),
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 100.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )
                }
                Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Blind ones",
                    modifier = Modifier
                        .size(150.dp)
                        .border(BorderStroke(1.dp, Color.Black))
                        .background(Color.Yellow))
                Button(onClick = {
                    count--
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, true)) {
                    Text(text = "-")
                }
            }
        }
    }
}