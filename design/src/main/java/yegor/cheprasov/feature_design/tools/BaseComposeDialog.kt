package yegor.cheprasov.feature_design.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import yegor.cheprasov.feature_design.R

@OptIn(ExperimentalMaterialApi::class)
abstract class BaseComposeDialog : DialogFragment() {

    override fun getTheme(): Int = R.style.DialogThemeFullScreen

    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            val weight = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog!!.window!!.setLayout(weight, height)
        }
    }

    open val bottomSheetState: ModalBottomSheetState
        @Composable
        get() = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.HalfExpanded)

    abstract val composableFunction: @Composable (ModalBottomSheetState) -> Unit

    open val scrimColor: Color = Color.LightGray

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            val state = bottomSheetState
            ModalBottomSheetLayout(
                sheetState = state,
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                sheetContent = { composableFunction(state) },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .animateContentSize(),
                sheetBackgroundColor = Color.Transparent,
                scrimColor = scrimColor
            ) {}
        }
    }
}