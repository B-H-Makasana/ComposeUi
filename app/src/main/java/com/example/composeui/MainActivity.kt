package com.example.composeui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.drawerlayout.widget.DrawerLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Codelab2()
        }
    }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun DrawerLayout(){
          MaterialTheme{

              Scaffold( topBar ={
                  TopAppBar(
                      title = { Text(text = "My First Application") },
                      navigationIcon = {
                          IconButton(
                              onClick = {
                              }
                          ) {
                              Icon(
                                  imageVector = Icons.Filled.Favorite,
                                  contentDescription = "Open Navigation Drawer"

                              )
                          }
                      }
                  )
                  },

                      ){
                   FloatingActionButton(onClick = { /*TODO*/ }) {

                   }


              }



          }
    }






    @Preview(showBackground = true)
   @Composable
   fun Codelab2(){
        var name:List<String> = List(1000){
            "$it"
        }
           LazyColumn{
              items(items = name){
                  name->
                  Greeting(name = name)
              }

       }
   }
    
    @Composable
    fun Greeting(name:String){
        var expanded = remember {
            mutableStateOf(false)
        }
        val extraPadding= if(expanded.value) 48.dp else 0.dp
        Surface(
            color = Color.DarkGray,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(2.dp)
        ){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ){
                Column(modifier = Modifier.animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessHigh))
                    .weight(1f)
                    .padding(bottom = extraPadding)) {
                    Text("Hello ", style = TextStyle(color = Color.White))
                    Text(name,style = TextStyle(color = Color.White), fontStyle = FontStyle(23))

                }
                ElevatedButton(onClick = { expanded.value = !expanded.value }){
                    Text(if (expanded.value) "Show less" else "Show more")
                }

            }

        }
    }



    @Composable
    fun DiceWithButton(){
        var result by remember {
            mutableStateOf(1)
        }
        var imageResource= when(result){
            1-> R.drawable.dice1
            2-> R.drawable.dice2
            3-> R.drawable.dice3
            4->R.drawable.dice4
            5->R.drawable.dice5
            else -> {  R.drawable.dice6
            }
        }
          Column(

              modifier= Modifier
                  .fillMaxWidth()
                  .padding(20.dp)
                  .fillMaxHeight(),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,





          ) {
                 Image(painter = painterResource(imageResource), contentDescription = result.toString(),
                     colorFilter = ColorFilter.tint(Color.Gray),
                     modifier = Modifier.width(200.dp)

                     )
                 Button(onClick = { result= (1..6).random() },
                  modifier = Modifier.width(100.dp),

                     ) {
                     Text("Roll")

                 }
          }
    }


}