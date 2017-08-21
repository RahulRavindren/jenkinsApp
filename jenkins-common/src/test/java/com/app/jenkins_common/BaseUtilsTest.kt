package com.app.jenkins_common


import com.app.jenkins_common.utils.BaseUtils
import junit.framework.Assert
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import java.util.Collections
import java.util.HashMap
import kotlin.collections.ArrayList
import kotlin.collections.Collection

@RunWith(JUnit4ClassRunner::class)
class BaseUtilsTest {

    @Test
    fun isEmptyStringTest() {
        val str = ""
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(str))
    }

    @Test
    fun isEmptyStringTestNullString() {
        val str: String? = null
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(str))
    }

    @Test
    fun isEmptyCollectionTest() {
        val collection = ArrayList<Any>();
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(collection))
    }

    @Test
    fun isEmptyCollectionTestNullCollection() {
        val collection: Collection<*>? = null
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(collection))
    }

    @Test
    fun isEmptyObjectTest() {
        val str_array = arrayOf<String>()
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(str_array))
    }

    @Test
    fun isEmptyObjectNull() {
        val str_array: Array<String>? = null
        Assert.assertTrue(BaseUtils.getInstance().isEmpty(str_array))
    }

    @Test
    fun copyAllTest() {
        val sourceMap = HashMap<String, String>()
        sourceMap.put("test", "test")
        val destinationMap = HashMap<String, String>()
        Assert.assertEquals(sourceMap, BaseUtils.getInstance().copyAll(destinationMap, sourceMap))
    }

    @Test
    fun copyAllTestSourceNull() {
        val destination = HashMap<String, String>()
        Assert.assertEquals(destination, BaseUtils.getInstance().copyAll(destination, null))

    }

    @Test
    fun copyAllTestDestinationNull() {
        val source = HashMap<String, String>()
        source.put("test", "test")
        Assert.assertEquals(source, BaseUtils.getInstance().copyAll(null, source))
    }

    @Test
    fun isValidIntegerTest() {
        val integer = "1"
        Assert.assertTrue(BaseUtils.getInstance().isValidInteger(integer))
    }

    @Test
    fun isValidIntegerTest1() {
        val integer = "a"
        Assert.assertFalse(BaseUtils.getInstance().isValidInteger(integer))
    }

    @Test
    fun equalsListBothEmptyList() {
        val list1 = ArrayList<String>()
        val list2 = ArrayList<String>()
        Assert.assertFalse(BaseUtils.getInstance().equalsList(list1, list2))
    }

    @Test
    fun equalsListUnequal() {
        val list1 = ArrayList<String>(3)
        Collections.fill(list1, "a")
        val list2 = ArrayList<String>(4)
        Collections.fill(list2, "b")
        Assert.assertFalse(BaseUtils.getInstance().equalsList(list1, list2))
    }


}
