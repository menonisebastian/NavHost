package com.example.navhost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.ArcAnimationSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navhost.ui.theme.NavHostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavHostTheme {
                RadioBackground()
            }
            }
        }
    }

// EJEMPLO NAV HOST
//@Composable
//fun AppNav()
//{
//    val navController = rememberNavController()
//    NavHost(
//            navController = navController, startDestination = "pantalla1"
//    ){
//        composable ("pantalla1")
//        {
//            Pantalla1(onIrPantalla2 = {navController.navigate("Pantalla2")})
//        }
//        composable ("pantalla2")
//        {
//            Pantalla2(onBack = {navController.popBackStack()})
//        }
//    }
//}
//
//@Composable
//fun Pantalla1(onIrPantalla2:() -> Unit) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Column (horizontalAlignment = Alignment.CenterHorizontally){
//            Text(text = "Estoy en la pantalla 1")
//            Spacer(Modifier.height(15.dp))
//            Button(
//                onClick = onIrPantalla2,
//                colors = ButtonDefaults.buttonColors(Color(0xFFFF0089)))
//                {
//                    Text(text = "Ir a la pantalla 2")
//                }
//        }
//    }
//}
//
//@Composable
//fun Pantalla2(onBack: () -> Unit) {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//        Column (horizontalAlignment = Alignment.CenterHorizontally){
//            Text(text = "Estoy en la pantalla 2")
//            Spacer(Modifier.height(15.dp))
//            Button(onClick = onBack){
//                Text(text = "Regresar a la pantalla anterior")
//            }
//        }
//    }
//}

////EJEMPLO 2 NAV HOST
//@Composable
//fun FormScreen(onEnviar: (String, String)-> Unit)
//{
//    var nombre by remember { mutableStateOf("") }
//    var apellidos by remember { mutableStateOf("") }
//
//    Column(Modifier
//        .fillMaxSize()
//        .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
//    {
//        Spacer(Modifier.height(15.dp))
//        TextField(value = nombre, onValueChange = {nombre = it}, label = {Text("Nombre")}, modifier = Modifier.fillMaxWidth())
//        Spacer(Modifier.height(15.dp))
//        TextField(value = apellidos, onValueChange = {apellidos = it}, label = {Text("Apellido")}, modifier = Modifier.fillMaxWidth())
//        Spacer(Modifier.height(15.dp))
//        Button(
//                onClick = { onEnviar(nombre, apellidos) },
//                colors = ButtonDefaults.buttonColors(Color(0xFFFF5722)))
//                {
//                    Text(text = "IR A LA PANTALLA 2")
//                }
//    }
//}
//
//@Composable
//fun FormScreen2(nombre:String, apellidos:String, onBack: ()-> Unit)
//{
//
//    Column(Modifier
//        .fillMaxSize()
//        .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
//    {
//        Spacer(Modifier.height(15.dp))
//        Text("Nombre: $nombre")
//        Spacer(Modifier.height(15.dp))
//        Text("Apellido: $apellidos")
//        Spacer(Modifier.height(15.dp))
//        Button(
//            onClick = { onBack() },
//            colors = ButtonDefaults.buttonColors(Color(0xFF35536B)))
//        {
//            Text(text = "VOLVER A LA PANTALLA PRINCIPAL")
//        }
//    }
//}
//
//@Composable
//fun AppNav()
//{
//    val navController=rememberNavController()
//
//    NavHost(navController, startDestination = "form")
//    {
//        composable("form")
//        {
//            FormScreen(onEnviar =
//                {nombre, apellidos ->
//                    navController.currentBackStackEntry?.savedStateHandle?.apply {
//                    set("nombre", nombre)
//                    set("apellidos", apellidos)
//                }
//                navController.navigate("second")
//            })
//        }
//        composable("second")
//        {
//            var prev = navController.previousBackStackEntry?.savedStateHandle
//            var nombre = prev?.get<String>("nombre").orEmpty()
//            var apellidos = prev?.get<String>("apellidos").orEmpty()
//
//            FormScreen2(nombre = nombre, apellidos= apellidos, onBack = { navController.popBackStack()})
//        }
//    }
//}

//EJEMPLO 3 NAV HOST
@Composable
fun FormScreen(onEnviar: (String, String)-> Unit)
{
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }

    Column(Modifier
        .fillMaxSize()
        .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(Modifier.height(15.dp))
        TextField(value = nombre, onValueChange = {nombre = it}, label = {Text("Nombre")}, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(15.dp))
        TextField(value = apellidos, onValueChange = {apellidos = it}, label = {Text("Apellido")}, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(15.dp))
        Button(
            onClick = { onEnviar(nombre, apellidos) },
            colors = ButtonDefaults.buttonColors(Color(0xFFFF5722)))
        {
            Text(text = "IR A LA PANTALLA 2")
        }
    }
}

@Composable
fun RadioButtonSingleSelection(modifier: Modifier = Modifier) {
    val radioOptions = listOf("Red", "Green", "Blue")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    // Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior

    Box(modifier.fillMaxSize().padding(20.dp), contentAlignment = Alignment.Center)
    {
        Column(modifier.selectableGroup(), horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("Elige un color de fondo", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier.height(20.dp))
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = { onOptionSelected(text) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.Center
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = null // null recommended for accessibility with screen readers
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color(0xFFFF5722)))
            {
                Text(text = "Ir a la siguiente pantalla")
            }
        }
    }
}

@Composable
fun RadioBackground() //radioOptions: List<String>, onBack: ()-> Unit
{
//    when(radioOptions)
//    {
//        "Red" -> {
//            Modifier.background(Color.Red)
//        }
//        "Green" -> {
//            Modifier.background(Color.Green)
//        }
//        "Blue" -> {
//            Modifier.background(Color.Blue)
//        }
//    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Button(
            onClick = { /*onBack()*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFF35536B)))
        {
            Text(text = "VOLVER A LA PANTALLA PRINCIPAL")
        }
    }
}

@Composable
fun AppNav()
{
    val navController=rememberNavController()

    NavHost(navController, startDestination = "form")
    {
        composable("form")
        {
            FormScreen(onEnviar =
                {nombre, apellidos ->
                    navController.currentBackStackEntry?.savedStateHandle?.apply {
                        set("nombre", nombre)
                        set("apellidos", apellidos)
                    }
                    navController.navigate("second")
                })
        }
        composable("second")
        {
            var prev = navController.previousBackStackEntry?.savedStateHandle
            var nombre = prev?.get<String>("nombre").orEmpty()
            var apellidos = prev?.get<String>("apellidos").orEmpty()

            //FormScreen2(nombre = nombre, apellidos= apellidos, onBack = { navController.popBackStack()})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBox() {
    RadioBackground()
}