package com.example.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a30daysapp.data.Plane
import com.example.a30daysapp.data.planes
import com.example.a30daysapp.ui.theme.A30DaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A30DaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PlaneApp()
                }
            }
        }
    }
}

/**
 * Composable that contains whole app layout like bar and list of planes
 */
@Composable
fun PlaneApp() {
    Scaffold(
        topBar = {
            PlaneTopAppBar()
        }
    ) {
        LazyColumn(
            contentPadding = it,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            itemsIndexed(planes) { index, plane ->
                PlaneItem(
                    dayNumber = index+1,
                    plane = plane
                )
            }
        }
    }
}

/**
 * Composable that displays a center top bar
 *
 * @param modifier modifiers to set this composable
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaneTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.tittle),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Composable that display a Card with all information and image about single plane
 *
 * @param dayNumber is Int that represents on witch day this card is
 * @param plane contains the data that populates the list item
 * @param modifier modifiers to set to this composable
 */
@Composable
fun PlaneItem(
    dayNumber: Int,
    plane: Plane,
    modifier: Modifier = Modifier
) {
    var expanded by remember{ mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable {expanded = !expanded  }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        )
        {
            Row {
                PlaneItemHeader(
                    dayNumber = dayNumber,
                    planeName = plane.name,
                    modifier = Modifier
                        .weight(1.1f)
                        .padding(end = dimensionResource(id = R.dimen.padding_small))
                )
                PlaneImage(
                    imageRes = plane.image,
                    descriptionRes = plane.name,
                    modifier = Modifier
                        .weight(0.9f)
                )
            }
            if(expanded) {
                PlaneDescription(
                    descriptionRes = plane.description,
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}


/**
 * Composable that display a number of the day and name of the plane
 *
 * @param dayNumber contains Int for the day
 * @param planeName contains resource witch plane's name
 * @param modifier modifiers to set to this composable
 */
@Composable
fun PlaneItemHeader(
    dayNumber: Int,
    @StringRes planeName: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.day_number, dayNumber),
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        Text(
            text = stringResource(id = planeName),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

/**
 * Composable that display plane' description
 *
 * @param descriptionRes contains a resource to the description
 * @param modifier modifiers to set to this composable
 */

@Composable
fun PlaneDescription(
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
) {
   Column(
       modifier = modifier
   ) {
       Text(
           text = stringResource(id = descriptionRes),
           style = MaterialTheme.typography.bodyLarge
       )
   }
}

/**
 * Composable that displays a plane image
 *
 * @param imageRes contains a image resource
 * @param descriptionRes contains a description(planes' name)
 * @param modifier modifiers to set to this composable
 */
@Composable
fun PlaneImage(
    @DrawableRes imageRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(id = imageRes),
        contentDescription = stringResource(id = descriptionRes),
        contentScale = ContentScale.FillWidth
    )
}

@Preview
@Composable
fun PlaneItemPreview() {
    A30DaysAppTheme {
        PlaneApp()
    }
}

@Preview
@Composable
fun PlaneItemDarkPreview() {
    A30DaysAppTheme(darkTheme = true) {
        PlaneApp()
    }
}