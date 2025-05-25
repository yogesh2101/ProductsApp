package com.ys.productsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ys.productsapp.dataclasses.Category
import com.ys.productsapp.ui.theme.ProductsAppTheme
import com.ys.productsapp.ui.theme.background
import com.ys.productsapp.ui.theme.product_name


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsAppTheme {
                // A surface container using the 'background' color from the theme

                Surface(modifier = Modifier.fillMaxSize(), color = background) {

                    Scaffold(topBar = {
                        val appFontFamily = FontFamily(
                            Font(R.font.tangerine) // Replace with your actual font file name
                        )

                        TopAppBar(title = { Text(text = "  Shop", color = Color.White, fontFamily = appFontFamily) }, navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "arrow back button",
                                tint = Color.White,
                                modifier = Modifier.size(35.dp)
                            )
                        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = background),
                            actions = {

                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "arrow back button",
                                    tint = Color.White,
                                    modifier = Modifier.size(35.dp)
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                CountBadgeFavorite()

                                Spacer(modifier = Modifier.width(8.dp))

                                CountBadgeCart()

                                Spacer(modifier = Modifier.width(10.dp))
                            })
                    }) {
                        ProductsScreen(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductsScreen(it: PaddingValues) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(it)
            .background(background)
            .verticalScroll(rememberScrollState())) {

        CardBanner()
        
        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()){
            Text(text = "Categories", fontSize = 26.sp)
            Text(text = "See all", fontSize = 14.sp, fontWeight = FontWeight.Thin, textDecoration = TextDecoration.Underline)
        }

        LazyRow(Modifier.fillMaxWidth()) {
            val categories = arrayOf(Category(R.drawable.cat, "Cleaners"),
                Category(R.drawable.cat, "Toner"),
                Category(R.drawable.cat, "Serums"),
                Category(R.drawable.cat, "Moisturisers"),
                Category(R.drawable.cat, "Suncream"))

            items(categories) {
                Column( horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(shape = CircleShape, colors = CardDefaults.cardColors(Color.Black), modifier = Modifier.padding(10.dp)) {
                        Image(painter = painterResource(it.image), contentDescription = it.name, modifier = Modifier
                            .padding(10.dp)
                            .size(85.dp))
                    }
                    
                    Text(text = it.name, fontSize = 12.sp)
                }
            }
        }

        Row (horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()){
            Text(text = "New Products", fontSize = 26.sp)
            Text(text = "See all", fontSize = 14.sp, fontWeight = FontWeight.Thin, textDecoration = TextDecoration.Underline)
        }


        // new products

        Row(Modifier.horizontalScroll(rememberScrollState())) {
            (1 .. 6).forEach{
                CardProduct()
            }
        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountBadgeFavorite() {
    var itemCount by remember { mutableStateOf(5) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = product_name,
                        contentColor = Color.Black
                    ) {
                        Text("$itemCount", color = Color.Black)
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "arrow back button",
                tint = Color.White,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountBadgeCart() {
    var itemCount by remember { mutableStateOf(3) }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        BadgedBox(
            badge = {
                if (itemCount > 0) {
                    Badge(
                        containerColor = product_name,
                        contentColor = Color.Black
                    ) {
                        Text("$itemCount", color = Color.Black)
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "arrow back button",
                tint = Color.White,
                modifier = Modifier.size(35.dp)
            )
        }
    }
}