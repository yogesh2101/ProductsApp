package com.ys.productsapp

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ys.productsapp.ui.theme.PurpleGrey40
import com.ys.productsapp.ui.theme.favourite
import com.ys.productsapp.ui.theme.yelloColor

@Composable
fun CardProduct() {
    // Load the PNG image from drawable resources
    val backgroundPainter: Painter = painterResource(id = R.drawable.card_grey_bg_png)
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .width(screenWidth)
            .wrapContentHeight()
            .padding(16.dp)
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
            ) {

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Card(
                        shape = CircleShape,
                        colors = CardDefaults.cardColors(Color.Black),
                        modifier = Modifier.padding(3.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            tint = favourite,
                            contentDescription = "favourite",
                            modifier = Modifier
                                .padding(10.dp)
                                .size(35.dp)
                        )
                    }

                    Row {
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            colors = CardDefaults.cardColors(Color.Black),
                            modifier = Modifier.padding(10.dp, 5.dp)
                        ) {
                            Text(
                                text = "Best Seller",
                                color = yelloColor,
                                modifier = Modifier.padding(5.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }

                }

                Image(
                    painter = painterResource(id = R.drawable.product_image),
                    contentDescription = "product image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(60.dp, 20.dp),
                    contentScale = ContentScale.FillWidth
                )
                
                Spacer(modifier = Modifier.fillMaxHeight().weight(1f))

                CardDeatils()
            }
        }
    }
}

