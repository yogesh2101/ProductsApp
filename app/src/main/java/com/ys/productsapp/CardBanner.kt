package com.ys.productsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ys.productsapp.ui.theme.product_name
import com.ys.productsapp.ui.theme.yelloColor

@Composable
fun CardBanner() {
    // Load the PNG image from drawable resources
    val backgroundPainter: Painter = painterResource(id = R.drawable.shopflowcard1)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = backgroundPainter,
            contentDescription = "Card Background",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
        Card(
            modifier = Modifier
                .matchParentSize(),
            shape = RoundedCornerShape(16.dp),
            // can make Card background color transparent if desired
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, top = 40.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "Get 20 % OFF",
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )

                Text(
                    text = "Get 20 % OFF",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )

                Spacer(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f))

                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.SpaceBetween) {
                    Card( shape = RoundedCornerShape(10.dp), colors = CardDefaults.cardColors(yelloColor), modifier = Modifier.padding(5.dp)) {
                        Text(text = "12 - 16 October", color = Color.Black, modifier = Modifier.padding(5.dp))
                    }
                    
                    Image(painter = painterResource(id = R.drawable.banner_image), contentDescription = "card Image", modifier = Modifier.size(100.dp))
                    
                    Spacer(modifier = Modifier.width(10.dp))
                }
                
                Spacer(modifier = Modifier.height(60.dp))
                
                Row(Modifier.padding(start = 55.dp)) {
                    Spacer(modifier = Modifier
                        .width(35.dp)
                        .height(10.dp)
                        .background(product_name,RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.dp, product_name, shape = RoundedCornerShape(10.dp)))

                    Spacer(modifier = Modifier.width(10.dp))

                    Spacer(modifier = Modifier
                        .width(35.dp)
                        .height(10.dp)
                        .background(Color.Black,RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(7.dp)))

                    Spacer(modifier = Modifier.width(10.dp))

                    Spacer(modifier = Modifier
                        .width(35.dp)
                        .height(10.dp)
                        .background(Color.Black,RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(7.dp)))
                }
            }
        }
    }
}

