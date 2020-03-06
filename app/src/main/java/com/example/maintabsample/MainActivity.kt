package com.example.maintabsample

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.commit
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.selects.select
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    lateinit var fragment1: FrameLayout
    lateinit var fragment2: FrameLayout
    lateinit var fragment3: FrameLayout
    lateinit var fragment4: FrameLayout
    lateinit var tabLayout: TabLayout
    lateinit var button: FloatingActionButton
    private var measureHeight = 0

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDetector = GestureDetectorCompat(this, this)
        tabLayout = findViewById(R.id.tab_layout)
        fragment1 = findViewById(R.id.fragment1)
        fragment2 = findViewById(R.id.fragment2)
        fragment3 = findViewById(R.id.fragment3)
        fragment4 = findViewById(R.id.fragment4)
        button = findViewById(R.id.button)

        supportFragmentManager.commit {
            replace(R.id.fragment1, MainFragment.newInstance(1))
            replace(R.id.fragment2, MainFragment.newInstance(2))
            replace(R.id.fragment3, MainFragment.newInstance(3))
            replace(R.id.fragment4, MainFragment.newInstance(4))
        }

        val view = findViewById<View>(android.R.id.content)
        view.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                if (view.measuredHeight > 0) {
                    updateMeasureHeight(view.measuredHeight)
                }
                return true
            }
        })

        button.setOnClickListener {
            ObjectAnimator.ofFloat(fragment1, "alpha", 0f, 1f).setDuration(500).start()
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                synchronizedTabLayoutAndFragments(true)
            }

        })
    }

    private fun updateMeasureHeight(measuredHeight: Int) {
        if (measureHeight == measuredHeight) {
            return
        }
        measureHeight = measuredHeight
        synchronizedTabLayoutAndFragments(false)
    }

    private fun synchronizedTabLayoutAndFragments(smooth: Boolean) {
        synchronizedTabLayoutFragment()
//        if (smooth) {
//            synchronizedTabLayoutAndFragmentSmooth()
//        } else {
//        }
    }

    private fun synchronizedTabLayoutFragment() {
        when (tabLayout.selectedTabPosition) {
            0 -> {
                fragment2.y = measureHeight.toFloat()
                fragment3.y = measureHeight.toFloat()
                fragment4.y = measureHeight.toFloat()
            }
            1 -> {
                fragment2.y = 0f
                fragment3.y = measureHeight.toFloat()
                fragment4.y = measureHeight.toFloat()
            }
            2 -> {
                fragment2.y = 0f
                fragment3.y = 0f
                fragment4.y = measureHeight.toFloat()
            }
            3 -> {
                fragment2.y = 0f
                fragment3.y = 0f
                fragment4.y = 0f
            }
        }
    }

    private fun synchronizedTabLayoutAndFragmentSmooth() {
        val currentFragmentIndex = getCurrentFragmentIndex()
        val fragmentContainer = getCurrentFragmentContainer()
        val selected = tabLayout.selectedTabPosition
        if (selected > currentFragmentIndex) {
            //아래에서 위로

            //before
            //  < current -> alpha 0f
            //play
            //  current -> change alpha (1f -> 0.3f)
            //  selected -> translationY 0f
//            ObjectAnimator.ofFloat()
            //after
            //  current(exclusive)~selected(exclusive) y 0f
        }
        if (selected < currentFragmentIndex) {
            //위에서 아래로
            //before
            //  < selected -> alpha 0f
            // selected~current -> y measureHeight
            //play
            //  selected -> change alpha (0.3f -> 1f)
            //  current -> translationY measureHeight
            //after
            //
        }
    }

    private fun getCurrentFragmentContainer(): FrameLayout {
        return when {
            fragment4.y == 0f -> fragment4
            fragment3.y == 0f -> fragment3
            fragment2.y == 0f -> fragment2
            else -> fragment1
        }
    }

    private fun getCurrentFragmentIndex(): Int {
        return when {
            fragment4.y == 0f -> 3
            fragment3.y == 0f -> 2
            fragment2.y == 0f -> 1
            else -> 0
        }
    }

    private fun getFragmentY(tabPosition: Int, fragmentIndex: Int): Int {
        if (tabPosition >= fragmentIndex) {
            return 0
        }
        return measureHeight
    }

    /**
     * if(tabPosition == fragmentIndex); reveal
     * if(tabPosition < fragmentIndex); reveal
     * if(tabPosition > fragmentIndex); dim
     */
    private fun getAlpha(tabPosition: Int, fragmentIndex: Int): FloatArray {

        return when {
            tabPosition == fragmentIndex -> floatArrayOf(0.3f, 1f)
            tabPosition > fragmentIndex -> floatArrayOf(1f, 0.3f)
            else -> floatArrayOf(1f, 1f)
        }
    }

    /*gesture*/

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onShowPress(e: MotionEvent?) {
        //no-op
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
        Log.d("MainActivity", "onDown $e")
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d("MainActivity", "onFling $velocityY")
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d("MainActivity", "onScroll $distanceY")
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        //no-op
    }
}
