package com.elfeky.devdash.ui.sign_in_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elfeky.devdash.navigation.Screen

@Composable
fun SignInScreen(modifier: Modifier = Modifier, navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.primary),
                    start = Offset(0f,0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                )
            )
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "DevDash",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(56.dp))

        Text(
            text = "SignIn",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(64.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it

            },
            label = {
                Text(
                    text = "Enter your email address",
                )
            },
            maxLines = 1,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                //unfocusedBorderColor = ,
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                unfocusedLabelColor = Color.Black
            ),
            shape = RoundedCornerShape(7.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "email icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            }


        )

        Spacer(Modifier.height(24.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = {
                Text(
                    "Enter your password",
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    val icon =
                        if (passwordVisibility) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
                    Icon(imageVector = icon, contentDescription = "password visibility")
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
//                focusedBorderColor = MaterialTheme.colorScheme.primary,
//                //unfocusedBorderColor = ,
//                unfocusedContainerColor = Color.White,
//                focusedContainerColor = Color.White,
//                focusedLabelColor = MaterialTheme.colorScheme.onBackground,
//                unfocusedLabelColor = Color.White,
//                disabledLabelColor = Color.White
            )
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = buildAnnotatedString {

                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append("You don't have account?")
                }

                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Sign Up")
                }
            },
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .clickable(onClick = {
                navController.navigate(Screen.SignUpScreen.route)
            })
        )

        Spacer(Modifier.height(32.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onClick = { },
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.onSurface,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray
            ),
            // Condition to make Button enabled
            enabled = (email.isNotEmpty() and password.isNotEmpty()),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Sign In"
            )
        }


    }

}

@Preview
@Composable
private fun SignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController = navController)
}