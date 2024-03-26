package com.emmanuel.safarimidapp

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emmanuel.safarimidapp.ui.theme.SafariMidappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafariMidappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Home()

                }
            }
        }
    }
}

@Composable
fun Home() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var context= LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally, 
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        
        Text(text = "Emmanuel's Mobile App",
                     color = Color.Red,
                     fontSize = 30.sp,
                     fontFamily = FontFamily.SansSerif
        )
        Text(text = "Welcome to my Android App",
                    color = Color.Black,
                    fontFamily = FontFamily.Default
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "This app entails some features created by the developer",
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive
        )
//        Image(painter = painterResource(id = R.drawable.sunset), contentDescription = null, modifier = Modifier.fillMaxSize())
//        Spacer(modifier = Modifier.height(20.dp))keyboardActions = KeyboardOptions(imeAction = ImeAction.Next),
        Text(text = "Safari Login",
            color = Color.Green,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email") },
            label = { Text(text = "Enter Email")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            )
        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password") },
            label = { Text(text = "Enter Password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { val intent=Intent(context,RegisterActivity::class.java)
                          context.startActivity(intent) },
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = "Login",
                fontSize = 25.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { val intent=Intent(context,IntentActivity::class.java)
            context.startActivity(intent) },
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = "Intent",
                fontSize = 25.sp)}
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { val intent=Intent(context,CalculatorActivity::class.java)
            context.startActivity(intent) },
            modifier = Modifier
                .fillMaxWidth()) {
            Text(text = "Calculator",
                fontSize = 25.sp)}
    }
}



@Preview
@Composable
private fun Homeprev() {
    Home()

}
        