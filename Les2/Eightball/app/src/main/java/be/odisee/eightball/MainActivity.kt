package be.odisee.eightball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.odisee.eightball.ui.theme.EightballTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EightballTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EightBallApp(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun EightBallApp(modifier: Modifier = Modifier){
    var number by remember {
        mutableStateOf(-1)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = modifier
    ) {
        Response(number)

        Button(
            onClick = { number = (1 .. 20).random() }
        ) {
            Text(
                text = stringResource(R.string.get_answer)
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EightBallPreview() {
    EightballTheme {
        EightBallApp(Modifier
            .fillMaxSize()
            .padding(16.dp))
    }
}
@Composable
fun Response(responseNr: Int ) {
    val text: String = when(responseNr) {
        1 -> stringResource(R.string.result_1)
        2 -> stringResource(R.string.result_2)
        3 -> stringResource(R.string.result_3)
        4 -> stringResource(R.string.result_4)
        5 -> stringResource(R.string.result_5)
        6 -> stringResource(R.string.result_6)
        7 -> stringResource(R.string.result_7)
        8 -> stringResource(R.string.result_8)
        9 -> stringResource(R.string.result_9)
        10 -> stringResource(R.string.result_10)
        11 -> stringResource(R.string.result_11)
        12 -> stringResource(R.string.result_12)
        13 -> stringResource(R.string.result_13)
        14 -> stringResource(R.string.result_14)
        15 -> stringResource(R.string.result_15)
        16 -> stringResource(R.string.result_16)
        17 -> stringResource(R.string.result_17)
        18 -> stringResource(R.string.result_18)
        19 -> stringResource(R.string.result_19)
        20 -> stringResource(R.string.result_20)

        else -> ""
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(R.drawable.bal),
            contentDescription = null
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ResponsePreview() {
    EightballTheme {
        Response(16)
    }
}