package com.example.phdrevamp.presentation.menu.component

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.phdrevamp.R
import com.example.phdrevamp.ui.theme.PhdrevampTheme
import com.example.phdrevamp.ui.theme.White500
import com.example.phdrevamp.util.extension.addCurrency

@Composable
fun MenuButton(
    context: Context,
    @DrawableRes iconMenu: Int,
    nameMenu: String,
    specification: String,
    price: Long
) {
    val constraintSet = ConstraintSet {
        val image = createRefFor("imgMenu")
        constrain(image) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        val menuInfo = createRefFor("menuInfo")
        constrain(menuInfo) {
            top.linkTo(image.bottom)
            bottom.linkTo(image.bottom)
            start.linkTo(image.start)
            end.linkTo(image.end)
        }
    }
    ConstraintLayout(constraintSet = constraintSet) {
        MenuInfo(
            modifier = Modifier.layoutId("menuInfo").padding(top = 60.dp),
            context = context,
            nameMenu = nameMenu,
            specification = specification,
            price = price
        )

        Image(
            modifier = Modifier
                .size(width = 111.dp, height = 113.dp)
                .layoutId("imgMenu"),
            painter = painterResource(id = iconMenu),
            contentDescription = null
        )
    }
}

@Composable
fun MenuInfo(
    modifier: Modifier = Modifier,
    context: Context,
    nameMenu: String,
    specification: String,
    price: Long
) {
    val constrainSet = ConstraintSet {
        val addCart = createRefFor("addCartButton")

        constrain(addCart) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }
    }
    Card(
        modifier = modifier
            .size(width = 169.dp, height = 180.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        ConstraintLayout(constraintSet = constrainSet, modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.padding(
                    start = 21.dp, end = 26.dp, top = 47.dp
                )
            ) {
                Text(
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 20.sp
                    ),
                    text = nameMenu
                )
                Text(
                    text = specification,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = White500
                    )
                )
                Text(
                    text = price.addCurrency(context),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Image(
                modifier = Modifier.layoutId("addCartButton"),
                painter = painterResource(id = R.drawable.ic_add_to_cart),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun previewMenuButton() {
    PhdrevampTheme {
        val context = LocalContext.current
        MenuButton(
            context = context,
            iconMenu = R.drawable.img_pizza,
            nameMenu = "Pizza Meat Lovers",
            specification = "Double Crust",
            price = 80000
        )
    }
}