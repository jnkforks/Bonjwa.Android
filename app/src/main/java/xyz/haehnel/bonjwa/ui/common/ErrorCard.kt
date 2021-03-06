package xyz.haehnel.bonjwa.ui.common

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Card
import androidx.ui.material.MaterialTheme
import androidx.ui.res.stringResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import xyz.haehnel.bonjwa.R
import xyz.haehnel.bonjwa.ui.darkTheme
import xyz.haehnel.bonjwa.ui.lightTheme

@Composable
fun ErrorCard(error: String, onRetry: (() -> Unit)? = null) {
    Card(
        elevation = 4.dp,
        color = MaterialTheme.colors.error,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = error)
            Spacer(Modifier.height(height = 8.dp))

            if (onRetry != null) {
                Button(
                    onClick = { onRetry() },
                    modifier = Modifier.gravity(Alignment.CenterHorizontally)
                ) {
                    Text(stringResource(R.string.retry))
                }
            }
        }
    }
}

@Preview("Events Error Message (Dark)")
@Composable
fun previewDarkEventsErrorMessage() {
    MaterialTheme(colors = darkTheme) {
        ErrorCard(error = "Fehler beim Laden der Events.")
    }
}

@Preview("Events Error Message (Light)")
@Composable
fun previewLightEventsErrorMessage() {
    MaterialTheme(colors = lightTheme) {
        ErrorCard(error = "Fehler beim Laden der Events.")
    }
}

@Preview("Events Error Message with Retry (Dark)")
@Composable
fun previewDarkEventsErrorMessageWithRetry() {
    MaterialTheme(colors = darkTheme) {
        ErrorCard(error = "Fehler beim Laden der Events.", onRetry = {})
    }
}

@Preview("Events Error Message with Retry (Light)")
@Composable
fun previewLightEventsErrorMessageWithRetry() {
    MaterialTheme(colors = lightTheme) {
        ErrorCard(error = "Fehler beim Laden der Events.", onRetry = {})
    }
}
