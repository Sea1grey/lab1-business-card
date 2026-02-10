package ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sergey.businesscard.R

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    val isTablet = configuration.screenWidthDp >= 600
    val padding = if (isTablet) 32.dp else dimensionResource(R.dimen.screen_padding)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(padding)
    ) {
        if (isPortrait) {
            PortraitContent()
        } else {
            LandscapeContent()
        }
    }
}

@Composable
private fun PortraitContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Image(
            painter = painterResource(R.drawable.photo),
            contentDescription = stringResource(R.string.avatar_description),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.full_name),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.group),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.contacts),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun LandscapeContent() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Image(
            painter = painterResource(R.drawable.photo),
            contentDescription = stringResource(R.string.avatar_description),
            modifier = Modifier
                .weight(0.4f)
                .aspectRatio(1f)
        )

        Column(
            modifier = Modifier.weight(0.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.full_name),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(R.string.group),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.contacts),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
