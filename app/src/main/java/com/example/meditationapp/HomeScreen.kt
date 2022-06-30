package com.example.meditationapp.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationapp.Feature
import com.example.meditationapp.ManuContent
import com.example.meditationapp.R
import com.example.meditationapp.StandardquadraticFromTo
import com.plcoding.meditationuiyoutube.ui.theme.*

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DeepBlue)
    ) {
        Column {
            GeetingStart(name = "Orpon")
            ChipSeliction(chip = listOf("Sweet Slip","Insomnia","Depression","Sweet Slip","Sweet Slip"))
            CurrentMeditation();
            FeatureSection(feature = listOf(
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,BlueViolet2, BlueViolet3
                ),
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_videocam,
                    LightGreen1,LightGreen2, LightGreen3
                ),
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone,
                    OrangeYellow1,OrangeYellow2, OrangeYellow3
                ),
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone,
                    Beige1,Beige1, Beige1
                ),
                Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,BlueViolet2, BlueViolet3
                ),Feature(
                    title = "Sleep Meditation",
                    R.drawable.ic_videocam,
                    LightGreen1,LightGreen2, LightGreen3
                )
            ))
        }
        BottomManuBar(items = listOf(
            ManuContent("Home",R.drawable.ic_home),
            ManuContent("Meditate",R.drawable.ic_bubble),
            ManuContent("Sleep",R.drawable.ic_moon),
            ManuContent("Music",R.drawable.ic_music),
            ManuContent("Profile",R.drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun GeetingStart(
    name: String
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h5,
                color = TextWhite,
                modifier = Modifier.padding(bottom = 7.dp, top = 10.dp)
            )
            Text(
                text = "Wish You Have Good Day !!",
                style = MaterialTheme.typography.body2,
                color = TextWhite
            )
        }
        Icon(painter = painterResource(id = R.drawable.ic_search),
            contentDescription ="Search_icon",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
        )

    }
}

@Composable
fun ChipSeliction(
    chip : List<String>) {
    var selectChilIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(){
        items(chip.size){
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable { selectChilIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectChilIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = chip[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "Meditation . 3-4 Min!!",
                style = MaterialTheme.typography.body1,
                color = TextWhite
            )
        }
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )

        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(feature: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Feature",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h3,
            color = TextWhite,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(
            cells =GridCells.Fixed(2) ,//How Many Colums in Grid
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ){
            items(feature.size){
                FeatureItem(feature = feature[it])
            }
        }
        
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width=constraints.maxWidth
        val height= constraints.maxHeight

        ///medium color point
        val medicumColoredPoint1= Offset(0f,height * 0.3f)
        val medicumColoredPoint2= Offset(width * 0.1f,height * 0.35f)
        val medicumColoredPoint3= Offset(width * 0.4f,height * 0.05f)
        val medicumColoredPoint4= Offset(width * 0.75f,height * 0.7f)
        val medicumColoredPoint5= Offset(width * 1.4f,-height.toFloat())

        val medicumColorPath= Path().apply {
            moveTo(medicumColoredPoint1.x,medicumColoredPoint1.y)
            StandardquadraticFromTo(medicumColoredPoint1,medicumColoredPoint2)
            StandardquadraticFromTo(medicumColoredPoint2,medicumColoredPoint3)
            StandardquadraticFromTo(medicumColoredPoint3,medicumColoredPoint4)
            StandardquadraticFromTo(medicumColoredPoint4,medicumColoredPoint5)
            lineTo(width.toFloat()+100f,height.toFloat()+100f)
            lineTo(-100f,height.toFloat()+100f)
            close()
        }
        //light color point
        val lightPoint1= Offset(0f,height * 0.3f)
        val lightPoint2= Offset(width * 0.1f,height * 0.4f)
        val lightPoint3= Offset(width * 0.3f,height * 0.35f)
        val lightPoint4= Offset(width * 0.65f,height.toFloat())
        val lightPoint5= Offset(width * 1.4f,-height.toFloat()/3f)

        val lightColorPath= Path().apply {
            moveTo(lightPoint1.x,lightPoint1.y)
            StandardquadraticFromTo(lightPoint1,lightPoint2)
            StandardquadraticFromTo(lightPoint2,lightPoint3)
            StandardquadraticFromTo(lightPoint3,lightPoint4)
            StandardquadraticFromTo(lightPoint4,lightPoint5)
            lineTo(width.toFloat()+100f,height.toFloat()+100f)
            lineTo(-100f,height.toFloat()+100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize() ){
            drawPath(
                path = medicumColorPath,
                color = feature.mediamColor
            )
            drawPath(
                path = lightColorPath,
                color = feature.lightColor
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Text(
                text =feature.title,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(painter = painterResource(id = feature.Icon),
                contentDescription =feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            Text(
                text ="Start",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
                    .align(Alignment.BottomEnd)
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }
    }
}

@Composable
fun BottomManuBar(
    items : List<ManuContent>,
    modifier: Modifier=Modifier,
    activeHighliteColor: Color= ButtonBlue,
    activeTextColor:Color=Color.White,
    inActiveTextColor:Color= AquaBlue,
    initialItemSelectedIndex: Int=0,
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialItemSelectedIndex)
    }
    Row (
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
            ){
        items.forEachIndexed { index, item -> 
            BottomManuItem(
                item = item,
                isSlected = index== selectedItemIndex,
                activeTextColor=activeTextColor,
                inActiveTextColor = inActiveTextColor,

            ) {
               selectedItemIndex=index
            }
        }

    }
    
}

@Composable
fun BottomManuItem(
    item :ManuContent,
    isSlected: Boolean=false,
    activeHighliteColor: Color= ButtonBlue,
    activeTextColor:Color=Color.White,
    inActiveTextColor:Color= AquaBlue,
    onItemClik:()-> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onItemClik()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSlected) ButtonBlue else Color.Transparent)
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(painter = painterResource(id = item.icon),
                    contentDescription ="icon",
                    tint = if (isSlected)activeTextColor else inActiveTextColor,
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text =item.tiltle,
                    color = if (isSlected)activeTextColor else inActiveTextColor
                )
            }
        }
    }
}