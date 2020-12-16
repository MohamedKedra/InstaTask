package com.example.instatask

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.instatask.view.task.ui.MainActivity
import kotlinx.android.synthetic.main.content_main.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Matcher


@RunWith(AndroidJUnit4::class)
class TaskUITest {

    @Rule
    @JvmField
    val activityTestRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    private val mainActivity : MainActivity = activityTestRule.activity
    private val resId = R.id.rv_words
    private var itemCount : Int = 0

    @Before
    fun setUpTest() {

        this.itemCount = mainActivity.rv_words.adapter?.itemCount!!
    }

    @Test
    fun validateRecyclerView(){
        if (itemCount > 0){

            for(i in 0..itemCount){
//                onView(withId(this.resId))
//                    .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
//
//                /* check if the ViewHolder is being displayed */
//                onView(new RecyclerViewMatcher(this.resId)
//                    .atPositionOnView(i, R.id.cardview))
//                    .check(matches(isDisplayed()));
//
//                /* checking for the text of the first one item */
//                if(i == 0) {
//                    onView(new RecyclerViewMatcher(this.resId)
//                        .atPositionOnView(i, R.id.ingredientName))
//                        .check(matches(withText("Farbstoffe")));
//                }
            }
        }
    }

    fun clickChildViewWithId(id: Int): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController?, view: View) {
                val v: View = view.findViewById(id)
                v.performClick()
            }
        }
    }
}