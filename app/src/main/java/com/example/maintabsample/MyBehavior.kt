package com.example.maintabsample

import android.content.Context
import android.graphics.Rect
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.WindowInsetsCompat

class MyBehavior<V : View>(context: Context, attributeSet: AttributeSet?) : CoordinatorLayout.Behavior<V>(context, attributeSet) {

    override fun onInterceptTouchEvent(parent: CoordinatorLayout, child: V, ev: MotionEvent): Boolean {
        Log.d("MyBehavior$${child.tag}", "onInterceptTouchEvent")
        return false
    }

    override fun blocksInteractionBelow(parent: CoordinatorLayout, child: V): Boolean {
        Log.d("MyBehavior$${child.tag}", "blocksInteractionBelow")
        return super.blocksInteractionBelow(parent, child)
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Log.d("MyBehavior$${child.tag}", "onNestedPreScroll")
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }


    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int, consumed: IntArray) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type, consumed)
        Log.d("MyBehavior$${child.tag}", "onNestedScroll")
    }

    override fun onSaveInstanceState(parent: CoordinatorLayout, child: V): Parcelable? {
        Log.d("MyBehavior$${child.tag}", "onSaveInstanceState")
        return super.onSaveInstanceState(parent, child)
    }


    override fun onNestedScrollAccepted(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type)
        Log.d("MyBehavior$${child.tag}", "onNestedScrollAccepted")
    }

    override fun getScrimColor(parent: CoordinatorLayout, child: V): Int {
        Log.d("MyBehavior$${child.tag}", "getScrimColor")
        return super.getScrimColor(parent, child)
    }

    override fun onNestedFling(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        Log.d("MyBehavior$${child.tag}", "onNestFling")
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
    }

    override fun onLayoutChild(parent: CoordinatorLayout, child: V, layoutDirection: Int): Boolean {
        Log.d("MyBehavior$${child.tag}", "onLayoutChild")
        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onNestedPreFling(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        target: View,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        Log.d("MyBehavior$${child.tag}", "onNestedPreFling")
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
    }

    override fun getInsetDodgeRect(parent: CoordinatorLayout, child: V, rect: Rect): Boolean {
        Log.d("MyBehavior$${child.tag}", "getInsetDodgeRect")
        return super.getInsetDodgeRect(parent, child, rect)
    }

    override fun onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams()
        Log.d("MyBehavior", "onDetachedFromLayoutParams")

    }

    override fun onRestoreInstanceState(parent: CoordinatorLayout, child: V, state: Parcelable) {
        super.onRestoreInstanceState(parent, child, state)
        Log.d("MyBehavior$${child.tag}", "onRestoreInstanceState")
    }


    override fun onDependentViewRemoved(parent: CoordinatorLayout, child: V, dependency: View) {
        super.onDependentViewRemoved(parent, child, dependency)
        Log.d("MyBehavior$${child.tag}", "onDependentViewRemoved")
    }


    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        target: View,
        type: Int
    ) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type)
        Log.d("MyBehavior$${child.tag}", "onStopNestedScroll")
    }

    override fun layoutDependsOn(parent: CoordinatorLayout, child: V, dependency: View): Boolean {
        Log.d("MyBehavior$${child.tag}", "layoutDependsOn")
        return super.layoutDependsOn(parent, child, dependency)
    }

    override fun onRequestChildRectangleOnScreen(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        rectangle: Rect,
        immediate: Boolean
    ): Boolean {
        Log.d("MyBehavior$${child.tag}", "onRequestChildRectangleOnScreen")
        return super.onRequestChildRectangleOnScreen(coordinatorLayout, child, rectangle, immediate)
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: V,
        dependency: View
    ): Boolean {
        Log.d("MyBehavior$${child.tag}", "onDependentViewChanged")
        return super.onDependentViewChanged(parent, child, dependency)
    }

    override fun getScrimOpacity(parent: CoordinatorLayout, child: V): Float {
        return super.getScrimOpacity(parent, child)
    }

    override fun onApplyWindowInsets(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        insets: WindowInsetsCompat
    ): WindowInsetsCompat {
        return super.onApplyWindowInsets(coordinatorLayout, child, insets)
    }

    override fun onTouchEvent(parent: CoordinatorLayout, child: V, ev: MotionEvent): Boolean {
        Log.d("MyBehavior$${child.tag}", "onTouchEvent")
        return super.onTouchEvent(parent, child, ev)
    }

    override fun onAttachedToLayoutParams(params: CoordinatorLayout.LayoutParams) {
        super.onAttachedToLayoutParams(params)
    }


    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: V,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        Log.d("MyBehavior$${child.tag}", "onStartNestedScroll")
        return super.onStartNestedScroll(
            coordinatorLayout,
            child,
            directTargetChild,
            target,
            axes,
            type
        )
    }

    override fun onMeasureChild(
        parent: CoordinatorLayout,
        child: V,
        parentWidthMeasureSpec: Int,
        widthUsed: Int,
        parentHeightMeasureSpec: Int,
        heightUsed: Int
    ): Boolean {
        return super.onMeasureChild(
            parent,
            child,
            parentWidthMeasureSpec,
            widthUsed,
            parentHeightMeasureSpec,
            heightUsed
        )
    }
}