package ar.com.emanuellopez.android.jetpack.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponents()
        }
    }
}

@Composable
fun MyComponents() {
    Row {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        "This is a test image"
    )
}

@Composable
fun MyTexts() {
    Column() {
        MyText("Hello Jetpack Compose!")
        MyText("This is another text")
    }
}

@Composable
fun MyText(text: String) {
    Text(text)
}

@Preview
@Composable
fun PreviewComponents() {
    MyComponents()
}