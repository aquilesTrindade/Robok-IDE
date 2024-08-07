package org.gampiot.robok.feature.component.editor

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.util.Pair
import android.app.Activity

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.editor.schemes.*
import org.gampiot.robok.feature.res.Strings

import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.schemes.*

class ThemeManager {

    companion object {
        private const val PREFS_NAME = "editor_prefs"
        private const val KEY_THEME = "editor_theme"

        val KNOWN_COLOR_SCHEMES: List<Pair<String, Class<out EditorColorScheme>>> = listOf(
            Pair("Robok Default", SchemeRobok::class.java),
            Pair("Robok TH", SchemeRobokTH::class.java),
            Pair("GitHub", SchemeGitHub::class.java),
            Pair("Eclipse", SchemeEclipse::class.java),
            Pair("Darcula", SchemeDarcula::class.java),
            Pair("VS2019", SchemeVS2019::class.java),
            Pair("NotepadXX", SchemeNotepadXX::class.java)
        )

        fun selectTheme(editor: CodeEditor, which: Int) {
            val scheme: EditorColorScheme = when (which) {
                0 -> SchemeRobok(editor.context)
                1 -> SchemeRobokTH(editor.context)
                2 -> SchemeGitHub()
                3 -> SchemeEclipse()
                4 -> SchemeDarcula()
                5 -> SchemeVS2019()
                6 -> SchemeNotepadXX()
                else -> SchemeRobok(editor.context)
            }
            Log.d("ThemeManager", "Selected theme index: $which")
            editor.colorScheme = scheme
        }

        fun showSwitchThemeDialog(activity: Activity, editor: CodeEditor, listener: (Int) -> Unit) {
            var selectedThemeIndex = 0
            val currentScheme = editor.colorScheme
            for (i in KNOWN_COLOR_SCHEMES.indices) {
                if (KNOWN_COLOR_SCHEMES[i].second == currentScheme.javaClass) {
                    selectedThemeIndex = i
                    break
                }
            }

            val themeItems = KNOWN_COLOR_SCHEMES.map { it.first }.toTypedArray()

            MaterialAlertDialogBuilder(activity)
                .setTitle(activity.getString(Strings.title_select_theme))
                .setSingleChoiceItems(themeItems, selectedThemeIndex) { _, which ->
                    listener(which)
                    saveTheme(activity, which)
                }
                .setPositiveButton(activity.getString(Strings.common_word_ok), null)
                .show()
        }

        fun saveTheme(context: Context, themeIndex: Int) {
            val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            prefs.edit().putInt(KEY_THEME, themeIndex).apply()
        }

        fun loadTheme(context: Context): Int {
            val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return prefs.getInt(KEY_THEME, 0) // Default theme is index 0 (Robok Default)
        }
    }
}