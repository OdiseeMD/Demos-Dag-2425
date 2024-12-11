package be.stevenop.demo_textfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.stevenop.demo_textfield.ui.theme.DemoTextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTextFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextFieldTest(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextFieldTest(modifier: Modifier = Modifier) {
    var naam by remember { mutableStateOf( "")  }
    var leeftijd by remember { mutableStateOf("")}

    var leeftijdEnabled by remember {mutableStateOf(true)}
    var naamEnabled by remember {mutableStateOf(true)}

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = naam,
            onValueChange = { naam = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = {
                Text(text = stringResource(R.string.geef_je_naam_op))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii,
                imeAction = ImeAction.Next
            ),
            enabled = naamEnabled
        )

        TextField(
            value = leeftijd,
            onValueChange = { leeftijd = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = {
                Text(text = stringResource(R.string.geef_je_leeftijd_op))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            enabled = leeftijdEnabled
        )

        TextSwitch(
            enabled = naamEnabled,
            label = stringResource(R.string.enable_naam),
            onCheckedChanged = {
                naamEnabled = it
            }
        )

        TextSwitch(
            enabled = leeftijdEnabled,
            label = stringResource(R.string.enable_leeftijd),
            onCheckedChanged = { leeftijdEnabled = it}
        )
    }
}

@Composable
fun TextSwitch(
    enabled: Boolean,
    label: String,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label)
        Spacer(modifier = Modifier.width(16.dp))
        Switch(
            checked = enabled,
            onCheckedChange = onCheckedChanged
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DemoTextFieldTheme {
        TextFieldTest(modifier= Modifier.padding(top=42.dp))
    }
}