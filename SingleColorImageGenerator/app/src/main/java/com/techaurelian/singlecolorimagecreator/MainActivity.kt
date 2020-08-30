package com.techaurelian.singlecolorimagecreator

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter

internal const val MAP_COLOR = "color"
internal const val MAP_NAME = "name"
internal const val MAP_CODE = "code"

class MainActivity : Activity() {

    private val adapterData
        get() = NamedColor.values().map {
            mapOf(
                MAP_COLOR to fullAlpha(it.rgb),
                MAP_NAME to it.name,
                MAP_CODE to colorToHex(it.rgb)
            )
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the named colors list view
        val listView = findViewById<ListView>(R.id.named_colors_list_view)
        initListView(listView)
    }

    /**
     * Initialize the Named Colors list view (simple adapter, view binder, etc.)
     */
    private fun initListView(listView: ListView) {

        // Create a simple adapter with the Named Alternatives data
        val adapterData = adapterData
        val from = arrayOf(MAP_COLOR, MAP_NAME, MAP_CODE);
        val to = intArrayOf(R.id.alternative_layout, R.id.alternative_name, R.id.alternative_code);
        val adapter = SimpleAdapter(this, adapterData, R.layout.list_item_named_color, from, to)

        // Set a custom view binder to add the shade color as the background of the list item
        adapter.viewBinder = SimpleAdapter.ViewBinder { view, data, _ ->
            if (view is LinearLayout) {
                view.setBackgroundColor(data as Int); true
            } else false
        }

        // Set the list view adapter and the on item click listener
        listView.adapter = adapter
        listView.onItemClickListener = this
    }
}