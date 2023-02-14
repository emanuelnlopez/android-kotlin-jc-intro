package ar.com.emanuellopez.android.jetpack.intro

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ar.com.emanuellopez.android.jetpack.intro.ui.theme.JetpackComposeIntroductionTheme

private val messages: List<MyMessage> = listOf(
    MyMessage(
        "Message Title #01",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis,"
    ),
    MyMessage("Message Title #02", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage(
        "Message Title #03",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #04",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna."
    ),
    MyMessage(
        "Message Title #05",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti. Proin commodo consequat massa, sit amet porttitor leo volutpat ut. Phasellus tincidunt, velit quis aliquet tincidunt, sapien sem condimentum elit, ut dictum erat velit consequat felis."
    ),
    MyMessage(
        "Message Title #06",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #07",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna."
    ),
    MyMessage("Message Title #08", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage(
        "Message Title #09",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #10",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti. Proin commodo consequat massa, sit amet porttitor leo volutpat ut. Phasellus tincidunt, velit quis aliquet tincidunt, sapien sem condimentum elit, ut dictum erat velit consequat felis."
    ),
    MyMessage("Message Title #11", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage(
        "Message Title #12",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #13",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna."
    ),
    MyMessage("Message Title #14", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage(
        "Message Title #15",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #16",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna."
    ),
    MyMessage("Message Title #17", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
    MyMessage(
        "Message Title #18",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna. Sed malesuada mattis velit vel aliquet. Suspendisse potenti."
    ),
    MyMessage(
        "Message Title #19",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eleifend mi placerat, volutpat urna quis, semper urna."
    ),
    MyMessage("Message Title #20", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
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
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(start = 8.dp)
        .clickable {
            expanded = !expanded
        }) {
        MyText(
            message.title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.subtitle2,
            lines = if (expanded) Int.MAX_VALUE else 1,
        )
    }
}

@Composable
fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    JetpackComposeIntroductionTheme {
        MyMessages(messages)
    }
}