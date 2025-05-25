package com.ys.productsapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ys.productsapp.ui.theme.favourite
import com.ys.productsapp.ui.theme.product_name
import com.ys.productsapp.ui.theme.star_color
import com.ys.productsapp.ui.theme.yelloColor

@Composable
fun CardDeatils() {
    // Load the PNG image from drawable resources
    val backgroundPainter: Painter = painterResource(id = R.drawable.card_black_shape)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
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
                    .padding(10.dp)
            ) {

                Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxWidth()){
                    Text(text = "Clencera", fontSize = 26.sp, color = product_name)
                    Text(text = "● in stock", fontSize = 14.sp, color = product_name, fontWeight = FontWeight.Thin)
                }

                Text(text = "French clay and algae-powered cleanser", fontSize = 14.sp, fontWeight = FontWeight.Thin, modifier = Modifier.padding(start = 10.dp))

                Text(text = "Skin Tightness ● Dry & Dehydrated Skin", fontSize = 14.sp, fontWeight = FontWeight.SemiBold , modifier = Modifier.padding(start = 10.dp))

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    Modifier.fillMaxWidth().padding(start = 10.dp, top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Row {
                            Text(
                                text = "RS. 355.20   ",
                                fontSize = 18.sp,
                                color = favourite,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = "RS. 444.00",
                                fontSize = 15.sp,
                                color = Color.Gray,
                                fontWeight = FontWeight.Thin,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = "★★★★★  ",
                                fontSize = 17.sp,
                                color = star_color,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = "249 reviews",
                                fontSize = 13.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Normal,
                                textDecoration = TextDecoration.Underline
                            )
                        }

                    }

                    Card(
                        shape = CircleShape,
                        border = BorderStroke(1.dp, color = product_name),
                        colors = CardDefaults.cardColors(Color.Transparent),
                        modifier = Modifier
                            .size(70.dp)
                            .padding(3.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            tint = product_name,
                            contentDescription = "favourite",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(10.dp)
                        )
                    }

                }
            }
        }
    }
}

