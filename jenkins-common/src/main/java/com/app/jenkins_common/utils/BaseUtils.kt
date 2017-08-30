package com.app.jenkins_common.utils


import java.lang.ref.WeakReference
import java.util.*
import javax.inject.Singleton

@Singleton
class BaseUtils {

    /**
     * @param str - input string
     * @return - boolean true/false
     */
    fun isEmpty(str: String?): Boolean {
        return str == null || str.trim { it <= ' ' } == EMPTY_STRING
    }

    /**
     * Checks if collection is empty
     *
     * @param collection - input collection
     * @return - boolean true/false
     */
    fun isEmpty(collection: Collection<*>?): Boolean {
        return collection == null || collection.isEmpty()
    }

    /**
     * @param array - input object array
     * @return - boolean true/false
     */
    fun isEmpty(array: Array<Any>?): Boolean {
        return array == null || array.size == 0
    }

    /**
     * @param map - input map
     * @return boolean - true/false
     */
    fun isEmpty(map: Map<*, *>?): Boolean {
        return map == null || map.isEmpty()
    }

    /**
     * @param destinationMap - destination map object copyTo
     * @param sourceMap - source map object copyFrom
     * @return - copied Map object (destination)
     */
    fun <T, V> copyAll(destinationMap: MutableMap<T, V>?, sourceMap: Map<T, V>): Map<T, V>? {
        if (isEmpty(sourceMap)) {
            return destinationMap
        }
        if (destinationMap == null) {
            return HashMap(sourceMap)
        }

        destinationMap.putAll(sourceMap)
        return destinationMap
    }

    /**
     * equals objects
     * @param a - object for compare
     * @param b - object for compare
     * @return - boolean true/false
     */
    fun equals(a: Any?, b: Any?): Boolean {
        return if (a == null) b == null else b != null && a == b
    }

    /**
     * compares string ignore case
     * @param a - String for compare
     * @param b - String for compare
     * @return - boolean true/false
     */
    fun equalsIgnoreCase(a: String?, b: String?): Boolean {
        return if (a == null) b == null else b != null && a.equals(b, ignoreCase = true)
    }

    /**
     * check string is valid number
     * @param str - String input
     * @return  - boolean true/false
     */
    fun isValidInteger(str: String): Boolean {
        return !isEmpty(str) && str.matches("[0-9]+".toRegex())
    }

    /**
     * @param str - String input
     * @return - boolean true/false
     */
    fun isEmptyWithoutTrim(str: String?): Boolean {
        return !(str != null && str.length > 0)
    }

    /**
     * checks lists are equal
     * @param firstList - first array
     * @param secondList - second array
     * @return - boolean true/false
     */
    fun equalsList(firstList: List<*>, secondList: List<*>): Boolean {
        if (isEmpty(firstList) || isEmpty(secondList)) {
            return false
        }
        if (firstList.size != secondList.size) {
            return false
        }

        for (i in firstList.indices) {
            if (!equals(firstList[i], secondList[i])) {
                return false
            }
        }

        return true
    }

    /**
     * checks if object available in weak-reference
     * @param weakReference - weak reference of a type
     * @return - boolean true/false
     */
    fun <T> isWeakReferenceObjectAvailable(weakReference: WeakReference<T>?): Boolean {
        try {
            return weakReference != null && weakReference.get() != null
        } catch (e: NullPointerException) {
            throw NullPointerException()
        }

    }

    companion object {
        private val EMPTY_STRING = ""
    }

}
