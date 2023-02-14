package ar.com.emanuellopez.android.jetpack.intro

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.emanuellopez.android.jetpack.intro.ui.theme.JetpackComposeIntroductionTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Message Title #01", "Message Body #01"),
    MyMessage("Message Title #02", "Message Body #02"),
    MyMessage("Message Title #03", "Message Body #03"),
    MyMessage("Message Title #04", "Message Body #04"),
    MyMessage("Message Title #05", "Message Body #05"),
    MyMessage("Message Title #06", "Message Body #06"),
    MyMessage("Message Title #07", "Message Body #07"),
    MyMessage("Message Title #08", "Message Body #08"),
    MyMessage("Message Title #09", "Message Body #09"),
    MyMessage("Message Title #10", "Message Body #10"),
    MyMessage("Message Title #11", "Message Body #11"),
    MyMessage("Message Title #12", "Message Body #12"),
    MyMessage("Message Title #13", "Message Body #13"),
    MyMessage("Message Title #14", "Message Body #14"),
    MyMessage("Message Title #15", "Message Body #15"),
    MyMessage("Message Title #16", "Message Body #16"),
    MyMessage("Message Title #17", "Message Body #17"),
    MyMessage("Message Title #18", "Message Body #18"),
    MyMessage("Message Title #19", "Message Body #19"),
    MyMessage("Message Title #20", "Message Body #20"),
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeIntroductionTheme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponents(message)
        }
    }
}

@Composable
fun MyComponents(message: MyMessage) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        "This is a test image",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

@Composable
fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    JetpackComposeIntroductionTheme {
        MyMessages(messages)
    }
}