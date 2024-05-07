import androidx.navigation.NavController

interface NavControllerProvider {
    fun provideNavController(): NavController
}