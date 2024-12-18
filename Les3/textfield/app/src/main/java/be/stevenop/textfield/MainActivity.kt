package be.stevenop.textfield

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.stevenop.textfield.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EditableTextFieldsExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EditableTextFieldsExample(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    var nameEnabled by remember { mutableStateOf(true)}
    var ageEnabled by remember { mutableStateOf(true)}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ){
        TextField(
            value = name,
            onValueChange = { name = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            label = {
                Text("Name")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            enabled = nameEnabled
        )

        TextField(
            value = age,
            onValueChange = { age = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            label = {
                Text("Firstname")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            enabled = ageEnabled
        )

        TextSwitch(
            label = "Enable name",
            value = nameEnabled,
            onCheckedChanged = {
                nameEnabled = it
            }
        )
        
        TextSwitch(
            label = "Enable firstname",
            value = ageEnabled,
            onCheckedChanged = {
                ageEnabled = it
            }
        )
    }
}

@Composable
fun TextSwitch(
    label: String,
    value: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
    ) {
        Text(label)
        Spacer(modifier = Modifier.width(16.dp))
        Switch(
            checked = value,
            onCheckedChange = onCheckedChanged
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TextFieldTheme {
        EditableTextFieldsExample()
    }
}