package dev.trindadeaquiles.robokide.ui.fragments.settings.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindadeaquiles.robokide.R
import dev.trindadeaquiles.robokide.databinding.FragmentSettingsEditorBinding
import dev.trindadeaquiles.robokide.ui.base.RobokFragment
import dev.trindadeaquiles.robokide.ui.components.editor.CodeEditorView
import dev.trindadeaquiles.robokide.ui.components.editor.ThemeManager

import dev.trindadeaquiles.ui.preferences.Preference

class SettingsEditorFragment(private val transitionAxis: Int = MaterialSharedAxis.X) : RobokFragment(transitionAxis) {

    private var _binding: FragmentSettingsEditorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsEditorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)

        val editorTheme = Preference(requireContext()).apply {
            setTitle(getString(R.string.settings_editor_theme_title))
            setDescription(getString(R.string.settings_editor_theme_description))
            setPreferenceClickListener {
                val codeEditor = CodeEditorView(requireContext())
                ThemeManager.showSwitchThemeDialog(requireActivity(), codeEditor.getCodeEditor()) { which ->
                    ThemeManager.selectTheme(codeEditor.getCodeEditor(), which)
                }
            }
        }
        binding.content.addView(editorTheme)

        val savedThemeIndex = ThemeManager.loadTheme(requireContext())
        val codeEditor = CodeEditorView(requireContext())
        ThemeManager.selectTheme(codeEditor.getCodeEditor(), savedThemeIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}